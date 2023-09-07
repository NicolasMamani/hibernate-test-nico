package org.example.dao;

import org.example.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Tests para las operaciones CRUD
 */
class EmployeeCriteriaTest {

    EmployeeDAO dao;
    @BeforeEach
    void setUp() {
        dao = new EmployeeDAOImpl();
    }

    @Test
    void findAllCriteriaTest() {
        List<Employee> employees = dao.findAllCriteria();
        System.out.println(employees);
    }

    @Test
    void findByIdCriteriaTest() {
        Employee employee = dao.findByIdCriteria(3L);
        System.out.println(employee);
    }
}