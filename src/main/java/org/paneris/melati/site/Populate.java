/*
 * $Source$
 * $Revision$
 *
 *
 * Contact details for copyright holder:
 * 
 *  Tim Pizey (timp@paneris.org)
 */
package org.paneris.melati.site;

import org.melati.Melati;
import org.melati.servlet.PoemServlet;
import org.melati.util.MelatiWriter;
import org.paneris.melati.site.model.Page;
import org.paneris.melati.site.model.SiteDatabase;

/**
 *  Url http://localhost/page/org.paneris.melati.site.Populate/site
 */

public class Populate extends PoemServlet {

  private static final long serialVersionUID = 1L;

  private SiteDatabase db;

  protected void doPoemRequest(Melati melati) throws Exception {

    db = (SiteDatabase)melati.getDatabase();

    melati.getResponse().setContentType("text/html");
    MelatiWriter output = melati.getWriter();

    output.write(
      "<html>\n"
        + "<head>\n"
        + "<title>"
        + melati.getPoemContext().getLogicalDatabase()
        + " Database Population</title>\n");
    output.write("</head>\n" + "<body>\n");
    output.write(
      "<h1 align=center>"
        + melati.getPoemContext().getLogicalDatabase()
        + " database</h1>\n");
    // set up our types 


      db.getUploadedFileTypeTable().ensure("Image");
      db.getUploadedFileTypeTable().ensure("HTML page");
      db.getUploadedFileTypeTable().ensure("HTML body");
      db.getUploadedFileTypeTable().ensure("Word doc");
      db.getUploadedFileTypeTable().ensure("PDF");
      db.getUploadedFileTypeTable().ensure("Template");

      db.getLinkTypeTable().ensure("Normal", "Internal site link");
      db.getLinkTypeTable().ensure("Popup", "Popup window");
      db.getLinkTypeTable().ensure("Offsite", "New window");

      db.getStyleTable().ensure("default");


    Page home = 
      db.getPageTable().ensure("Home", null, "Home",
          "      <h1>Welcome</h1>\n" +
          "<p>Welcome.</p>\n");


      db.getPageTable().ensure("About Us", home, 
                               "About Us", 
                               "<h1>About Us</h1>\n" +
                               "<p>\n" +
                               "Wemyss Vintage Malts came into being because of the long standing passion\n" + 
                               "the family of the same name have for malt whisky.\n" +
                               "It's as simple as that.\n" +
                               "The name is pronounced <i>Weems</i> and it's the Scots word for caves.\n" +
                               "</p>\n" +
                               "<p>\n" +
                               "The family come from Fife and their home,\n" +
                               "since the turn of the 13th century,\n" +
                               "is Wemyss Castle which sits on top of an outcrop of rocks and caves\n" +
                               "three hundred foot above the Firth of Forth looking back towards Edinburgh.\n" +
                               "</p>\n\n" +
                               "<p>\n" +
                               "Their connections with the industry date back to the turn of the 19th century \n" +
                               "when John Haig (founder of Haig's) built his first distillery on Wemyss land.\n" +
                               "Even today barley from the Wemyss Estate " + 
                               "is prized by many of the leading distillers.\n" +
                               "</p>\n");




      db.getPageTable().ensure("The Malts", home, "The Malts", 
          "<h1>The Malts</h1>\n" +
          "<p>\n" +
          "Each cask of malt has its own unique character,\n" +
          "so it is not suprising that distilleries blend together many different\n" +
          "casks to achieve taste consistency for their single malt brands -\n" +
          "it makes a lot of sense.\n" +
          "We believe that by doing this something can get lost.\n" + 
          "</p>\n" +
          "<p>\n" +
          "Our malts are from a single cask.\n" +
          "The casks are meticulously selected,\n" +
          "with the help of industry expert Charlie Maclean\n" +
          "(author of eight books on the subject of malt whisky),\n" +
          "and only the truly exceptional casks are chosen.\n" +
          "These casks, due to their individuality,\n" +
          "are not necessarily representative of the distillery make and \n" +
          "consequently each one is attributed a name based on its own taste and aroma.\n" +
          "Due to the nature of a single cask selection supply is very limited\n" +
          "and is usually restricted to between three and four hundred bottles.\n" +
          "</p>\n" +
          "<p>\n" +
          "All are bottled at a minimum of 46% with a select few being bottled at\n" +
          "cask strength under The Earl's Reserve label.\n" +
          "None of them are chill-filtered as well as being fee of artificial colouring,\n" +
          "such as caramel.\n" +
          "That way they reach you in their natural state.\n" +
          "</p>\n" +
          "<p>\n" +
          "For list of available casks please goto the <a href='Sales.html'>sales</a> page.\n" +
          "</p>");



      db.getPageTable().ensure("The Regions", home, "The Regions", 
    "        <h1>The Regions</h1>\n" +
    "        <p> The core of our philosophy at Wemyss Vintage Malts is that our malts\n" + 
    "          should reflect the region from which they come. Consequently, we present\n" + 
    "          our malts on a regional basis reflecting the different taste profiles. \n" +
    "        </p><br>\n" +
    "        <p> Currently, there are four different malts in the range: Speyside,\n" + 
    "          Highland, Islay and Lowland. </p>\n" +
    "        <p> The following provides a brief overview of the taste profiles of the\n" + 
    "          different regions: </p><br>\n" +
    "        <h2>Islay</h2>\n" +
    "        <p> The most distinctively flavoured of all malts. The island has a bountiful\n" + 
    "          supply of peat which is constantly lashed by the wind, rain and sea. \n" +
    "          All these elements come through strongly in its malts, often described \n" +
    "          as <i>seaweed</i>, <i>iodine</i> or even <i>peat monsters</i>. In all \n" +
    "          there are eight distilleries, but not all are working. </p><br>\n" +
    "        <h2>Highland</h2>\n" +
    "        <p> The most geographically spread out region which consequently has the \n" + 
    "          most taste diversity. Many of the more northern malts have spicy or \n" +
    "          heathery characteristics whilst the Eastern Highlands are more fruity. \n" +
    "        </p><br>\n" +
    "        <h2>Speyside</h2>\n" +
    "        <p> Really a sub region of Highland, but they are noted for their elegance,\n" + 
    "          complexity and sweetness/mellow characteristics. More than 40 distilleries\n" + 
    "          are present in this region which stretches from the River Findhorn in \n" +
    "          the West to the Deveron in the East, and takes in the Livet. </p><br>\n" +
    "        <h2>Lowland</h2>\n" +
    "        <p> Tends to produce whiskies which are softer and more approachable,\n" + 
    "          with a general lack of peatiness of its Highland cousins. The region \n" +
    "          today has only two operating distilleries. Generally much more mellow. \n" +
    "        </p><br>\n" +
    "        <h2>Campbeltown</h2>\n" +
    "        <p> Briny in character with a hint of peatiness. A connoisseur's region.\n" + 
    "          The region once had about thirty distilleries, today it has only two. \n" +
    "        </p>\n");

 
      db.getPageTable().ensure("News", home, "News",
          "<h1>News</h1>\n" +
          "<p>\n" +
          "<font color='green'>\n" +
          "      Same as <a href='http://www.fontyspoolwines.com.au/news/'>" + 
          "Fonty's Pool web site</a> ie so we can upload Press Releases and \n" +
          "      also a 'subscribe to our newsletter' as a drop down menu.\n" +
          "</font>\n" +
          "</p>");

 
      db.getPageTable().ensure("Sales", home, "Sales",
    "<h1>Sales</h1>\n" +
    "<p> You can purchase the full range of single casks directly by filling\n" + 
    "  in the order form below. You will then be contacted for payment. Orders \n" +
    "  of less than &pound;50 unfortunately necessitate a &pound;6.50 delivery \n" +
    "  charge to mainland UK. For other destinations please contact us. </p>\n" +
    "<p><font color='green'>(An online order form as per " + 
    "<a href='http://www.fontyspoolwines.com.au/sales/'>Fonty's</a>, not secure\n" + 
    "  e-commerce, which arrives via email to do@wdc.co.uk. Must be changeable)</font>\n" + 
    "</p>\n" +
    "<table width='90%' border='1' align='left' " + 
    "cellpadding='3' cellspacing='2' bordercolor='#FFFFFF' bgcolor='#CCCC99' class='sales'>\n" +
    "  <tr bgcolor='#CCCC99'> \n" +
    "    <th class='sales'> Item </th>\n" +
    "    <th class='sales'> Tasting Note </th>\n" +
    "    <th class='sales'> Price </th>\n" +
    "    <th class='sales'> Quantity </th>\n" +
    "  </tr>\n" +
    "  <tr align='left' valign='middle' bgcolor='#FFFFCC'>\n" + 
    "    <td class='sales'> Single Highland Malt, 13 yr old </td>\n" +
    "    <td class='sales'> Fruity and juicy on the nose, just like the apples.\n" + 
    "     An all purpose malt. </td>\n" +
    "    <td class='sales'> &pound;35.00 </td>\n" +
    "    <td class='sales'>&nbsp; </td>\n" +
    "  </tr>\n" +
    "</table>\n");

 
      db.getPageTable().ensure("Contact Us", home, "Contact Us", 
         "<h1>Contact Us</h1>\n" +
          "<address>\n" +
          "Wemyss Vintage Malts Ltd,\n" +
          "<br>\n" +
          "Mains House,\n" +
          "<br>\n" +
          "East Wemyss,\n" +
          "<br>\n" +
          "Fife KY1 4TE\n" +
          "<br>\n" +
          "<br>\n" +
          "Tel: 01592-651-316\n" +
          "<br>\n" +
          "Fax: 1592-653233\n" +
          "<br>\n" +
          "Email: info@W-V-M.co.uk <font color='green'>(needs setting up)</font>\n" +
          "</address>\n" 
     );
      
     db.getPageTable().ensure("Trade Info", home, "Trade Info",
        "<h1>Trade Info</h1>\n" +
        "<p>\n" +
        "For enquiries relating to distribution of our products please contact:\n" +
        "</p>\n" +
        "<h2>United Kingdom</h2>\n" +
        "<address>\n" +
        "Boutinot uk\n" +
        "<br>\n" +
        "Boutinot Limited, Brook House\n" +
        "<br>\n" +
        "Northenden Road, Gatley\n" +
        "<br>\n" +
        "Cheshire, SK8 4DN\n" +
        "<br>\n" +
        "<br>\n" +
        "Tel: 0161-908-1300\n" +
        "<br>\n" +
        "Email: jeanw@boutinot.com\n" +
        "</address>\n" +
        "<h2>EU</h2>\n" +
        "<address>\n" +
        "Rimauresq sarl\n" +
        "<br>\n" +
        "c/o Rimauresq SA\n" +
        "<br>\n" +
        "Quartier Rimaurets\n" +
        "<br>\n" +
        "83790 Pignans\n" + 
        "<br>\n" +
        "VAR\n" +
        "<br>\n" +
        "FRANCE\n" +
        "<br>\n" +
        "<br>\n" +
        "Tel: +33 494-48-80-45\n" +
        "<br>\n" +
        "Email: rimauresq@wanadoo.fr\n" +
        "</address>\n" +
        "<h2>Australasia</h2>\n" +
        "<address>\n" +
        "Fonty's Pool vineyards pty ltd,\n" +
        "<br>\n" +
        "PO Box 1709,\n" + 
        "Manjimup, \n" +
        "<br>\n" +
        "WA 6258, \n" +
        "<br>\n" +
        "Australia\n" +
        "<br>\n" +
        "<br>\n" +
        "Tel: +61 8 9777 0788\n" +
        "<br>\n" +
        "Email: info@fontyspoolwines.com.au\n" +
        "</address>");
     
/*
 This must not exist for the template to be found.

    Page siteMap = 
      db.getPageTable().ensure("Site Map", home);
*/


    output.write(
      "<h1 align=center><font color='green'>"
        + " Populated</font></h1>\n");
    output.write("</body>\n" + "</html>\n");

    return;
  }

}
