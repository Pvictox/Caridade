/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Scanner;


public class Leitor {
    private static Scanner scan = new Scanner(System.in, "ISO-8859-1");
    
    public static int leInteiro(){
        int x;
        x = scan.nextInt();
        scan.nextLine();
        return x;
    }
    
    public static String leString(){
        String str;
        str = scan.nextLine();
        return str;
    }
}
