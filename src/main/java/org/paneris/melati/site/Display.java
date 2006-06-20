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
import org.melati.PoemContext;
import org.melati.template.ServletTemplateContext;
import org.melati.util.StringUtils;
import org.paneris.melati.site.model.Template;
import org.paneris.melati.site.model.Templated;
import org.paneris.melati.site.model.HasGetTemplateUrl;

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
 * valid valid  null           Display/page/About.melati.site.html 
 * valid valid  present        Display/page/1/Special.html
 * valid valid  present        Display/page/About.Us/intranet.html 
 * 
 * 
 */
public class Display extends SiteServlet {

  private static final long serialVersionUID = 1L;

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

}
