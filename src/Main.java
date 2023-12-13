import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final double salaryOperator = 20_000;
        final double salaryManager = 50_000;
        final double salaryTopManager = 100_000;

        final int minRevenue = 115_000;
        final int maxRevenue = 140_000;

        Company company1 = new Company();

        for (int i = 0; i < 180; i++) {
            company1.hire(new Operator(salaryOperator));
        }
        for (int i = 0; i < 80; i++) {
            double revenue = (Math.random() * maxRevenue - minRevenue) + minRevenue;
            company1.hire(new Manager(salaryManager, revenue));
        }
        for (int i = 0; i < 10; i++) {
            company1.hire(new TopManager(salaryTopManager, company1.getIncome()));
        }

        System.out.println(company1.getIncome());

        printEmployee(company1);

        for (int i = 0; i < (company1.getListEmployee().size() + 1) / 2; i++) {
            Random rand = new Random();
            Employee emp = company1.getListEmployee().get(rand.nextInt(company1.getListEmployee().size()));
            company1.fire(emp);
        }

        System.out.println(company1.getIncome());
        printEmployee(company1);

    }
    static void printEmployee(Company company) {
        System.out.println("Список топовых сотрудников.");
        for (Employee el : company.getTopSalaryStaff(15)) {
            System.out.println(el.getMonthSalary());
        }
        System.out.println("Список худших сотрудников");
        for (Employee el : company.getLowestSalaryStaff(30)) {
            System.out.println(el.getMonthSalary());
        }
    }
}