/*
 * $Source$
 * $Revision$
 *
 *
 * Contact details for copyright holder:
 * 
 *  Tim Pizey (timp@paneris.org)
 */

package org.paneris.melati.site;

import org.melati.Melati;
import org.melati.poem.Persistent;
import org.melati.poem.Column;
import org.melati.poem.Table;
import org.melati.PoemContext;
import org.melati.servlet.PathInfoException;
import org.melati.template.ServletTemplateContext;
import org.melati.util.StringUtils;
import org.paneris.wvm.model.Template;
import org.paneris.wvm.model.Templated;
import org.paneris.wvm.model.HasGetTemplateUrl;

/**
 * Display an object using its Template.
 * 
 * This is the main servlet for the site, so it needs to handle 
 * a number of request types.
 * 
 * 1. Display of a record from the db
 * 2. Display a selection of records from a table in the db
 * 3. Display images or files from the DOCUMENT_ROOT
 * 
 * This last is a trick to enable an image or page to be 
 * displayed instead of a db record/table.
 * 
 * 
 *
 *  http://localhost/db/Display/table/record.html
 * 
 *
 * Table Record Method         URL
 * null  null   null           Display - Error
 * null  null   present        Display/AllUrls.html
 * valid null   present        Display/page/Summary.html
 * valid valid  null           Display/page/1.html
 * valid valid  null           Display/page/About.Wvm.html 
 * valid valid  present        Display/page/1/Special.html
 * valid valid  present        Display/page/About.Wvm/intranet.html 
 * 
 * 
 */
public class Display extends SiteServlet {

  protected String reallyDoTemplateRequest(Melati melati, 
                                           ServletTemplateContext context)
      throws Exception {

    PoemContext mc = melati.getPoemContext();
    String method = mc.getMethod();

    Persistent object = melati.getObject();

    if (object != null) {
      object.assertCanRead();
      context.put("object", object);
    }
    if (method != null && !method.equals("") && 
        melati.getTable() != null) {
      if (method.lastIndexOf(".htm") != -1) {
        method = method.substring(0,method.lastIndexOf(".htm")); 
      }
      
      if (melati.getObject() == null) {
        Integer id = null;
        try {
          id = new Integer(method);
        }
        catch (NumberFormatException e) {
          if (melati.getTable() != null) {
            String value = StringUtils.tr(method,'.', ' '); 
            value = StringUtils.tr(method,'_', ' '); 
            Column search = melati.getTable().primaryCriterionColumn();
            Persistent o = search.firstWhereEq(value);
            if (o != null) id = o.troid();
          }
        }
        if (id != null) {
          melati.getPoemContext().setTroid(id); 
          melati.getPoemContext().setMethod(null);
        } 
        melati.loadTableAndObject();
        if (melati.getObject() != null) {
          object = melati.getObject();
          object.assertCanRead();
          context.put("object", object);
          if (object instanceof Templated) {
            Template t = ((Templated)object).getTemplate();
            String url = null;
            if (t != null) url = t.getUrl();
            if (url != null) {
              System.err.println("returning url:" + url);
              return url;
            } else {
              System.err.println("url null");              
            }
          } else {
            System.err.println("not templated:" +object.getClass().getName());              
          }
          System.err.println("return 1 - really");
          return StringUtils.capitalised(melati.getTable().getName());
        // StringUtils.tr(melati.getObject().getClass().getName(), '.', '/');
        } else {
          System.err.println("return 2");
          return method;
        }
      } else {
        System.err.println("return 3");
        return method;
      }
    }  
    if (context.getForm("template") != null) {
      System.err.println("return 4");
      return context.getForm("template");
    }
    if (object != null && object instanceof Templated) {
      Template t = ((Templated)object).getTemplate();
      String url = null;
      if(t != null) url = t.getUrl();
      if (url != null) return url;
      return StringUtils.capitalised(melati.getTable().getName());
    }
    if (object != null && object instanceof HasGetTemplateUrl) {
      String t = ((HasGetTemplateUrl)melati.getObject()).getTemplateUrl();
      if (t != null) return t;
      return StringUtils.capitalised(melati.getTable().getName());
    }
    return "Display";
  }


