package source;

import java.util.Random;
import java.util.Scanner;

public class Client {

    private Scanner clientIn = new Scanner(System.in);
    // attributi
    private final String[] tipiCreatura = {
            "Drago",
            "Alieno",
            "Dinosauro"
    };
    private boolean isNotDone;

    Creatura miaCreatura = new Creatura(scegliNome(), scegliTipo());// inizializza l'oggetto creatura con nome e tipo scelti dall'utente

    public Client() {// costruttore
        isNotDone = false;
    }

    public void menu() {
        miaCreatura.isVivo(0, 2);
        // presenta all'utente lo stato della creatura e un menù con selezione a input di numeri, se l'utente inserisce 0 esce,
        // se l'utente inserisce un valore non valido esegue una ricorsione
        miaCreatura.checkStato();
        System.out.println(
                "\ncosa vuoi fare a " + miaCreatura.getNome() +
                "\n1 per lavorare" +
                "\n2 per mangiare" +
                "\n3 per lavare" +
                "\n4 per giocare" +
                "\n5 per medicare/allenare" +
                "\n6 per evolvere" +
                "\n0 per uscire");
        switch (clientIn.nextInt()) {
            case 0 -> {
                System.out.println("sto uscendo");
                System.exit(0);
            }
            case 1 -> miaCreatura.faiLavoro();
            case 2 -> miaCreatura.daiCibo();
            case 3 -> miaCreatura.faiBagnetto();
            case 4 -> miaCreatura.daiGioco();
            case 5 -> miaCreatura.daiMedicina();
            default -> menu();
        }

        miaCreatura.isVivo(0, 20);
        menu();
    }

    public String scegliNome() {// è la prima funzione eseguita quindi da il benvenuto e chiede il nome della creatura
        System.out.println("\nBenvenuto nel gioco del Tamagotchi\n");
        System.out.println("Scegli il nome della tua creatura");
        return clientIn.nextLine();
    }

    public String scegliTipo() { // sceglie il tipo di creature o a random o chiedendo all'utente il numero corrisponedente
        System.out.println("vuoi scegliere la creatura? S/N?");
        String temp = clientIn.next();
        if (!(temp.equals("s") || temp.equals("S")))
            return tipiCreatura[randInt(0, 2)];// se l'utente mette qualsiasi cosa che non sia "s" o "S" sceglie a random la creatura
        do {// se isNotDone è true fa scegliere di nuovo perché l'utente ha sbagliato
            isNotDone = false;
            System.out.println("Scegli il tipo di Creatura\n1 per Drago\n2 per Alieno\n3 per Dinosauro\n0 per tornare indietro");
            int tipo = clientIn.nextInt();
            switch (tipo) {
                case 0 -> {
                    return scegliTipo();
                }
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

    public void evolvi() {
        miaCreatura.controllore();
        if (!(miaCreatura.getPuntiFame() == miaCreatura.getMaxPunti() && miaCreatura.getSoldiTam() > 1000)) {
            System.out.println("Devi avere almeno 1000 Tam e punti vita massimi (" + miaCreatura.getMaxPunti() + ") per evolvere la Creatura");
            return;
        }
        if (miaCreatura.getTipo().equals("Drago")) {
            miaCreatura = new Drago(miaCreatura.getNome(), miaCreatura.getTipo() + " evoluto");
        } else if (miaCreatura.getTipo().equals("Alieno")) {
            miaCreatura = new Alieno(miaCreatura.getNome(), miaCreatura.getTipo() + " evoluto");
        } else {
            miaCreatura = new Dinosauro(miaCreatura.getNome(), miaCreatura.getTipo() + " evoluto");
        }
        miaCreatura.setMaxPunti(miaCreatura.getMaxPunti() + 100);
        System.out.println(miaCreatura.getNome() + "si è evuluto!");
        miaCreatura.checkStato();
    }

    public int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
