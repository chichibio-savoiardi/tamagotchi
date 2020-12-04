package Source.JavaUtils;

import java.util.*;
import java.lang.*;

public class BasicUtils {
    static Scanner basicIn = new Scanner(System.in);

    public int fattoriale(int n) {
        int f;
        if (n == 0) f = 1;
        else f = n * fattoriale(n - 1);
        return f;
    }

    public int binomial(int n, int k) {
        int f;
        if (n < k) f = 0;
        else f = fattoriale(n) / (fattoriale(k) * (n - fattoriale(k)));
        return f;
    }

    public int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
