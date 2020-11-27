/* +++++
 * Autore: Iuri Antico
 *
 * informazioni addizionali:
 * se il return code è 1 il programma è finito in checkStato()
 * se il return code è 2 il programma è finito in menu()
 * se il return code è 3 l'utente è uscito dal menu() e ha finito il programma
 */
package company;

import java.util.*;
import java.lang.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Creatura miaCreatura = new Creatura(scegliNome(), scegliTipo());// inizializza l'oggetto creatura con nome e tipo scelti dall'utente

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        if (!miaCreatura.isSonoVivo()) {// se la creatura è morta finisce il programma
            System.out.println(miaCreatura.getNome() + " e morto/a");
            System.exit(2);
        }
        // presenta all'utente lo stato della creatura e un menù con selezione a input di numeri, se l'utente inserisce 0 esce,
        // se l'utente inserisce un valore non valido esegue una ricorsione
        miaCreatura.checkStato();
        System.out.println("\ncosa vuoi fare a " + miaCreatura.getNome() + "\n1 per lavorare\n2 per mangiare\n3 per lavare\n4 per giocare\n5 per medicare\n0 per uscire");
        switch (in.nextInt()) {
            case 0 -> {
                System.out.println("sto uscendo");
                System.exit(3);
            }
            case 1 -> miaCreatura.faiLavoro();
            case 2 -> miaCreatura.daiCibo();
            case 3 -> miaCreatura.faiBagnetto();
            case 4 -> miaCreatura.daiGioco();
            case 5 -> miaCreatura.daiMedicina();
            default -> menu();
        }

        if (miaCreatura.isSonoVivo()) menu();// se la creatura è viva continua il programma
    }

    public static String scegliNome() {// è la prima funzione eseguita quindi da il benvenuto e chiede il nome della creatura
        System.out.println("\nBenvenuto nel gioco del Tamagotchi\n");
        System.out.println("Scegli il nome della tua creatura");
        return in.nextLine();
    }

    public static String scegliTipo() { // sceglie il tipo di creature o a random o chiedendo all'utente il numero corrisponedente
        String[] tipiCreatura = {
                "Drago",
                "Alieno",
                "Dinosauro"
        };
        System.out.println("vuoi scegliere la creatura? S/N?");
        String temp = in.next();
        if (!(temp.equals("s") || temp.equals("S"))) return tipiCreatura[randInt(0, 2)];// se l'utente mette qualsiasi cosa che non sia "s" o "S" sceglie a random la creatura
        boolean isNotDone = false;
        do {// se isNotDone è true fa scegliere di nuovo perché l'utente ha sbagliato
            isNotDone = false;
            System.out.println("Scegli il tipo di Creatura\n1 per Drago\n2 per Alieno\n3 per Dinosauro");
            int tipo = in.nextInt();
            switch (tipo) {
                case 1 -> {
                    return tipiCreatura[0];
                }
                case 2 -> {
                    return tipiCreatura[1];
                }
                case 3 -> {
                    return tipiCreatura[2];
                }
                default -> {
                    isNotDone = true;
                }
            }
        } while (isNotDone);
        return tipiCreatura[randInt(0, 2)];
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}