package hus.oop.numbersystem;

import java.math.BigInteger;

public class HexadecimalConverter extends AbstractNumberConverter {
    public HexadecimalConverter(OriginalNumber originalNumber) {
        /* TODO */
        super(originalNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 16.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 16.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        /* TODO */
        BigInteger num = new BigInteger(decimal);
        StringBuilder result = new StringBuilder();
        String digits = "0123456789ABCDEF";
        if (num.equals(BigInteger.ZERO)) return "0";
        BigInteger SIXTEEN = BigInteger.valueOf(16);
        while (num.compareTo(BigInteger.ZERO) > 0) {
            result.append(digits.charAt(num.mod(SIXTEEN).intValue()));
            num = num.divide(SIXTEEN);
        }
        return result.toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal 
     * số được chuyển đổi theo định dạng a1a2...an(16).
     */
    @Override
    public void update() {
        /* TODO */
        convert();
        display();
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(16).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println("Hexadecimal: " + convertedNumber + "(16)");
    }
}
