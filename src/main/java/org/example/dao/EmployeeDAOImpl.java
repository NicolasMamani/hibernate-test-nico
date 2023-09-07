package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.entities.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public List<Employee> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Consulta HQL
        //List<Employee> employees = session.createQuery("from Employee",Employee.class).list();
        Query<Employee> query = session.createQuery("from Employee",Employee.class);
        List<Employee> employees = query.list();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> findAllCriteria() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        //1. Criteria
        CriteriaBuilder builder =session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        criteria.select(criteria.from(Employee.class));
        /*
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(root);
         */

        //2. Query
        List<Employee> employees = session.createQuery(criteria).list();

        session.close();
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Employee employee = session.find(Employee.class, id);
        session.close();

        return employee;
    }

    @Override
    public Employee findByIdCriteria(Long id) {
        //nos conectamos con Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        //1. Criteria
        CriteriaBuilder builder =session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        //Ahora vamos a filtar con un objeto "Predicado"
        Predicate filter = builder.equal(root.get("id"),id);
        criteria.select(root).where(filter);

        //2. Query
        Employee employee = session.createQuery(criteria).getSingleResult();

        //terminamos
        session.close();
        return employee;
    }

    @Override
    public List<Employee> findByAge(Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Employee> query = session.createQuery("from Employee where age = :age", Employee.class);
        query.setParameter("age",age);
        List<Employee> employees = query.list();
        session.close();
        return employees;
    }

    @Override
    public Employee create(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //empezamos una transacción
        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            HibernateUtil.shutdown();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().getRollbackOnly();
        }
        session.close();
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //empezamos una transacción
        try {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
            HibernateUtil.shutdown();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().getRollbackOnly();
        }
        session.close();
        return employee;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
