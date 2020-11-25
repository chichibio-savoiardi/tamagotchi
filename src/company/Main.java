package company;

import java.util.*;
import java.lang.*;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        inizializzatore();
    }

    public static void inizializzatore() {
        System.out.println("Benvenuto nel gioco del Tamagotchi\n");
        System.out.println("Scegli il tipo di Creatura\n1 per Drago\n2 per Alieno\n3 per Dinosauro");
        int scegliTipo = in.nextInt();
        System.out.println("Inserisci il nome");
        String nome = in.next();
        switch (scegliTipo) {
            case 1 -> {
                Creatura miaCreatura = new Creatura(nome, "Drago");
            }
            case 2 -> {
                Creatura miaCreatura = new Creatura(nome, "Alieno");
            }
            case 3 -> {
                Creatura miaCreatura = new Creatura(nome, "Dinosauro");
            }
            default -> inizializzatore();
        }
    }

    public static void menu() {
        //
    }
}
