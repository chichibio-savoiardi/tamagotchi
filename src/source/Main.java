/* +++++
 * Autore: Iuri Antico
 * -----
 * informazioni addizionali:
 * se il exit code è:
 * 0 l'utente è uscito dal menu() e ha finito il programma, o altre cause
 * 1 il programma è finito in isVivo()
 * 2 il programma è finito all'inizio di menu() per morte della creatura
 * 20 il programma è finito alla fine di menu() per morte della creatura
 * +++++
*/
package source;

import java.util.*;
import java.lang.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Client Client = new Client();

    public static void main(String[] args) {
        Client.menu();
    }
}