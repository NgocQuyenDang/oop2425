package hus.oop.numbersystem;

import java.math.BigInteger;

public class BinaryConverter extends AbstractNumberConverter {
    public BinaryConverter(OriginalNumber originalNumber) {
        /* TODO */
        super(originalNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 2.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 2.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        /* TODO */
        BigInteger n = new BigInteger(decimal);
        StringBuilder bin = new StringBuilder();

        if (n.equals(BigInteger.ZERO)) {
            return "0";
        }

        BigInteger TWO = BigInteger.valueOf(2);
        BigInteger ZERO = BigInteger.ZERO;
        while (n.compareTo(BigInteger.ZERO) > 0) {
            bin.append(n.mod(TWO).toString());
            n = n.divide(TWO);
        }
        bin.reverse();
        return bin.toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
     * số được chuyển đổi theo định dạng a1a2...an(2).
     */
    @Override
    public void update() {
        /* TODO */
        convert();
        display();
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(2).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println("Binary: " + convertedNumber + "(2)");
    }
}
