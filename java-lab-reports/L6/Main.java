import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        Student student = new Student(id, name, cgpa);
        StudentDAO dao = new StudentDAO();
        dao.insert(student);

        sc.close();
    }
}
