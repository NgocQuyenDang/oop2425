package hus.oop.numbersystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSystemTestDrive {
    public static void main(String[] args) {
        /* Yêu cầu:

        - Sinh ngẫu nhiên 3 số bằng cách:
            - Cơ số radix là một số tự nhiên nằm trong đoạn [2, 16] được sinh ngẫu nhiên.
            - Xâu ký tự biểu diễn số được sinh ra bằng cách:
                + Độ dài số là một số tự nhiên nằm trong đoạn [10, 30] được sinh ra ngẫu nhiên.
                + Mỗi chữ số được sinh ra bằng cách: sinh ra một chỉ số ngẫu nhiên nằm trong đoạn [0, radix - 1],
                  sau đó lấy tương ứng với chỉ số đó một chữ số nằm trong xâu "0123456789ABCDEF".

        - Mỗi lần sinh ra một số và một cơ số mới, thực hiện việc cập nhật và in ra các số được chuyển đổi
          tự động sang các số được biểu diễn trong hệ cơ số 2, 8, 16.

        - Thực hiện chạy chương trình để in ra terminal thông tin về các số ban đầu và các số chuyển đổi, ví dụ:
          Original number: 123456
          radix 12
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Original number: 456789
          radix 7
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_NumberSystemConverter>.txt (Ví dụ, NguyenVanA_123456_NumberSystemConverter.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_NumberSystemConverter>.zip (Ví dụ, NguyenVanA_123456_NumberSystemConverter.zip),
          nộp lên classroom.
         */
        Random random = new Random();
        for (int t = 0; t < 3 ;t ++) {
            int radix = random.nextInt(15) + 2;
            String randomNum = "0123456789ABCDEF";
            String originalNumber = "";
            int numLength = random.nextInt(21) + 10;
            for (int i = 0; i < numLength; i++) {
                int index = random.nextInt(radix);
                originalNumber += randomNum.charAt(index);
            }
            OriginalNumber originalNumber1 = new OriginalNumber(originalNumber, radix);
            System.out.println("Original Number: " + originalNumber.toString());
            System.out.println("radix: " + radix);

            List<NumberConverter> converters = new ArrayList<>();
            converters.add(new BinaryConverter(originalNumber1));
            converters.add(new OctalConverter(originalNumber1));
            converters.add(new HexadecimalConverter(originalNumber1));

            for (NumberConverter converter : converters) {
                converter.update();
            }
            System.out.println();
        }
    }
}
