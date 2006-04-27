// Do not edit this file!  It was generated by Melati POEM's DSD preprocessor.

package org.paneris.melati.site.model.generated;


import java.sql.Timestamp;
import org.melati.poem.AccessPoemException;
import org.melati.poem.Column;
import org.melati.poem.Field;
import org.melati.poem.NoSuchRowPoemException;
import org.melati.poem.Persistent;
import org.melati.poem.ValidationPoemException;
import org.paneris.melati.site.model.Page;
import org.paneris.melati.site.model.PageTable;
import org.paneris.melati.site.model.SiteDatabaseTables;
import org.paneris.melati.site.model.Style;
import org.paneris.melati.site.model.Template;


/**
 * Melati POEM generated abstract base class for a <code>Persistent</code> 
 * <code>Page</code> Object.
 *
 * @generator org.melati.poem.prepro.TableDef#generateBaseJava 
 */
public abstract class PageBase extends Persistent {


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
  * Retrieves the  <code>PageTable</code> table 
  * which this <code>Persistent</code> is from.
  * 
  * @generator org.melati.poem.prepro.TableDef#generateBaseJava 
  * @return the PageTable
  */
  public PageTable getPageTable() {
    return (PageTable)getTable();
  }

  private PageTable _getPageTable() {
    return (PageTable)getTable();
  }

  // Fields in this table 
 /**
  * id 
  */
  protected Integer id;
 /**
  * name - A file system name, no spaces or special characters 
  */
  protected String name;
 /**
  * Display Name - The full name used in the TITLE. 
  */
  protected String displayname;
 /**
  * Display order - A rank determining where the page appears in a list 
  */
  protected Integer displayorder;
 /**
  * display - Whether to display this page 
  */
  protected Boolean display;
 /**
  * deleted - Soft delete 
  */
  protected Boolean deleted;
 /**
  * Last encached - When the page was encached; cleared when the page is 
  * updated 
  */
  protected Timestamp lastencached;
 /**
  * parent - The parent page (empty for Home).  
  */
  protected Integer parent;
 /**
  * template - The name of the layout for this page 
  */
  protected Integer template;
 /**
  * style - The name of the CSS class for this page 
  */
  protected Integer style;


 /**
  * Retrieves the <code>Id</code> value, without locking, 
  * for this <code>Page</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Integer id
  */
  public Integer getId_unsafe() {
    return id;
  }


 /**
  * Sets the <code>Id</code> value directly, without checking, 
  * for this Page <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setId_unsafe(Integer cooked) {
    id = cooked;
  }

 /**
  * Retrieves the Id value, with locking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Id</code> for this 
  *         <code>Page</code> <code>Persistent</code>  
  */

  public Integer getId()
      throws AccessPoemException {
    readLock();
    return getId_unsafe();
  }


