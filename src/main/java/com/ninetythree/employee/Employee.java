package com.ninetythree.employee;

/**
 * Created by Dillan on 12/2/2015.
 */
public class Employee {
    private int empNumber;
    private String name;
    private String surname;
    private double salary;

    public Employee() {
    }

    public Employee(int empNumber, String name, String surname, double salary) {
        this.empNumber = empNumber;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
