package hus.oop.rootsolver;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến sử dụng phương pháp Newton-Raphson.
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double x = upper;
        int iterations = 0;
        double h = function.evaluate(x) / derived(x);
        while (Math.abs(h) >= tolerance &&  iterations < maxIterations) {
            h = function.evaluate(x) / derived(x);

            x = x - h;
            iterations++;
        }
        return x;
    }

    public static double derived(double x) {
        return MyMath.sin(x) + x * MyMath.cos(x);
    }
}
