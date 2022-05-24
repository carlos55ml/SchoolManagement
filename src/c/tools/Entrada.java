package c.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Entrada {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Entrada(){}

    public static int readInt(){
        boolean validNum;
        int a = 0;
        do {
            System.out.print(" > ");
            try {
                a = Integer.parseInt(reader.readLine());
                validNum = true;
            } catch (NumberFormatException | IOException err){
                System.out.print("\nValor introducido invalido. Pruebe otra vez.");
                validNum = false;
            }
        } while(!validNum);
        return a;
    }

    public static int readRangeInt(int r1, int r2){
        boolean validNum;
        int a = 0;
        do {
            System.out.print(" > ");
            try {
                a = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException err){
                System.out.print("\nValor introducido invalido. Pruebe otra vez.");
                validNum = false;
            } finally {
            	if (a < r1 || a > r2) {
                    System.out.print("El numero debe estar entre "+r1+" y "+r2+"\n");
                    validNum = false;
                } else {
                    validNum = true;
                }
            }
        } while(!validNum);
        return a;
    }

    public static String readString() {
        System.out.print(" > ");
        String s="";
        try {
            s = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s;
    }

}
