package org.example.entities;

import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeTest {
    @Test
    void createTablesTest(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Employee employee1 = new Employee(null,"nicolas","mamani","niko_mamani@mail.com",22,40000d,false, LocalDate.of(1990,1,1), LocalDateTime.now());
        Employee employee2 = new Employee(null,
                "martin",
                "coser",
                "martin@gmail.com",
                22,
                30000d,
                false,
                LocalDate.of(2000,1,1),
                LocalDateTime.now()
                );
        //empezamos una transacción
        session.beginTransaction();
        session.save(employee1);
        session.save(employee2);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        HibernateUtil.shutdown();
    }
}
