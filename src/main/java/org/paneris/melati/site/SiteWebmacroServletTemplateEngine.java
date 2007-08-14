/*
 * $Source$
 * $Revision$
 *
 *
 * Contact details for copyright holder:
 * 
 *  Tim Pizey (timp At paneris.org)
 */

package org.paneris.melati.site;

import org.melati.template.webmacro.WebmacroServletTemplateEngine;

/**
 * With added root. 
 * 
 * @author timp
 * @since 14 Aug 2007
 *
 */
public class SiteWebmacroServletTemplateEngine extends WebmacroServletTemplateEngine {

  /**
   * Constructor.
   */
  public SiteWebmacroServletTemplateEngine() {
    super();
    roots.add("org/paneris/melati/site/view/");
  }

}
