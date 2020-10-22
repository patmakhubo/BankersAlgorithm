/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DekkersAlgorithm;

/**
 *
 * @author Administrator
 */
public class FirstAttempt {
    static int t = 1;
    public static void main(String[] args) {
        t1();
        t2();
    }
    @SuppressWarnings("empty-statement")
    static void t1 (){
        do{
        while(t == 2);
        t = 2;
        }while(t == 2);
    }
    @SuppressWarnings("empty-statement")
    static void t2 (){
        do{while(t == 1);
        t = 1;}while(t == 1);
    }
}
