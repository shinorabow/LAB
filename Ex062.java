


/************************************************************
 * 【Ex062.java】 整数型配列中の全要素の和を返却するメソッド sumArray 作成せよ。
 *
 * ［機能］ パラメータで指定された整数型配列中の全要素の和を返却する。
 *       ただし、Stream API(java.util.stream) を使用すること。
 * ［形式］ public static int sumArray(int[] a)
 * ［引数］ 整数の配列
 * ［戻り値］ 全要素の和
 * ［使用例］ int sum = sumArray({1, 2, 3});  // sum の値は 6 
 ************************************************************/

import java.util.Arrays;
import java.util.stream.IntStream;
;

public class Ex062 {
    // TODO 学籍番号と氏名を設定すること
    private static String gakuban = "14EC001";
    private static String yourname = "篠崎";

    public static int sumArray(int[] a) {
        // TODO このメソッドを完成させること
        IntStream st =Arrays.stream(a);
        int i = st.sum();

        return i; // もし必要なければこの行を削除すること
    }

/************************************************************
 ************************************************************
 * 実装したメソッドのテストプログラム。ここから下は変更禁止!!
 ************************************************************
 ************************************************************/
    private static String question = "Ex062";
    private static String method = "sumArray";

    // Execute test by comparing values Expected and Returned
    static void executeTest() {
        int[][] param1 = { // Checkpoint 1
            {1}, {1, 2, 3}, {-1, -2, -3}, {123, -45, 67, -890}, {},};
        int[] expect = { // Checkpoint 2
            1, 6, -6, -745, 0,};        
        System.out.printf("課題番号:%s, 学籍番号:%s, 氏名:%s\n",
                question, gakuban, yourname);
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            int returned = 0; //3
            try {
                returned = sumArray(param1[i]); //4
                if (expect[i] == (returned)) { //5
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
                        i + 1, info1, method, Arrays.toString(param1[i]));
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