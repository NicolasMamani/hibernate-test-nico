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
class EmployeeCRUDTest {

    EmployeeDAO dao;
    @BeforeEach
    void setUp() {
        dao = new EmployeeDAOImpl();
    }

    @Test
    void findAll() {
        List<Employee> employeeList = dao.findAll();
        System.out.println(employeeList);
    }

    @Test
    void findById() {
        Employee employee1 = dao.findById(1L);
        Employee employee2 = dao.findById(1L);
        System.out.println(employee2);
    }

    @Test
    void findByAge() {
        List<Employee> employees = dao.findByAge(22);
        System.out.println(employees);
    }

    @Test
    void create() {
        Employee employee = new Employee(null,"Hernan","Arias","hernan@gmail.com",21,40000d,true, LocalDate.now(), LocalDateTime.now());
        dao.create(employee);
        System.out.println(employee);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}