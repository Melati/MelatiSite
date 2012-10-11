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
 * see  org.melati.poem.prepro.TableDef#generateTableJava 
 */
public class UploadedImageTable<T extends UploadedImage> extends UploadedImageTableBase<UploadedImage> {

 /**
  * Constructor.
  * 
  * see org.melati.poem.prepro.TableDef#generateTableJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being used
  * @throws PoemException    if anything goes wrong
  */
  public UploadedImageTable(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }

  // programmer's domain-specific code here

  /**
   * Find or create an object with these properties.
   * Note that height and width are defaulted.
   * @param displayName
   * @param description
   * @param url
   * @param type
   * @return existing or newly created one
   */
  public UploadedImage ensure(String displayName, String description, 
                              String url, UploadedFileType type, 
                              Integer width, Integer height){
    UploadedImage p = (UploadedImage)getDisplaynameColumn().firstWhereEq(displayName);
    if (p == null) {
      p = (UploadedImage)newPersistent();
      p.setDisplayname(displayName);
      p.setDescription(description);
      p.setUrl(url);
      p.setWidth(width);
      p.setHeight(height);
      p.setType(type);
      p.setDeleted(false);
      p.makePersistent();
    }
    return p;
  }
  
  /**
   * @return the relative url 
   */
  public String getRelativeUrl() {
    return "/images";
  }

}