 /**
  * Sets the <code>Id</code> value, with checking, for this 
  * <code>Page</code> <code>Persistent</code>.
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
    _getPageTable().getIdColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setId_unsafe(cooked);
  }

 /**
  * Sets the <code>Id</code> value, with checking, for this 
  * <code>Page</code> <code>Persistent</code>.
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
  * from this <code>Page</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Integer id
  */
  public Field getIdField() throws AccessPoemException {
    Column c = _getPageTable().getIdColumn();
    return new Field(c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Name</code> value, without locking, 
  * for this <code>Page</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the String name
  */
  public String getName_unsafe() {
    return name;
  }


 /**
  * Sets the <code>Name</code> value directly, without checking, 
  * for this Page <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setName_unsafe(String cooked) {
    name = cooked;
  }

 /**
  * Retrieves the Name value, with locking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   A file system name, no spaces or special characters 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Name</code> for this 
  *         <code>Page</code> <code>Persistent</code>  
  */

  public String getName()
      throws AccessPoemException {
    readLock();
    return getName_unsafe();
  }


 /**
  * Sets the <code>Name</code> value, with checking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   A file system name, no spaces or special characters 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setName(String cooked)
      throws AccessPoemException, ValidationPoemException {
    _getPageTable().getNameColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setName_unsafe(cooked);
  }


 /**
  * Retrieves the <code>Name</code> value as a <code>Field</code>
  * from this <code>Page</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the String name
  */
  public Field getNameField() throws AccessPoemException {
    Column c = _getPageTable().getNameColumn();
    return new Field(c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Displayname</code> value, without locking, 
  * for this <code>Page</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the String displayname
  */
  public String getDisplayname_unsafe() {
    return displayname;
  }


 /**
  * Sets the <code>Displayname</code> value directly, without checking, 
  * for this Page <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setDisplayname_unsafe(String cooked) {
    displayname = cooked;
  }

 /**
  * Retrieves the Displayname value, with locking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   The full name used in the TITLE. 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Displayname</code> for this 
  *         <code>Page</code> <code>Persistent</code>  
  */

  public String getDisplayname()
      throws AccessPoemException {
    readLock();
    return getDisplayname_unsafe();
  }


 /**
  * Sets the <code>Displayname</code> value, with checking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   The full name used in the TITLE. 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setDisplayname(String cooked)
      throws AccessPoemException, ValidationPoemException {
    _getPageTable().getDisplaynameColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setDisplayname_unsafe(cooked);
  }


 /**
  * Retrieves the <code>Displayname</code> value as a <code>Field</code>
  * from this <code>Page</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the String displayname
  */
  public Field getDisplaynameField() throws AccessPoemException {
    Column c = _getPageTable().getDisplaynameColumn();
    return new Field(c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Displayorder</code> value, without locking, 
  * for this <code>Page</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Integer displayorder
  */
  public Integer getDisplayorder_unsafe() {
    return displayorder;
  }


 /**
  * Sets the <code>Displayorder</code> value directly, without checking, 
  * for this Page <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setDisplayorder_unsafe(Integer cooked) {
    displayorder = cooked;
  }

 /**
  * Retrieves the Displayorder value, with locking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   A rank determining where the page appears in a list 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Displayorder</code> for this 
  *         <code>Page</code> <code>Persistent</code>  
  */

  public Integer getDisplayorder()
      throws AccessPoemException {
    readLock();
    return getDisplayorder_unsafe();
  }


 /**
  * Sets the <code>Displayorder</code> value, with checking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   A rank determining where the page appears in a list 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setDisplayorder(Integer cooked)
      throws AccessPoemException, ValidationPoemException {
    _getPageTable().getDisplayorderColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setDisplayorder_unsafe(cooked);
  }

 /**
  * Sets the <code>Displayorder</code> value, with checking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   A rank determining where the page appears in a list 
  * 
  * 
  * @generator org.melati.poem.prepro.IntegerFieldDef#generateBaseMethods 
  * @param cooked  a validated <code>int</code>
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */

  public final void setDisplayorder(int cooked)
      throws AccessPoemException, ValidationPoemException {
    setDisplayorder(new Integer(cooked));
  }


 /**
  * Retrieves the <code>Displayorder</code> value as a <code>Field</code>
  * from this <code>Page</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Integer displayorder
  */
  public Field getDisplayorderField() throws AccessPoemException {
    Column c = _getPageTable().getDisplayorderColumn();
    return new Field(c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Display</code> value, without locking, 
  * for this <code>Page</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Boolean display
  */
  public Boolean getDisplay_unsafe() {
    return display;
  }


 /**
  * Sets the <code>Display</code> value directly, without checking, 
  * for this Page <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setDisplay_unsafe(Boolean cooked) {
    display = cooked;
  }

 /**
  * Retrieves the Display value, with locking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   Whether to display this page 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Display</code> for this 
  *         <code>Page</code> <code>Persistent</code>  
  */

  public Boolean getDisplay()
      throws AccessPoemException {
    readLock();
    return getDisplay_unsafe();
  }


 /**
  * Sets the <code>Display</code> value, with checking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   Whether to display this page 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setDisplay(Boolean cooked)
      throws AccessPoemException, ValidationPoemException {
    _getPageTable().getDisplayColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setDisplay_unsafe(cooked);
  }

 /**
  * Sets the <code>Display</code> value, with checking, 
  * from a <code>boolean</code>, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   Whether to display this page 
  * 
  * 
  * @generator org.melati.poem.prepro.BooleanFieldDef#generateBaseMethods 
  * @param cooked  a <code>boolean</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */

  public final void setDisplay(boolean cooked)
      throws AccessPoemException, ValidationPoemException {
    setDisplay(cooked ? Boolean.TRUE : Boolean.FALSE);
  }


 /**
  * Retrieves the <code>Display</code> value as a <code>Field</code>
  * from this <code>Page</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Boolean display
  */
  public Field getDisplayField() throws AccessPoemException {
    Column c = _getPageTable().getDisplayColumn();
    return new Field(c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Deleted</code> value, without locking, 
  * for this <code>Page</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Boolean deleted
  */
  public Boolean getDeleted_unsafe() {
    return deleted;
  }


 /**
  * Sets the <code>Deleted</code> value directly, without checking, 
  * for this Page <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setDeleted_unsafe(Boolean cooked) {
    deleted = cooked;
  }

 /**
  * Retrieves the Deleted value, with locking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   Soft delete 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Deleted</code> for this 
  *         <code>Page</code> <code>Persistent</code>  
  */

  public Boolean getDeleted()
      throws AccessPoemException {
    readLock();
    return getDeleted_unsafe();
  }


 /**
  * Sets the <code>Deleted</code> value, with checking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   Soft delete 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setDeleted(Boolean cooked)
      throws AccessPoemException, ValidationPoemException {
    _getPageTable().getDeletedColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setDeleted_unsafe(cooked);
  }

 /**
  * Sets the <code>Deleted</code> value, with checking, 
  * from a <code>boolean</code>, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   Soft delete 
  * 
  * 
  * @generator org.melati.poem.prepro.BooleanFieldDef#generateBaseMethods 
  * @param cooked  a <code>boolean</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */

  public final void setDeleted(boolean cooked)
      throws AccessPoemException, ValidationPoemException {
    setDeleted(cooked ? Boolean.TRUE : Boolean.FALSE);
  }


 /**
  * Retrieves the <code>Deleted</code> value as a <code>Field</code>
  * from this <code>Page</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Boolean deleted
  */
  public Field getDeletedField() throws AccessPoemException {
    Column c = _getPageTable().getDeletedColumn();
    return new Field(c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Lastencached</code> value, without locking, 
  * for this <code>Page</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Timestamp lastencached
  */
  public Timestamp getLastencached_unsafe() {
    return lastencached;
  }


 /**
  * Sets the <code>Lastencached</code> value directly, without checking, 
  * for this Page <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setLastencached_unsafe(Timestamp cooked) {
    lastencached = cooked;
  }

 /**
  * Retrieves the Lastencached value, with locking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   When the page was encached; cleared when the page is updated 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Lastencached</code> for this 
  *         <code>Page</code> <code>Persistent</code>  
  */

  public Timestamp getLastencached()
      throws AccessPoemException {
    readLock();
    return getLastencached_unsafe();
  }


 /**
  * Sets the <code>Lastencached</code> value, with checking, for this 
  * <code>Page</code> <code>Persistent</code>.
  * Field description: 
  *   When the page was encached; cleared when the page is updated 
  * 
  * @generator org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setLastencached(Timestamp cooked)
      throws AccessPoemException, ValidationPoemException {
    _getPageTable().getLastencachedColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setLastencached_unsafe(cooked);
  }


 /**
  * Retrieves the <code>Lastencached</code> value as a <code>Field</code>
  * from this <code>Page</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Timestamp lastencached
  */
  public Field getLastencachedField() throws AccessPoemException {
    Column c = _getPageTable().getLastencachedColumn();
    return new Field(c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Parent</code> value, without locking, 
  * for this <code>Page</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Integer parent
  */
  public Integer getParent_unsafe() {
    return parent;
  }


 /**
  * Sets the <code>Parent</code> value directly, without checking, 
  * for this Page <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setParent_unsafe(Integer cooked) {
    parent = cooked;
  }

 /**
  * Retrieves the Table Row Object ID. 
  *
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer read access rights 
  * @return the TROID as an <code>Integer</code> 
  */

  public Integer getParentTroid()
      throws AccessPoemException {
    readLock();
    return getParent_unsafe();
  }


 /**
  * Sets the Table Row Object ID. 
  * 
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @param raw  a Table Row Object Id 
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  */
  public void setParentTroid(Integer raw)
      throws AccessPoemException {
    setParent(raw == null ? null : 
        getSiteDatabaseTables().getPageTable().getPageObject(raw));
  }


 /**
  * Retrieves the <code>Parent</code> object reffered to.
  *  
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer read access rights 
  * @throws NoSuchRowPoemException  
  *         if the <Persistent</code> has yet to be allocated a TROID 
  * @return the <code>Parent</code> as a <code>Page</code> 
  */
  public Page getParent()
      throws AccessPoemException, NoSuchRowPoemException {
    Integer troid = getParentTroid();
    return troid == null ? null :
        getSiteDatabaseTables().getPageTable().getPageObject(troid);
  }


 /**
  * Set the Parent.
  * 
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @param cooked  a validated <code>Page</code>
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  */
  public void setParent(Page cooked)
      throws AccessPoemException {
    _getPageTable().
      getParentColumn().
        getType().assertValidCooked(cooked);
    writeLock();
    if (cooked == null)
      setParent_unsafe(null);
    else {
      cooked.existenceLock();
      setParent_unsafe(cooked.troid());
    }
  }


 /**
  * Retrieves the <code>Parent</code> value as a <code>Field</code>
  * from this <code>Page</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Integer parent
  */
  public Field getParentField() throws AccessPoemException {
    Column c = _getPageTable().getParentColumn();
    return new Field(c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Template</code> value, without locking, 
  * for this <code>Page</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Integer template
  */
  public Integer getTemplate_unsafe() {
    return template;
  }


 /**
  * Sets the <code>Template</code> value directly, without checking, 
  * for this Page <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setTemplate_unsafe(Integer cooked) {
    template = cooked;
  }

 /**
  * Retrieves the Table Row Object ID. 
  *
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer read access rights 
  * @return the TROID as an <code>Integer</code> 
  */

  public Integer getTemplateTroid()
      throws AccessPoemException {
    readLock();
    return getTemplate_unsafe();
  }


 /**
  * Sets the Table Row Object ID. 
  * 
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @param raw  a Table Row Object Id 
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  */
  public void setTemplateTroid(Integer raw)
      throws AccessPoemException {
    setTemplate(raw == null ? null : 
        (Template)getSiteDatabaseTables().getTemplateTable().getTemplateObject(raw));
  }


 /**
  * Retrieves the <code>Template</code> object reffered to.
  *  
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer read access rights 
  * @throws NoSuchRowPoemException  
  *         if the <Persistent</code> has yet to be allocated a TROID 
  * @return the <code>Template</code> as a <code>Template</code> 
  */
  public Template getTemplate()
      throws AccessPoemException, NoSuchRowPoemException {
    Integer troid = getTemplateTroid();
    return troid == null ? null :
        (Template)getSiteDatabaseTables().getTemplateTable().getTemplateObject(troid);
  }


 /**
  * Set the Template.
  * 
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @param cooked  a validated <code>Template</code>
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  */
  public void setTemplate(Template cooked)
      throws AccessPoemException {
    _getPageTable().
      getTemplateColumn().
        getType().assertValidCooked(cooked);
    writeLock();
    if (cooked == null)
      setTemplate_unsafe(null);
    else {
      cooked.existenceLock();
      setTemplate_unsafe(cooked.troid());
    }
  }


 /**
  * Retrieves the <code>Template</code> value as a <code>Field</code>
  * from this <code>Page</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Integer template
  */
  public Field getTemplateField() throws AccessPoemException {
    Column c = _getPageTable().getTemplateColumn();
    return new Field(c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Style</code> value, without locking, 
  * for this <code>Page</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Integer style
  */
  public Integer getStyle_unsafe() {
    return style;
  }


 /**
  * Sets the <code>Style</code> value directly, without checking, 
  * for this Page <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setStyle_unsafe(Integer cooked) {
    style = cooked;
  }

 /**
  * Retrieves the Table Row Object ID. 
  *
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer read access rights 
  * @return the TROID as an <code>Integer</code> 
  */

  public Integer getStyleTroid()
      throws AccessPoemException {
    readLock();
    return getStyle_unsafe();
  }


 /**
  * Sets the Table Row Object ID. 
  * 
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @param raw  a Table Row Object Id 
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  */
  public void setStyleTroid(Integer raw)
      throws AccessPoemException {
    setStyle(raw == null ? null : 
        getSiteDatabaseTables().getStyleTable().getStyleObject(raw));
  }


 /**
  * Retrieves the <code>Style</code> object reffered to.
  *  
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer read access rights 
  * @throws NoSuchRowPoemException  
  *         if the <Persistent</code> has yet to be allocated a TROID 
  * @return the <code>Style</code> as a <code>Style</code> 
  */
  public Style getStyle()
      throws AccessPoemException, NoSuchRowPoemException {
    Integer troid = getStyleTroid();
    return troid == null ? null :
        getSiteDatabaseTables().getStyleTable().getStyleObject(troid);
  }


 /**
  * Set the Style.
  * 
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @param cooked  a validated <code>Style</code>
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  */
  public void setStyle(Style cooked)
      throws AccessPoemException {
    _getPageTable().
      getStyleColumn().
        getType().assertValidCooked(cooked);
    writeLock();
    if (cooked == null)
      setStyle_unsafe(null);
    else {
      cooked.existenceLock();
      setStyle_unsafe(cooked.troid());
    }
  }


 /**
  * Retrieves the <code>Style</code> value as a <code>Field</code>
  * from this <code>Page</code> <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Integer style
  */
  public Field getStyleField() throws AccessPoemException {
    Column c = _getPageTable().getStyleColumn();
    return new Field(c.getRaw(this), c);
  }
}

