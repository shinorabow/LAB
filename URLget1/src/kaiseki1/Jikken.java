/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaiseki1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import urlget1.URLget1;
import urlget1.getURL;

/**
 *
 * @author DE
 */
public class Jikken {
    
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
Keitairead k1 = new Keitairead();
        String s = new String();
        ArrayList<String[]> data11 = new ArrayList<>();
        data11 = k1.select("out2");
     // System.out.println(s);
    
    
    }
}
