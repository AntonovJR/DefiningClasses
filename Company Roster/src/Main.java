import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Department> departments = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            switch (input.length) {
                case 4:
                    Employee employee = new Employee(name, salary,
                            position, department);
                    departments.putIfAbsent(department, new Department(department));
                    departments.get(department).getEmployees().add(employee);
                    break;

                case 5:
                    try {
                        int age = Integer.parseInt(input[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } catch (NumberFormatException e) {
                        String email = input[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    departments.putIfAbsent(department, new Department(department));
                    departments.get(department).getEmployees().add(employee);
                    break;

                case 6:
                    String email = input[4];
                    int age = Integer.parseInt(input[5]);
                    employee = new Employee(name, salary,
                            position, department, email, age);
                    departments.putIfAbsent(department, new Department(department));
                    departments.get(department).getEmployees().add(employee);
                    break;

            }

        }
        Department maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();
        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1,e2)-> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee-> System.out.println(employee.toString()));
    }
}
