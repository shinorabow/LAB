/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/************************************************************
 * 【Ex082.java】 日本語テキスト中の固有名詞を返却するメソッド properNoun を作成せよ。
 *
 * ［機能］ パラメータで指定された日本語テキスト中に最初に現れる固有名詞を返却する。
 *       ただし、固有名詞が１つもない場合は空文字列を返却する。
 *       形態素解析エンジンはkuromojiを使用すること。
 * ［形式］ public static String properNoun(String text)
 * ［引数］ 日本語テキスト
 * ［戻り値］ 最初に現れる固有名詞
 * ［使用例］ String s = properNoun("錦織ストレートで連勝"); // s の値は "錦織" 
 ************************************************************/

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

public class Ex082 {

    // TODO 学籍番号と氏名を設定すること
    private static String gakuban = "14EC099";
    private static String yourname = "篠崎";

    public static String properNoun(String text) {
        

            Tokenizer tokenizer = Tokenizer.builder().build();
    for (Token token : tokenizer.tokenize(text)) {
        String[] features = token.getAllFeaturesArray();
      if(features[1].equals("固有名詞")){
      return token.getSurfaceForm();
      }
    }


        return ""; // もし必要なければこの行を削除すること
    }

/************************************************************
 ************************************************************
 * 実装したメソッドのテストプログラム。ここから下は変更禁止!!
 ************************************************************
 ************************************************************/
    private static String question = "Ex082";
    private static String method = "properNoun";

    // Execute test by comparing values Expected and Returned
    static void executeTest() {
        String[] param1 = { // Checkpoint 1
			"都知事に小池氏", "リオ五輪メダル41個",
			"現職大統領が広島訪問", "北海道新幹線開業",
			"18歳選挙権施行",};
        String[] expect = { // Checkpoint 2
			"小池", "リオ", "広島", "北海道", "",};
        System.out.printf("課題番号:%s, 学籍番号:%s, 氏名:%s\n",
                question, gakuban, yourname);
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            String returned = null; //3
            try {
                returned = properNoun(param1[i]); //4
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

