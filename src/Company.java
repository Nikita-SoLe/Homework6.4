import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
    private final List<Employee> listEmployee;
    private double companyIncome;
    public Company() {
        this.listEmployee = new ArrayList<>();
        this.companyIncome = 0;
    }
    public void hire(Employee emp) {
        this.listEmployee.add(emp);
        setIncome();
        System.out.println("Сотрудник добавлен.");
    }
    public List<Employee> getListEmployee() {
        return listEmployee;
    }
    public void hireAll(List<Employee> list) {
        this.listEmployee.addAll(list);
        setIncome();
        System.out.println("Все сотрудники добавлены.");
    }
    public void fire(Employee emp) {
        if (listEmployee.contains(emp)) {
            listEmployee.remove(emp);
            setIncome();
        } else {
            System.out.println("В компании нет такого сотрудника.");
        }
    }
    public double getIncome() {
        return companyIncome;
    }
    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> topSalaryStaff = new ArrayList<>(listEmployee);
        topSalaryStaff.sort((e1, e2) -> Double.compare(e2.getMonthSalary(), e1.getMonthSalary()));
        if (0 > count || count > topSalaryStaff.size()) {
            System.out.println("Неверное количество сотрудник.");
            return topSalaryStaff;
        }
        return topSalaryStaff.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> lowestSalaryStaff = new ArrayList<>(listEmployee);
        lowestSalaryStaff.sort(Comparator.comparingDouble(Employee::getMonthSalary));
        if (0 > count || count > lowestSalaryStaff.size()) {
            System.out.println("Неверное количество сотрудник.");
            return lowestSalaryStaff;
        }
        return lowestSalaryStaff.subList(0, count);
    }
    private void setIncome() {
        companyIncome = 0;
        for (Employee emp  : listEmployee) {
            if (emp instanceof Manager) {
                companyIncome +=  ((Manager) emp).getRevenue();
            }
        }
    }
}
