package com.academia.placementhistory.DAO;

import com.academia.placementhistory.Bean.Employee;

public interface EmployeeDAO {
    boolean verifyEmail(Employee emp);
    boolean addEmployee(Employee emp);
}
