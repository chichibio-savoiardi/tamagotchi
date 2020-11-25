package company;

import java.util.*;

public class Creatura {
    private String nome, tipo;
    private int puntiVita, puntiFame, puntiFelicita, soldiTam;
    private boolean sonoVivo;

    Scanner creaturaIn = new Scanner(System.in);

    public Creatura(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.puntiVita = 100;
        this.puntiFame = 100;
        this.puntiFelicita = 100;
        this.soldiTam = 1000;
        this.sonoVivo = true;
    }

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

    public void daiCibo() {
        if (puntiVita < 1 && puntiFame < 1 && puntiFelicita < 1) {
            sonoVivo = false;
            checkStato();
            return;
        }

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

        if (puntiFame > 100) puntiFame = 100;
        checkStato();
    }

    public void faiBagnetto() {
        if (puntiVita < 1 && puntiFame < 1 && puntiFelicita < 1) {
            sonoVivo = false;
            checkStato();
            return;
        }

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

        if (puntiVita > 100) puntiVita = 100;
        checkStato();
    }

    public void daiGioco() {
        if (puntiVita < 1 && puntiFame < 1 && puntiFelicita < 1) {
            sonoVivo = false;
            checkStato();
            return;
        }

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

        if (puntiFelicita > 100) puntiFelicita = 100;
        checkStato();
    }



    public void daiMedicina() {
        if (puntiVita < 1 && puntiFame < 1 && puntiFelicita < 1) {
            sonoVivo = false;
            checkStato();
            return;
        }
        System.out.println("Vuoi curare " + nome + " per 200 Tam? S/N");
        if (creaturaIn.nextLine().equals("s") || creaturaIn.nextLine().equals("S")) {
            puntiVita += 50;
            soldiTam -= 200;
        }
        if (puntiVita > 100) puntiVita = 100;
        checkStato();
    }

    public void faiLavoro(){
        if (puntiVita < 1 && puntiFame < 1 && puntiFelicita < 1) {
            sonoVivo = false;
            checkStato();
            return;
        }

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

        if (puntiVita > 100) puntiVita = 100;
        if (puntiFame > 100) puntiFame = 100;
        if (puntiFelicita > 100) puntiFelicita = 100;
        checkStato();
    }

    public void checkStato() {
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Punti Vita: " + puntiVita);
        System.out.println("Punti Felicita: " + puntiFelicita);
        System.out.println("Punti Fame: " + puntiFame);
        System.out.println("Ammontare Tam: " + soldiTam);
        if (sonoVivo) {
            System.out.println("La creatura e viva");
        } else {
            System.out.println("La creatura e morta");
            return;
        }
    }
}
