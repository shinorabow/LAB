/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlget1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DE
 */
public class URLget1 {

    
   static String s = new String();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        getURL gg = new getURL();
       try {
           s=gg.getSourceText(new URL("http://zobereka.mukade.jp/index2.html"));
       } catch (MalformedURLException ex) {
           Logger.getLogger(URLget1.class.getName()).log(Level.SEVERE, null, ex);
       }
     // System.out.println(s);
    }
    
}
