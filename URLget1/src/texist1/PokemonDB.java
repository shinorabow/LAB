/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texist1;



 import java.io.*;
 import java.sql.*;
 import java.util.*;
 import org.jsoup.Jsoup;
 import org.jsoup.nodes.*;
 import org.jsoup.select.*;

 /**
 * Pokemon Database Class
 *
 * @author Ushio lnoue
 */
 public class PokemonDB {
 /** 主妾率売URL */
 String jdbcStr = "jdbc:h2:~/keitai01" ;
 int ncol = 0; // カラム数

 /**コ ンス トラクタ
     * @throws java.lang.Exception */
 public PokemonDB() throws Exception {
     Class.forName("org.h2.Driver");
 }
 /**接続処理
 *
     * @return 
     * @throws java.lang.Exception
 *@return接 続ハ ン ドラ
 */
 public Connection connect() throws Exception {
 Connection con = DriverManager.getConnection(jdbcStr, "sa" ,"");
    if (con != null)
    return con;
 return null;
 }

 /**
 *テ ー ブル作成処理
 *
     * @param tableName
     * @param columns
     * @return 
     * @throws java.lang.Exception
 */
 public boolean createTable(String tableName, String[] columns)throws Exception {
 Connection con = connect();

 //既 にテー ブルが あれば削除す る
 String drop = "DROP TABLE IF EXISTS " + tableName;
 PreparedStatement pstmt = con.prepareStatement(drop);
 pstmt.executeUpdate();
 System.out.printf(" テー ブル ltSを 肖1除 しま したc¥n" ,tableName);

 // 新たにテー ブル を作成す る
 ncol = columns.length;
 String create = "CREATE TABLE " + tableName + " (" ;
 for(int i=0; i < ncol;i++){ //カ ラム定義を追加する
 create += columns[i];
 if (i < columns.length - 1)
 create += "," ;
 }
 create += ")" ;
 pstmt = con.prepareStatement(create);
 pstmt.executeUpdate();
 System.out.printf(" テー ブル %Sを 作成 しま した¥n" ,tableName);


    con.close();
 return true;
 }

 /**
 *
     * @param Fname
     * @return 
     * @throws java.lang.Exception
 */
 
 
    
 public ArrayList<String[]> readtxt(String Fname) throws Exception{
        BufferedReader br =  null;
     ArrayList<String[]> table = new ArrayList<>();    
     
        try{
        br =  new BufferedReader(new FileReader(Fname +".txt"));// STEP1
        StringBuilder sb = new StringBuilder();
        
        
      //  String hp = br.readLine();
    //  String s1 = new String();
      String s2 = new String();
        
        String str = br.readLine();
        while(str != null){
            sb.append(str);
            
            if(str.equals("EOS"))
                break;
            
        String[] s1 = str.split("[\t,]");
        
        int i = 0;
            //017
            int k = s1.length;
                String[] row = new String[10];
            for(i=0;i<10;i++){
                if(k==10)
                    row[i] = s1[i];
                else if(i<k)
                   row[i] = s1[i];
                else
                  row[i] = s1[0];
           // row[i] = s1[i];
                
            }
            
            
            table.add(row);
           
            
          //  System.out.println(str);
            
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
    
 
 
 
 
 /**
70 *デ ータ入力処理
71 *
72 *@param tableName作 成す るテー ブル名
73 *@param HTMLpath入 力HTMLフ ァイル名
74 *@return入 力行数
75
     * @param tableName
     * @param HTMLpath
     * @return 
     * @throws java.lang.Exception */
 public int insertFrom(String tableName) throws Exception {
 Connection con = connect();
 /*
 ArrayList<String[]> data = new ArrayList<>();

 // すべてのtable要 素 を取得す る
 File input = new File(HTMLpath);
 Document doc = Jsoup.parse(input, "UTF-8" );
 Elements tables = doc.select("table" );
 for (Element table: tables) {
Element caption = table.select("caption > b" ).first();
if(caption !=null){
String[] item = new String[ncol];
String[]cdata = caption.text().split(" ");
item[0] = cdata[2];
item[1] = cdata[0];
Elements specs = table.select("td");
for (Element spec: specs) {
switch (spec.select("b").text()) {
case
"分類:" :
item[2] = spec.ownText(); break;
case"タイプ:" :
item[3] = spec.ownText(); break;
case"高さ:" :
item[4]= spec.ownText() + " ";
item[4] += spec.select("a" ).text();
case"重さ:" :
item[5] = spec.ownText() + " ";
item[5]+= spec.select("a" ).text();
case"特性:" :
item[6] = spec.ownText(); break;
case"かくれ特性:" :
item[7]= spec.ownText(); break;
case"進化前:" :
item[8] = spec.ownText();
item[8]+= spec.select("a" ).text();
case"進化後:" :
item[9] = spec.ownText();
item[9] += spec.select("a" ).text();
}
}
for (String i: item) System.out.print(i+" ");
System.out.println();
data.add(item);
}
}
 */
 //1NSERT文 を生成する
 String insert = "INSERT INTO " + tableName + " VALUES (" ;
 for (int i = 0; i < ncol; i++) {
insert += "?" ;
if(i < ncol - 1)
insert += "," ;
 }


insert += ")" ;
PreparedStatement pstmt = con.prepareStatement(insert);


 ArrayList<String[]> data2 = readtxt("out2");

//ArrayListか らデータを読み込み、INSERT文 を実行する
int nrow=0;// レコー ド数
for(String[] row : data2){
for (int i = 1; i <= ncol; i++)
pstmt.setString(i, row[i - 1]);
    if (pstmt.executeUpdate() != 1) {
    System.out.println((nrow+1)+" 行日を追加できません。");
    } else{
    nrow++;
    }
}
System.out.println(" ファイル か ら"+ nrow +" 行挿入 しま した。");
con.close();
 return nrow;
 }
 
/*データ出力処理
150 *
151 *@param sql 検 索のためのSELECT文
152 *Oreturn検 索結 果 のテー ブル
153 */
 public ArrayList< String[]> select(String sql) throws Exception {
Connection con = connect();
//SELECT文 を実行 し、検索結果のカラム数 を得 る
PreparedStatement pstmt = con.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
int ncol = rs.getMetaData().getColumnCount();
//検索結果を全部取得す る
ArrayList<String[]> table = new ArrayList< >();
while(rs.next()){
String[] row = new String[ncol];
    for (int i = 0; i < ncol; i++)
    row[i] = rs.getString(i + 1);
table.add(row);
 }
rs.close() ;
con.close();
return table;
 }
 }
 
