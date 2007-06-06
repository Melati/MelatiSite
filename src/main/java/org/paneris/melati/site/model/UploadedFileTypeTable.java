package org.paneris.melati.site.model;

import org.paneris.melati.site.model.generated.UploadedFileTypeTableBase;
import org.melati.poem.DefinitionSource;
import org.melati.poem.Database;
import org.melati.poem.PoemException;

/**
 * Melati POEM generated, programmer modifiable stub 
 * for a <code>UploadedFileTypeTable</code> object.
 * <p>
 * Description: 
 *   A type of uploaded file. 
 * </p>
 *
 * 
 * <table> 
 * <tr><th colspan='3'>
 * Field summary for SQL table <code>UploadedFileType</code>
 * </th></tr>
 * <tr><th>Name</th><th>Type</th><th>Description</th></tr>
 * <tr><td> id </td><td> Integer </td><td> &nbsp; </td></tr> 
 * <tr><td> type </td><td> String </td><td> Type of uploaded file </td></tr> 
 * </table> 
 * 
 * @generator  org.melati.poem.prepro.TableDef#generateTableMainJava 
 */
public class UploadedFileTypeTable extends UploadedFileTypeTableBase {

 /**
  * Constructor.
  * 
  * @generator org.melati.poem.prepro.TableDef#generateTableMainJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being used
  * @throws PoemException    if anything goes wrong
  */
  public UploadedFileTypeTable(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }

  // programmer's domain-specific code here

  /**
   * @return existing or newly minted Persistent
   */
  public UploadedFileType ensure(String type) {
    UploadedFileType p = (UploadedFileType)getTypeColumn().firstWhereEq(type);
    if (p == null) {
      p = (UploadedFileType)newPersistent();
      p.setType(type);
      p.makePersistent();
    } 
    return p;
  }

}
