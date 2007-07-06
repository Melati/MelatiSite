package org.paneris.melati.site.model;

import org.paneris.melati.site.model.generated.LinkTypeTableBase;
import org.melati.poem.DefinitionSource;
import org.melati.poem.Database;
import org.melati.poem.PoemException;

/**
 * Melati POEM generated, programmer modifiable stub 
 * for a <code>LinkTypeTable</code> object.
 * <p>
 * Description: 
 *   Types of media output. 
 * </p>
 *
 * 
 * <table> 
 * <tr><th colspan='3'>
 * Field summary for SQL table <code>LinkType</code>
 * </th></tr>
 * <tr><th>Name</th><th>Type</th><th>Description</th></tr>
 * <tr><td> id </td><td> Integer </td><td> &nbsp; </td></tr> 
 * <tr><td> name </td><td> String </td><td> The category's name </td></tr> 
 * <tr><td> description </td><td> String </td><td> The a description of the 
 * link type </td></tr> 
 * </table> 
 * 
 * @generator  org.melati.poem.prepro.TableDef#generateTableMainJava 
 */
public class LinkTypeTable extends LinkTypeTableBase {

 /**
  * Constructor.
  * 
  * @generator org.melati.poem.prepro.TableDef#generateTableMainJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being used
  * @throws PoemException    if anything goes wrong
  */
  public LinkTypeTable(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }

  // programmer's domain-specific code here

  /**
   * @return existing or newly minted LinkType
   */
  public LinkType ensure(String name, String description) {
    LinkType p = (LinkType)getNameColumn().firstWhereEq(name);
    if (p == null) {
      p = (LinkType)newPersistent();
      p.setName(name);
      p.setDescription(description);
      p.makePersistent();
    }
    return p;
  }

}
