package company;

import java.util.*;
import java.lang.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Creatura miaCreatura = new Creatura(scegliNome(), scegliTipo());

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        if (!miaCreatura.isSonoVivo()){
            System.out.println(miaCreatura.getNome() + " e morto/a");
            return;
        }
        System.out.println("\ncosa vuoi fare a " + miaCreatura.getNome() + "\n1 per lavorare\n2 per mangiare\n3 per lavare\n4 per giocare\n5 per medicare\n0 per uscire");
        switch (in.nextInt()) {
            case 0 -> {
                System.out.println("sto uscendo");
                return;
            }
            case 1 -> miaCreatura.faiLavoro();
            case 2 -> miaCreatura.daiCibo();
            case 3 -> miaCreatura.faiBagnetto();
            case 4 -> miaCreatura.daiGioco();
            case 5 -> miaCreatura.daiMedicina();
            default -> menu();
        }
        if (miaCreatura.isSonoVivo()) menu();
    }

    public static String scegliNome() {
        System.out.println("\nBenvenuto nel gioco del Tamagotchi\n");
        System.out.println("Scegli il nome della tua creatura");
        return in.nextLine();
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
}