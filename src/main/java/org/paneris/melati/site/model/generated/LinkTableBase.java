// Do not edit this file!  It was generated by Melati POEM's DSD preprocessor.

package org.paneris.melati.site.model.generated;


import org.melati.poem.AccessPoemException;
import org.melati.poem.Column;
import org.melati.poem.Database;
import org.melati.poem.DefinitionSource;
import org.melati.poem.DisplayLevel;
import org.melati.poem.Field;
import org.melati.poem.IntegerPoemType;
import org.melati.poem.JdbcPersistent;
import org.melati.poem.Persistent;
import org.melati.poem.PoemException;
import org.melati.poem.ReferencePoemType;
import org.melati.poem.Searchability;
import org.melati.poem.StandardIntegrityFix;
import org.melati.poem.StringPoemType;
import org.melati.poem.TroidPoemType;
import org.melati.poem.ValidationPoemException;
import org.paneris.melati.site.model.Link;
import org.paneris.melati.site.model.LinkType;
import org.paneris.melati.site.model.Page;
import org.paneris.melati.site.model.SiteDatabaseTables;
import org.paneris.melati.site.model.SiteTable;


/**
 * Melati POEM generated base class for <code>Table</code> <code>Link</code>.
 *
 * see org.melati.poem.prepro.TableDef#generateTableBaseJava 
 */

public class LinkTableBase<T extends Link> extends SiteTable<T> {

  private Column<Integer> col_id = null;
  private Column<Integer> col_page = null;
  private Column<Integer> col_type = null;
  private Column<String> col_url = null;
  private Column<String> col_displayname = null;
  private Column<Integer> col_displayorder = null;

 /**
  * Constructor. 
  * 
  * see org.melati.poem.prepro.TableDef#generateTableBaseJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being used
  * @throws PoemException    if anything goes wrong
  */

  public LinkTableBase(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }


 /**
  * Get the database tables.
  *
  * see org.melati.poem.prepro.TableDef#generateTableBaseJava 
  * @return the database tables
  */
  public SiteDatabaseTables getSiteDatabaseTables() {
    return (SiteDatabaseTables)getDatabase();
  }


