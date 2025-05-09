package com.example.employeerecordinterface;

public class Date {

    private int day;
    private int month;
    private int year;

    //No-arg constructor
    public Date()
    {
        year = 2001;
        month = 1;
        day = 1;
    }

    //Paramaterized constructor
    public Date(int month, int day, int year)
    {
        setDate(month,day,year);
    }

    //Copy constructor
    public Date(Date other)
    {
        day = other.day;
        month = other.month;
        year = other.year;
    }

    //getters
    public int getDay(){
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return getMonth() + "-" + getDay() + "-" + getYear();
    }

    //setters
    public void setDate(int month, int day, int year)
    {

        // Validates year
        if (year >= 1900 && year <= 2022) {
            this.year = year;
        }
        else
            this.year = 2001;

        // Validates month
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
        else
            this.month = 1;

        // Validates day
        if (this.month == 2) { // February
            if (day >= 1 && day <= 28) {
                this.day = day;
            }
            else
                this.day = 1;
        }

        // April, June, September, November
        else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
            if (day >= 1 && day <= 30) {
                this.day = day;
            }
            else
                this.day = 1;
        }
        else {
            // January, March, May, July, August, October, December
            if (day >= 1 && day <= 31) {
                this.day = day;
            }
            else
                this.day = 1;
        }
    }

    //equals method
    public boolean equals(Date date1, Date date2) {
        if (date1 == date2) {
            return true;
        }
        if (date1 == null || date2 == null) {
            return false;
        }
        return date1.equals(date2);
    }


}
