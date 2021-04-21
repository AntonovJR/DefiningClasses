import java.util.ArrayList;
import java.util.List;

public class Department {
    public String getName() {
        return name;
    }

    private String name;


    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAverageSalary() {
        return this.employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

    }
}