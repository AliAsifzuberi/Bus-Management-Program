/**
 * Class: Employee
 * Programmer: Ali Zuberi
 * Date: April 6, 2021
 * Program Name: Employee.java
 * Description: Creating a class for employee objects.
 */
package hasan_culm;
import java.text.*;
public class Employee {
    //fields
    private String name, email, route;
    private long phoneNum;
    private double wage, hours;
    
    //arg-constructor
    Employee(String n, String e, String r, long p, double h){
        name = n;
        email = e;
        route = r;
        phoneNum = p;
        hours = h;
        wage = 21.5;//same wage for all GO Transit workers
    }//end of constructor
    
    //mutators-setters
    /**
     * Method Name: setName
     * Used to set the employee's name
     * @param n - employee's name
     */
    public void setName(String n){
        name = n;
    }//end of method
    /**
     * Method Name: setEmail
     * Used to set the employee's email
     * @param e - employee's email
     */
    public void setEmail(String e){
        email = e;
    }//end of method
    /**
     * Method Name: setRoute
     * Used to set the employee's route
     * @param r - employee's route
     */
    public void setRoute(String r){
        route = r;
    }//end of method
    /**
     * Method Name: setPhoneNum
     * Used to set the employee's phone number
     * @param p - employee's phone number
     */
    public void setPhoneNum(long p){
        phoneNum = p;
    }//end of method
    /**
     * Method Name: setHours
     * Used to set the employee's number of hours worked
     * @param h - employee's number of hours worked
     */
    public void setHours(double h){
        hours = h;
    }//end of method
    /**
     * Method Name: setWage
     * Used to set the employee's hourly wage
     * @param w - employee's hourly wage
     */
    public void setWage(int w){
        wage = w;
    }//end of method
    
    //accessors-getters
    /**
     * Method Name: getName
     * Used to access and obtain employee's name
     * @return name - employee's name
     */
    public String getName(){
        return name;
    }//end of method
    /**
     * Method Name: getEmail
     * Used to access and obtain employee's email
     * @return email - employee's email
     */
    public String getEmail(){
        return email;
    }//end of method
    /**
     * Method Name: getRoute
     * Used to access and obtain the employee's route
     * @return route - employee's route
     */
    public String getRoute(){
        return route;
    }//end of method
    /**
     * Method Name: getPhoneNum
     * Used to access and obtain the employee's phone number
     * @return phoneNum - employee's phone number
     */
    public long getPhoneNum(){
        return phoneNum;
    }//end of method
    /**
     * Method Name: getHours
     * Used to access and obtain the employee's hours worked
     * @return hours - employee's hours worked
     */
    public double getHours(){
        return hours;
    }//end of method
    /**
     * Method Name: getWage
     * Used to access and obtain employee's hourly wage
     * @return wage - employee's hourly wage
     */
    public double getWage(){
        return wage;
    }//end of method
    
    //unique methods
    /**
     * Method Name: toString
     * Prints state of employee object
     * @return str - object's state
     */
    public String toString(){
        //creating a rounder for monetary values
        DecimalFormat moneyR = new DecimalFormat("$###,###,##0.00");
        
        //declaring string variable and gross pay variable
        String str;
        double grossPay;
        
        //initialzing gross pay variable
        grossPay = hours*wage;
        
        //initalizing string variable
        str = "Name: " + name + "\nEmail: " + email + "\nRoute: " + route +
                "\nPhone Number: " + phoneNum + "\nHours Worked: " + hours + 
                "\nHourly Wage: " + moneyR.format(wage) + "\nGross Pay: " + 
                moneyR.format(grossPay);
        
        return str;//returning string variable
    }//end of method
    
    /**
     * Method Name: grossPay
     * Calculates employee's gross pay 
     * @return - the gross pay
     */
    public double grossPay(){
        return hours*wage;
    }//end of method

}//end of class