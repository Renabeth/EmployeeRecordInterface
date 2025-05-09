package com.example.employeerecordinterface;

/*
Author: Serena D'Avanzo
I certify that this submission is my own original work
Employee Record Interface
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField employeeIDTF;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField hireMonthTF;
    @FXML
    private TextField hireDayTF;
    @FXML
    private TextField hireYearTF;
    @FXML
    private Button addEmployeeButton;
    @FXML
    private TextArea statusTA;
    @FXML
    private TextArea outputTA;
    @FXML
    private Label employeeCount;
    @FXML
    private Button displayAllButton;

    ArrayList<Employee> employeeList= new ArrayList();
    String output = "";
    int ID;
    String firstName = "";
    String lastName = "";
    int month;
    int day;
    int year;

    //Event Handler for Add Employee button
    @FXML
    private void addEmployeeHandler(ActionEvent event) throws IOException {

        statusTA.setEditable(false);
        outputTA.setEditable(false);

        //Initialize employee variables to user input
        ID = Integer.parseInt(employeeIDTF.getText());
        firstName = firstNameTF.getText();
        lastName = lastNameTF.getText();
        month = Integer.parseInt(hireMonthTF.getText());
        day = Integer.parseInt(hireDayTF.getText());
        year = Integer.parseInt(hireYearTF.getText());

        Employee emp = new Employee(firstName, lastName, ID, month, day, year); //create employee object
        employeeList.add(emp);  //add to array
        outputTA.appendText("--------------------");
        outputTA.appendText("\n" + emp.toString() + "\n");  //display Employee in text area

        //Clear all fields once record is added
        employeeIDTF.clear();
        firstNameTF.clear();
        lastNameTF.clear();
        hireMonthTF.clear();
        hireDayTF.clear();
        hireYearTF.clear();

        //Display when record is successfully added
        statusTA.setText("New Record Added");

        //Number Format Exception Handler
        try {
            emp.getID();
        }
        catch(NumberFormatException e) {
            System.out.println("ID must be a number.");
            statusTA.appendText("ID must be a number");
            e.getMessage();
        }

        //IOException Event Handler
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.close();
        }
        catch (IOException e) {
            outputTA.setText("IOException Caught");
            System.out.println(e.getMessage());
        }

        // Write employee data to a file
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("src\\main\\java\\com\\mycompany\\courseproject\\output.txt", true));
            for (int i = 0; i < employeeList.size(); i++) {
                writer.println(employeeList.get(i).toString());
            }
            writer.close();
        }
        catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }

        //Display total number of employees
        int numOfEmployees = employeeList.size();
        employeeCount.setText("Number Of Employees: " + Integer.toString(numOfEmployees));

    }

    //Event Handler for Display All button
    @FXML
    private void displayAllHandler(ActionEvent event) {

        // Display employee information in the output text area
        outputTA.clear();
        output = "";
        for (Employee e : employeeList) {
            output += e.toString() + "\n\n";
        }
        outputTA.appendText(output);
        statusTA.setText("Displaying All Employees");
    }

}







