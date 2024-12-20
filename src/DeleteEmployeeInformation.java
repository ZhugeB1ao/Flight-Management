import java.util.List;
import java.util.Scanner;

public class DeleteEmployeeInformation {
    Scanner scanner = new Scanner(System.in);

    public void execute(List<Employee> employees, EmployeeOperations employeeOps) {
        while (true) {
            showInfo(employeeOps);
            String id = inputIDWithValidation(employeeOps, employees);

            // Find employee need to remove
            Employee toRemove = findEmployeeById(id, employees);

            // Result of removing
            removeResult(toRemove,employees,id,employeeOps);

            // Ask user if they want to perform another action
            if(!performAnotherDelete(employeeOps))
                break;
        }
    }

    public void showInfo(EmployeeOperations employeeOps) {
        employeeOps.showEmployeeInformation();
    }

    public String inputIDWithValidation(EmployeeOperations employeeOps, List<Employee> employees){
        return employeeOps.inputWithValidation("ID of the employee to remove", scanner, input -> employeeOps.isValidId(input, employees));
    }

    private Employee findEmployeeById(String id, List<Employee> employees) {
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    public void removeResult(Employee toRemove, List<Employee> employees, String id, EmployeeOperations employeeOps) {
        if (toRemove != null) {
            employees.remove(toRemove);
            System.out.println("Employee removed successfully!");
            employeeOps.updateCSV(employees, "src/employee_data.csv");
        } else {
            System.out.println("Employee with ID: " + id + " not found.");
        }
    }

    public boolean performAnotherDelete(EmployeeOperations employeeOps) {
        System.out.print("Do you want to remove another employee? (yes/no): ");
        String choice = scanner.nextLine();
        return employeeOps.performAnotherAction(choice);
    }
}
