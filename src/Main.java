public class Main {
    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        fillEmployees(); // заполняем массив с данными о сотрудниках, зарплатах, отделах и id;
        printEmployees(employees); // печатаем полученый массив;
        printTotalSalary(employees); // печатаем сумму зарплат всех сотрудников;
        printLessSalary(employees); // сотрудник с минимально й зарплатой;
        printMoreSalary(employees); // сотрудник с максимальной зарплатой;
        printAmountSalary(employees); //средняя зарплата среди всех сотрудников;
        printNames(employees);
        changeSalary(employees, 10); // Изменяем зарплату сотрудников на 10%. Перезаписываем данные в исходный массив и дальше работаем с измененным массивом;
        printEmployees(employees); // выводим измененный массив с данными сотрудников;
        printLessSalary(createNewArrayDepartment(1)); // выводим в консоль имя и зарплату сотрудника с минимальной зарплатой по данному отделу;
        printMoreSalary(createNewArrayDepartment(2)); // выводим в консоль имя и зарплату сотрудника с максимальной зарплатой по данному отделу;
        printTotalSalary(createNewArrayDepartment(3)); // общая сумма выплат всех зарплат по отделу;
        printAmountSalary(createNewArrayDepartment(1)); // Средняя зарплата по отделу;
        changeSalary(createNewArrayDepartment(1), 10); // Изменяем (индексируем) зарплату всем сотрудникам указанного отдела;
        printEmployees(createNewArrayDepartment(1)); // Выводим все данные о сотрудниках данного отдела;
        printEmployees(createNewArrayLessSalary(employees, 100_000, createSizeLessSalary(100_000))); // Передаем данные о сотрудниках, чьи зарплаты меньше указанной;
        printEmployees(createNewArrayMoreSalary(60_000)); // Передаем данняе о сотрудниках, чьи зарплаты больше указанной;
    }

    public static void fillEmployees() {
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
        for (Employee employee : employees){
            System.out.println(employee);
    }

}

    public static int calculateTotalSalary() {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;

    }

    public static void printTotalSalary(Employee[] employees) {
        System.out.println("Общая сумма выплат: " + calculateTotalSalary());
    }

    public static String findLessSalary() {
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
        System.out.println(findLessSalary());
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
        return calculateTotalSalary() / employees.length;
    }

    public static void printAmountSalary(Employee[] employees) {
        System.out.println("Средний размер выплат за месяц составляет " + findAmountSalary(employees));
    }

    public static void printNames(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Имя сотрудника с " + employees[i].getId() + " id: " + employees[i].getEmployer());
        }
    }

    public static Employee[] changeSalary(Employee[]employees, int percent) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary((employees[i].getSalary() / 100 * percent) + employees[i].getSalary());
        }
        return employees;
    }

    public static int createSizeOfArray(Employee[] employees, int department) {
        int size = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                size++;
            }
        }
        return size;
    }

    public static Employee[] createNewArrayDepartment(int department) {
        int size = createSizeOfArray(employees, department);
        Employee[] newArray = new Employee[size];
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                newArray[counter] = employees[i];
                counter++;
            }
        }
        return newArray;
    }

    public static int createSizeLessSalary(int checkingSalary) {
        int size = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < checkingSalary) {
                size++;
            }
        }
        return size;
    }

    public static Employee[] createNewArrayLessSalary(Employee[] employees, int checkingSalary, int size) {
        Employee[] checkingLessSalary = new Employee[size];
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < checkingSalary) {
                checkingLessSalary[counter] = employees[i];
                counter++;
            }
        }return checkingLessSalary;
    }

    public static int createSizeMoreSalary(Employee[] employees, int checkingSalary) {
        int size = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= checkingSalary) {
                size++;
            }
        }return size;
    }

    public static Employee[] createNewArrayMoreSalary(int checkingSalary) {
        int size = createSizeMoreSalary(employees, checkingSalary);
        Employee[] checkingMoreSalary = new Employee[size];
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= checkingSalary) {
                checkingMoreSalary[counter] = employees[i];
                counter++;
            }
        }return checkingMoreSalary;
    }
}