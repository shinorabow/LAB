/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texist1;

import java.util.*;

 /**
 * Main Application Class
 *
 * @author Ushio lnoue
 */
 public class Mainapp {
 public static void main(String[] args) throws Exception {
 //デ ータベースを準備する
 PokemonDB db = new PokemonDB();
 String tableName="千住支部";

 // テーブルを作成する
 String[] columns = {" MOJI VARCHAR(64) " ,
 "HINSHI VARCHAR(64)" ," GENKEI VARCHAR(64)" ," AA VARCHAR(64)" ,
 "BB VARCHAR(64)" ," CC VARCHAR(64)" ," DD VARCHAR(64)" , "EE VARCHAR(64)" ,
"FF VARCHAR(64)" , "GG VARCHAR(64)" ,};
 db.createTable(tableName, columns);

 //デ ー タを入 力す る
 String HTMLpath = "Pokemon(1-51)-Wikipedia.html" ;
 db.insertFrom(tableName);

 //デ ー タを出力す る
 String sql = "SELECT * FROM " + tableName;
 ArrayList<String[]> list = db.select(sql);
 int nrow = list.size();
 //デ ータを表示する
 if(nrow> 0){
System.out.println( "番号¥t名 前¥t分 類¥tタ イ プ¥t高 さ¥t重 さ¥t特 性¥tか <れ 特性¥t進 化前¥t進 化後"
);
for(String[] row : list){
for (int i = 0; i < 10; i++) {
System.out.printf("%s¥t" , row[i]);
}
System.out.println();
        }
     }
    }
 }
