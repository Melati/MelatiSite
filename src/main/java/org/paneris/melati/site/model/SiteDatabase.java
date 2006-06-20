package org.paneris.melati.site.model;

import org.melati.poem.AccessToken;
import org.melati.poem.PoemTask;
import org.paneris.melati.site.model.generated.SiteDatabaseBase;

/**
 * Melati POEM generated, programmer modifiable stub.
 */
public class SiteDatabase extends SiteDatabaseBase
                            implements SiteDatabaseTables {
  // programmer's domain-specific code here

  private Page homePage;
  
  public void connect(
      String dbmsclass,
      String url,
      String username,
      String password,
      int maxConnections) {
      super.connect(dbmsclass, url, username, password, maxConnections);

      inSession(AccessToken.root, new PoemTask() {
        public void run() {

          homePage = (Page)getPageTable().ensure("Home");

        }
      });
  }

  /**
   * @return Returns the homePage.
   */
  public Page getHomePage() {
    return homePage;
  }
}


