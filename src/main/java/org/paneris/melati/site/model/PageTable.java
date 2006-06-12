package org.paneris.melati.site.model;

import org.paneris.melati.site.model.generated.PageTableBase;
import org.melati.poem.DefinitionSource;
import org.melati.poem.Database;
import org.melati.poem.PoemException;

/**
 * Melati POEM generated, programmer modifiable stub 
 * for a <code>PageTable</code> object.
 * <p>
 * Description: 
 *   A Page. 
 * </p>
 *
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
 * <tr><td> deleted </td><td> Boolean </td><td> Whether or not to include 
 * this Unit </td></tr> 
 * <tr><td> lastencached </td><td> Timestamp </td><td> When the unit was 
 * encached; cleared when the unit is updated </td></tr> 
 * <tr><td> parent </td><td> Page </td><td> The organisation to which this is 
 * affiliated, if any.  </td></tr> 
 * <tr><td> template </td><td> Template </td><td> The name of the layout for 
 * this page </td></tr> 
 * <tr><td> style </td><td> Style </td><td> The name of the CSS class for 
 * this page </td></tr> 
 * <tr><td> messageboard </td><td> Board </td><td> A messageboard on which 
 * this unit can be discussed </td></tr> 
 * </table> 
 * 
 * @generator  org.melati.poem.prepro.TableDef#generateTableMainJava 
 */
public class PageTable extends PageTableBase {

 /**
  * Constructor.
  * 
  * @generator org.melati.poem.prepro.TableDef#generateTableMainJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being used
  * @throws PoemException    if anything goes wrong
  */
  public PageTable(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }

  // programmer's domain-specific code here

  static int displayOrder = 0;

  /**
   * Create or retrieve existing page by name.
   * 
   * @return the existing or newly created object
   */
  public Page ensurePage(String displayName){
    String name = deSpace(displayName);
    Page p = (Page)getNameColumn().firstWhereEq(name);
    if (p == null) {
      p = (Page)newPersistent();
      p.setName(name);
      p.setDisplayname(displayName);
      p.setDisplayorder(displayOrder);
      p.setDeleted(false);
      p.setDisplay(true);
      displayOrder = displayOrder + 1;
      p.makePersistent();
    }
    return p;
  }

  public Page ensure(String displayName){
    Page p = ensurePage(displayName);
    SiteDatabaseTables db = ((SiteDatabaseTables)getDatabase());
    db.getDivTable().ensure(p);
    return p;
  }

  public Page ensure(String displayName, Page parent){
    Page p = ensure(displayName);
    p.setParent(parent);
    return p;
  }
  
  public Page ensure(String displayName, Page parent, 
                     String divSubject, String divContent){
    Page p = ensurePage(displayName);
    p.setParent(parent);
    ((SiteDatabase)getDatabase()).
        getDivTable().ensure(p, divSubject, divContent);
    return p;
  }


  public static String deSpace(String s) {
    int l = s.length();
    for (int i = 0; i < l; ++i) {
      char c = s.charAt(i);
      if (c == ' ') {
        // damn, found one; catch up to here ...
        StringBuffer t = new StringBuffer(l -1);
        for (int j = 0; j < i; ++j)
          t.append(s.charAt(j));
        // ... and continue
        for (++i; i < l; ++i) {
          c = s.charAt(i);
          if (c != ' ')
           t.append(c);
        }
        return t.toString();
      }
    }
    return s;
  }
}
