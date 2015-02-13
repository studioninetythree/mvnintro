package com.ninetythree.maven;

import com.ninetythree.employee.TestEmployee;
import com.ninetythree.fileh.TestFileH;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.swing.*;
import java.util.ArrayList;

public class AppTest extends TestCase {
    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testApp() {
        assertTrue(true);
    }

    public static void main(String[] args) {
        final TestEmployee leader = new TestEmployee(1, "Dillan", "Isaacs", 5689.56);
        final String name = "Dillan";
        final int pin = 1234;

        ArrayList<TestEmployee> employees = new ArrayList<TestEmployee>();

        int usernumber = Integer.parseInt(JOptionPane.showInputDialog("Enter employee number: "));
        assertEquals(usernumber, leader.getEmpNumber());
        assertEquals(name, leader.getName());
        if (leader.getEmpNumber() == usernumber) {
            int p = Integer.parseInt(JOptionPane.showInputDialog("Enter pin: "));
            assertEquals(pin, p);
            if (pin == p) {
                TestFileH.testReadFile();
                employees.addAll(TestFileH.testGetEmpsRead());
                TestFileH.testWriteFile(employees);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid user entered.");
        }
    }
}
