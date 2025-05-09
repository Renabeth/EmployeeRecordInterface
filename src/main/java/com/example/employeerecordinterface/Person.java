package com.example.employeerecordinterface;

public class Person {
    private String firstName;
    private String lastName;

    //No-arg constructor
    public Person()
    {
        firstName = "No Name";
        lastName = "No Name";
    }

    //Paramaterized constructor
    public Person(String firstName, String lastName)
    {
        setFirstName(firstName);
        setLastName(lastName);
    }

    //Copy constructor
    public Person(Person other)
    {
        firstName = other.firstName;
        lastName = other.lastName;
    }

    //getters
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    @Override
    public String toString()
    {
        return getFirstName() + " " + getLastName();
    }

    //setters
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    //equals method
    public boolean equals(Person other) {

        if (other == this) { // Check if Person objects are the same
            return true;
        }
        if (!(other instanceof Person)) { // Check if the object is an instance of Person
            return false;
        }
        else
            return false;

    }


}

