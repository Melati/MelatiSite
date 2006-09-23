package org.paneris.melati.site.model;

import org.paneris.melati.site.model.generated.UploadedImageTableBase;
import org.melati.poem.DefinitionSource;
import org.melati.poem.Database;
import org.melati.poem.PoemException;

/**
 * Melati POEM generated, programmer modifiable stub 
 * for a <code>UploadedImageTable</code> object.
 * <p>
 * Description: 
 *   An image uploaded by a user. 
 * </p>
 *
 * 
 * <table> 
 * <tr><th colspan='3'>
 * Field summary for SQL table <code>UploadedImage</code>
 * </th></tr>
 * <tr><th>Name</th><th>Type</th><th>Description</th></tr>
 * <tr><td> id </td><td> Integer </td><td> &nbsp; </td></tr> 
 * <tr><td> url </td><td> String </td><td> The name of the file, as uploaded 
 * </td></tr> 
 * <tr><td> height </td><td> Integer </td><td> The height of this file if it 
 * is an image </td></tr> 
 * <tr><td> width </td><td> Integer </td><td> The width of this file if it is 
 * an image </td></tr> 
 * </table> 
 * 
 * @generator  org.melati.poem.prepro.TableDef#generateTableMainJava 
 */
public class UploadedImageTable extends UploadedImageTableBase {

 /**
  * Constructor.
  * 
  * @generator org.melati.poem.prepro.TableDef#generateTableMainJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being us  String displayname 
      (size = unlimited)
      (displayname = "Display name")
      (description = "The layout's name")
      (displaylevel = primary)
      (searchability = primary);
ed
  * @throws PoemException    if anything goes wrong
  */
  public UploadedImageTable(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }

  // programmer's domain-specific code here
  public UploadedImage ensure(String displayName, String description, String url){
    UploadedImage p = (UploadedImage)getDisplaynameColumn().firstWhereEq(displayName);
    if (p == null) {
      p = (UploadedImage)newPersistent();
      p.setDisplayname(displayName);
      p.setDescription(description);
      p.setUrl(url);
      p.setType(((SiteDatabaseTables)getDatabase()).getUploadedFileTypeTable().ensure("gig"));
      p.setDeleted(false);
      p.makePersistent();
    }
    return (UploadedImage)p;
  }

}