 /**
  * Initialise this table by defining its columns.
  *
  * see org.melati.poem.prepro.TableDef#generateTableBaseJava 
  */
  public void init() throws PoemException {
    super.init();
    defineColumn(col_id =
        new Column<Integer>(this, "id",
                   new TroidPoemType(),
                   DefinitionSource.dsd) { 
          public Object getCooked(Persistent g)
              throws AccessPoemException, PoemException {
            return ((Link)g).getId();
          }

          public void setCooked(Persistent g, Object cooked)
              throws AccessPoemException, ValidationPoemException {
            ((Link)g).setId((Integer)cooked);
          }

          public Field<Integer> asField(Persistent g) {
            return ((Link)g).getIdField();
          }

          public boolean defaultUserEditable() {
            return false;
          }

          public boolean defaultUserCreateable() {
            return false;
          }

          public DisplayLevel defaultDisplayLevel() {
            return DisplayLevel.record;
          }

          public int defaultDisplayOrder() {
            return 0;
          }

          public Object getRaw_unsafe(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getId_unsafe();
          }

          public void setRaw_unsafe(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setId_unsafe((Integer)raw);
          }

          public Object getRaw(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getId();
          }

          public void setRaw(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setId((Integer)raw);
          }
        });

    defineColumn(col_page =
        new Column<Integer>(this, "page",
                   new ReferencePoemType(getSiteDatabaseTables().
                                             getPageTable(), false),
                   DefinitionSource.dsd) { 
          public Object getCooked(Persistent g)
              throws AccessPoemException, PoemException {
            return ((Link)g).getPage();
          }

          public void setCooked(Persistent g, Object cooked)
              throws AccessPoemException, ValidationPoemException {
            ((Link)g).setPage((Page)cooked);
          }

          public Field<Integer> asField(Persistent g) {
            return ((Link)g).getPageField();
          }

          public Searchability defaultSearchability() {
            return Searchability.primary;
          }

          public Integer defaultDisplayOrderPriority() {
            return new Integer(1);
          }

          public int defaultDisplayOrder() {
            return 1;
          }

          public String defaultDescription() {
            return "The page to which the link is relevant";
          }

          public boolean defaultIndexed() {
            return true;
          }

          public String defaultRenderinfo() {
            return "SelectionWindow";
          }

          public Object getRaw_unsafe(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getPage_unsafe();
          }

          public void setRaw_unsafe(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setPage_unsafe((Integer)raw);
          }

          public Object getRaw(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getPageTroid();
          }

          public void setRaw(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setPageTroid((Integer)raw);
          }

          public StandardIntegrityFix defaultIntegrityFix() {
            return StandardIntegrityFix.delete;
          }
        });

    defineColumn(col_type =
        new Column<Integer>(this, "type",
                   new ReferencePoemType(getSiteDatabaseTables().
                                             getLinkTypeTable(), false),
                   DefinitionSource.dsd) { 
          public Object getCooked(Persistent g)
              throws AccessPoemException, PoemException {
            return ((Link)g).getType();
          }

          public void setCooked(Persistent g, Object cooked)
              throws AccessPoemException, ValidationPoemException {
            ((Link)g).setType((LinkType)cooked);
          }

          public Field<Integer> asField(Persistent g) {
            return ((Link)g).getTypeField();
          }

          public int defaultDisplayOrder() {
            return 2;
          }

          public String defaultDescription() {
            return "The type of this link";
          }

          public Object getRaw_unsafe(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getType_unsafe();
          }

          public void setRaw_unsafe(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setType_unsafe((Integer)raw);
          }

          public Object getRaw(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getTypeTroid();
          }

          public void setRaw(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setTypeTroid((Integer)raw);
          }
        });

    defineColumn(col_url =
        new Column<String>(this, "url",
                   new StringPoemType(false, -1),
                   DefinitionSource.dsd) { 
          public Object getCooked(Persistent g)
              throws AccessPoemException, PoemException {
            return ((Link)g).getUrl();
          }

          public void setCooked(Persistent g, Object cooked)
              throws AccessPoemException, ValidationPoemException {
            ((Link)g).setUrl((String)cooked);
          }

          public Field<String> asField(Persistent g) {
            return ((Link)g).getUrlField();
          }

          public String defaultDisplayName() {
            return "URL";
          }

          public int defaultDisplayOrder() {
            return 3;
          }

          public String defaultDescription() {
            return "The full URL for the site's front page";
          }

          public Object getRaw_unsafe(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getUrl_unsafe();
          }

          public void setRaw_unsafe(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setUrl_unsafe((String)raw);
          }

          public Object getRaw(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getUrl();
          }

          public void setRaw(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setUrl((String)raw);
          }
        });

    defineColumn(col_displayname =
        new Column<String>(this, "displayname",
                   new StringPoemType(false, -1),
                   DefinitionSource.dsd) { 
          public Object getCooked(Persistent g)
              throws AccessPoemException, PoemException {
            return ((Link)g).getDisplayname();
          }

          public void setCooked(Persistent g, Object cooked)
              throws AccessPoemException, ValidationPoemException {
            ((Link)g).setDisplayname((String)cooked);
          }

          public Field<String> asField(Persistent g) {
            return ((Link)g).getDisplaynameField();
          }

          public DisplayLevel defaultDisplayLevel() {
            return DisplayLevel.primary;
          }

          public String defaultDisplayName() {
            return "Display name";
          }

          public int defaultDisplayOrder() {
            return 4;
          }

          public String defaultDescription() {
            return "The site's name";
          }

          public Object getRaw_unsafe(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getDisplayname_unsafe();
          }

          public void setRaw_unsafe(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setDisplayname_unsafe((String)raw);
          }

          public Object getRaw(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getDisplayname();
          }

          public void setRaw(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setDisplayname((String)raw);
          }
        });

    defineColumn(col_displayorder =
        new Column<Integer>(this, "displayorder",
                   new IntegerPoemType(false),
                   DefinitionSource.dsd) { 
          public Object getCooked(Persistent g)
              throws AccessPoemException, PoemException {
            return ((Link)g).getDisplayorder();
          }

          public void setCooked(Persistent g, Object cooked)
              throws AccessPoemException, ValidationPoemException {
            ((Link)g).setDisplayorder((Integer)cooked);
          }

          public Field<Integer> asField(Persistent g) {
            return ((Link)g).getDisplayorderField();
          }

          public Integer defaultDisplayOrderPriority() {
            return new Integer(0);
          }

          public int defaultDisplayOrder() {
            return 5;
          }

          public Object getRaw_unsafe(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getDisplayorder_unsafe();
          }

          public void setRaw_unsafe(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setDisplayorder_unsafe((Integer)raw);
          }

          public Object getRaw(Persistent g)
              throws AccessPoemException {
            return ((Link)g).getDisplayorder();
          }

          public void setRaw(Persistent g, Object raw)
              throws AccessPoemException {
            ((Link)g).setDisplayorder((Integer)raw);
          }
        });
  }


