package com.ninetythree.employee;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by Dillan on 12/2/2015.
 */
public class TestEmployee extends TestCase
{
    private int empNumber;
    private String name;
    private String surname;
    private double salary;

    public TestEmployee(String testName)
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( TestEmployee.class );
    }

    public void testTestFileH()
    {
        assertTrue( true );
    }
    public void setUp() throws Exception
    {

    }

    public void tearDown() throws Exception
    {

    }

    public TestEmployee() {}

    public TestEmployee(int empNumber, String name, String surname, double salary)
    {
        this.empNumber = empNumber;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        assertEquals(5689.56, salary);
    }

    public int getEmpNumber()
    {
        return empNumber;
    }

    public void setEmpNumber(int empNumber)
    {
        assertNotNull(empNumber);
        this.empNumber = empNumber;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        assertNotNull(name);
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        assertNotNull(surname);
        this.surname = surname;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        assertNotNull(salary);
        this.salary = salary;
    }
}

