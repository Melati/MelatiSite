package org.paneris.melati.site.model;


import org.paneris.melati.site.model.generated.TemplateTableBase;
import org.melati.poem.DefinitionSource;
import org.melati.poem.Database;
import org.melati.poem.PoemException;

/**
 * Melati POEM generated, programmer modifiable stub 
 * for a <code>TemplateTable</code> object.
 * <p>
 * Description: 
 *   A page template, used to control HTML fragment layout. 
 * </p>
 *
 * 
 * <table> 
 * <tr><th colspan='3'>
 * Field summary for SQL table <code>Template</code>
 * </th></tr>
 * <tr><th>Name</th><th>Type</th><th>Description</th></tr>
 * <tr><td> id </td><td> Integer </td><td> &nbsp; </td></tr> 
 * <tr><td> url </td><td> String </td><td> Key by which template engine can 
 * locate template, no need for extension </td></tr> 
 * </table> 
 * 
 * see  org.melati.poem.prepro.TableDef#generateTableJava 
 */
public class TemplateTable<T extends Template> extends TemplateTableBase<Template> {

 /**
  * Constructor.
  * 
  * see org.melati.poem.prepro.TableDef#generateTableJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being used
  * @throws PoemException    if anything goes wrong
  */
  public TemplateTable(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }

  // programmer's domain-specific code here

  /**
   * Create or retrieve existing Template by name.
   * 
   * @return the existing or newly created object
   */
  public Template ensure(String displayName, String url) {
    Template p = (Template)getDisplaynameColumn().firstWhereEq(displayName);
    if (p == null) {
      p = (Template)newPersistent();
      p.setDisplayname(displayName);
      p.setDescription(displayName);
      p.setUrl(url);
      p.setType(((SiteDatabaseTables)getDatabase()).getUploadedFileTypeTable().ensure("wm"));
      p.makePersistent();
    }
    return p;
  }
  
}

