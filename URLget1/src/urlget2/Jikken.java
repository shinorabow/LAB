/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlget2;

/**
 *
 * @author DE
 */
public class Jikken {
    	public static void main(String args[]){
		Geturl2 jtest = new Geturl2();

                String[] listA = {"貸借対照表","西千住駅","東千住駅"};
                
                for(String s:listA){
                String str1 = jtest.Jouhou(s);
                System.out.println(str1);
                System.out.println("\n***************\n");
                }
                
                
	}
}
