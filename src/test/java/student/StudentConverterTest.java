package student;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentConverterTest {

    private final StudentConverter studentConverter = new StudentConverter();

    private final static int LIST_SIZE = 10;

    @Test
    void HighAchieverTest() {
        List<Student> students = generateStudents(21, 35, 91, 100);
        List<Student> result = studentConverter.convertStudents(students);
        for (int i = 0; i < students.size(); i++) {
            assertEquals(students.get(i).getAge(), result.get(i).getAge());
            assertEquals(students.get(i).getGrade(), result.get(i).getGrade());
            assertTrue(result.get(i).isHonorRoll());
        }
    }

    @Test
    void ExceptionalYoungHighAchieverTest() {
        List<Student> students = generateStudents(15, 20, 91, 100);
        List<Student> result = studentConverter.convertStudents(students);
        for (int i = 0; i < students.size(); i++) {
            assertEquals(students.get(i).getAge(), result.get(i).getAge());
            assertEquals(students.get(i).getGrade(), result.get(i).getGrade());
            assertTrue(result.get(i).isExceptional());
        }
    }

    @Test
    void PassedStudentTest() {
        List<Student> students = generateStudents(71, 90);
        List<Student> result = studentConverter.convertStudents(students);
        for (int i = 0; i < students.size(); i++) {
            assertEquals(students.get(i).getGrade(), result.get(i).getGrade());
            assertTrue(result.get(i).isPassed());
        }
    }

    @Test
    void FailedStudentTest() {
        List<Student> students = generateStudents(0, 70);
        List<Student> result = studentConverter.convertStudents(students);
        for (int i = 0; i < students.size(); i++) {
            assertEquals(students.get(i).getGrade(), result.get(i).getGrade());
            assertFalse(result.get(i).isPassed());
        }
    }

    @Test
    void EmptyListTest() {
        assertTrue(studentConverter.convertStudents(new ArrayList<>()).isEmpty());
    }


    @Test
    void NullInputTest() {
        assertThrows(RuntimeException.class, ()-> studentConverter.convertStudents(null));
    }


    private List<Student> generateStudents(int minAge, int maxAge, int minGrade, int maxGrade) {
        return Stream.generate(Student::new).limit(LIST_SIZE).peek(student -> {
            student.setAge(getRandom(minAge, maxAge));
            student.setGrade(getRandom(minGrade, maxGrade));
        }).toList();
    }

    private List<Student> generateStudents(int minGrade, int maxGrade) {
        return Stream.generate(Student::new).limit(LIST_SIZE).peek(student -> student.setGrade(getRandom(minGrade, maxGrade))).toList();
    }

    // min and max are inclusive
    private int getRandom(int min, int max) {
        Random random = new Random();
        max++;
        return random.nextInt(max - min) + min;
    }

}
