package com.ninetythree.maven;

import com.ninetythree.employee.Employee;
import com.ninetythree.fileh.FileH;

import javax.swing.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        final Employee leader = new Employee(1, "Dillan", "Isaacs", 5689.56);
        final int pin = 1234;

        ArrayList<Employee> employees = new ArrayList<Employee>();

        int usernumber = Integer.parseInt(JOptionPane.showInputDialog("Enter employee number: "));
        if (leader.getEmpNumber() == usernumber) {
            int p = Integer.parseInt(JOptionPane.showInputDialog("Enter pin: "));
            if (pin == p) {
                FileH.testReadFile();
                employees.addAll(FileH.testGetEmpsRead());
                FileH.testWriteFile(employees);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid user entered.");
        }
    }
}
