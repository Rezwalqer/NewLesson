import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        fillEmployees(employees);
        printEmployees(employees);
        printTotalSalary(employees);
        printLessSalary(employees);
        printMoreSalary(employees);
        printAmountSalary(employees);
        printNames(employees);

    }

    public static void fillEmployees(Employee[] employees) {
        employees[0] = new Employee("Иванов Иван Иванович", 110_000, 1);
        employees[1] = new Employee("Иванов Андрей Иванович", 114_000, 2);
        employees[2] = new Employee("Иванов Иван Андреевич", 86_000, 3);
        employees[3] = new Employee("Иванов Стапан Андреевич", 59_000, 4);
        employees[4] = new Employee("Иванов Вячеслав Степанович", 70_000, 5);
        employees[5] = new Employee("Иванов Спепан Степанович", 150_000, 1);
        employees[6] = new Employee("Иванов Алексей Иванович", 50_000, 2);
        employees[7] = new Employee("Иванов Иван Алексеевич", 47_000, 3);
        employees[8] = new Employee("Иванов Александр Иванович", 58_000, 4);
        employees[9] = new Employee("Иванов Артем Иванович", 49_000, 5);

    }


    public static void printEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
        }
    }

    public static int calculateTotalSalary(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;

    }

    public static void printTotalSalary(Employee[] employees) {
        System.out.println("Общая сумма выплат: " + calculateTotalSalary(employees));
    }

    public static String findLessSalary(Employee[] employees) {
        int lessSalary = employees[0].getSalary();
        String lessEmployer = employees[0].getEmployer();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < lessSalary) {
                lessSalary = employees[i].getSalary();
                lessEmployer = employees[i].getEmployer();
            }
        }
        return "Сотрудник с минимальной зарплатой: " + lessEmployer + ". Его зарплата составляет: " + lessSalary + " рублей.";
    }

    public static void printLessSalary(Employee[] employees) {
        System.out.println(findLessSalary(employees));
    }

    public static String findMoreSalary(Employee[] employees) {
        int moreSalary = employees[0].getSalary();
        String moreEmployer = employees[0].getEmployer();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > moreSalary) {
                moreSalary = employees[i].getSalary();
                moreEmployer = employees[i].getEmployer();
            }
        }
        return "Сотрудник с максимальной зарплатой: " + moreEmployer + ". Его зарплата составляет: " + moreSalary + " рублей.";
    }

    public static void printMoreSalary(Employee[] employees) {
        System.out.println(findMoreSalary(employees));
    }

    public static int findAmountSalary(Employee[] employees) {
        return calculateTotalSalary(employees) / employees.length;
    }

    public static void printAmountSalary(Employee[] employees) {
        System.out.println("Средний размер выплат за месяц составляет " + findAmountSalary(employees));
    }

    public static void printNames(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Имя сотрудника с " + employees[i].getId() + " id: " + employees[i].getEmployer());
        }
    }
}