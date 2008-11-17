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
import org.melati.poem.Searchability;
import org.melati.poem.StringPoemType;
import org.melati.poem.TroidPoemType;
import org.melati.poem.ValidationPoemException;
import org.paneris.melati.site.model.SiteDatabaseTables;
import org.paneris.melati.site.model.UploadedFileTable;
import org.paneris.melati.site.model.UploadedImage;


/**
 * Melati POEM generated base class for 
<code>Table</code> <code>UploadedImage</code>.
 *
 * @see org.melati.poem.prepro.TableDef#generateTableBaseJava 
 */

public class UploadedImageTableBase extends UploadedFileTable {

  private Column col_id = null;
  private Column col_url = null;
  private Column col_height = null;
  private Column col_width = null;

 /**
  * Constructor. 
  * 
  * @see org.melati.poem.prepro.TableDef#generateTableBaseJava 
  * @param database          the POEM database we are using
  * @param name              the name of this <code>Table</code>
  * @param definitionSource  which definition is being used
  * @throws PoemException    if anything goes wrong
  */

  public UploadedImageTableBase(
      Database database, String name,
      DefinitionSource definitionSource) throws PoemException {
    super(database, name, definitionSource);
  }


 /**
  * Get the database tables.
  *
  * @see org.melati.poem.prepro.TableDef#generateTableBaseJava 
  * @return the database tables
  */
  public SiteDatabaseTables getSiteDatabaseTables() {
    return (SiteDatabaseTables)getDatabase();
  }

  public void init() throws PoemException {
    super.init();
    defineColumn(col_id =
        new Column(this, "id",
                   new TroidPoemType(),
                   DefinitionSource.dsd) { 
          public Object getCooked(Persistent g)
              throws AccessPoemException, PoemException {
            return ((UploadedImage)g).getId();
          }

          public void setCooked(Persistent g, Object cooked)
              throws AccessPoemException, ValidationPoemException {
            ((UploadedImage)g).setId((Integer)cooked);
          }

          public Field asField(Persistent g) {
            return ((UploadedImage)g).getIdField();
          }

          protected boolean defaultUserEditable() {
            return false;
          }

          protected boolean defaultUserCreateable() {
            return false;
          }

          protected DisplayLevel defaultDisplayLevel() {
            return DisplayLevel.record;
          }

          protected int defaultDisplayOrder() {
            return 0;
          }

          public Object getRaw_unsafe(Persistent g)
              throws AccessPoemException {
            return ((UploadedImage)g).getId_unsafe();
          }

          public void setRaw_unsafe(Persistent g, Object raw)
              throws AccessPoemException {
            ((UploadedImage)g).setId_unsafe((Integer)raw);
          }

          public Object getRaw(Persistent g)
              throws AccessPoemException {
            return ((UploadedImage)g).getId();
          }

          public void setRaw(Persistent g, Object raw)
              throws AccessPoemException {
            ((UploadedImage)g).setId((Integer)raw);
          }
        });

    defineColumn(col_url =
        new Column(this, "url",
                   new StringPoemType(false, -1),
                   DefinitionSource.dsd) { 
          public Object getCooked(Persistent g)
              throws AccessPoemException, PoemException {
            return ((UploadedImage)g).getUrl();
          }

          public void setCooked(Persistent g, Object cooked)
              throws AccessPoemException, ValidationPoemException {
            ((UploadedImage)g).setUrl((String)cooked);
          }

          public Field asField(Persistent g) {
            return ((UploadedImage)g).getUrlField();
          }

          protected DisplayLevel defaultDisplayLevel() {
            return DisplayLevel.primary;
          }

          protected Searchability defaultSearchability() {
            return Searchability.yes;
          }

          protected Integer defaultDisplayOrderPriority() {
            return new Integer(0);
          }

          protected int defaultDisplayOrder() {
            return 1;
          }

          protected String defaultDescription() {
            return "The name of the file, as uploaded";
          }

          protected int defaultWidth() {
            return 40;
          }

          protected String defaultRenderinfo() {
            return "ImageUpload";
          }

          public Object getRaw_unsafe(Persistent g)
              throws AccessPoemException {
            return ((UploadedImage)g).getUrl_unsafe();
          }

          public void setRaw_unsafe(Persistent g, Object raw)
              throws AccessPoemException {
            ((UploadedImage)g).setUrl_unsafe((String)raw);
          }

          public Object getRaw(Persistent g)
              throws AccessPoemException {
            return ((UploadedImage)g).getUrl();
          }

          public void setRaw(Persistent g, Object raw)
              throws AccessPoemException {
            ((UploadedImage)g).setUrl((String)raw);
          }
        });

    defineColumn(col_height =
        new Column(this, "height",
                   new IntegerPoemType(true),
                   DefinitionSource.dsd) { 
          public Object getCooked(Persistent g)
              throws AccessPoemException, PoemException {
            return ((UploadedImage)g).getHeight();
          }

          public void setCooked(Persistent g, Object cooked)
              throws AccessPoemException, ValidationPoemException {
            ((UploadedImage)g).setHeight((Integer)cooked);
          }

          public Field asField(Persistent g) {
            return ((UploadedImage)g).getHeightField();
          }

          protected DisplayLevel defaultDisplayLevel() {
            return DisplayLevel.record;
          }

          protected Searchability defaultSearchability() {
            return Searchability.no;
          }

          protected int defaultDisplayOrder() {
            return 2;
          }

          protected String defaultDescription() {
            return "The height of this file if it is an image";
          }

          public Object getRaw_unsafe(Persistent g)
              throws AccessPoemException {
            return ((UploadedImage)g).getHeight_unsafe();
          }

          public void setRaw_unsafe(Persistent g, Object raw)
              throws AccessPoemException {
            ((UploadedImage)g).setHeight_unsafe((Integer)raw);
          }

          public Object getRaw(Persistent g)
              throws AccessPoemException {
            return ((UploadedImage)g).getHeight();
          }

          public void setRaw(Persistent g, Object raw)
              throws AccessPoemException {
            ((UploadedImage)g).setHeight((Integer)raw);
          }
        });

    defineColumn(col_width =
        new Column(this, "width",
                   new IntegerPoemType(true),
                   DefinitionSource.dsd) { 
          public Object getCooked(Persistent g)
              throws AccessPoemException, PoemException {
            return ((UploadedImage)g).getWidth();
          }

          public void setCooked(Persistent g, Object cooked)
              throws AccessPoemException, ValidationPoemException {
            ((UploadedImage)g).setWidth((Integer)cooked);
          }

          public Field asField(Persistent g) {
            return ((UploadedImage)g).getWidthField();
          }

          protected DisplayLevel defaultDisplayLevel() {
            return DisplayLevel.record;
          }

          protected Searchability defaultSearchability() {
            return Searchability.no;
          }

          protected int defaultDisplayOrder() {
            return 3;
          }

          protected String defaultDescription() {
            return "The width of this file if it is an image";
          }

          public Object getRaw_unsafe(Persistent g)
              throws AccessPoemException {
            return ((UploadedImage)g).getWidth_unsafe();
          }

          public void setRaw_unsafe(Persistent g, Object raw)
              throws AccessPoemException {
            ((UploadedImage)g).setWidth_unsafe((Integer)raw);
          }

          public Object getRaw(Persistent g)
              throws AccessPoemException {
            return ((UploadedImage)g).getWidth();
          }

          public void setRaw(Persistent g, Object raw)
              throws AccessPoemException {
            ((UploadedImage)g).setWidth((Integer)raw);
          }
        });
  }


