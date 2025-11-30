package com.lab14;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Ingrese la cantidad de cursos a registrar:");
        int cantidad = pedirNumeroValido();
        Course[] cursos = new Course[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nCurso #" + (i + 1));
            cursos[i] = crearCurso();
        }

        System.out.println("\n--- Información de los cursos ---");
        for (Course c : cursos) {
            System.out.println(c.showInformation());
        }
    }

    private static int pedirNumeroValido() {
        Scanner sc = new Scanner(System.in);
        int num;
        do {

            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un número válido:");
                sc.next();
            }
            num = sc.nextInt();
        } while (num <= 0);
        return num;
    }

    private static Course crearCurso() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type (1=Online, 2=On Site): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Duration(hs): ");
        int duration = sc.nextInt();
        sc.nextLine();

        if (tipo == 1) {
            System.out.print("Platform: ");
            String platform = sc.nextLine();
            return new OnlineCourse(title, duration, platform);
        } else {
            System.out.print("Room: ");
            String room = sc.nextLine();
            return new OnSiteCourse(title, duration, room);
        }
    }
}
