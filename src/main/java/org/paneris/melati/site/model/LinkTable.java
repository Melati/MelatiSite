// Delete this line to prevent overwriting of this file

package org.paneris.melati.site.model;


import org.paneris.melati.site.model.generated.LinkTableBase;
import org.melati.poem.DefinitionSource;
import org.melati.poem.Database;
import org.melati.poem.PoemException;

/**
 * Melati POEM generated, programmer modifiable stub 
 * for a <code>LinkTable</code> object.
 * <p>
 * Description: 
 *   A link. 
 * </p>
 *
 * 
 * <table> 
 * <tr><th colspan='3'>
 * Field summary for SQL table <code>Link</code>
 * </th></tr>
 * <tr><th>Name</th><th>Type</th><th>Description</th></tr>
 * <tr><td> id </td><td> Integer </td><td> &nbsp; </td></tr> 
 * <tr><td> page </td><td> Page </td><td> The page to which the link is 
 * relevant </td></tr> 
 * <tr><td> type </td><td> LinkType </td><td> The type of this link 
 * </td></tr> 
 * <tr><td> url </td><td> String </td><td> The full URL for the site's front 
 * page </td></tr> 
 * <tr><td> displayname </td><td> String </td><td> The site's name </td></tr> 
 * <tr><td> displayorder </td><td> Integer </td><td> &nbsp; </td></tr> 
 * </table> 
 * 
 * see  org.melati.poem.prepro.TableDef#generateTableJava 
 */
public class LinkTable<T extends Link> extends LinkTableBase<Link> {

 /**
  * Constructor.
  * 
  * see org.melati.poem.prepro.TableDef#generateTableJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being used
  * @throws PoemException    if anything goes wrong
  */
  public LinkTable(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }

  // programmer's domain-specific code here
}

