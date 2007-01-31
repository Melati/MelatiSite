package org.paneris.melati.site.model;

import java.util.Enumeration;
import java.util.Vector;

import org.melati.Melati;
import org.melati.admin.AdminSpecialised;
import org.melati.poem.CachedSelection;
import org.melati.poem.util.ArrayUtils;
import org.melati.poem.util.EmptyEnumeration;
import org.melati.template.MarkupLanguage;
import org.melati.util.StringUtils;
import org.melati.util.Treeable;
import org.paneris.melati.site.model.generated.PageBase;

/**
 * Melati POEM generated, programmer modifiable stub for a
 * <code>Persistent</code> <code>Page</code> object.
 * 
 * 
 * <table>
 * <tr>
 * <th colspan='3'> Field summary for SQL table <code>Page</code> </th>
 * </tr>
 * <tr>
 * <th>Name</th>
 * <th>Type</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td> fsname </td>
 * <td> String </td>
 * <td> A file system name, no spaces or special characters </td>
 * </tr>
 * <tr>
 * <td> deleted </td>
 * <td> Boolean </td>
 * <td> Whether or not to include this Unit </td>
 * </tr>
 * <tr>
 * <td> lastencached </td>
 * <td> Timestamp </td>
 * <td> When the unit was encached; cleared when the unit is updated </td>
 * </tr>
 * <tr>
 * <td> layout </td>
 * <td> Layout </td>
 * <td> The name of the layout for this Unit </td>
 * </tr>
 * <tr>
 * <td> messageboard </td>
 * <td> Board </td>
 * <td> A messageboard on which this unit can be discussed </td>
 * </tr>
 * </table>
 * 
 * @generator org.melati.poem.prepro.TableDef#generateMainJava
 */
public class Page extends PageBase implements AdminSpecialised, Treeable,
    Templated {

  /**
   * Constructor for a <code>Persistent</code> <code>Page</code> object.
   * 
   * @generator org.melati.poem.prepro.TableDef#generateMainJava
   */
  public Page() {
  }

  // programmer's domain-specific code here

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
  public Enumeration getAncestors() {
    Vector v = new Vector();
    Page p = getParent();
    while (p != null) {
      v.addElement(p);
      p = p.getParent();
    }
    Vector reversed = new Vector();
    for (Enumeration e = v.elements(); e.hasMoreElements();) {
      reversed.insertElementAt(e.nextElement(), 0);
    }
    return reversed.elements();
  }

  public String getRelativeDisplayUrlById() {
    return "Display/page/" + troid() + ".html";
  }

  /**
   * @return the name with underscores for spaces and a file extension added.
   */
  public String getRelativeDisplayUrlByContent() {
    return StringUtils.tr(getDisplayname(), ' ', '_') + ".html";
  }

  /**
   * XML does not allow forward slashes in Is, so we use periods.
   * 
   * @return The table name, a period followed by the troid.
   */
  public String getXmlId() {
    return StringUtils.tr(toString(), '/', '.');
  }

  private CachedSelection divs = null;

  public Enumeration getDivs() {
    if (getTroid() == null)
      return EmptyEnumeration.it;
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
    Treeable[] children = null;
    Object[] kids = ArrayUtils.arrayOf(getPageTable().getParentColumn()
        .referencesTo(this));
    int j = 0;
    for (int i = 0; i < kids.length; i++) {
      if (((Page) kids[i]).getDisplay().booleanValue()) {
        j++;
      }
    }
    children = new Treeable[j];
    int k = 0;
    for (int i = 0; i < kids.length; i++) {
      if (((Page) kids[i]).getDisplay().booleanValue()) {
        children[k] = (Treeable) kids[i];
        k++;
      }
    }
    System.out.println("length:" + kids.length + " j:" + j + " k:" + k);
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
