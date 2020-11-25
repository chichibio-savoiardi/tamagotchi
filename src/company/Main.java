package company;

import java.util.*;
import java.lang.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Creatura miaCreatura = new Creatura(scegliNome(), scegliTipo());

    public static void main(String[] args) {
        menu();
        miaCreatura.checkStato();
    }

    public static String scegliNome() {
        System.out.println("Benvenuto nel gioco del Tamagotchi\n");
        System.out.println("Scegli il nome della tua creatura");
        return in.next();
    }

    public static String scegliTipo() {
        System.out.println("Scegli il tipo di Creatura\n1 per Drago\n2 per Alieno\n3 per Dinosauro");
        int tipo = in.nextInt();
        switch (tipo) {
            case 1 -> {
                return "Drago";
            }
            case 2 -> {
                return "Alieno";
            }
            case 3 -> {
                return "Dinosauro";
            }
            default -> {
                return scegliTipo();
            }
        }
    }

    public static void menu() {
        //todo
    }
}