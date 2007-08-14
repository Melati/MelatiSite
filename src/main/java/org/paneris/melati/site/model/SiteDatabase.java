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
  private Setting description;
  private Setting keywords;
  
  public void connect(
      String name,
      String dbmsclass,
      String url,
      String username,
      String password,
      int maxConnections) {
      super.connect(name, dbmsclass, url, username, password, maxConnections);

      inSession(AccessToken.root, new PoemTask() {
        public void run() {

          homePage = getPageTable().ensure("Home");
          description =
            (Setting)getSettingTable().ensure(
                "description",
                "A site developed using MelatiSite.",
                "Site description",
                "Descriptive text used in meta tags");
          keywords =
            (Setting)getSettingTable().ensure(
                "keywords",
                "MelatiSite, Melati, PanEris",
                "Site keywords",
                "Comma separated values for use in keywords meta tag");

        }
      });
  }

  /**
   * @return Returns the homePage.
   */
  public Page getHomePage() {
    return homePage;
  }

  /**
   * @return the description 
   */
  public String getDescription() {
    return description.getValue();
  }
  /**
   * @return the keywords
   */
  public String getKeywords() {
    return keywords.getValue();
  }
  
}


