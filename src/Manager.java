import java.util.Comparator;

public class Manager implements Employee, Comparator<Employee> {
    double salary;
    double revenue;
    public Manager() {
        this.salary = 0;
        this.revenue = 0;
    }
    public Manager(double fix, double revenue) {
        this.setSalary(fix, revenue);
        this.revenue = revenue;
    }
    public void setSalary(double fix, double revenue) {
        this.salary = fix + revenue * 0.05;
        this.revenue = revenue;
    }
    @Override
    public double getMonthSalary() {
        return salary;
    }
    public double getRevenue() {
        return revenue;
    }
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getMonthSalary(), e2.getMonthSalary());
    }
}