 /**
  * Retrieves the <code>Id</code> <code>Column</code> for this 
  * <code>UploadedImage</code> <code>Table</code>.
  * 
  * @see org.melati.poem.prepro.FieldDef#generateColAccessor 
  * @return the id <code>Column</code>
  */
  public final Column getIdColumn() {
    return col_id;
  }


 /**
  * Retrieves the <code>Url</code> <code>Column</code> for this 
  * <code>UploadedImage</code> <code>Table</code>.
  * 
  * @see org.melati.poem.prepro.FieldDef#generateColAccessor 
  * @return the url <code>Column</code>
  */
  public final Column getUrlColumn() {
    return col_url;
  }


 /**
  * Retrieves the <code>Height</code> <code>Column</code> for this 
  * <code>UploadedImage</code> <code>Table</code>.
  * 
  * @see org.melati.poem.prepro.FieldDef#generateColAccessor 
  * @return the height <code>Column</code>
  */
  public final Column getHeightColumn() {
    return col_height;
  }


 /**
  * Retrieves the <code>Width</code> <code>Column</code> for this 
  * <code>UploadedImage</code> <code>Table</code>.
  * 
  * @see org.melati.poem.prepro.FieldDef#generateColAccessor 
  * @return the width <code>Column</code>
  */
  public final Column getWidthColumn() {
    return col_width;
  }


 /**
  * Retrieve the <code>UploadedImage</code> as a <code>UploadedImage</code>.
  *
  * @see org.melati.poem.prepro.TableDef#generateTableBaseJava 
  * @param troid a Table Row Oject ID
  * @return the <code>Persistent</code> identified by the <code>troid</code>
  */
  public UploadedImage getUploadedImageObject(Integer troid) {
    return (UploadedImage)getObject(troid);
  }


 /**
  * Retrieve the <code>UploadedImage</code> 
  * as a <code>UploadedImage</code>.
  *
  * @see org.melati.poem.prepro.TableDef#generateTableBaseJava 
  * @param troid a Table Row Object ID
  * @return the <code>Persistent</code> identified   */
  public UploadedImage getUploadedImageObject(int troid) {
    return (UploadedImage)getObject(troid);
  }

  protected JdbcPersistent _newPersistent() {
    return new UploadedImage();
  }
  protected String defaultDisplayName() {
    return "Uploaded Image";
  }

  protected String defaultDescription() {
    return "An image uploaded by a user";
  }

  protected boolean defaultRememberAllTroids() {
    return true;
  }

  protected Integer defaultCacheLimit() {
    return new Integer(999999999);
  }

  protected String defaultCategory() {
    return "Data";
  }

  protected int defaultDisplayOrder() {
    return 310;
  }
}

