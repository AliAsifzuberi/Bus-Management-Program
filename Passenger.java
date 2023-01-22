/**
 * Class: Passenger
 * Programmer: Ali Zuberi
 * Date: April 6, 2021
 * Program Name: Passenger.java
 * Description: Creating a class for person objects.
 */
package hasan_culm;
import java.text.*;
public class Passenger {
    //fields
    private String name, email, route;
    private long phoneNum;
    private int ticketNum;
    private double prestoBalance;
    private boolean presto;
    
    //arg-constructor 
    Passenger(String n, String e, String r, long p, int t, double b, boolean pr)
    {
        name = n;
        email = e;
        route = r;
        phoneNum = p;
        ticketNum = t;
        prestoBalance = b;
        presto = pr;
    }//end of constructor
    
    //mutators-setters
    /**
     * Method Name: setName
     * Used to set name of passenger
     * @param n - passenger's name
     */
    public void setName(String n){
        name = n;
    }//end of method
    /**
     * Method Name: setEmail
     * Used to set email of passenger
     * @param e - passenger's email
     */
    public void setEmail(String e){
        email = e;
    }//end of method
    /**
     * Method Name: setRoute
     * Used to set route that passenger is taking
     * @param r - passenger's route
     */
    public void setRoute(String r){
        route = r;
    }//end of method
    /**
     * Method Name: setPhoneNum
     * Used to set phone number of passenger 
     * @param p - passenger's phone number
     */
    public void setPhoneNum(long p){
        phoneNum = p;
    }//end of method
    /**
     * Method Name: setTicketNum
     * Used to set ticket number of passenger
     * @param t - passenger's ticket number
     */
    public void setTicketNum(int t){
        ticketNum = t;
    }//end of method
    /**
     * Method Name: setPrestoBalance
     * Used to set the presto balance of passenger
     * @param b - passenger's presto balance
     */
    public void setPrestoBalance(double b){
        prestoBalance = b;
    }//end of method
    /**
     * Method Name: setPresto
     * Used to set status of presto (if passenger has one or not)
     * @param pr - passenger's presto status
     */
    public void setPresto(boolean pr){
        presto = pr;
    }//end of method
    
    //accessors-getters
    /**
     * Method Name: getName
     * Used to access and obtain the passenger's name
     * @return name - passenger's name
     */
    public String getName(){
        return name;
    }//end of method
    /**
     * Method Name: getEmail
     * Used to access and obtain the passenger's email
     * @return email - passenger's email
     */
    public String getEmail(){
        return email;
    }//end of method
    /**
     * Method Name: getRoute
     * Used to access and obtain the passenger's route
     * @return route - passenger's route
     */
    public String getRoute(){
        return route;
    }//end of method
    /**
     * Method Name: getPhoneNum
     * Used to access and obtain the passenger's phone number
     * @return phoneNum - passenger's phone number
     */
    public long getPhoneNum(){
        return phoneNum;
    }//end of method
    /**
     * Method Name: getTicketNum
     * Used to access and obtain the passenger's ticket number
     * @return ticketNum - passenger's ticket number
     */
    public int getTicketNum(){
        return ticketNum;
    }//end of method
    /**
     * Method Name: getPrestoBalance
     * Used to access and obtain the passenger's presto balance
     * @return prestoBalance - passenger's presto balance
     */
    public double getPrestoBalance(){
        return prestoBalance;
    }//end of method
    /**
     * Method Name: getPresto
     * Used to access and obtain the status of passenger's presto
     * @return presto - status of the passenger's presto 
     */
    public boolean getPresto(){
        return presto;
    }//end of method
    
    //unique methods
    /**
     * Method Name: toString
     * Prints state of passenger object
     * @return str - object's state
     */
    public String toString(){
        //creating a rounder for monetary values
        DecimalFormat moneyR = new DecimalFormat("$###,###,##0.00");
        
        //declaring string value to be returned
        String str;
        
        //if passenger has a presto card
        if (presto == true){
            str = "Name: " + name + "\nEmail: " + email + "\nRoute: " + route + 
                    "\nPhone Number: " + phoneNum + "\nTicket Number: " + 
                    ticketNum + "\nPresto: Yes\nPresto Balance: " + 
                    moneyR.format(prestoBalance);
        }
        //if passenger does not have a presto card
        else{
            str = "Name: " + name + "\nEmail: " + email + "\nRoute: " + route + 
                    "\nPhone Number: " + phoneNum + "\nTicket Number: " + 
                    ticketNum + "\nPresto: No\nPresto Balance: " + 
                    moneyR.format(prestoBalance);
        }
        return str;//returning string value
    }//end of method
    
}//end of class