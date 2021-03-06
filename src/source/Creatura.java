package source;

import java.util.*;

public class Creatura {
    // attributi, si spiegano da soli
    protected String nome, tipo;
    protected int puntiVita, puntiFame, puntiFelicita, soldiTam, maxPunti, minPunti;
    protected boolean sonoVivo;

    protected Scanner creaturaIn = new Scanner(System.in);

    public Creatura(String nome, String tipo) {// costruttore
        this.nome = nome;
        this.tipo = tipo;
        this.maxPunti = 100;
        this.minPunti = 0;
        this.puntiVita = maxPunti - 20;
        this.puntiFame = maxPunti - 20;
        this.puntiFelicita = maxPunti - 20;
        this.soldiTam = 900;
        this.sonoVivo = true;
    }

    //vari getter/setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPuntiVita() {
        return puntiVita;
    }

    public void setPuntiVita(int puntiVita) {
        this.puntiVita = puntiVita;
    }

    public int getPuntiFame() {
        return puntiFame;
    }

    public void setPuntiFame(int puntiFame) {
        this.puntiFame = puntiFame;
    }

    public int getPuntiFelicita() {
        return puntiFelicita;
    }

    public void setPuntiFelicita(int puntiFelicita) {
        this.puntiFelicita = puntiFelicita;
    }

    public int getSoldiTam() {
        return soldiTam;
    }

    public void setSoldiTam(int soldiTam) {
        this.soldiTam = soldiTam;
    }

    public boolean isSonoVivo() {
        return sonoVivo;
    }

    public void setSonoVivo(boolean sonoVivo) {
        this.sonoVivo = sonoVivo;
    }

    public int getMaxPunti() {
        return maxPunti;
    }

    public void setMaxPunti(int maxPunti) {
        this.maxPunti = maxPunti;
    }

    //fine getter/setter

    public void daiCibo() {
        // chiede all'utente cosa vuola far mangiare alla creatura tra tre opzioni una migliore ma più costosa dell'altra,
        // controlla che la creatura non sia morta, controlla che i punti vita siano sotto il 100
        System.out.println("Scrivere 1 per Torta, al costo di 200 Tam\nSeleziona 2 per Biscotto, al costo di 100 Tam\nSeleziona 3 per Caramella, al costo di 50 Tam");

        switch (creaturaIn.nextInt()) {
            case 1 -> {
                puntiFame += 60;
                puntiVita -= 30;
                soldiTam -= 200;
            }
            case 2 -> {
                puntiFame += 30;
                puntiVita -= 20;
                soldiTam -= 100;
            }
            case 3 -> {
                puntiFame += 20;
                puntiVita -= 10;
                soldiTam -= 50;
            }
        }
        checkStato();
    }

    public void faiBagnetto() {// stessa cosa del cibo ma col bagno
        System.out.println("Scrivere 1 per Bagno lungo, al costo di 150 Tam\nSeleziona 2 per Bagno corto, al costo di 70 Tam\nSeleziona 3 per Bide', al costo di 40 Tam");

        switch (creaturaIn.nextInt()) {
            case 1 -> {
                puntiVita += 50;
                puntiFelicita -= 30;
                soldiTam -= 150;
            }
            case 2 -> {
                puntiVita += 30;
                puntiFelicita -= 15;
                soldiTam -= 70;
            }
            case 3 -> {
                puntiVita += 10;
                puntiFelicita -= 5;
                soldiTam -= 40;
            }
        }
        checkStato();
    }

    public void daiGioco() {// stessa cosa del cibo ma col gioco
        System.out.println("Scrivere 1 per giocare al PC, al costo di 200 Tam\nSeleziona 2 per a Calcio, al costo di 100 Tam\nSeleziona 3 per Disegnare, al costo di 50 Tam");

        switch (creaturaIn.nextInt()) {
            case 1 -> {
                puntiFelicita += 60;
                puntiVita -= 30;
                soldiTam -= 200;
            }
            case 2 -> {
                puntiFelicita += 40;
                puntiVita -= 20;
                soldiTam -= 100;
            }
            case 3 -> {
                puntiFelicita += 30;
                puntiVita -= 10;
                soldiTam -= 50;
            }
        }
        checkStato();
    }



    public void daiMedicina() {// chiede all'utente se vuole medicare la creatura, controlla che la creatura non sia morta, controlla che i punti vita siano sotto il 100
        System.out.println("Vuoi curare " + nome + " per 200 Tam? S/N");
        String temp = creaturaIn.next();
        if (temp.equals("s") || temp.equals("S")) {
            puntiVita += 60;
            soldiTam -= 200;
        }
        checkStato();
    }

    public void faiLavoro(){
        //chiede all'utente che lavoro vuole fare per guadagnare Tam
        System.out.println("Scrivere 1 per Consegna lunga\nSeleziona 2 per Consegna corta\nSeleziona 3 per Consegna normale");

        switch (creaturaIn.nextInt()) {
            case 1 -> {
                soldiTam += 500;
                puntiVita -= 40;
                puntiFame -= 40;
                puntiFelicita -= 40;
            }
            case 2 -> {
                soldiTam += 300;
                puntiVita -= 20;
                puntiFame -= 20;
                puntiFelicita -= 20;
            }
            case 3 -> {
                soldiTam += 100;
                puntiVita -= 10;
                puntiFame -= 10;
                puntiFelicita -= 10;
            }
        }
        checkStato();
    }

    public void checkStato() {// stampa lo stato della creatura e controlla se è in vita
        controllore();// controlla se la creatura è morta, e che gli attributi siano sotto il 100
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Punti Vita: " + puntiVita);
        System.out.println("Punti Felicita: " + puntiFelicita);
        System.out.println("Punti Fame: " + puntiFame);
        System.out.println("Ammontare Tam: " + soldiTam);
        isVivo(1, 1);
    }
    public void controllore() {
        // controlla che gli attributi non siano superiori a maxPunti, se lo sono li riporta a maxPunti
        if (puntiVita > maxPunti) puntiVita = maxPunti;
        if (puntiFame > maxPunti) puntiFame = maxPunti;
        if (puntiFelicita > maxPunti) puntiFelicita = maxPunti;
        if (soldiTam < 1) {
            System.out.println("Hai finito i soldi");
            System.exit(3);
        }
        //controlla che la creatura non sia morta, se lo è mette sonoVivo a false
        if (puntiVita <= minPunti && puntiFame <= minPunti && puntiFelicita <= minPunti) sonoVivo = false;
    }

    public void isVivo(int doPrint, int exitCode) {
        switch (doPrint) {// 0 non stampa il fatto che la creatura è viva, 1 stampa il fatto che la creatura sia viva
            case 0 -> {
                if (!sonoVivo) {// controlla se sonoVivo è false, e nel caso lo sia finisce il programma
                    System.out.println(nome + " e morto/a");
                    System.exit(exitCode);
                }
            }
            case 1 -> {
                if (sonoVivo) {// controlla se sonoVivo è true, e nel caso non lo sia finisce il programma
                    System.out.println(nome + " e vivo/a");
                } else {
                    System.out.println(nome + " e morto/a");
                    System.exit(exitCode);
                }
            }
            default -> throw new IllegalStateException("In Creatura.isVivo().doPrint, Unexpected value: " + doPrint);
        }
    }
}
