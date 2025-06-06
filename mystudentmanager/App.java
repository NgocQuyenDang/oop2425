package hus.oop.mystudentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                TODO

                - Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào đối tượng được tạo ra từ
                lớp StudentManager để quản lý.
                - Đối tượng tạo ra từ lớp StudentManager là duy nhất trong chương trình, do dùng Singleton Pattern,
                và được tạo ra bằng cách gọi hàm StudentManager.getInstance().
                */
                Student student = new Student.StudentBuilder(dataList.get(0))
                        .withLastname(dataList.get(1))
                        .withFirstname(dataList.get(2))
                        .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                        .withMathsGrade(Double.parseDouble(dataList.get(4)))
                        .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                        .withChemistryGrade(Double.parseDouble(dataList.get(6)))
                        .build();
                StudentManager.getInstance().append(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        init();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu và theo yêu cầu đã cho.
        - Viết code để test cho tất cả các hàm test.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom.
         */
        // testOriginalData();
        // testFilterStudentsByAverageGrade();
        testFilterStudentsByMathGrade();
    }

    public static void init() {
        String filePath = "data/students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        /* TODO */
        System.out.println("Students information: ");
        MyList students = StudentManager.getInstance().getStudentList();
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student) students.get(i);
            System.out.print(student.getId() + " " + student.getLastname() + " " + student.getFirstname() + " " + student.getYearOfBirth());
            System.out.println();
        }
    }

    public static void testFilterStudentsByAverageGrade() {
        /* TODO */
        System.out.println("Students with average grade greater than 5");
        MyList students = StudentManager.getInstance().filterStudentsByAverageGrade();

        MyIterator iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = (Student) iterator.next();
            printInfo(student);
        }
    }

    public static void testFilterStudentsByMathGrade() {
        /* TODO */
        System.out.println("Students with math grade greater than 5");

        MyList students = StudentManager.getInstance().filterStudentsByMathGrade();

        MyIterator iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = (Student) iterator.next();
            printInfo(student);
        }
    }

    public static void printInfo(Student student) {
        System.out.print(student.getId() + " " + student.getLastname() + " " + student.getFirstname() + " " + student.getYearOfBirth());
        System.out.println();
    }
}
