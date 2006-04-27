/*
 *
 * Created on 16-Dec-2003
 *
 * @author timp@paneris.org
 *
 */
package org.paneris.melati.site.model;

import org.melati.poem.AccessPoemException;
import org.melati.poem.Field;
import org.melati.poem.NoSuchRowPoemException;

/**
 * An object with a template field. 
 * 
 * @author timp@paneris.org
 *
 */
public interface Templated {
  /**
  * Retrieves the <code>Template</code> value, without locking, 
  * for this <code>Page</code> <code>Persistent</code>.
  *
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @return the Integer template
  */
  
  Integer getTemplate_unsafe();
  /**
  * Sets the <code>Template</code> value directly, without checking, 
  * for this Page <code>Persistent</code>.
  * 
  * @generator org.melati.poem.prepro.FieldDef#generateBaseMethods 
  * @param cooked  the pre-validated value to set
  */
  
  void setTemplate_unsafe(Integer cooked);
  /**
  * Retrieves the Table Row Object ID. 
  *
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer read access rights 
  * @return the TROID as an <code>Integer</code> 
  */
  
  Integer getTemplateTroid() throws AccessPoemException;
  /**
  * Sets the Table Row Object ID. 
  * 
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @param raw  a Table Row Object Id 
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights
  */
  void setTemplateTroid(Integer raw)
    throws AccessPoemException;
  
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
  Template getTemplate()
    throws AccessPoemException, NoSuchRowPoemException;
  
  /**
  * Set the Template.
  * 
  * @generator org.melati.poem.prepro.ReferenceFieldDef#generateBaseMethods 
  * @param cooked  a validated <code>Template</code>
  * @throws AccessPoemException  
  *         if the current <code>AccessToken</code> 
  *         does not confer write access rights 
  */
  void setTemplate(Template cooked) throws AccessPoemException;
  
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
  Field getTemplateField() throws AccessPoemException;
}
