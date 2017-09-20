/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlget2;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Geturl2 {
	static String url = "https://ja.wikipedia.org/wiki/貸借対照表";
        
        
 public boolean isExistURL(String urlStr) {
        URL url;
        int status = 0;
        try {
            url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            status = conn.getResponseCode();
            conn.disconnect();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (status == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            return false;
        }
    }
        

	//decorate tweets
	//return <text> [<author>]
	String decorate(String text, String author) {
		StringBuilder sb = new StringBuilder();
		sb.append(text);
		sb.append(" [");
		sb.append(author);
		sb.append("]");
		return sb.toString();
	}
	
	//Use DOM methods to navigate a document
	//http://jsoup.org/cookbook/extracting-data/dom-navigation
	String getTweetByDom(Document doc) {
		Element content = doc.getElementById("contents_box");
		Element meigen = content.getElementsByClass("meigenbox").first();
		String text = meigen.getElementsByClass("text").first().text();
		Element link = meigen.getElementsByClass("link").first();
		String author = link.getElementsByTag("a").first().text();
		
		return decorate(text, author);
	}
	
	//Use selector-syntax to find elements
	//http://jsoup.org/cookbook/extracting-data/selector-syntax
	String getTweetBySelectorSyntax(Document doc) {
            int i = 0;
            StringBuilder sb = new StringBuilder();
                
		Element content = doc.select("h1.firstHeading").first();
		Elements meigen = doc.select("h2");
		String text = content.text();
		Elements link = doc.select("p");
                sb.append(text);
                sb.append("\n--------------------\n");
                	for( Element table : link ) {
                         String te1 =   table.text();
                 sb.append(te1);

               sb.append("\n");

}
	//	String author = link.select("a").first().text();
               // System.out.println(text);
                String str = new String(sb);
		return str;
	}
        
        public String Jouhou(String mono){
            String Tweet2 = new String();
        	try {
                    String a ="https://ja.wikipedia.org/wiki/" + mono;
                    
                    boolean u = isExistURL(a);
                    
                    if(u){
                    
			Document doc = Jsoup.connect(a).get();
		//	String tweet1 = jtest.getTweetByDom(doc);
			Tweet2 = getTweetBySelectorSyntax(doc);
		//	System.out.println(tweet1);
		//	System.out.println(Tweet2);
                
                    }
                    else
                    {
                        Tweet2 = "そんなサイトは存在しない\n"+a;
                    }
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
                return Tweet2;
                
        }
	
	/*public static void main(String args[]){
		Geturl2 jtest = new Geturl2();

                String[] listA = {"貸借対照表","京成電鉄","五日市線"};
                
                for(String s:listA){
                String str1 = jtest.Jouhou(s);
                System.out.println(str1);
                System.out.println("\n***************\n");
                }
                
                
	}*/
}
