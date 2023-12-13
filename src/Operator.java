import java.util.Comparator;

public class Operator implements Employee, Comparator<Employee> {
    double salary;
    public Operator() {
        this.salary = 0;
    }
    public Operator(double fix) {
        setSalary(fix);
    }
    public void setSalary(double fix) {
        this.salary = fix;
    }
    public double getMonthSalary() {
        return salary;
    }
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getMonthSalary(), e2.getMonthSalary());
    }
}
