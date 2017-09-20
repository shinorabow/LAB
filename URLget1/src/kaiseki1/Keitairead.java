/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaiseki1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DE
 */
public class Keitairead {
        
   
    
 public ArrayList<String[]> select(String Fname) throws Exception{
        BufferedReader br =  null;
     ArrayList<String[]> table = new ArrayList<>();    
     
        try{
        br =  new BufferedReader(new FileReader(Fname +".txt"));// STEP1
        StringBuilder sb = new StringBuilder();
        
        
        String hp = br.readLine();
        
        String str = br.readLine();
        while(str != null){
            if(str.equals("EOS"))
                break;
            sb.append(str);
            
         //   System.out.println(str+"!!!!!!!!");
            String[] s1 = str.split("[\t,]");
        
        int i = 0;
            //017
            int k = s1.length;
                String[] row = new String[k];
                System.out.print(k+"\t");
            for(i=0;i<10;i++){
                if(k==10)
                    System.out.print(s1[i]+" ");
                else if(i<k)
                   System.out.print(s1[i]+" "); 
                else
                  System.out.print(s1[0]+" ");   
                
            }
            System.out.println();
            
            str = br.readLine();
        }
        
        
        br.close();
        
        return table;
        
        }catch(IOException e){}
        finally{
                if(br != null) {
                try {                               /* close()がIOExceptionを送出する可能性があるため、再度try-catchが */
                    if(br != null) {				/* 必要。ただし失敗しても何もできないためcatchブロック内は空にしてある */
                    	br.close();      
                    }
                } catch(IOException e2) { }
                }
        
        }
        return table;
    }
    
}
