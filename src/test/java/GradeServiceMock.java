public class GradeServiceMock implements GradeService{
    public boolean checkGrade(int grade){
        return grade >= 2 && grade <= 5;
    }
}