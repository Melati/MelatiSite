/*
 * $Source$
 * $Revision$
 *
 *
 * Contact details for copyright holder:
 * 
 *  Tim Pizey (http://paneris.org/~timp)
 */

package org.paneris.melati.site;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;

import org.melati.Melati;
import org.melati.PoemContext;
import org.melati.poem.Column;
import org.melati.poem.Persistent;
import org.melati.poem.Table;
import org.melati.servlet.PathInfoException;
import org.melati.servlet.TemplateServlet;
import org.melati.template.ServletTemplateContext;
import org.melati.util.StringUtils;

/**
 * @author timp
 * 
 */
public abstract class SiteServlet extends TemplateServlet {

  /** Turn on placement of debugging info into context */
  public static final boolean DEBUG = true;

  private static final String STATIC_ROOT = "/dist/MelatiSite/src/main/webapp";

  private static final String DB_NAME = "site";

  /**
   * {@inheritDoc}
   * 
   * @see org.melati.servlet.PoemServlet#doConfiguredRequest(org.melati.Melati)
   */
  protected void doConfiguredRequest(final Melati melati)
      throws ServletException, IOException {
    String pathInfo = getPathInfo(melati);
    System.err.println("pathinfo:" + pathInfo);

    // check if pathinfo exists in filesystem
    // if so then redirect to it, unless we came from there
    while (pathInfo != "" && !fileAt(pathInfo)) {
      String s = pathInfo.substring(1);
      int i = s.indexOf('/');
      if (i != -1)
        pathInfo = s.substring(i);
      else
        pathInfo = "";
    }

    if (pathInfo != "") {
      System.err.println("pathinfo:" + pathInfo);
      System.err.println("Ref:" + melati.getRequest().getHeader("Referer"));
      String referer = melati.getRequest().getHeader("Referer");
      StringBuffer url = new StringBuffer();
      String scheme = melati.getRequest().getScheme();
      url.append(scheme);
      url.append("://");
      url.append(melati.getRequest().getServerName());
      url.append(pathInfo);
      // IE leaves referer empty in redirects !!
      if (referer != null  && referer.indexOf(pathInfo) == -1) {
        melati.getResponse().sendRedirect(url.toString());
        return;
      }
    }
    super.doConfiguredRequest(melati);
  }

  protected boolean fileAt(String filename) {
    if (filename.equals(""))
      return false;
    if (filename.equals("/"))
      return false;
    String fsName = getSTATIC_ROOT() + filename;
    File it = new File(fsName);
    System.err.println("FS:" + fsName + " " + it.exists());
    return it.exists();
  }

  /**
   * Concrete method for {@link TemplateServlet}.
   * 
   * @param melati
   * @param context
   * @return Template name
   */
  protected String doTemplateRequest(Melati melati,
      ServletTemplateContext context) throws Exception {
    return melati.templateName(reallyDoTemplateRequest(melati, context));
  }

  /**
   * Override this method to build up output in individual servlets.
   * 
   * @return Template name without path or extension
   */
  protected abstract String reallyDoTemplateRequest(Melati melati,
      ServletTemplateContext templateContext) throws Exception;

  protected String getSetting(Melati melati, String settingName) {
    String returnString = melati.getDatabase().getSettingTable().get(
        settingName);
    if (returnString == null)
      throw new RuntimeException("Setting " + settingName
          + " not found in setting table");
    return returnString;
  }

