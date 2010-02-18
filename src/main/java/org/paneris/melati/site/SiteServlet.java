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
import org.melati.poem.util.StringUtils;

/**
 * @author timp
 * 
 */
public abstract class SiteServlet extends TemplateServlet {

  private static final long serialVersionUID = 2807149216380558185L;

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
      if (i == -1)
        pathInfo = "";
      else
        pathInfo = s.substring(i);
    }

    if (pathInfo != "") {
      System.err.println("pathinfo:" + pathInfo);
      System.err.println("Ref:" + melati.getRequest().getHeader("Referer"));
      StringBuffer url = new StringBuffer();
      String scheme = melati.getRequest().getScheme();
      url.append(scheme);
      url.append("://");
      url.append(melati.getRequest().getServerName());
      url.append(pathInfo);
      // IE leaves referrer empty in redirects !!
      //String referrer = melati.getRequest().getHeader("Referer");
      //if (referrer != null  && referrer.indexOf(pathInfo) == -1) {
        melati.getResponse().sendRedirect(url.toString());
        return;
      //}
    }
    super.doConfiguredRequest(melati);
    melati.setResponseContentType("text/html");
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
