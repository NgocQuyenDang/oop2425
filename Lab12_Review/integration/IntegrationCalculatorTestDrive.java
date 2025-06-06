package hus.oop.integration;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testArrayPolynomial();
        testListPolynomial();
        testIntegrationCalculator();
    }

    public static void testArrayPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ArrayPolynomial array1 = new ArrayPolynomial();
        array1.append(3.0);
        array1.append(2.0);
        array1.append(1.0);
        System.out.println(array1.toString());
        array1.set(4.0, 0);
        System.out.println("Array 1: ");
        System.out.println(array1.toString());
        ArrayPolynomial array2 = new ArrayPolynomial();
        array2.append(5.0);
        array2.append(6.0);
        array2.append(7.0);
        System.out.println("Array 2: ");
        System.out.println(array2.toString());

        System.out.println("Array 1 minus Array 2: ");
        System.out.println(array1.minus(array2));
        System.out.println("Array 1 multiply Array 2: ");
        System.out.println(array1.multiply(array2));
        System.out.print("Array 1 at x = 2 : ");
        System.out.println(array1.evaluate(2.0));
    }

    public static void testListPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ListPolynomial list1 = new ListPolynomial();
        list1.append(3.0);
        list1.append(2.0);
        list1.append(1.0);
        System.out.println("List 1: ");
        System.out.println(list1.toString());
        ListPolynomial list2 = new ListPolynomial();
        list2.append(5.0);
        list2.append(6.0);
        list2.append(7.0);
        System.out.println("List 2: ");
        System.out.println(list2.toString());
        System.out.println("List 1 minus List 2: ");
        System.out.println(list1.minus(list2));
        System.out.println("List 1 multiply List 2: ");
        System.out.println(list1.multiply(list2));
        System.out.print("List 1 at x = 2 : ");
        System.out.println(list1.evaluate(2.0));
    }

    public static void testIntegrationCalculator() {
        /*
         TODO

         - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
           IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
        ArrayPolynomial poly1 = new ArrayPolynomial();
        poly1.append(3.0);
        poly1.append(2.0);
        poly1.append(1.0);

        double lower = 0.0;
        double upper = 2.0;

        MidpointRule midpoint = new MidpointRule(0.00001, 20);
        IntegrationCalculator calc = new IntegrationCalculator(midpoint, poly1);
        System.out.println("------Midpoint Rule-------");
        System.out.println("Polynomial: " + poly1.toString());
        System.out.println("Integration Calculator: " + calc.integrate(lower, upper));

        SimpsonRule simpson = new SimpsonRule(0.00001, 20);
        IntegrationCalculator calc2 = new IntegrationCalculator(simpson, poly1);
        System.out.println("------Simpson Rule-------");
        System.out.println("Integration Calculator: " + calc2.integrate(lower, upper));

        TrapezoidRule  trapezoid = new TrapezoidRule(0.00001, 20);
        IntegrationCalculator calc3 = new IntegrationCalculator(trapezoid, poly1);
        System.out.println("------Trapezoid Rule-------");
        System.out.println("Integration Calculator: " + calc3.integrate(lower, upper));
    }
}
