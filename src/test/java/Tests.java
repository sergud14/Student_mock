import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Tests {
    @RepeatedTest(value=4,name="корректные оценки добавляются в список оценок")
    public void gradesInRange(RepetitionInfo repetitionInfo){
        Student stud= new Student("vasia");
        int num = repetitionInfo.getCurrentRepetition()+1;
        stud.setGradeService(new GradeServiceMock());
        stud.addGrade(num);
        Assertions.assertEquals(stud.getGrades().get(0),num);
    }

    @ParameterizedTest(name="добавление неверных оценок кидает исключение")
    @MethodSource("MarksGenerator#ints")
    public void gradesNotInRange(int x){
        Student stud= new Student("vasia");
        stud.setGradeService(new GradeServiceMock());
        Assertions.assertThrows(IllegalArgumentException.class,()->stud.addGrade(x));
    }
}