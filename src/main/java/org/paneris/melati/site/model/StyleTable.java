// Delete this line to prevent overwriting of this file

package org.paneris.melati.site.model;


import org.paneris.melati.site.model.generated.StyleTableBase;
import org.melati.poem.DefinitionSource;
import org.melati.poem.Database;
import org.melati.poem.PoemException;

/**
 * Melati POEM generated, programmer modifiable stub 
 * for a <code>StyleTable</code> object.
 * <p>
 * Description: 
 *   A CSS Class Id. 
 * </p>
 *
 * 
 * <table> 
 * <tr><th colspan='3'>
 * Field summary for SQL table <code>Style</code>
 * </th></tr>
 * <tr><th>Name</th><th>Type</th><th>Description</th></tr>
 * <tr><td> id </td><td> Integer </td><td> &nbsp; </td></tr> 
 * <tr><td> name </td><td> String </td><td> The Class id </td></tr> 
 * </table> 
 * 
 * see  org.melati.poem.prepro.TableDef#generateTableJava 
 */
public class StyleTable<T extends Style> extends StyleTableBase<Style> {

 /**
  * Constructor.
  * 
  * see org.melati.poem.prepro.TableDef#generateTableJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being used
  * @throws PoemException    if anything goes wrong
  */
  public StyleTable(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }

  // programmer's domain-specific code here
  
  /**
   * Create or retrieve existing organisation by name.
   * 
   * @return the existing or newly created object
   */

  public Style ensure(String name) {
    Style p = (Style)getNameColumn().firstWhereEq(name);
    if (p == null) {
      p = (Style)newPersistent();
      p.setName(name);
      p.makePersistent();
    }
    return p;
  }
}

