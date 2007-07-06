// Do not edit this file!  It was generated by Melati POEM's DSD preprocessor.

package org.paneris.melati.site.model.generated;


import org.melati.poem.AccessPoemException;
import org.melati.poem.Column;
import org.melati.poem.Field;
import org.melati.poem.ValidationPoemException;
import org.paneris.melati.site.model.SiteDatabaseTables;
import org.paneris.melati.site.model.UploadedDocumentTable;
import org.paneris.melati.site.model.UploadedFile;


/**
 * Melati POEM generated abstract base class for a <code>Persistent</code> 
 * <code>UploadedDocument</code> Object.
 *
 * @generator org.melati.poem.prepro.TableDef#generatePersistentBaseJava 
 */
public abstract class UploadedDocumentBase extends UploadedFile {


 /**
  * Retrieves the Database object.
  * 
  * @generator org.melati.poem.prepro.TableDef#generatePersistentBaseJava 
  * @return the database
  */
  public SiteDatabaseTables getSiteDatabaseTables() {
    return (SiteDatabaseTables)getDatabase();
  }


 /**
  * Retrieves the  <code>UploadedDocumentTable</code> table 
  * which this <code>Persistent</code> is from.
  * 
  * @generator org.melati.poem.prepro.TableDef#generatePersistentBaseJava 
  * @return the UploadedDocumentTable
  */
  public UploadedDocumentTable getUploadedDocumentTable() {
    return (UploadedDocumentTable)getTable();
  }

  private UploadedDocumentTable _getUploadedDocumentTable() {
    return (UploadedDocumentTable)getTable();
  }

  // Fields in this table 
 /**
  * id 
  */
  protected Integer id;
 /**
  * url - The name of the file, as uploaded 
  */
  protected String url;


 /**
  * Retrieves the <code>Id</code> value, without locking, 
  * for this <code>UploadedDocument</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Integer id
  */
  public Integer getId_unsafe() {
    return id;
  }


 /**
  * Sets the <code>Id</code> value directly, without checking, 
  * for this UploadedDocument <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setId_unsafe(Integer cooked) {
    id = cooked;
  }

 /**
  * Retrieves the Id value, with locking, for this 
  * <code>UploadedDocument</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Id</code> for this 
  *         <code>UploadedDocument</code> <code>Persistent</code>  
  */

  public Integer getId()
      throws AccessPoemException {
    readLock();
    return getId_unsafe();
  }


 /**
  * Sets the <code>Id</code> value, with checking, for this 
  * <code>UploadedDocument</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setId(Integer cooked)
      throws AccessPoemException, ValidationPoemException {
    _getUploadedDocumentTable().getIdColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setId_unsafe(cooked);
  }

 /**
  * Sets the <code>Id</code> value, with checking, for this 
  * <code>UploadedDocument</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.IntegerFieldDef#generateBaseMethods 
  * @param cooked  a validated <code>int</code>
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */

  public final void setId(int cooked)
      throws AccessPoemException, ValidationPoemException {
    setId(new Integer(cooked));
  }


 /**
  * Retrieves the <code>Id</code> value as a <code>Field</code>
  * from this <code>UploadedDocument</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Integer id
  */
  public Field getIdField() throws AccessPoemException {
    Column c = _getUploadedDocumentTable().getIdColumn();
    return new Field(c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Url</code> value, without locking, 
  * for this <code>UploadedDocument</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the String url
  */
  public String getUrl_unsafe() {
    return url;
  }


 /**
  * Sets the <code>Url</code> value directly, without checking, 
  * for this UploadedDocument <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setUrl_unsafe(String cooked) {
    url = cooked;
  }

 /**
  * Retrieves the Url value, with locking, for this 
  * <code>UploadedDocument</code> <code>Persistent</code>.
  * Field description: 
  *   The name of the file, as uploaded 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Url</code> for this 
  *         <code>UploadedDocument</code> <code>Persistent</code>  
  */

  public String getUrl()
      throws AccessPoemException {
    readLock();
    return getUrl_unsafe();
  }


 /**
  * Sets the <code>Url</code> value, with checking, for this 
  * <code>UploadedDocument</code> <code>Persistent</code>.
  * Field description: 
  *   The name of the file, as uploaded 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setUrl(String cooked)
      throws AccessPoemException, ValidationPoemException {
    _getUploadedDocumentTable().getUrlColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setUrl_unsafe(cooked);
  }


 /**
  * Retrieves the <code>Url</code> value as a <code>Field</code>
  * from this <code>UploadedDocument</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the String url
  */
  public Field getUrlField() throws AccessPoemException {
    Column c = _getUploadedDocumentTable().getUrlColumn();
    return new Field(c.getRaw(this), c);
  }
}

