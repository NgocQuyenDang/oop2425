package hus.oop.rootsolver;

public class RootFindingTestDrive {
    public static void main(String[] args) {
        /*
        TODO

        Chạy các hàm test để test chương trình.
        Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_RootFinding>.txt
        (ví dụ, NguyenVanA_123456_RootFinding.txt).
        Nén tất cả các file source code và file kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_RootFinding>.zip (ví dụ, NguyenVanA_123456_RootFinding.txt), và nộp bài
        lên classroom.
        */
        testRootSolver();
    }

    public static void testRootSolver() {
        /*
         TODO

         - Viết chương trình tìm nghiệm của hàm (sin(x).x - 3) theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           UnivariateRealRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, hàm và nghiệm của hàm tìm được.
         */
        UnivariateRealFunction f = new UnivariateRealFunction();
        RootSolver bisection = new BisectionSolver(1e-10, 20);
        RootSolver secant = new SecantSolver(1e-10, 20);
        RootSolver newton = new NewtonRaphsonSolver(1e-10, 20);

        UnivariateRealRootFinding bisectionFinding = new UnivariateRealRootFinding(f, bisection);
        UnivariateRealRootFinding secantFinding = new UnivariateRealRootFinding(f, secant);
        UnivariateRealRootFinding newtonFinding = new UnivariateRealRootFinding(f, newton);

        double x1 = bisectionFinding.solve(12, 14);
        double x2 = secantFinding.solve(12, 14);
        double x3 = newtonFinding.solve(12, 14);

        System.out.println("Solve using bisection: ");
        System.out.println("x1 = " + x1);
        System.out.println("Solve using secant: ");
        System.out.println("x2 = " + x2);
        System.out.println("Solve using newton: ");
        System.out.println("x3 = " + x3);
    }
}
