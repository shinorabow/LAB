/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaiseki1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import org.jsoup.Connection;

/**
 *
 * @author DE
 */
public class Keitaisql {
    boolean u =false;
       boolean v = false;
       String str = new String();

         int n=0;
        BufferedReader br =  null;

        
    public void CreT(){
        Connection conn = null;
        Statement stmt = null;
        String sql_str = null;
        try {
            Class.forName("org.h2.Driver");
            System.out.println("JDBCドライバをロードしました...");
            conn = DriverManager.getConnection
            ("jdbc:h2:~/test");
            System.out.println("データベースに接続しました...");
                // ステートメントを作成
            stmt = conn.createStatement();
            String drop ="DROP TABLE IF EXISTS KEITAI";
            PreparedStatement pstmt = conn.prepareStatement(drop);
            pstmt.executeUpdate();
            sql_str =
            "create table KEITAI ( " +
            " NOM INT(10) primary key, " +
            " MOJI VARCHAR(11), " +
            " GENKEI VARCHAR(11), " +
            " HINSHI VARCHAR(11), " +
            ")";
            stmt.executeUpdate(sql_str);
            System.out.println("KEITAI表を作成しました...");
                stmt.close();
            conn.close();
            System.out.println("接続をクローズしました...");
            // 例外を処理
          } catch (Exception ex) {
            System.out.println("Exceptionが発生しました...");
            // エラー・メッセージを出力
            System.out.print(ex.toString());
            // SQLExceptionの場合、エラー・コードを出力
            if (ex instanceof SQLException) {
              System.out.println("エラー・コード: " +
              ((SQLException)ex).getErrorCode());
            }
              try {
                // ステートメントがクローズされていない場合、
                // それをクローズ
                if (stmt != null) {
                  stmt.close();
                }
                // 接続がクローズされていない場合、それをクローズ
                if (conn != null) {
                  conn.close();
                  System.out.println("接続をクローズしました...");
                }
              } catch (SQLException se) {}
            }


            
            
        }
        
    public void csvIn(String fname)  {
        
        try {
            Class.forName("org.h2.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();            /* ドライバが見つからない場合の処理（＊）*/
        }
        /* ; */
        
        ArrayList<String[]> data = new ArrayList<>();
        
        
        
        Connection con = null;
         try {
            // STEP 1: データベースの接続
            con = DriverManager.getConnection("jdbc:h2:~/test");  /* JDBC URLを指定 */
            
            // ********** リスト12-3 ここから **********
            // STEP 2-(2)-1 送信すべきSQLの雛形を準備
            PreparedStatement pstmt = con.prepareStatement
              ("SELECT * FROM MONSTERS WHERE HP >= ?");
            // STEP 2-(2)-2 ひな形に値を流し込みSQLを組み立て送信する
            pstmt.setInt(1, 10);            // １番目の？に10を流し込み
            ResultSet rs = pstmt.executeQuery();
            // STEP 2-(2)-3 結果表を処理する
             /* ************************************
                結果表の処理（記述する内容は、後述します）
              ************************************* */
            rs.close();
            pstmt.close();                  // 後片付け
        
        
                StringBuilder sb = new StringBuilder();
                
                
                
        try {/* 入れ子です　*/
                 br =  new BufferedReader(new FileReader("Nikkei225J.csv"));// STEP1
               
                 
                 
        String hp = br.readLine();
           str = br.readLine();
            while(str != null){
            sb.append(str);
            
            System.out.println(str);

            str = br.readLine();
            }
            
            
            br.close();
        }catch(IOException e){}
        finally{
        if(br != null) {
                try {                               /* close()がIOExceptionを送出する可能性があるため、再度try-catchが */
                    if(br != null) {				/* 必要。ただし失敗しても何もできないためcatchブロック内は空にしてある */
                    	br.close();      
                    }
                } catch(IOException e2) { }
                }
            }/* 入れ子終わり */
        
        
         } catch(SQLException e) {
            e.printStackTrace();            /* 接続やSQL処理の失敗時の処理（＊）*/
        } finally {
            // STEP 3: データベース接続の切断
            if(con != null) {
                try {
                    con.close();
                } catch(SQLException e) {
                    e.printStackTrace();    /* 切断失敗時の処理（＊）*/
                }
            }   /* ＊の箇所は必要に応じて適切なエラー処理を記述します */
        }
        
        }
        
        
       
       public void ppp(){
       System.out.println(u);
       }
     
     
}

    

