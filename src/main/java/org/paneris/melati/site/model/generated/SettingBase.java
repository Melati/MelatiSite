// Do not edit this file!  It was generated by Melati POEM's DSD preprocessor.

package org.paneris.melati.site.model.generated;


import org.melati.poem.Setting;
import org.paneris.melati.site.model.SettingTable;
import org.paneris.melati.site.model.SiteDatabaseTables;


/**
 * Melati POEM generated abstract base class for a <code>Persistent</code> 
 * <code>Setting</code> Object.
 *
 * see org.melati.poem.prepro.TableDef#generatePersistentBaseJava 
 */
public abstract class SettingBase extends Setting {


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
  * Retrieves the  <code>SettingTable</code> table 
  * which this <code>Persistent</code> is from.
  * 
  * see org.melati.poem.prepro.TableDef#generatePersistentBaseJava 
  * @return the org.melati.poem.SettingTable
  */
  public org.melati.poem.SettingTable getSettingTable() {
    return (org.melati.poem.SettingTable)getTable();
  }

  // There are no Fields in this table, only in its ancestors 

}

