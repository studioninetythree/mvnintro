package com.ninetythree.fileh;

import com.ninetythree.employee.TestEmployee;
import junit.framework.TestCase;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dillan on 12/2/2015.
 */
public class TestFileH extends TestCase {
    static private Scanner input;
    final static private String inputFile = "src/test/Employees.txt";
    final static private String outputFile = "EmployeesSalaryIncrease.txt";
    static ArrayList<TestEmployee> empsRead = new ArrayList<TestEmployee>();
    static ArrayList<TestEmployee> empsWrite = new ArrayList<TestEmployee>();
    final static File file = new File("EmployeesSalaryRaise.txt");


    public void setUp() throws Exception {
    }

    public void tearDown() throws Exception {
    }

    static public void testCloseFile() {
        try {
            if (input != null)
                input.close();
        } catch (NullPointerException exception) {
            throw exception;
        }

    }

    static public void testReadFile() {
        try {
            input = new Scanner(new File(inputFile));
            assertNotNull(input);
            assertNotNull(inputFile);

            while (input.hasNext()) {
                String line = input.nextLine();
                String[] tokens = line.split("#");
                int empNo = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                String surname = tokens[2];
                double salary = Double.parseDouble(tokens[3]);
                empsRead.add(new TestEmployee(empNo, name, surname, salary));
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        } finally {
            try {
                testCloseFile();
            } catch (Exception ex) {
                assertEquals(ex, new NullPointerException());
            }
        }
        testCloseFile();
    }

    static public void testWriteFile(ArrayList<TestEmployee> e) {
        assertNotNull(empsRead);
        if (empsRead.isEmpty() || empsRead == null) {
            testCloseFile();
        } else {
            empsWrite.addAll(empsRead);
            assertTrue(empsWrite.equals(empsRead));
            try {
                try {
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    for (TestEmployee em : empsWrite) {
                        double salIncrease = em.getSalary() + (em.getSalary() / 50 * 100);
                        em.setSalary(salIncrease);

                        int empNo = em.getEmpNumber();
                        String name = em.getName();
                        String surname = em.getSurname();
                        String to_write = String.format("%d#%s#%s#%2f#\n", empNo, name, surname, salIncrease);
                        bw.write(to_write);
                        bw.flush();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                }
                JOptionPane.showMessageDialog(null, "Write : " + empsWrite.size());
                testCloseFile();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            }
        }
    }

    static public ArrayList<TestEmployee> testGetEmpsRead() {
        assertNotNull(empsRead);
        return empsRead;
    }
}
