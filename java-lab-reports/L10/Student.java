import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cgpa;

    public Student() {}

    public Student(String name, double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
    public void setName(String name) { this.name = name; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }
}
