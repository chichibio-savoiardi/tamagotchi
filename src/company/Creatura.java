package company;

import java.util.*;

public class Creatura {
    // attributi, si spiegano da soli
    private String nome, tipo;
    private int puntiVita, puntiFame, puntiFelicita, soldiTam;
    private boolean sonoVivo;

    Scanner creaturaIn = new Scanner(System.in);

    public Creatura(String nome, String tipo) {// costruttore
        this.nome = nome;
        this.tipo = tipo;
        this.puntiVita = 100;
        this.puntiFame = 100;
        this.puntiFelicita = 100;
        this.soldiTam = 1000;
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

    //fine getter/setter

    public void daiCibo() {
        // chiede all'utente cosa vuola far mangiare alla creatura tra tre opzioni una migliore ma più costosa dell'altra,
        // controlla che la creatura non sia morta, controlla che i punti vita siano sotto il 100
        System.out.println("Scrivere 1 per Torta, al costo di 200 Tam\nSeleziona 2 per Biscotto, al costo di 100 Tam\nSeleziona 3 per Caramella, al costo di 50 Tam");

        switch (creaturaIn.nextInt()) {
            case 1 -> {
                puntiFame += 50;
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
        controllore();
    }

    public void faiBagnetto() {// stessa cosa del cibo ma col bagno
        System.out.println("Scrivere 1 per Bagno lungo, al costo di 150 Tam\nSeleziona 2 per Bagno corto, al costo di 70 Tam\nSeleziona 3 per Bide', al costo di 40 Tam");

        switch (creaturaIn.nextInt()) {
            case 1 -> {
                puntiVita += 40;
                puntiFelicita -= 30;
                soldiTam -= 150;
            }
            case 2 -> {
                puntiVita += 20;
                puntiFelicita -= 15;
                soldiTam -= 70;
            }
            case 3 -> {
                puntiVita += 10;
                puntiFelicita -= 5;
                soldiTam -= 40;
            }
        }
        controllore();
    }

    public void daiGioco() {// stessa cosa del cibo ma col gioco
        System.out.println("Scrivere 1 per giocare al PC, al costo di 200 Tam\nSeleziona 2 per a Calcio, al costo di 100 Tam\nSeleziona 3 per Disegnare, al costo di 50 Tam");

        switch (creaturaIn.nextInt()) {
            case 1 -> {
                puntiFelicita += 50;
                puntiVita -= 30;
                soldiTam -= 200;
            }
            case 2 -> {
                puntiFelicita += 30;
                puntiVita -= 20;
                soldiTam -= 100;
            }
            case 3 -> {
                puntiFelicita += 20;
                puntiVita -= 10;
                soldiTam -= 50;
            }
        }
        controllore();
    }



    public void daiMedicina() {// chiede all'utente se vuole medicare la creatura, controlla che la creatura non sia morta, controlla che i punti vita siano sotto il 100
        System.out.println("Vuoi curare " + nome + " per 200 Tam? S/N");
        String temp = creaturaIn.next();
        if (temp.equals("s") || temp.equals("S")) {
            puntiVita += 50;
            soldiTam -= 200;
        }
        controllore();
    }

    public void faiLavoro(){
        //chiede all'utente che lavoro vuole fare per guadagnare Tam
        System.out.println("Scrivere 1 per Consegna lunga\nSeleziona 2 per Consegna corta\nSeleziona 3 per Consegna normale");

        switch (creaturaIn.nextInt()) {
            case 1 -> {
                soldiTam += 400;
                puntiVita -= 40;
                puntiFame -= 40;
                puntiFelicita -= 40;
            }
            case 2 -> {
                soldiTam += 200;
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
        controllore();
    }

    public void checkStato() {// stampa lo stato della creatura e controlla se è in vita
        if (puntiVita < 1 && puntiFame < 1 && puntiFelicita < 1) sonoVivo = false;// controlla se la creatura è morta
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Punti Vita: " + puntiVita);
        System.out.println("Punti Felicita: " + puntiFelicita);
        System.out.println("Punti Fame: " + puntiFame);
        System.out.println("Ammontare Tam: " + soldiTam);
        if (sonoVivo) {// decide se la creatura è morta e nel caso lo sia finisce il programma
            System.out.println(nome + " e vivo/a");
        } else {
            System.out.println(nome + " e morto/a");
            System.exit(1);
        }
    }
    public void controllore() {
        // controlla che gli attributi non siano superiori a 100, se lo sono li riporta a 100
        if (puntiVita > 100) puntiVita = 100;
        if (puntiFame > 100) puntiFame = 100;
        if (puntiFelicita > 100) puntiFelicita = 100;
        //controlla che la creatura non sia morta, se lo è mette sonoVivo a false e chiama checkStato() che fara finire il programma dicendo all'utente le brutte notizie
        if (puntiVita < 1 && puntiFame < 1 && puntiFelicita < 1) {
            sonoVivo = false;
            checkStato();
        }
    }
}
