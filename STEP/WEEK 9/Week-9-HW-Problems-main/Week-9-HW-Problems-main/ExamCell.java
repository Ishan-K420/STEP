class University {
    String name="ABC University";
    class Department {
        void show(){System.out.println("Department of CS in "+name);}
    }
    static class ExamCell {
        static void info(){System.out.println("Exam Cell is active");}
    }
}

public class ExamCell {
    public static void main(String[] args){
        University u=new University();
        University.Department d=u.new Department();
        d.show();
        University.ExamCell.info();
    }
}
