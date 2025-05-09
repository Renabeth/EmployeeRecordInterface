package com.example.employeerecordinterface;

public class Employee extends Person {
    private int ID;
    Date hireDate = new Date();

    //No-arg constructor
    public Employee()
    {
        ID = 0;
        setFirstName("");
        setLastName("");
        hireDate.setDate(1,1,2001);
    }
    //Paramaterized constructor
    public Employee(String firstName, String lastName, int ID, int month, int day, int year)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setID(ID);
        setHireDate(hireDate);

    }
    //Copy constructor
    public Employee(Employee other)
    {
        hireDate = other.hireDate;
        ID = other.ID;
    }

    //getters
    public int getID(){
        return ID;
    }

    public Date getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return "First Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nID: " + getID() + "\nHire Date: " + getHireDate();
    }

    //setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setHireDate(Date hireDate) {
        hireDate.setDate(1,1,2000);
    }

    //equals method
    public boolean equals(Employee other) {
        //Compare first and last name
        if (!super.equals(other)) {
            return false;
        }

        if (!hireDate.equals(other.hireDate)) {  //Compare hireDate
            return false;
        }

        return ID == other.ID;   // Compare ID

    }


}
