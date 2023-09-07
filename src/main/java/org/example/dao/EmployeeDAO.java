package org.example.dao;

import org.example.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    /**
     * Método que permite recuperar todos los empleados de base de datos
     * Utiliza HQL
     * @return lista de empleados
     */
    List<Employee> findAll();

    /**
     * Método que permite recuperar todos los empleados de base de datos
     * Utiliza Criteria
     * @return lista de empleados
     */
    List<Employee> findAllCriteria();

    /**
     * Buscar un empleado por su ID
     * Utiliza métodos de Hibernate
     * @return empleado
     */
    Employee findById(Long id);


    /**
     * Buscar un empleado por su ID
     * Utiliza Criteria
     * @return empleado
     */
    Employee findByIdCriteria(Long id);

    /**
     * Busca todos los empleados por edad
     * @param age
     * @return
     */
    List<Employee> findByAge(Integer age);

    /**
     * Se inserta un nuevo registro en la tabla employee
     * @param employee
     * @return
     */
    Employee  create(Employee employee);

    /**
     * Actualiza un registro existente en la tabla employee
     * @param employee
     * @return
     */
    Employee update(Employee employee);

    /**
     * Borrar un registro empleado de la tabla employee
     * @param id
     * @return
     */
    boolean deleteById(Long id);
}
