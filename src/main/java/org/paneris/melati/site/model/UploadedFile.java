// Delete this line to prevent overwriting of this file

package org.paneris.melati.site.model;


import org.paneris.melati.site.model.generated.UploadedFileBase;

/**
 * Melati POEM generated, programmer modifiable stub 
 * for a <code>Persistent</code> <code>UploadedFile</code> object.
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
 * <tr><td> displayname </td><td> String </td><td> The layout's name 
 * </td></tr> 
 * </table> 
 * 
 * see org.melati.poem.prepro.TableDef#generatePersistentJava 
 */
public class UploadedFile extends UploadedFileBase {

 /**
  * Constructor 
  * for a <code>Persistent</code> <code>UploadedFile</code> object.
  * 
  * see org.melati.poem.prepro.TableDef#generatePersistentJava 
  */
  public UploadedFile() { 
    super();
}

  // programmer's domain-specific code here
}