  /**
   * Hardcode the db, rather than using Poem's URL specified LDB.
   * 
   * @see org.melati.servlet.ConfigServlet#melatiContext(org.melati.Melati)
   */
  protected PoemContext poemContext(Melati melati) throws PathInfoException {

    PoemContext it = new PoemContext();
    it.setLogicalDatabase(getDB_NAME());

    String initParameterPathInfo = getInitParameter("pathinfo");
    String[] parts;
    if (initParameterPathInfo != null) {
      parts = StringUtils.split(initParameterPathInfo, '/');
      System.err.println("Got init param:" + initParameterPathInfo);
    } else {
      System.err.println("Did not find init param");
      parts = melati.getPathInfoParts();
    }
    if (parts.length > 0) {
      // Display/table.html - might be needed
      // Display/ATemplate.html - template that is DB specific
      // or contains no template specific info at all
      if (parts.length == 1)
        it.setMethod(parts[0]);

      // Display/page/1.html
      // Display/page/TableSpecificSummaryTemplate.html
      // Display/page/Primary.Search.Criterion.content.html
      if (parts.length == 2) {
        String r = parts[1];
        if (r.lastIndexOf(".htm") != -1) {
          r = r.substring(0, r.lastIndexOf(".htm"));
          // it.method = "html";
        }
        it.setTable(parts[0]);
        try {
          it.setTroid(new Integer(r));
        } catch (NumberFormatException e) {
          it.setMethod(parts[1]);
        }
      }
      // Display/page/1/SpecialTemplate.html
      // Display/page/Primary.Search.Criterion.content/SpecialTemplate.html
      // Display/page/Primary_Search_Criterion_content/SpecialTemplate.html
      if (parts.length == 3) {
        it.setTable(parts[0]);
        try {
          it.setTroid(new Integer(parts[1]));
        } catch (NumberFormatException e) {
          String r = parts[1];
          if (r.lastIndexOf(".htm") != -1) {
            r = r.substring(0, r.lastIndexOf(".htm"));
          }
          String value = StringUtils.tr(r, '.', ' ');
          value = StringUtils.tr(r, '_', ' ');
          Table t = melati.getTable();
          if (t != null) {
            Column c = t.primaryCriterionColumn();
            if (c == null)
              throw new NullPointerException("primaryCriterionColumn null");
            Persistent o = c.firstWhereEq(value);
            if (o != null)
              it.setTroid(o.troid());
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
   * 
   * @author timp
   * 
   */
  public static class Util {

    /**
     * Return a contrasting colour given a colour.
     * 
     * @param rgb
     *          the colour to contrast with
     * @return the colour string
     */
    public String contrastingColour(String rgb) {
      if (rgb.length() != 6)
        throw new IllegalArgumentException();
      String red = rgb.substring(0, 2);
      String green = rgb.substring(2, 4);
      String blue = rgb.substring(4);

      int redI = Integer.parseInt(red, 16);
      int greenI = Integer.parseInt(green, 16);
      int blueI = Integer.parseInt(blue, 16);
      int luminence = redI + greenI + blueI;
      int redNew;
      int greenNew;
      int blueNew;
      if (luminence > ((3 * 255) / 2)) {
        // r>b>g
        // r>g>b
        // g>r>b
        // b>r>g
        // b>g>r
        // g>b>r
        if (redI > blueI) {
          if (blueI > greenI) { // r>b>g
            redNew = (greenI / 2);
            greenNew = (redI / 2);
            blueNew = (blueI / 2);
          } else {
            if (redI > greenI) { // r>g>b
              redNew = (blueI / 2);
              greenNew = (greenI / 2);
              blueNew = (redI / 2);
            } else { // g>r>b
              redNew = (redI / 2);
              greenNew = (blueI / 2);
              blueNew = (greenI / 2);
            }
          }
        } else {
          if (redI > greenI) { // b>r>g
            redNew = (redI / 2);
            greenNew = (blueI / 2);
            blueNew = (greenI / 2);
          } else {
            if (blueI > greenI) { // b>g>r
              redNew = (blueI / 2);
              greenNew = (greenI / 2);
              blueNew = (redI / 2);
            } else { // g>b>r
              redNew = (greenI / 2);
              greenNew = (redI / 2);
              blueNew = (blueI / 2);
            }
          }
        }
      } else {
        if (redI > blueI) {
          if (blueI > greenI) { // r>b>g
            redNew = 255 - (greenI / 2);
            greenNew = 255 - (redI / 2);
            blueNew = 255 - (blueI / 2);
          } else {
            if (redI > greenI) { // r>g>b
              redNew = 255 - (blueI / 2);
              greenNew = 255 - (greenI / 2);
              blueNew = 255 - (redI / 2);
            } else { // g>r>b
              redNew = 255 - (redI / 2);
              greenNew = 255 - (blueI / 2);
              blueNew = 255 - (greenI / 2);
            }
          }
        } else {
          if (redI > greenI) { // b>r>g
            redNew = 255 - (redI / 2);
            greenNew = 255 - (blueI / 2);
            blueNew = 255 - (greenI / 2);
          } else {
            if (blueI > greenI) { // b>g>r
              redNew = 255 - (blueI / 2);
              greenNew = 255 - (greenI / 2);
              blueNew = 255 - (redI / 2);
            } else { // g>b>r
              redNew = 255 - (greenI / 2);
              greenNew = 255 - (redI / 2);
              blueNew = 255 - (blueI / 2);
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

  /**
   * @return Returns the dB_NAME.
   */
  public String getDB_NAME() {
    return DB_NAME;
  }

  /**
   * @return the root
   */
  public String getSTATIC_ROOT() {
    return STATIC_ROOT;
  }

  private String getPathInfo(Melati melati) {
    String initParameterPathInfo = getInitParameter("pathinfo");
    String pathInfo = melati.getRequest().getPathInfo();
    if (initParameterPathInfo == null) {
      return pathInfo == null ? "" : pathInfo;
    } else {
      return initParameterPathInfo + (pathInfo == null ? "" : pathInfo);
    }

  }

}
