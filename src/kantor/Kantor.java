/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kantor;

import java.util.Random;

/**
 *
 * @author Depoula
 */
public class Kantor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                
        
        int tableSize = 1000;
        int[][] a = generateArray(tableSize);
        int[] d = printArray(a);
        int[] nl = new int[tableSize];

        System.out.println("Διαγωνιος");
        for (int i = 0; i < a.length; i++) {

            System.out.print(a[i][i] + " ");
            nl[i] = a[i][i] ^ 1;
        }
        System.out.println("");

        System.out.println("Αλλαγμενη διαγώνιος");
        for (int i = 0; i < nl.length; i++) {

            System.out.print(nl[i] + " ");

        }
        System.out.println("");
        checkDiagonalInArray(a, nl);

        //Test Να δεις οτι δουλευει η αναζήτηση διαγωνιου
//        int[][] x = {{1,1,1}, {1,1,1}, {1,1,1}};
//        int[] y = {1,1,1};
//        System.out.println("");
//        checkDiagonalInArray(x, y);
    }

    public static void checkDiagonalInArray(int[][] a, int[] d) {
        int counter = 0;
        Boolean found = false;
        for (int i = 0; i < a.length; i++) {

            counter = 0;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == d[j]) {
                    counter++;
                }
            }

            if (counter == a.length) {
                System.out.println("Βρηκα ομοια γραμμη στην γραμμη " + i);
                found = true;
            }

        }

        if (found == false) {
            System.out.println("Δεν βρηκα ιδια διαγωνιο");
        }
    }

    public static int[][] generateArray(int tableSize) {
        int[][] a = new int[tableSize][tableSize];
        Random r = new Random();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                a[i][j] = r.nextInt(2);
            }
        }

        return a;
    }

    public static int[] printArray(int[][] a) {
        int[] d = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
                System.out.print("|");
            }
            System.out.println("");
        }

        return d;
    }

}
