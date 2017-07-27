/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlget1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author DE
 */
public class getURL {
    
    
    
    public static String getSourceText(URL url) throws IOException {
InputStream in = url.openStream();
StringBuilder sb = new StringBuilder();
try {
BufferedReader bf = new BufferedReader(new InputStreamReader(in));
String s;
while ((s=bf.readLine())!=null) {
    System.out.println(s);
sb.append(s);
}
} finally {
in.close();
}
return sb.toString();
}
    
    
}
