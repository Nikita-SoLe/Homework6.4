import java.util.Comparator;

public class TopManager implements Employee, Comparator<Employee> {
    double salary;
    public TopManager() {
        this.salary = 0;
    }
    public TopManager(double fix, double companyIncome) {
        setSalary(fix, companyIncome);
    }
    public void setSalary(double fix, double companyIncome) {
        this.salary = companyIncome > 10_000_000 ? fix + fix * 1.5 : fix;
    }
    @Override
    public double getMonthSalary() {
        return salary;
    }
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getMonthSalary(), e2.getMonthSalary());
    }
}
