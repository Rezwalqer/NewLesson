public class Employee {
    private String employer;
    private int salary;
    private int department;
    private static int count;
    private int id;


    public Employee(String employer, int salary, int department) {
        this.employer = employer;
        this.salary = salary;
        this.department = department;
        id = ++count;
    }

    public String getEmployer() {
        return employer;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Сотрудник: " + employer + "; Зарплата: " + salary + "; Отдел: " + department +"; id: " + id;
    }
}
