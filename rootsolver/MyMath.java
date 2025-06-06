package hus.oop.rootsolver;

public class MyMath {
    public static double sin(double x) {
        /* TODO */
        double term = 0.0;
        double sum = 0.0;
        int n = 0;
        do {
            term = Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
            sum += term;
            n++;
            if (n > 100) {
                break;
            }
        } while (Math.abs(term) > 1e-10);
        return sum;
    }

    public static double cos(double x) {
        /* TODO */
        double term = 0.0;
        double sum = 0.0;
        int n = 0;
        do {
            term = Math.pow(-1, n) * Math.pow(x, 2 * n) / factorial(2 * n);
            sum += term;
            n++;
            if (n > 100) {
                break;
            }
        } while (Math.abs(term) > 1e-10);
        return sum;
    }

    public double exp(double x) {
        /* TODO */
        double term = 0.0;
        double sum = 0.0;
        int n = 0;
        do {
            term = Math.pow(x, n) / factorial(n);
            sum += term;
            n++;
        } while (Math.abs(term) > 1e-10);
        return sum;
    }

    public double ln(double x) {
        /* TODO */
        double sum = 0.0;
        double term = 0.0;
        int n = 1;
        do {
            term = Math.pow(-1, n + 1) * Math.pow(x, n) / n;
            sum += term;
            n++;
        } while (Math.abs(term) > 1e-10);
        return sum;
    }

    public static double factorial(int x) {
        int res = 1;
        for (int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;
    }
}
