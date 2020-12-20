package source;

public class Alieno extends Creatura {
    public Alieno(String nome, String tipo) {
        super(nome, tipo);
    }

    @Override
    public void daiMedicina() {// chiede all'utente se vuole medicare la creatura, controlla che la creatura non sia morta, controlla che i punti vita siano sotto il 100
        System.out.println("Vuoi allenare " + nome + " per 100 Tam? S/N");
        String temp = creaturaIn.next();
        if (temp.equals("s") || temp.equals("S")) {
            puntiVita += 100;
            soldiTam -= 100;
        }
        checkStato();
    }
}