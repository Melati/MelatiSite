package org.paneris.melati.site.model;

import java.util.Enumeration;

import org.paneris.melati.site.model.generated.DivTableBase;
import org.melati.poem.DefinitionSource;
import org.melati.poem.Database;
import org.melati.poem.PoemException;

/**
 * Melati POEM generated, programmer modifiable stub 
 * for a <code>DivTable</code> object.
 * <p>
 * Description: 
 *   An HTML fragment. 
 * </p>
 *
 * 
 * <table> 
 * <tr><th colspan='3'>
 * Field summary for SQL table <code>Div</code>
 * </th></tr>
 * <tr><th>Name</th><th>Type</th><th>Description</th></tr>
 * <tr><td> id </td><td> Integer </td><td> &nbsp; </td></tr> 
 * <tr><td> page </td><td> Page </td><td> The Page to which this fragment 
 * belongs </td></tr> 
 * <tr><td> displayorder </td><td> Integer </td><td> A rank determining where 
 * the div appears in a page </td></tr> 
 * <tr><td> style </td><td> Style </td><td> The name of the CSS class for 
 * this DIV </td></tr> 
 * <tr><td> title </td><td> String </td><td> The HTML title </td></tr> 
 * <tr><td> content </td><td> String </td><td> The HTML content </td></tr> 
 * </table> 
 * 
 * @generator  org.melati.poem.prepro.TableDef#generateTableMainJava 
 */
public class DivTable extends DivTableBase {

 /**
  * Constructor.
  * 
  * @generator org.melati.poem.prepro.TableDef#generateTableMainJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being used
  * @throws PoemException    if anything goes wrong
  */
  public DivTable(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }

  // programmer's domain-specific code here

  /**
   * Create or retrieve existing div by name.
   * 
   * @return the existing or newly created object
   */

  public Div ensure(Page page, String title, String content) {
    Style s = ((SiteDatabaseTables)getDatabase()).getStyleTable().ensure("default");
    return ensure(page, s, title, content);
  }

  public Div ensure(Page page, Style style, String title, String content) {
    Div q = (Div)newPersistent();
    q.setPage(page);
    q.setTitle(title);
    Div p = (Div)firstSelection(whereClause(q));
    if (p == null) {
      p = (Div)newPersistent();
      p.setPage(page);
      Enumeration e = getPageColumn().selectionWhereEq(page.troid());
      int c = 0;
      while (e.hasMoreElements()) {
        e.nextElement();
        c++;
      } 
      p.setDisplayorder(c);
      p.setStyle(style);
      p.setTitle(title);
      p.setContent(content);
      p.makePersistent();
    }
    return p;
  }

  /**
   * Create an ipsum record
   * 
   * @return the existing or newly created object
   */

  public Div ensure(Page page) {
    Style s = ((SiteDatabaseTables)getDatabase()).getStyleTable().ensure("ipsum");
    return ensure(page,s);
  }
  /**
   * Create or retrieve existing div by name.
   * 
   * @return the existing or newly created object
   */

  public Div ensure(Page page, Style style) {
    Div p = (Div)getPageColumn().firstWhereEq(page.troid());
    if (p == null) {
      p = ensure(page, style, "Lorem Ipsum",
          "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>");
    }
    return p;
  }

}
