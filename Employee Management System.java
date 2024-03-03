import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;

    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    public void addEmployee(Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
            return;
        }
        System.out.println("Employee List:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void updateEmployee(int id, String name, String position, double salary) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setPosition(position);
                employee.setSalary(salary);
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void deleteEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter employee position: ");
                    String position = scanner.next();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    ems.addEmployee(new Employee(0, name, position, salary));
                    break;
                case 2:
                    ems.viewEmployees();
                    break;
                case 3:
                    System.out.print("Enter employee ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new position: ");
                    String newPosition = scanner.next();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    ems.updateEmployee(idToUpdate, newName, newPosition, newSalary);
                    break;
                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    ems.deleteEmployee(idToDelete);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
        scanner.close();
    }
}
