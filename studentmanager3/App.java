package hus.oop.studentmanager;

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
        testOriginalData();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu và theo yêu cầu đã cho.
        - Viết code để test cho tất cả các hàm test.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom.
         */
        testSortMathsGradeIncreasing();
        testSortMathsGradeDecreasing();
    }

    public static void init() {
        String filePath = "data/students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.println(studentIds);
    }

    public static void testSortMathsGradeIncreasing() {
        /* TODO */
        List<Student> sorted = StudentManager.getInstance().sortMathsGradeIncreasing();
        System.out.println("Sorted Math Increasing: ");
        StudentManager.print(sorted);
    }

    public static void testSortMathsGradeDecreasing() {
        /* TODO */
        List<Student> sorted = StudentManager.getInstance().sortMathsGradeDecreasing();
        System.out.println("Sorted Math Decreasing: ");
        StudentManager.print(sorted);
    }

    public static void testSortPhysicsGradeIncreasing() {
        /* TODO */
        List<Student> sorted = StudentManager.getInstance().sortPhysicsGradeDecreasing();
        System.out.println("Sorted Physics Increasing: ");
        StudentManager.print(sorted);
    }

    public static void testSortPhysicsGradeDecreasing() {
        /* TODO */
        List<Student> sorted = StudentManager.getInstance().sortPhysicsGradeDecreasing();
        System.out.println("Sorted Physics Decreasing: ");
        StudentManager.print(sorted);
    }

    public static void testSortChemistryGradeIncreasing() {
        /* TODO */
        List<Student> sorted = StudentManager.getInstance().sortChemistryGradeIncreasing();
        System.out.println("Sorted Chemistry Increasing: ");
        StudentManager.print(sorted);
    }

    public static void testSortChemistryGradeDecreasing() {
        /* TODO */
        List<Student> sorted = StudentManager.getInstance().sortChemistryGradeDecreasing();
        System.out.println("Sorted Chemistry Decreasing: ");
        StudentManager.print(sorted);
    }

    public static void testSortAverageGradeIncreasing() {
        /* TODO */
        List<Student> sorted = StudentManager.getInstance().sortAverageGradeIncreasing();
        System.out.println("Sorted Average Grade Increasing: ");
        StudentManager.print(sorted);
    }

    public static void testSortAverageGradeDecreasing() {
        /* TODO */
        List<Student> sorted = StudentManager.getInstance().sortAverageGradeDecreasing();
        System.out.println("Sorted Average Grade Decreasing: ");
        StudentManager.print(sorted);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
        List<Student> filter = StudentManager.getInstance().filterStudentsHighestAverageGrade(10);
        System.out.println("Highest average grade in students with average grade : ");
        StudentManager.print(filter);
    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
        List<Student> filter = StudentManager.getInstance().filterStudentsLowestAverageGrade(10);
        System.out.println("Filtered 10 Students with Lowest Average Grade: ");
        StudentManager.print(filter);
    }
}
