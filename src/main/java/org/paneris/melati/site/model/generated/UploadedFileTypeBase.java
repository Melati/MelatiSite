// Do not edit this file!  It was generated by Melati POEM's DSD preprocessor.

package org.paneris.melati.site.model.generated;


import org.melati.poem.AccessPoemException;
import org.melati.poem.Column;
import org.melati.poem.Field;
import org.melati.poem.Persistent;
import org.melati.poem.ValidationPoemException;
import org.paneris.melati.site.model.SiteDatabaseTables;
import org.paneris.melati.site.model.UploadedFileTypeTable;


/**
 * Melati POEM generated abstract base class for a <code>Persistent</code> 
 * <code>UploadedFileType</code> Object.
 *
 * @generator org.melati.poem.prepro.TableDef#generateBaseJava 
 */
public abstract class UploadedFileTypeBase extends Persistent {


 /**
  * Retrieves the Database object.
  * 
  * @generator org.melati.poem.prepro.TableDef#generateBaseJava 
  * @return the database
  */
  public SiteDatabaseTables getSiteDatabaseTables() {
    return (SiteDatabaseTables)getDatabase();
  }


 /**
  * Retrieves the  <code>UploadedFileTypeTable</code> table 
  * which this <code>Persistent</code> is from.
  * 
  * @generator org.melati.poem.prepro.TableDef#generateBaseJava 
  * @return the UploadedFileTypeTable
  */
  public UploadedFileTypeTable getUploadedFileTypeTable() {
    return (UploadedFileTypeTable)getTable();
  }

  private UploadedFileTypeTable _getUploadedFileTypeTable() {
    return (UploadedFileTypeTable)getTable();
  }

  // Fields in this table 
 /**
  * id 
  */
  protected Integer id;
 /**
  * type - Type of uploaded file 
  */
  protected String type;


 /**
  * Retrieves the <code>Id</code> value, without locking, 
  * for this <code>UploadedFileType</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Integer id
  */
  public Integer getId_unsafe() {
    return id;
  }


 /**
  * Sets the <code>Id</code> value directly, without checking, 
  * for this UploadedFileType <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setId_unsafe(Integer cooked) {
    id = cooked;
  }

 /**
  * Retrieves the Id value, with locking, for this 
  * <code>UploadedFileType</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Id</code> for this 
  *         <code>UploadedFileType</code> <code>Persistent</code>  
  */

  public Integer getId()
      throws AccessPoemException {
    readLock();
    return getId_unsafe();
  }


 /**
  * Sets the <code>Id</code> value, with checking, for this 
  * <code>UploadedFileType</code> <code>Persistent</code>.
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
    _getUploadedFileTypeTable().getIdColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setId_unsafe(cooked);
  }

 /**
  * Sets the <code>Id</code> value, with checking, for this 
  * <code>UploadedFileType</code> <code>Persistent</code>.
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
  * from this <code>UploadedFileType</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Integer id
  */
  public Field getIdField() throws AccessPoemException {
    Column c = _getUploadedFileTypeTable().getIdColumn();
    return new Field(c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Type</code> value, without locking, 
  * for this <code>UploadedFileType</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the String type
  */
  public String getType_unsafe() {
    return type;
  }


 /**
  * Sets the <code>Type</code> value directly, without checking, 
  * for this UploadedFileType <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setType_unsafe(String cooked) {
    type = cooked;
  }

 /**
  * Retrieves the Type value, with locking, for this 
  * <code>UploadedFileType</code> <code>Persistent</code>.
  * Field description: 
  *   Type of uploaded file 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Type</code> for this 
  *         <code>UploadedFileType</code> <code>Persistent</code>  
  */

  public String getType()
      throws AccessPoemException {
    readLock();
    return getType_unsafe();
  }


 /**
  * Sets the <code>Type</code> value, with checking, for this 
  * <code>UploadedFileType</code> <code>Persistent</code>.
  * Field description: 
  *   Type of uploaded file 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setType(String cooked)
      throws AccessPoemException, ValidationPoemException {
    _getUploadedFileTypeTable().getTypeColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setType_unsafe(cooked);
  }


 /**
  * Retrieves the <code>Type</code> value as a <code>Field</code>
  * from this <code>UploadedFileType</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the String type
  */
  public Field getTypeField() throws AccessPoemException {
    Column c = _getUploadedFileTypeTable().getTypeColumn();
    return new Field(c.getRaw(this), c);
  }
}

