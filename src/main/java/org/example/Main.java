package org.example;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.Random rnd = new java.util.Random();
        boolean play = true;

        while (play) {
            int secret = rnd.nextInt(100) + 1;
            System.out.println("Adivina el número (1-100):");


            System.out.println("¿Jugar de nuevo? (s/n)");
            String resp = sc.next();
            if (!resp.equalsIgnoreCase("s")) {
                play = false;
            }
        }

        sc.close(); // cerrar scanner
    }
}