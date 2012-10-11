// Do not edit this file!  It was generated by Melati POEM's DSD preprocessor.

package org.paneris.melati.site.model.generated;


import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import org.melati.poem.AccessPoemException;
import org.melati.poem.CachedSelection;
import org.melati.poem.Column;
import org.melati.poem.Field;
import org.melati.poem.JdbcPersistent;
import org.melati.poem.ValidationPoemException;
import org.melati.poem.util.EmptyEnumeration;
import org.paneris.melati.site.model.Div;
import org.paneris.melati.site.model.Page;
import org.paneris.melati.site.model.SiteDatabaseTables;
import org.paneris.melati.site.model.Style;
import org.paneris.melati.site.model.StyleTable;


/**
 * Melati POEM generated abstract base class for a <code>Persistent</code> 
 * <code>Style</code> Object.
 *
 * see org.melati.poem.prepro.TableDef#generatePersistentBaseJava 
 */
public abstract class StyleBase extends JdbcPersistent {


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
  * Retrieves the  <code>StyleTable</code> table 
  * which this <code>Persistent</code> is from.
  * 
  * see org.melati.poem.prepro.TableDef#generatePersistentBaseJava 
  * @return the StyleTable
  */
  @SuppressWarnings("unchecked")
  public StyleTable<Style> getStyleTable() {
    return (StyleTable<Style>)getTable();
  }

  @SuppressWarnings("unchecked")
  private StyleTable<Style> _getStyleTable() {
    return (StyleTable<Style>)getTable();
  }

  // Fields in this table 
 /**
  * id 
  */
  protected Integer id;
 /**
  * Name - The Class id 
  */
  protected String name;


 /**
  * Retrieves the <code>Id</code> value, without locking, 
  * for this <code>Style</code> <code>Persistent</code>.
  *
  * see org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Integer id
  */
  public Integer getId_unsafe() {
    return id;
  }


 /**
  * Sets the <code>Id</code> value directly, without checking, 
  * for this Style <code>Persistent</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setId_unsafe(Integer cooked) {
    id = cooked;
  }

 /**
  * Retrieves the Id value, with locking, for this 
  * <code>Style</code> <code>Persistent</code>.
  * 
  * Generated by org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Id</code> for this 
  *         <code>Style</code> <code>Persistent</code>  
  */

  public Integer getId()
      throws AccessPoemException {
    readLock();
    return getId_unsafe();
  }


 /**
  * Sets the <code>Id</code> value, with checking, for this 
  * <code>Style</code> <code>Persistent</code>.
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
    _getStyleTable().getIdColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setId_unsafe(cooked);
  }

 /**
  * Sets the <code>Id</code> value, with checking, for this 
  * <code>Style</code> <code>Persistent</code>.
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
  * from this <code>Style</code> <code>Persistent</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the Integer id
  */
  public Field<Integer> getIdField() throws AccessPoemException {
    Column<Integer> c = _getStyleTable().getIdColumn();
    return new Field<Integer>((Integer)c.getRaw(this), c);
  }


 /**
  * Retrieves the <code>Name</code> value, without locking, 
  * for this <code>Style</code> <code>Persistent</code>.
  *
  * see org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the String name
  */
  public String getName_unsafe() {
    return name;
  }


 /**
  * Sets the <code>Name</code> value directly, without checking, 
  * for this Style <code>Persistent</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  public void setName_unsafe(String cooked) {
    name = cooked;
  }

 /**
  * Retrieves the Name value, with locking, for this 
  * <code>Style</code> <code>Persistent</code>.
  * Field description: 
  *   The Class id 
  * 
  * Generated by org.melati.poem.prepro.AtomFieldDef#generateBaseMethods 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  * @return the value of the field <code>Name</code> for this 
  *         <code>Style</code> <code>Persistent</code>  
  */

  public String getName()
      throws AccessPoemException {
    readLock();
    return getName_unsafe();
  }


 /**
  * Sets the <code>Name</code> value, with checking, for this 
  * <code>Style</code> <code>Persistent</code>.
  * Field description: 
  *   The Class id 
  * 
  * Generated by org.melati.poem.prepro.AtomFieldDef#generateBaseMethods  
  * @param cooked  a validated <code>int</code> 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @throws ValidationPoemException 
  *         if the value is not valid
  */
  public void setName(String cooked)
      throws AccessPoemException, ValidationPoemException {
    _getStyleTable().getNameColumn().
      getType().assertValidCooked(cooked);
    writeLock();
    setName_unsafe(cooked);
  }


 /**
  * Retrieves the <code>Name</code> value as a <code>Field</code>
  * from this <code>Style</code> <code>Persistent</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateFieldCreator 
  * @throws AccessPoemException 
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  * @return the String name
  */
  public Field<String> getNameField() throws AccessPoemException {
    Column<String> c = _getStyleTable().getNameColumn();
    return new Field<String>((String)c.getRaw(this), c);
  }

  private CachedSelection<Page> stylePages = null;
  /** References to this Style in the Page table via its style field.*/
  @SuppressWarnings("unchecked")
  public Enumeration<Page> getStylePages() {
    if (getTroid() == null)
      return new EmptyEnumeration<Page>();
    else {
      if (stylePages == null)
        stylePages =
          getSiteDatabaseTables().getPageTable().getStyleColumn().cachedSelectionWhereEq(getTroid());
      return stylePages.objects();
    }
  }


  /** References to this Style in the Page table via its style field, as a List.*/
  public List<Page> getStylePageList() {
    return Collections.list(getStylePages());
  }



  private CachedSelection<Div> styleDivs = null;
  /** References to this Style in the Div table via its style field.*/
  @SuppressWarnings("unchecked")
  public Enumeration<Div> getStyleDivs() {
    if (getTroid() == null)
      return new EmptyEnumeration<Div>();
    else {
      if (styleDivs == null)
        styleDivs =
          getSiteDatabaseTables().getDivTable().getStyleColumn().cachedSelectionWhereEq(getTroid());
      return styleDivs.objects();
    }
  }


  /** References to this Style in the Div table via its style field, as a List.*/
  public List<Div> getStyleDivList() {
    return Collections.list(getStyleDivs());
  }



}

