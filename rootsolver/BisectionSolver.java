package hus.oop.rootsolver;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp chia đôi (Bisection)
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double midpoint = 0;
        int iterations = 0;
        if (function.evaluate(lower) * function.evaluate(upper) > 0) {
            System.out.println("No Root Found");
        } else {
            while (((upper - lower)/ 2.0) > tolerance && iterations < maxIterations ) {
                midpoint =(double) ((double)(upper + lower)/2.0);
                if (function.evaluate(midpoint) == 0) {
                    return midpoint;
                }
                else if (function.evaluate(lower)*function.evaluate(midpoint) < 0) {
                    upper = midpoint;
                }
                else {
                    lower = midpoint;
                }
                iterations++;
            }
        }
        return midpoint;
    }
}
