package org.example.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="ob_employees")
public class Employee implements Serializable {

    // atributos (cada atributo representa una columna en la base de datos)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //lo común es usar Long que es una wrapper class.

    @Column(name="first_name",nullable = false,length = 30)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(unique = true)
    private String email; //el email por lo general no se repiten iguales emails

    private Integer age;
    private Double salary;
    private Boolean married;
    @Column(name="birth_date")
    private LocalDate birthDate; //almacena año, mes y dia
    @Column(name = "register_date")
    private LocalDateTime registerDate; //almacena año,mes,día con hora y segundos.

    //constructores (tiene que haber por lo menos uno)
    public Employee(){}

    public Employee(Long id, String firstName, String lastName, String email, Integer age, Double salary, Boolean married, LocalDate birthDate, LocalDateTime registerDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.married = married;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //método toString

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", married=" + married +
                ", birthDate=" + birthDate +
                ", registerDate=" + registerDate +
                '}';
    }
}
