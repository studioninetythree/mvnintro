package com.ninetythree.fileh;
import com.ninetythree.employee.Employee;

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
public class FileH
{
    static private Scanner input;
    final static private String inputFile = "Employees.txt";
    final static private String outputFile = "EmployeesSalaryIncrease.txt";
    static ArrayList<Employee> empsRead = new ArrayList<Employee>();
    static ArrayList<Employee> empsWrite = new ArrayList<Employee>();
    final static File file = new File("EmployeesSalaryRaise.txt");

    static public void testCloseFile()
    {
        try
        {
            input.close();
        }
        catch (NullPointerException exception)
        {
            throw exception;
        }

    }

    static public void testReadFile()
    {
        try
        {
            input = new Scanner(new File(inputFile));

            while(input.hasNext())
            {
                String line = input.nextLine();
                String[] tokens = line.split("#");
                int empNo = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                String surname = tokens[2];
                double salary = Double.parseDouble(tokens[3]);
                empsRead.add(new Employee(empNo, name, surname, salary));
            }
            JOptionPane.showMessageDialog(null,"Read: " + empsRead.size());
        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        finally
        {
            try
            {
                testCloseFile();
            }
            catch (NullPointerException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        testCloseFile();
    }

    static public void testWriteFile(ArrayList<Employee> emp)
    {
        if(empsRead.isEmpty() || empsRead == null)
        {
            testCloseFile();
        }
        else {
            empsWrite.addAll(empsRead);
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Employee e : empsWrite) {
                    double salIncrease = e.getSalary() + (e.getSalary() / 50 * 100);
                    e.setSalary(salIncrease);

                    int empNo = e.getEmpNumber();
                    String name = e.getName();
                    String surname = e.getSurname();
                    String to_write = String.format("%d#%s#%s#%2f#\n", empNo, name, surname, salIncrease);
                    bw.write(to_write);
                    bw.flush();
                }
            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            }
            JOptionPane.showMessageDialog(null, "Write : " + empsWrite.size());
            testCloseFile();
        }
    }

    static public ArrayList<Employee> testGetEmpsRead()
    {
        return empsRead;
    }

}
