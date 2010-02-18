/*
 * $Source$
 * $Revision$
 *
 * Copyright (C) 2008 Tim Pizey
 *
 * Part of Melati (http://melati.org), a framework for the rapid
 * development of clean, maintainable web applications.
 *
 * Melati is free software; Permission is granted to copy, distribute
 * and/or modify this software under the terms either:
 *
 * a) the GNU General Public License as published by the Free Software
 *    Foundation; either version 2 of the License, or (at your option)
 *    any later version,
 *
 *    or
 *
 * b) any version of the Melati Software License, as published
 *    at http://melati.org
 *
 * You should have received a copy of the GNU General Public License and
 * the Melati Software License along with this program;
 * if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA to obtain the
 * GNU General Public License and visit http://melati.org to obtain the
 * Melati Software License.
 *
 * Feel free to contact the Developers of Melati (http://melati.org),
 * if you would like to work out a different arrangement than the options
 * outlined here.  It is our intention to allow Melati to be used by as
 * wide an audience as possible.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Contact details for copyright holder:
 *
 *     Tim Pizey <timp At paneris.org>
 *     http://paneris.org/~timp
 */

package org.paneris.melati.site;

import org.melati.Melati;

/**
 * A little something to generate alternating colours.
 * 
 * Test with something like http://localhost:8080/Display/melatitest/Contrast
 * @author timp
 * @since  3 Mar 2009
 *
 */
public class ColourChooser {

  /**
   * Constructor.
   * @param melati required by getContextUtil
   */
  public ColourChooser(Melati melati) {
  }

    /**
     * Return a contrasting colour given a colour.
     * 
     * @param rgb
     *          the colour to contrast with
     * @return the colour string
     */
    public static String contrastingColour(String rgb) {
      if (rgb.length() != 6)
        throw new IllegalArgumentException(rgb);
      //float divisor = new Float(1.7).floatValue();
      String red = rgb.substring(0, 2);
      String green = rgb.substring(2, 4);
      String blue = rgb.substring(4);

      float redI = new Float(Integer.parseInt(red, 16)).floatValue();
      float greenI = new Float(Integer.parseInt(green, 16)).floatValue();
      float blueI = new Float(Integer.parseInt(blue, 16)).floatValue();
      float luminence = redI + greenI + blueI;
      float redNew;
      float greenNew;
      float blueNew;
      if (luminence > ((3 * 255) / 2.5)) {
        // r>b>g
        // r>g>b
        // g>r>b
        // b>r>g
        // b>g>r
        // g>b>r
        if (redI > blueI) {
          if (blueI > greenI) { // r>b>g
            redNew = greenI;
            greenNew = redI;
            blueNew = blueI - 30;
          } else {
            if (redI > greenI) { // r>g>b
              redNew = blueI;
              greenNew = greenI - 30 ;
              blueNew = redI ;
            } else {           // g>r>b
              redNew = redI - 30;
              greenNew = blueI ;
              blueNew = greenI ;
            }
          }
        } else {
          if (redI > greenI) { // b>r>g
            redNew = redI - 30 ;
            greenNew = blueI ;
            blueNew = greenI ;
          } else {
            if (blueI > greenI) { // b>g>r
              redNew = blueI;
              greenNew = greenI - 30;
              blueNew = redI ;
            } else {              // g>b>r
              redNew = greenI ;
              greenNew = redI ;
              blueNew = blueI - 30 ;
            }
          }
        }
      } else {
        if (redI > blueI) {
          if (blueI > greenI) { // r>b>g
            redNew = greenI ;
            greenNew = redI ;
            blueNew = blueI + 30;
          } else {
            if (redI > greenI) { // r>g>b
              redNew = blueI ;
              greenNew = greenI +30;
              blueNew = redI ;
            } else { // g>r>b
              redNew = redI + 30;
              greenNew = blueI ;
              blueNew =  greenI ;
            }
          }
        } else {
          if (redI > greenI) { // b>r>g
            redNew = redI + 30;
            greenNew = blueI ;
            blueNew = greenI ;
          } else {
            if (blueI > greenI) { // b>g>r
              redNew = blueI ;
              greenNew = greenI + 30;
              blueNew = redI ;
            } else { // g>b>r
              redNew = greenI ;
              greenNew = redI ;
              blueNew = blueI + 30 ;
            }
          }
        }
      }
      String redNewS = (redNew < 16) ? "0" + Integer.toHexString(Math.round(redNew))
          : Integer.toHexString(Math.round(redNew));
      String greenNewS = (greenNew < 16) ? "0" + Integer.toHexString(Math.round(greenNew))
          : Integer.toHexString(Math.round(greenNew));
      String blueNewS = (blueNew < 16) ? "0" + Integer.toHexString(Math.round(blueNew))
          : Integer.toHexString(Math.round(blueNew));

      return redNewS + greenNewS + blueNewS;
    }

}
