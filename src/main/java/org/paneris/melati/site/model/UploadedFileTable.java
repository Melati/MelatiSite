package org.paneris.melati.site.model;

import org.paneris.melati.site.model.generated.UploadedFileTableBase;
import org.melati.poem.DefinitionSource;
import org.melati.poem.Database;
import org.melati.poem.PoemException;
import org.melati.poem.Persistent;
import org.melati.poem.AccessPoemException;
import org.melati.poem.InitialisationPoemException;
import org.melati.poem.ValidationPoemException;
import org.melati.poem.PoemThread;
import org.melati.poem.User;
import java.sql.Date;

/**
 * Melati POEM generated, programmer modifiable stub 
 * for a <code>UploadedFileTable</code> object.
 * <p>
 * Description: 
 *   A file uploaded by a user. 
 * </p>
 *
 * 
 * <table> 
 * <tr><th colspan='3'>
 * Field summary for SQL table <code>UploadedFile</code>
 * </th></tr>
 * <tr><th>Name</th><th>Type</th><th>Description</th></tr>
 * <tr><td> type </td><td> UploadedFileType </td><td> The type of this file 
 * </td></tr> 
 * <tr><td> description </td><td> String </td><td> A description of the file 
 * </td></tr> 
 * <tr><td> size </td><td> Integer </td><td> The size of this file </td></tr> 
 * <tr><td> when </td><td> Date </td><td> The date on which this file was 
 * uploaded </td></tr> 
 * <tr><td> uploadedby </td><td> User </td><td> The user who uploaded this 
 * file </td></tr> 
 * <tr><td> deleted </td><td> Boolean </td><td> Whether this file been 
 * deleted or not </td></tr> 
 * </table> 
 * 
 * @generator  org.melati.poem.prepro.TableDef#generateTableMainJava 
 */
public class UploadedFileTable extends UploadedFileTableBase {

 /**
  * Constructor.
  * 
  * @generator org.melati.poem.prepro.TableDef#generateTableMainJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being used
  * @throws PoemException    if anything goes wrong
  */
  public UploadedFileTable(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }

  // programmer's domain-specific code here

  public void create(Persistent persistent)
      throws AccessPoemException, ValidationPoemException,
             InitialisationPoemException {

    Integer userTroid;
    try{
      User user = (User)PoemThread.accessToken();
      userTroid = user.troid();
    } catch (ClassCastException e){ // When access token is root ie not a real user
      userTroid = new Integer(1);  
    }
    
/*
Need canUpload capability?

    if (!user.canUploadTo(account))
      throw new AccessPoemException(PoemThread.accessToken(),
                            getDatabase().administerCapability());
*/

/*
    File testfile = new File( ((UploadedFile)persistent).getPath_unsafe() );
    long size = testfile.length();
    String sizeString = null;
    if ((size / KILOBYTE) >= 1) {
      if ((size / MEGABYTE) >= 1) {
        if ((size / GIGABYTE) >= 1)
          sizeString = (size / GIGABYTE) + " Gb";
        else
          sizeString = (size / MEGABYTE) + " Mb";
      } else {
        sizeString = (size / KILOBYTE) + " Kb";
      }
    } else {
      sizeString = size + " bytes";
    }
*/
    persistent.setRaw("uploadedby", userTroid);
    persistent.setRaw("when", new Date(new java.util.Date().getTime()));
    persistent.setRaw("deleted", Boolean.FALSE);

    super.create(persistent);
  }

  /**
   * @return the relative url 
   */
  public String getRelativeUrl() {
    return "/";
  }

}
