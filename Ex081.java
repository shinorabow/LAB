/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/************************************************************
 * 【Ex081.java】 引数として与えられた日本語テキストを分かち書きするメソッド wakachi を作成せよ。
 *
 * ［機能］ パラメータで指定された日本語テキストを、形態素ごとに半角スペース1文字で区切った
 *       分かち書きの文字列に変換する。形態素解析エンジンはkuromojiを使用すること。
 * ［形式］ public static String wakachi(String text)
 * ［引数］ 日本語テキスト
 * ［戻り値］ 分かち書きされた日本語テキスト
 * ［使用例］ String s = wakachi("情報通信工学"); // s の値は "情報 通信 工学" 
 ************************************************************/

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

public class Ex081 {

    // TODO 学籍番号と氏名を設定すること
    private static String gakuban = "14EC099";
    private static String yourname = "篠崎";

    
    public static String wakachi(String text) {
        StringBuilder sb = new StringBuilder();

        
        Tokenizer tokenizer = Tokenizer.builder().build();
    for (Token token : tokenizer.tokenize(text)) {
        if(token.getPosition()!=0){
              sb.append(" ");
        }
      sb.append(token.getSurfaceForm());

    }
        String str = new String(sb);

        return str; // もし必要なければこの行を削除すること
    }

/************************************************************
 ************************************************************
 * 実装したメソッドのテストプログラム。ここから下は変更禁止!!
 ************************************************************
 ************************************************************/
    private static String question = "Ex081";
    private static String method = "wakachi";

    // Execute test by comparing values Expected and Returned
    static void executeTest() {
        String[] param1 = { // Checkpoint 1
            "データ工学", "情報通信工学", "2017年5月",
            "逃げるは恥だが役に立つ", "あなたのことはそれほど",};
        String[] expect = { // Checkpoint 2
            "データ 工学", "情報 通信 工学", "2017 年 5 月",
            "逃げる は 恥 だ が 役に立つ", "あなた の こと は それほど",};
        System.out.printf("課題番号:%s, 学籍番号:%s, 氏名:%s\n",
                question, gakuban, yourname);
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            String returned = null; //3
            try {
                returned = wakachi(param1[i]); //4
                if (expect[i].equals(returned)) { //5
                    info1 = "OK";
                    passed++;
                } else {
                    info1 = "NG";
                    info2 = String.format(" <= SHOULD BE %s", expect[i]);
                }
            } catch (Exception e) {
                info1 = "NG";
                info2 = "EXCEPTION!!";
                ex = e;
            } finally {
                String line = String.format("*** Test#%d %s %s(%s) => ",
                        i + 1, info1, method, param1[i]);
                if (ex == null) {
                    System.out.println(line + returned + info2);
                } else {
                    System.out.println(line + info2);
                    ex.printStackTrace();
                    return;
                }
            }
        }
        System.out.printf("Summary: %s,%s,%s,%d/%d\n",
                question, gakuban, yourname, passed, param1.length);
    }

    // Main method
    public static void main(String[] args) {
        gakuban = gakuban.toUpperCase();
        if (!gakuban.matches("[1][0-9]EC[0-9]{3}")) {
            System.out.println("ERROR! 学籍番号に誤りがあります。");
        } else if (yourname.contains("千住")) {
            System.out.println("ERROR! 氏名に誤りがあります。");
        } else {
            executeTest();
        }
    }
}
