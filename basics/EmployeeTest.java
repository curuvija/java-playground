package basics;

import basics.classes.Employee;

import java.io.*;

public class EmployeeTest {
    Employee empOne = new Employee("James Smith");
    Employee empTwo = new Employee("Mary Anne");
    // Invoking methods for each object created

    empOne.empAge(26);
    empOne.empDesignation("Senior Software Engineer");
    empOne.empSalary(1000);
    empOne.printEmployee();

    empTwo.empAge(21);
    empTwo.empDesignation("Software Engineer");
    empTwo.empSalary(500);
    empTwo.printEmployee();
}