 /**
  * Retrieves the <code>Id</code> <code>Column</code> for this 
  * <code>Link</code> <code>Table</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateColAccessor 
  * @return the id <code>Column</code>
  */
  public final Column<Integer> getIdColumn() {
    return col_id;
  }


 /**
  * Retrieves the <code>Page</code> <code>Column</code> for this 
  * <code>Link</code> <code>Table</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateColAccessor 
  * @return the page <code>Column</code>
  */
  public final Column<Integer> getPageColumn() {
    return col_page;
  }


 /**
  * Retrieves the <code>Type</code> <code>Column</code> for this 
  * <code>Link</code> <code>Table</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateColAccessor 
  * @return the type <code>Column</code>
  */
  public final Column<Integer> getTypeColumn() {
    return col_type;
  }


 /**
  * Retrieves the <code>Url</code> <code>Column</code> for this 
  * <code>Link</code> <code>Table</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateColAccessor 
  * @return the url <code>Column</code>
  */
  public final Column<String> getUrlColumn() {
    return col_url;
  }


 /**
  * Retrieves the <code>Displayname</code> <code>Column</code> for this 
  * <code>Link</code> <code>Table</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateColAccessor 
  * @return the displayname <code>Column</code>
  */
  public final Column<String> getDisplaynameColumn() {
    return col_displayname;
  }


 /**
  * Retrieves the <code>Displayorder</code> <code>Column</code> for this 
  * <code>Link</code> <code>Table</code>.
  * 
  * see org.melati.poem.prepro.FieldDef#generateColAccessor 
  * @return the displayorder <code>Column</code>
  */
  public final Column<Integer> getDisplayorderColumn() {
    return col_displayorder;
  }


 /**
  * Retrieve the <code>Link</code> as a <code>Link</code>.
  *
  * see org.melati.poem.prepro.TableDef#generateTableBaseJava 
  * @param troid a Table Row Oject ID
  * @return the <code>Persistent</code> identified by the <code>troid</code>
  */
  public Link getLinkObject(Integer troid) {
    return (Link)getObject(troid);
  }


 /**
  * Retrieve the <code>Link</code> 
  * as a <code>Link</code>.
  *
  * see org.melati.poem.prepro.TableDef#generateTableBaseJava 
  * @param troid a Table Row Object ID
  * @return the <code>Persistent</code> identified   */
  public Link getLinkObject(int troid) {
    return (Link)getObject(troid);
  }

  protected JdbcPersistent _newPersistent() {
    return new Link();
  }
  public String defaultDisplayName() {
    return "Link";
  }

  public String defaultDescription() {
    return "A link";
  }

  public String defaultCategory() {
    return "Data";
  }

  public int defaultDisplayOrder() {
    return 700;
  }
}

