package hus.oop.numbersystem;

import java.math.BigInteger;

public class OctalConverter extends AbstractNumberConverter {
    public OctalConverter(OriginalNumber originalNumber) {
        /* TODO */
        super(originalNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 8.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 8.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        /* TODO */
        BigInteger number = new BigInteger(decimal);
        BigInteger EIGHT = BigInteger.valueOf(8);
        int rem;
        StringBuilder result = new StringBuilder();
        char[] dig = {'0','1','2','3','4','5','6','7'};
        while (number.compareTo(BigInteger.ZERO) > 0) {
            result.append(dig[number.mod(EIGHT).intValue()]);
            number = number.divide(EIGHT);
        }
        return result.toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal 
     * số được chuyển đổi theo định dạng a1a2...an(8).
     */
    @Override
    public void update() {
        /* TODO */
        convert();
        display();
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(8).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println("Octal: " + convertedNumber + "(8)");
    }
}