  /**
   * Hardcode the db, rather than using Poem's
   * URL specified LDB.
   * 
   * @see org.melati.servlet.ConfigServlet#melatiContext(org.melati.Melati)
   */
  protected PoemContext poemContext(Melati melati)
      throws PathInfoException {

    PoemContext it = new PoemContext();
    it.setLogicalDatabase("wvm");

    String[] parts = melati.getPathInfoParts();
    if (parts.length > 0) {
      // Display/table.html - might be needed
      // Display/ATemplate.html - template that is DB specific 
      // or contains no template specific info at all 
      if (parts.length == 1) it.setMethod(parts[0]);

      // Display/page/1.html
      // Display/page/TableSpecificSummaryTemplate.html
      // Display/page/Primary.Search.Criterion.content.html
      if (parts.length == 2) {
        String r = parts[1];
        if (r.lastIndexOf(".htm") != -1) {
          r = r.substring(0,r.lastIndexOf(".htm")); 
      //    it.method = "html";
        }
        it.setTable(parts[0]);
        try {
          it.setTroid(new Integer(r));
        }
        catch (NumberFormatException e) {
          it.setMethod(parts[1]);
        }
      }
      // Display/page/1/SpecialTemplate.html
      // Display/page/Primary.Search.Criterion.content/SpecialTemplate.html
      // Display/page/Primary_Search_Criterion_content/SpecialTemplate.html
      if (parts.length == 3) {
        it.setTable(parts[0]);
        try {
          it.setTroid(new Integer (parts[1]));
        }
        catch (NumberFormatException e) {
          String r = parts[1];
          if (r.lastIndexOf(".htm") != -1) {
            r = r.substring(0,r.lastIndexOf(".htm")); 
          }
          String value = StringUtils.tr(r,'.', ' '); 
          value = StringUtils.tr(r,'_', ' '); 
          Table t = melati.getTable();
          if (t != null) {
            Column c = t.primaryCriterionColumn();
            if (c == null) throw new NullPointerException("primaryCriterionColumn null");
            Persistent o = c.firstWhereEq(value);
            if (o != null) it.setTroid(o.troid());
          }
        }
        it.setMethod(parts[2]);
      }
/*
      if (parts.length > 3) 
     {
        String pathInfo = melati.getRequest().getPathInfo();
        pathInfo = pathInfo.substring(1);
        for (int i = 0; i< 2; i++) {
          pathInfo = pathInfo.substring(pathInfo.indexOf("/") + 1);
        }          
        it.method = pathInfo;
     }
*/
    }
    return it;
}



 /**
  * A little something to generate alternating colours. 
  * @author timp
  *
  */
public static class Util {
  
  /**
   * Return a contrasting colour given a colour.
   *  
   * @param rgb the colour to contrast with
   * @return the colour string
   */
  public String contrastingColour(String rgb) {
    if (rgb.length() != 6) throw new IllegalArgumentException();
    String red = rgb.substring(0,2);
    String green = rgb.substring(2,4);
    String blue = rgb.substring(4);

    int redI = Integer.parseInt(red,16);
    int greenI = Integer.parseInt(green,16);
    int blueI = Integer.parseInt(blue,16);
    int luminence = redI + greenI + blueI;
    int redNew;
    int greenNew;
    int blueNew;
    if (luminence > ((3 * 255)/2)) {
      // r>b>g
      // r>g>b
      // g>r>b
      // b>r>g
      // b>g>r
      // g>b>r
      if (redI > blueI){
        if (blueI > greenI){  // r>b>g
          redNew = (greenI/2); 
          greenNew = (redI/2); 
          blueNew = (blueI/2);
        } else {
          if (redI > greenI){ // r>g>b
            redNew = (blueI/2); 
            greenNew = (greenI/2); 
            blueNew = (redI/2);
          } else { // g>r>b
            redNew = (redI/2); 
            greenNew = (blueI/2); 
            blueNew = (greenI/2);            
          }
        }
      } else {
        if (redI > greenI){ // b>r>g
          redNew = (redI/2); 
          greenNew = (blueI/2); 
          blueNew = (greenI/2);
        } else {
          if (blueI > greenI){ // b>g>r
            redNew = (blueI/2); 
            greenNew = (greenI/2); 
            blueNew =  (redI/2);
          } else { // g>b>r
            redNew = (greenI/2); 
            greenNew = (redI/2); 
            blueNew =  (blueI/2);            
          }
        }
      }
    } else {
      if (redI > blueI){
        if (blueI > greenI){  // r>b>g
          redNew = 255 - (greenI/2); 
          greenNew = 255 - (redI/2); 
          blueNew = 255 - (blueI/2);
        } else {
          if (redI > greenI){ // r>g>b
            redNew = 255 - (blueI/2); 
            greenNew = 255 - (greenI/2); 
            blueNew = 255 - (redI/2);
          } else { // g>r>b
            redNew = 255 - (redI/2); 
            greenNew = 255 - (blueI/2); 
            blueNew = 255 - (greenI/2);            
          }
        }
      } else {
        if (redI > greenI){ // b>r>g
          redNew = 255 - (redI/2); 
          greenNew = 255 - (blueI/2); 
          blueNew = 255 - (greenI/2);
        } else {
          if (blueI > greenI){ // b>g>r
            redNew = 255 - (blueI/2); 
            greenNew = 255 - (greenI/2); 
            blueNew = 255 - (redI/2);
          } else { // g>b>r
            redNew = 255 - (greenI/2); 
            greenNew = 255 - (redI/2); 
            blueNew = 255 - (blueI/2);            
          }
        }
      }
    }
    String redNewS = (redNew < 16) ? "0" + Integer.toHexString(redNew) 
                                   : Integer.toHexString(redNew);
    String greenNewS = (greenNew < 16) ? "0" + Integer.toHexString(greenNew) 
                                   : Integer.toHexString(greenNew);
    String blueNewS = (blueNew < 16) ? "0" + Integer.toHexString(blueNew) 
                                   : Integer.toHexString(blueNew);
    
    return redNewS + greenNewS + blueNewS;
  }
 }
}
