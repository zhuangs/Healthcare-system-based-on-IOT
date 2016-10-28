/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class EmployeeDirectory {
    private ArrayList<Employee> employeeList;
    
    public EmployeeDirectory(){
        employeeList = new ArrayList<>();
    }
    public Employee addEmployee(){
        Employee employee = new Employee();
        employeeList.add(employee);
        return employee;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    
}
