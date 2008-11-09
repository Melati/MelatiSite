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

import org.melati.template.velocity.VelocityServletTemplateEngine;

/**
 * With added root. 
 * 
 * @author timp
 * @since 14 Aug 2007
 *
 */
public class SiteVelocityServletTemplateEngine extends VelocityServletTemplateEngine {

  /**
   * Constructor.
   */
  public SiteVelocityServletTemplateEngine() {
    super();
    addRoot("org/paneris/melati/site/view");
  }

}
