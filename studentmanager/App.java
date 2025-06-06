package hus.oop.studentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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

                Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào StudentManager để quản lý.
                */
                Student.StudentBuilder student = new Student.StudentBuilder(dataList.get(0))
                        .withLastname(dataList.get(1))
                        .withFirstname(dataList.get(2))
                        .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                        .withMathsGrade(Double.parseDouble(dataList.get(4)))
                        .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                        .withChemistryGrade(Double.parseDouble(dataList.get(6)));
                Student std = student.build();
                StudentManager.getInstance().append(std);
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
        testOriginalData();
        testSortMathsGradeIncreasing();
        testSortMathsGradeDecreasing();
        testSortPhysicsGradeIncreasing();
        testSortPhysicsGradeDecreasing();
    }

    public static void init() {
        String filePath = "data/students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        init();
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.print(studentIds);
    }

    public static void testSortYearOfBirthIncreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortYearOfBirthIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortYearOfBirthDecreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortYearOfBirthDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortMathsGradeIncreasing() {
        /* TODO */
        System.out.println("Math Grade Increasing: ");
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        StudentManager.print(students);
    }

    public static void testSortMathsGradeDecreasing() {
        /* TODO */
        System.out.println("Math Grade Decreasing: ");
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        StudentManager.print(students);
    }

    public static void testSortPhysicsGradeIncreasing() {
        /* TODO */
        System.out.println("Physics Grade Increasing: ");
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeIncreasing();
        StudentManager.print(students);
    }

    public static void testSortPhysicsGradeDecreasing() {
        /* TODO */
        System.out.println("Physics Grade Decreasing: ");
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeDecreasing();
        StudentManager.print(students);
    }

    public static void testSortChemistryGradeIncreasing() {
        /* TODO */
        System.out.println("Chemistry Grade Increasing: ");
        List<Student> students = StudentManager.getInstance().sortChemistryGradeIncreasing();
        StudentManager.print(students);
    }

    public static void testSortChemistryGradeDecreasing() {
        /* TODO */
        System.out.println("Chemistry Grade Decreasing: ");
        List<Student> students = StudentManager.getInstance().sortChemistryGradeDecreasing();
        StudentManager.print(students);
    }

    public static void testFilterStudentsHighestMathsGrade() {
        init();
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        List<Student> nHighestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighestMathsGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nHighestMathsGradeStudents);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestMathsGrade() {
        init();
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        List<Student> nLowestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestMathsGradeStudents.add(students.get(i));
        }

        String codeString = StudentManager.getInstance().idOfStudentsToString(nLowestMathsGradeStudents);
        System.out.print(codeString);
    }

    public static void testFilterStudentsHighestPhysicsGrade() {
        /* TODO */
        System.out.println("Top 5 Highest Grade of Physics: ");
        List<Student> students = StudentManager.getInstance().filterStudentsHighestPhysicsGrade(5);
        StudentManager.print(students);
    }

    public static void testFilterStudentsLowestPhysicsGrade() {
        /* TODO */
        System.out.println("Top 5 Lowest Grade of Physics: ");
        List<Student> students = StudentManager.getInstance().filterStudentsLowestPhysicsGrade(5);
        StudentManager.print(students);
    }

    public static void testFilterStudentsHighestChemistryGrade() {
        /* TODO */
        System.out.println("Top 5 Highest Grade of Chemistry: ");
        List<Student> students = StudentManager.getInstance().filterStudentsHighestChemistryGrade(5);
        StudentManager.print(students);
    }

    public static void testFilterStudentsLowestChemistryGrade() {
        /* TODO */
        System.out.println("Top 5 Lowest Grade of Chemistry: ");
        List<Student> students = StudentManager.getInstance().filterStudentsLowestChemistryGrade(5);
        StudentManager.print(students);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
    }
}
