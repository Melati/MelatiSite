// Do not edit this file!  It was generated by Melati POEM's DSD preprocessor.

package org.paneris.melati.site.model.generated;


import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import org.melati.poem.AccessPoemException;
import org.melati.poem.CachedSelection;
import org.melati.poem.Column;
import org.melati.poem.Field;
import org.melati.poem.ValidationPoemException;
import org.melati.poem.util.EmptyEnumeration;
import org.paneris.melati.site.model.Page;
import org.paneris.melati.site.model.SiteDatabaseTables;
import org.paneris.melati.site.model.Template;
import org.paneris.melati.site.model.TemplateTable;
import org.paneris.melati.site.model.UploadedFile;


/**
 * Melati POEM generated abstract base class for a <code>Persistent</code> 
 * <code>Template</code> Object.
 *
 * see org.melati.poem.prepro.TableDef#generatePersistentBaseJava 
 */
public abstract class TemplateBase extends UploadedFile {


 /**
  * Retrieves the Database object.
  * 
  * see org.melati.poem.prepro.TableDef#generatePersistentBaseJava 
  * @return the database
  */
  public SiteDatabaseTables getSiteDatabaseTables() {
    return (SiteDatabaseTables)getDatabase();
  }


 /**
  * Retrieves the  <code>TemplateTable</code> table 
  * which this <code>Persistent</code> is from.
  * 
  * see org.melati.poem.prepro.TableDef#generatePersistentBaseJava 
  * @return the TemplateTable
  */
  @SuppressWarnings("unchecked")
  public TemplateTable<Template> getTemplateTable() {
    return (TemplateTable<Template>)getTable();
  }

  @SuppressWarnings("unchecked")
  private TemplateTable<Template> _getTemplateTable() {
    return (TemplateTable<Template>)getTable();
  }

  // Fields in this table 
 /**
  * id 
  */
  protected Integer id;
 /**
  * url - Key by which template engine can locate template, no need for 
  * extension 
  */
  protected String url;


 /**
  * Retrieves the <code>Id</code> value, without locking, 
  * for this <code>Template</code> <code>Persistent</code>.
  *
  * see org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Integer id
  */
  public Integer getId_unsafe() {
    return id;
  }


 /**
  * Sets the <code>Id</code> value directly, without checking, 
  * for this Template <code>Persistent</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setId_unsafe(Integer cooked) {
    id = cooked;
  }

 /**
  * Retrieves the Id value, with locking, for this 
  * <code>Template</code> <code>Persistent</code>.
  * 
  * Generated by org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Id</code> for this 
  *         <code>Template</code> <code>Persistent</code>  
  */

  public Integer getId()
      throws AccessPoemException {
    readLock();
    return getId_unsafe();
  }


 /**
  * Sets the <code>Id</code> value, with checking, for this 
  * <code>Template</code> <code>Persistent</code>.
  * 
  * Generated by org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setId(Integer cooked)
      throws AccessPoemException, ValidationPoemException {
    _getTemplateTable().getIdColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setId_unsafe(cooked);
  }

 /**
  * Sets the <code>Id</code> value, with checking, for this 
  * <code>Template</code> <code>Persistent</code>.
  * 
  * Generated by org.melati.poem.prepro.IntegerFieldDef#generateBaseMethods 
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
  * from this <code>Template</code> <code>Persistent</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Integer id
  */
  public Field<Integer> getIdField() throws AccessPoemException {
    Column<Integer> c = _getTemplateTable().getIdColumn();
    return new Field<Integer>((Integer)c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Url</code> value, without locking, 
  * for this <code>Template</code> <code>Persistent</code>.
  *
  * see org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the String url
  */
  public String getUrl_unsafe() {
    return url;
  }


 /**
  * Sets the <code>Url</code> value directly, without checking, 
  * for this Template <code>Persistent</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setUrl_unsafe(String cooked) {
    url = cooked;
  }

 /**
  * Retrieves the Url value, with locking, for this 
  * <code>Template</code> <code>Persistent</code>.
  * Field description: 
  *   Key by which template engine can locate template, no need for extension 
  * 
  * Generated by org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Url</code> for this 
  *         <code>Template</code> <code>Persistent</code>  
  */

  public String getUrl()
      throws AccessPoemException {
    readLock();
    return getUrl_unsafe();
  }


 /**
  * Sets the <code>Url</code> value, with checking, for this 
  * <code>Template</code> <code>Persistent</code>.
  * Field description: 
  *   Key by which template engine can locate template, no need for extension 
  * 
  * Generated by org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setUrl(String cooked)
      throws AccessPoemException, ValidationPoemException {
    _getTemplateTable().getUrlColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setUrl_unsafe(cooked);
  }


 /**
  * Retrieves the <code>Url</code> value as a <code>Field</code>
  * from this <code>Template</code> <code>Persistent</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the String url
  */
  public Field<String> getUrlField() throws AccessPoemException {
    Column<String> c = _getTemplateTable().getUrlColumn();
    return new Field<String>((String)c.getRaw(this), c);
  }

  private CachedSelection<Page> templatePages = null;
  /** References to this Template in the Page table via its template field.*/
  @SuppressWarnings("unchecked")
  public Enumeration<Page> getTemplatePages() {
    if (getTroid() == null)
      return new EmptyEnumeration<Page>();
    else {
      if (templatePages == null)
        templatePages =
          getSiteDatabaseTables().getPageTable().getTemplateColumn().cachedSelectionWhereEq(getTroid());
      return templatePages.objects();
    }
  }


  /** References to this Template in the Page table via its template field, as a List.*/
  public List<Page> getTemplatePageList() {
    return Collections.list(getTemplatePages());
  }



}

