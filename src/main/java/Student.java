public class Student {

    public String name;
    public int age;
    public int grade;
    public boolean exceptional;
    public boolean honorRoll;
    public boolean passed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isExceptional() {
        return exceptional;
    }

    public void setExceptional(boolean exceptional) {
        this.exceptional = exceptional;
    }

    public boolean isHonorRoll() {
        return honorRoll;
    }

    public void setHonorRoll(boolean honorRoll) {
        this.honorRoll = honorRoll;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}