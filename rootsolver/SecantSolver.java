package hus.oop.rootsolver;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp Secant
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm trong đoạn [lower, upper]
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double fa = function.evaluate(lower);
        double fb = function.evaluate(upper);

        if (fa == fb) throw new IllegalArgumentException();
        double c = upper -((fb * (upper - lower)) / (fb - fa));
        if (Math.abs(c - upper) > tolerance ) {
            return solve(function, upper, c);
        } else {
            return c;
        }
    }
}
