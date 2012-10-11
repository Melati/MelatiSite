package org.paneris.melati.site.model;

import java.util.Enumeration;
import java.util.Vector;

import org.melati.Melati;
import org.melati.admin.AdminSpecialised;
import org.melati.poem.CachedSelection;
import org.melati.poem.util.EmptyEnumeration;
import org.melati.template.MarkupLanguage;
import org.melati.poem.Treeable;
import org.paneris.melati.site.model.generated.PageBase;

/**
 * Melati POEM generated, programmer modifiable stub 
 * for a <code>Persistent</code> <code>Page</code> object.
 * 
 * <p> 
 * Description: 
 *   A Page. 
 * </p>
 * 
 * <table> 
 * <tr><th colspan='3'>
 * Field summary for SQL table <code>Page</code>
 * </th></tr>
 * <tr><th>Name</th><th>Type</th><th>Description</th></tr>
 * <tr><td> id </td><td> Integer </td><td> &nbsp; </td></tr> 
 * <tr><td> name </td><td> String </td><td> A file system name, no spaces or 
 * special characters </td></tr> 
 * <tr><td> displayname </td><td> String </td><td> The full name used in the 
 * TITLE. </td></tr> 
 * <tr><td> displayorder </td><td> Integer </td><td> A rank determining where 
 * the page appears in a list </td></tr> 
 * <tr><td> display </td><td> Boolean </td><td> Whether to display this page 
 * </td></tr> 
 * <tr><td> deleted </td><td> Boolean </td><td> Soft delete </td></tr> 
 * <tr><td> lastencached </td><td> Timestamp </td><td> When the page was 
 * encached; cleared when the page is updated </td></tr> 
 * <tr><td> parent </td><td> Page </td><td> The parent page (empty for Home). 
 *  </td></tr> 
 * <tr><td> template </td><td> Template </td><td> The name of the layout for 
 * this page </td></tr> 
 * <tr><td> style </td><td> Style </td><td> The name of the CSS class for 
 * this page </td></tr> 
 * </table> 
 * 
 * see org.melati.poem.prepro.TableDef#generatePersistentJava 
 */
public class Page extends PageBase implements AdminSpecialised, Treeable,
    Templated {

 /**
  * Constructor 
  * for a <code>Persistent</code> <code>Page</code> object.
  * <p>
  * Description: 
  *   A Page. 
  * </p>
  * 
  * see org.melati.poem.prepro.TableDef#generatePersistentJava 
  */
  public Page() { 
    super();
}

  // programmer's domain-specific code here

  /**
   * @return the database
   */
  public SiteDatabaseTables getSiteDatabase() {
    return (SiteDatabaseTables) getDatabase();
}

  /**
   * @return a string with non breaking space for spaces
   */
  /*
   * public String getDisplayName() { return super.getDisplayname().replace("
   * ","&nbsp;"); }
   */
  /**
   * @return an Enumeration of ancestors
   */
  public Enumeration<Page> getAncestors() {
    Vector<Page> v = new Vector<Page>();
    Page p = getParent();
    while (p != null) {
      v.addElement(p);
      p = p.getParent();
    }
    Vector<Page> reversed = new Vector<Page>();
    for (Enumeration<Page> e = v.elements(); e.hasMoreElements();) {
      reversed.insertElementAt(e.nextElement(), 0);
    }
    return reversed.elements();
  }

  /**
   * @return the numeric url
   */
  public String getRelativeDisplayUrlById() {
    return "Display/page/" + troid() + ".html";
  }

  /**
   * @return the name with underscores for spaces and a file extension added.
   */
  public String getRelativeDisplayUrlByContent() {
    return getUrlName() + ".html";
  }
  /**
   * @return the name with underscores for spaces and a file extension added.
   */
  public String getUrlName() {
    return getDisplayname().replace(' ', '_');
  }
  /**
   * @return the name with underscores for spaces and a file extension added.
   */
  public String getJavaName() {
    return getUrlName().replace('-', '_');
  }

  /**
   * XML does not allow forward slashes in Ids, so we use periods.
   * 
   * @return The table name, a period followed by the troid.
   */
  public String getXmlId() {
    return toString().replace('/', '.');
  }

  private CachedSelection<Div> divs = null;

  /**
   * @return the divs
   */
  @SuppressWarnings("unchecked")
  public Enumeration<Div> getDivs() {
    if (getTroid() == null)
      return new EmptyEnumeration<Div>();
    else {
      if (divs == null)
        divs = getSiteDatabase().getDivTable().getPageColumn()
            .cachedSelectionWhereEq(getTroid());
      return divs.objects();
    }
  }

  /*
   * @see org.melati.util.Treeable#getChildren()
   */

  public Treeable[] getChildren() {
    Object[] kids = super.getChildren();
    int displayabledChildCount = 0;
    for (int i = 0; i < kids.length; i++) {
      if (((Page) kids[i]).getDisplay().booleanValue()) {
        displayabledChildCount++;
      }
    }
    Treeable[] children = new Treeable[displayabledChildCount];
    int k = 0;
    for (int i = 0; i < kids.length; i++) {
      if (((Page) kids[i]).getDisplay().booleanValue()) {
        children[k] = (Treeable) kids[i];
        k++;
      }
    }
    return children;
  }

  public String adminHandle(Melati melati, MarkupLanguage markupLanguage)
      throws Exception {
    return null;
  }

  public String adminSpecialFacilities(Melati melati,
      MarkupLanguage markupLanguage) throws Exception {
    return "org/paneris/melati/site/model/Page.adminSpecial.wm";
  }


}
