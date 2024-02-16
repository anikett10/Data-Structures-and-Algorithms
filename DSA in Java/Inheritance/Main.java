/*
 * Author: Aniket Bhangale
 * Description: This Java program defines three classes - Human, Student, and Faculty.
 * The Human class is a base class that contains information about a person, such as name, age, and gender.
 * The Student class extends the Human class and adds attributes specific to students, such as roll number, class, semester, and CPF.
 * The Faculty class also extends the Human class and includes attributes related to faculty, such as employee ID, salary, and specialization.
 * The program demonstrates the use of these classes by creating instances of Student and Faculty and modifying their attributes.
 */

class Human {
    String name;
    int age;
    String gender;

    Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

class Student extends Human {
    int rollno;
    String class1;
    int semester;
    int cpf;

    Student(String name, int age, String gender, int rollno, String class1, int semester, int cpf) {
        super(name, age, gender);
        this.rollno = rollno;
        this.class1 = class1;
        this.semester = semester;
        this.cpf = cpf;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getInfo() {
        return "Name= " + getName() + "\n" +
                "Age= " + getAge() + "\n" +
                "Gender= " + getGender() + "\n" +
                "Roll No= " + rollno + "\n" +
                "Class= " + class1 + "\n" +
                "Sem= " + semester + "\n" +
                "CPF= " + cpf;
    }
}

class Faculty extends Human {
    int empid;
    double salary;
    String spec;

    Faculty(String name, int age, String gender, int empid, double salary, String spec) {
        super(name, age, gender);
        this.empid = empid;
        this.salary = salary;
        this.spec = spec;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getInfo() {
        return "Name= " + getName() + "\n" +
                "Age= " + getAge() + "\n" +
                "Gender= " + getGender() + "\n" +
                "Emp ID= " + empid + "\n" +
                "Salary= " + salary + "\n" +
                "Specification= " + spec + "\n";
    }
}

class Exp1 {
    public static void main(String arg[]) {
        Student s1 = new Student("Aniket", 18, "Male", 19, "IT", 3, 9);
        System.out.println(s1.getInfo() + "\n");
        s1.setAge(45);
        System.out.println(s1.getInfo() + "\n");
        Faculty f1 = new Faculty("MED", 21, "Male", 19, 1051000.0, "AI/ML");
        System.out.println(f1.getInfo() + "\n");
        f1.setSpec("DBMS");
        f1.setSalary(20000.0);
        System.out.println(f1.getInfo());
    }
}
