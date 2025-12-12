package org.example;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.Random rnd = new java.util.Random();
        boolean play = true;

        while (play) {
            int secret = rnd.nextInt(100) + 1;
            System.out.println("Adivina el número (1-100):");

            while (true) {

                int guess = sc.nextInt();
                if (guess < secret) {
                    System.out.println("El número es mayor");
                } else if (guess > secret) {
                    System.out.println("El número es menor");
                } else {
                    System.out.println("Número correcto");
                    break;
                }
            }

            System.out.println("¿Jugar de nuevo? (s/n)");
            String resp = sc.next();
            if (!resp.equalsIgnoreCase("s")) {
                play = false;
            }
        }

        sc.close(); // cerrar scanner
    }
}