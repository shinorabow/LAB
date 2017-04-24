


/************************************************************
 * 【Ex061.java】 整数が 2 または 3 の倍数どうかを判定するメソッド isDivable を作成せよ。
 *
 * ［機能］ パラメータで指定された整数が、2 または 3 の倍数のときは true を、そうでないときは
 *       false を返却する。ただし、整数の判定には以下の関数を使用すること。
 *       BiFunction<Integer, Integer, Boolean> lamexp
 * ［形式］ public static boolean isDivable(int n)
 * ［引数］ 整数
 * ［戻り値］ true または false
 * ［使用例］ boolean b = isDivable(27);  // b の値は true 
 ************************************************************/

import java.util.function.BiFunction;

public class Ex061 {
    // TODO 学籍番号と氏名を設定すること
    private static String gakuban = "14EC001";
    private static String yourname = "篠崎";

    // ラムダ式
    private static BiFunction<Integer, Integer, Boolean>
            lamexp = (a, b) -> {return a%b == 0;};

    public static boolean isDivable(int n) {
        // TODO このメソッドを完成させること
        boolean x = lamexp.apply(n, 2);

        if(x==false){
        x = lamexp.apply(n, 3);
        }
        
        return x;
    }

/************************************************************
 ************************************************************
 * 実装したメソッドのテストプログラム。ここから下は変更禁止!!
 ************************************************************
 ************************************************************/
    private static String question = "Ex061";
    private static String method = "isDivable";

    // Execute test by comparing values Expected and Returned
    static void executeTest() {
        int[] param1 = { // Checkpoint 1
            12, 11, 10, -1, -15,};
        boolean[] expect = { // Checkpoint 2
            true, false,true, false, true,};        
        System.out.printf("課題番号:%s, 学籍番号:%s, 氏名:%s\n",
                question, gakuban, yourname);
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            boolean returned = false; //3
            try {
                returned = isDivable(param1[i]); //4
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