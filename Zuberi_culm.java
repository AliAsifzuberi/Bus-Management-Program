/**
 * Project: GO Transit Operations System (Culminating)
 * Programmer: Ali Zuberi
 * Date: April 6, 2021
 * Program Name: Hasan_culm.java
 * Description: Using content learned in ICS4U to design a program which 
 *              performs backend operations for GO Transit.
 */
package hasan_culm;
import java.util.*;
import java.text.*;
import java.io.*;
public class Hasan_culm {

    public static Scanner scanN = new Scanner(System.in);//global Num scanner
    public static Scanner scanS = new Scanner(System.in);//global Str scanner
    //global money decimal formatter
    public static DecimalFormat moneyR = new DecimalFormat("$###,###,##0.00");
   
    public static void main(String[] args) throws IOException{
        //creating file and print writers for use
        FileWriter fp, fe;
        PrintWriter pfp, pfe;
        
        //declaring object array lists
        ArrayList<Passenger> passengers = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        
        //declaring and initializing variables
        int role, p = 0, e = 0, option;
        String choice, name = null, routeChange, choiceOptions = null, routeKey;
        int[] passengerRouteSearch, employeeRouteSearch;
        
        //calling on methods to print title and list of routes
        title();
        routes();
        
        //do-while loop which runs the user interaction portion of program
        do{
            //greeting user and asking if they're an employee or passenger
            role = greeting();
            
            //two different cases based on user's role
            switch(role){
                
                //if user is a passenger
                case 1: 
                    //retreiving user information
                    passengers.add(getPassengerData());
                    name = passengers.get(p).getName();//initializing name var
                    
                    /*
                    a do-while loop which runs as long as user wants to keep 
                    selecting an option from the menu
                    */
                    do{
                    //prompting user for their choice
                    option = passengerMenu(name);
                    
                    //different cases based on user's choice
                    switch(option){
                        //if user chooses option 1
                        case 1:
                            //calling on routes method to display the routes
                            routes();
                            break;
                        //if user chooses option 2    
                        case 2:
                            do{
                            //prompting user for their new route with e.handling
                                System.out.println("Please enter the route");
                                routeChange = scanS.nextLine();
                            }while((!routeChange.equalsIgnoreCase("21A"))&&
                                   (!routeChange.equalsIgnoreCase("21B"))&&
                                   (!routeChange.equalsIgnoreCase("25"))&&
                                   (!routeChange.equalsIgnoreCase("47")));  
                             
                            //changing the passenger's route
                            passengers.get(p).setRoute(routeChange);
                            break;
                        //if user chooses option 3    
                        case 3:
                            //calling on method to perform option 3
                            passengerOptionThree(passengers.get(p));
                            break;
                        //if user chooses option 4    
                        case 4:
                            //setting boolean to true as they have a presto
                            passengers.get(p).setPresto(true);
                            //informing user of the action that's been done
                            System.out.println("A presto card has been added"
                                    + " to your account.");
                            break;
                        //if user chooses option 5    
                        case 5:    
                        default:
                            //informing user that no options were selected
                            System.out.println("No options were selected");
                            choiceOptions = "N";//setting to N, to break loop
                            break;    
                    }
                    
                    /*
                    prompts user if they would like to pick another option, 
                    only if they did not pick option 5
                    */
                    if(option != 5){
                        //do-while loop for error handling
                        do{
                        System.out.println("\nWould you like to choose another "
                                + "option? (Yes or No)");
                        choiceOptions = scanS.nextLine();
                        }while((!choiceOptions.equalsIgnoreCase("yes"))&&
                                (!choiceOptions.equalsIgnoreCase("no")));
                    }//end of if statement

                    }while(choiceOptions.equalsIgnoreCase("yes"));
                    p++;//increment counter for passengers arraylist
                    break;
                
                //if user is an employee    
                case 2:
                    //prompting user for their information
                    employees.add(getEmployeeData());
                    name = employees.get(e).getName();//initializing name var
                    
                    /*
                    a do-while loop which runs as long as user wants to keep 
                    selecting an option from the menu
                    */
                    do{
                    //prompting user for their choice
                    option = employeeMenu(name);
                    
                    //different cases based on user's choice
                    switch(option){
                        //if user chooses option 1
                        case 1:
                            //calling on method to display the routes
                            routes();
                            break;
                        //if user chooses option 2    
                        case 2:
                            do{
                            //prompting user for their new route with e.handling
                                System.out.println("Please enter the route");
                                routeChange = scanS.nextLine();
                            }while((!routeChange.equalsIgnoreCase("21A"))&&
                                   (!routeChange.equalsIgnoreCase("21B"))&&
                                   (!routeChange.equalsIgnoreCase("25"))&&
                                   (!routeChange.equalsIgnoreCase("47"))); 
                             
                            //changing the employee's route
                            employees.get(e).setRoute(routeChange);
                            break;
                        //if user chooses option 3    
                        case 3:
                            //displaying employee's wage
                            System.out.println("Current Hourly Wage: " +
                                    moneyR.format(employees.get(e).getWage()));
                            break;
                        //if user chooses option 4    
                        case 4:
                            //calling on method to perform option 4
                            employeeOptionFour(employees.get(e));
                            break;
                        //if user chooses option 5    
                        case 5:
                            //displaying the gross pay
                            System.out.println("Your current gross pay is at: " 
                                    + moneyR.format(employees.get(e).grossPay())
                            );
                            break;
                        //if user chooses option 6    
                        case 6:
                            //informing user of file choices
                            System.out.println("Program contains the "
                                    + "following files: Passengers.txt,"
                                    + " Employees.txt");
                            //calling on method to read files
                            readFiles();
                            break;
                        //if user chooses option 7    
                        case 7:
                            //printing message to user
                            System.out.println("***You are only allowed to "
                                    + "search through users you have manually"
                                    + " inputted as of now***\n\t\tOthers"
                                    + " information are kept condifential in "
                                    + "the files!");
                            //prompting user for the route with error handling
                            do{
                                System.out.println("Please enter the route");
                                routeKey = scanS.nextLine();
                            }while((!routeKey.equalsIgnoreCase("21A"))&&
                                   (!routeKey.equalsIgnoreCase("21B"))&&
                                   (!routeKey.equalsIgnoreCase("25"))&&
                                   (!routeKey.equalsIgnoreCase("47")));
                            /*
                            sorting object arraylists by name in alphabetical 
                            order (A-Z)
                            */
                            selectionSortPassenger(passengers);
                            selectionSortEmployee(employees);
                            
                            //performing searches
                            employeeRouteSearch = searchEmployee(employees, 
                                    routeKey);
                            passengerRouteSearch = searchPassenger(passengers, 
                                    routeKey);
                            
                            //printing out the objects that contain the key
                            System.out.println("\n\nThese are the employees "
                                    + "who are on the route you searched...");
                            for(int i=0; i<employeeRouteSearch.length; i++){
                                System.out.println(employees.
                                        get(employeeRouteSearch[i]) + "\n");
                            }
                            System.out.println("\n\nThese are the passengers"
                                    + " who are on the route you searched...");
                            for(int i=0; i<passengerRouteSearch.length; i++){
                                System.out.println(passengers.
                                        get(passengerRouteSearch[i]) + "\n");
                            }
                            break;
                        //if user chooses option 8    
                        case 8:    
                        default:
                            //informing user that no options were selected
                            System.out.println("No options were selected");
                            choiceOptions = "N";//setting to N, to break loop
                            break;
                    }
                    
                    /*
                    prompts user if they would like to pick another option, 
                    only if they did not pick option 8
                    */
                    if(option != 8){
                        //do-while loop for error handling
                        do{
                        System.out.println("\nWould you like to choose another"
                                + " option (Yes or No)");
                        choiceOptions = scanS.nextLine();
                        }while((!choiceOptions.equalsIgnoreCase("yes"))&&
                                (!choiceOptions.equalsIgnoreCase("no")));
                    }//end of if statement
                    
                    }while(choiceOptions.equalsIgnoreCase("yes"));
                    e++;//increment counter for employees arraylist
                    break;
                default:
                    break;
                }
            
            //printing farewell message for current user
            farewell(name);
            
            //asking if they would like to enter another user
            System.out.println("\nWould you like to enter another user?");
            choice = scanS.nextLine();
            
        }while(choice.equalsIgnoreCase("yes"));
        
        //sorting object arraylists by name in alphabetical order (A-Z)
        selectionSortPassenger(passengers);
        selectionSortEmployee(employees);
        
        /*
        appending a file for passenger objects and printing each of
        their states to the file. (File has been created)
        */
        //informing user that file is being created/updated
        System.out.println("\n\nUpdating file: Passengers.txt");
        //creating a file and initialzing a filewriter to append it
        fp = new FileWriter("Passengers.txt", true);
        //initializing a printwriter for the file that was created
        pfp = new PrintWriter(fp);
        //printing each passenger object onto the file
        for(Passenger pp: passengers){
            pfp.println(pp + "\n");
        }
        pfp.close();//closing the file stream
        //informing user that file has been created/appended
        System.out.println("File updated.");
        
        /*
        appending a file for employee objects and printing each of 
        their states to the file. (File has been created)
        */
        //informing user that file is being created/updated
        System.out.println("\nUpdating file: Employees.txt");
        //creating a file and initialzing a filewriter to append it
        fe = new FileWriter("Employees.txt", true);
        //initializing a printwriter for the file that was created
        pfe = new PrintWriter(fe);
        //printing each employee object onto the file
        for(Employee ee: employees){
            pfe.println(ee + "\n");
        }
        pfe.close();//closing the file stream
        //informing user that file has been created/appended
        System.out.println("File updated.");

    }//end of main method
    
    /**
     * Method Name: getPassengerData
     * Fills passenger object with the information for its fields
     * @return - a passenger object initialized with user input
     */
    public static Passenger getPassengerData(){
        //declaring variables
        String name, email, route, choice;
        long phoneNum;
        int ticketNum;
        double prestoBalance = 0;//setting balance to 0 as default
        boolean presto = false;//setting boolean to false as default
        
        //prompting user(passenger) for their information 
        System.out.println("Please enter your name");
        name = scanS.nextLine();
        System.out.println("Please enter your email address");
        email = scanS.nextLine();
        System.out.println("Please enter your phone number");
        phoneNum = scanN.nextLong();
        do{
            System.out.println("Please enter the route you are taking/took");
            route = scanS.nextLine();
        }while((!route.equalsIgnoreCase("21A"))&&
               (!route.equalsIgnoreCase("21B"))&&
               (!route.equalsIgnoreCase("25"))&&
               (!route.equalsIgnoreCase("47")));//error handling  
        System.out.println("Please enter your ticket number");
        ticketNum = scanN.nextInt();
        do{
            System.out.println("Do you have a presto card? (Y/N)");
            choice = scanS.nextLine();
            choice = choice.toLowerCase();
            //if user says yes
            if(choice.equalsIgnoreCase("y")){
                presto = true;
            }//end of if statement
            //if user says no
            else if(choice.equalsIgnoreCase("n")){
                presto = false;
            }//end of else if statement
        }while((!choice.equals("y"))&&(!choice.equals("n")));//error handling
        //if user had said yes to having a presto card
        if(presto == true){
            do{
                System.out.println("What is your presto card's balance?");
                prestoBalance = scanN.nextDouble();
            }while(prestoBalance < 0);//error handling
        }
        
        //returning passenger object to main
        return new Passenger(name, email, route, phoneNum, 
                ticketNum, prestoBalance, presto);
    }//end of method
    
    /**
     * Method Name: getEmployeeData
     * Fills employee object with the information for its fields
     * @return - an employee object initialized with user input
     */
    public static Employee getEmployeeData(){
        //declaring variables
        String name, email, route;
        long phoneNum;
        double hours;
        
        //prompting user(employee) for their information
        System.out.println("Please enter your name");
        name = scanS.nextLine();
        System.out.println("Please enter your email address");
        email = scanS.nextLine();
        System.out.println("Please enter your phone number");
        phoneNum = scanN.nextLong();
        do{
            System.out.println("Please enter the route you will overlook");
            route = scanS.nextLine();
        }while((!route.equalsIgnoreCase("21A"))&&
                (!route.equalsIgnoreCase("21B"))&&
                (!route.equalsIgnoreCase("25"))&&
                (!route.equalsIgnoreCase("47")));//error handling    
        do{
            System.out.println("Please enter the amount of hours you have "
                    + "worked");
            hours = scanN.nextDouble();
        }while(hours < 0);//error handling
        
        //returning employee object to the main
        return new Employee(name, email, route, phoneNum, hours);
    }//end of method
    
    /**
     * Method Name: title
     * Prints title of the program out
     */
    public static void title(){
        System.out.println("**************** GO TRANSIT OPERATIONS SYSTEM *****"
                + "***********");
    }//end of method
    
    /**
     * Method Name: greeting
     * Greets user and asks if they are a passenger or an employee
     * @return numChoice - number indicating if they are a passenger or employee
     */
    public static int greeting(){
        //declaring variables
        String choice;
        int numChoice;
        
        //prompting user for input with error handling
        do{
            System.out.println("Welcome to the GO Transit Operations System!\n"
                    + "\nAre you a passenger or an employee?");
            choice = scanS.nextLine();
            choice = choice.toLowerCase();
        }while((!choice.equals("passenger")) && (!choice.equals("employee")));
        
        //if user is a passenger
        if(choice.equals("passenger")){
            numChoice = 1;
        }
        //if user is an employee
        else{
            numChoice = 2;
        }
        
        return numChoice;//returning variable to main
    }//end of method
    
    /**
     * Method Name: routes
     * Displays the routes that are running  
     */
    public static void routes(){
        //printing list of routes running
        System.out.println("\n\nThese are the routes currently running...\n");
        System.out.println("1. Route 21B| Mitlon GO to Union GO");
        System.out.println("2. Route 21A| Milton Go to Square One GO");
        System.out.println("3. Route 25| U of Waterloo to Square One GO");
        System.out.println("4. Route 47| McMaster U to Erin Mills GO\n\n");
    }//end of method
    
    /**
     * Method Name: passengerMenu
     * Displays a list of options for passenger to choose from
     * @param n - the passenger's name
     * @return choice - the passenger's choice
     */
    public static int passengerMenu(String n){
        //declaring choice variable
        int choice;
        
        //displaying options for passenger to choose from
        System.out.println("\n\nHello " + n + "! Please select one of the "
                + "following options...");
        System.out.println("1. View current routes");
        System.out.println("2. Change the route you are taking");
        System.out.println("3. Add money to presto balance");
        System.out.println("4. Purchase a presto card");
        System.out.println("5. None\n");
        
        //prompting user for their choice
        do{
            System.out.println("Please enter your choice");
            choice = scanN.nextInt();
        }while ((choice<1)||(choice>5));//error handling

        return choice;//returning choice variable to main
    }//end of method
    
    /**
     * Method Name: employeeMenu
     * Displays a list of options for employee to choose from
     * @param n - the employee's name
     * @return choice - the employee's choice
     */
    public static int employeeMenu(String n){
        //declaring choice variable
        int choice;
        
        //displaying options for user to choose from
        System.out.println("\n\nHello " + n + "! Please select one of the"
                + " following options...");
        System.out.println("1. View current routes");
        System.out.println("2. Change the route you will be overlooking");
        System.out.println("3. View your current hourly wage");
        System.out.println("4. Update the hours you have worked so far");
        System.out.println("5. See your current gross pay");
        System.out.println("6. Read files (passenger and employee info.)");
        System.out.println("7. Search who's on which route");
        System.out.println("8. None\n");
        
        //prompting user for their choice
        do{
            System.out.println("Please enter your choice");
            choice = scanN.nextInt();
        }while ((choice<1)||(choice>8));//error handling
        
        return choice;//returning choice variable to main
    }//end of method
    
    
    /**
     * Method Name: selectionSortPassenger
     * Sorts passengers in alphabetical order by their names
     * @param p - array list of passenger objects
     */
    public static void selectionSortPassenger (ArrayList<Passenger> p){
        //declaring variables
        Passenger minValue; // stores the value at min index
        int minIndex; // stores the mininum index
        
        //uses selection sort to sort array
        for (int i = 0; i <p.size()-1; i++) {

            minValue = p.get(i); // gets name of the object at lowest index
            minIndex = i; // stores this lowest index

            for (int j = i+1; j < p.size(); j++) { // compares to next val
                // if first string comes first alphabetically...
                if (p.get(j).getName().compareToIgnoreCase
                    (minValue.getName())<0){
                    minValue = p.get(j); // saves value at index j
                    minIndex = j; // saves index 
                }//end of if statment
            }//end of inner for loop
            p.set(minIndex, p.get(i)); // switching places
            p.set(i, minValue); // switching places
        }//end of outer for loop
    }//end of method
    
    /**
     * Method Name: selectionSortEmployee
     * Sorts employees in alphabetical order by their names
     * @param e - array list of employee objects
     */
    public static void selectionSortEmployee (ArrayList<Employee> e){
        //declaring variables
        Employee minValue; // stores the value at min index
        int minIndex; // stores the mininum index
        
        //uses selection sort to sort array
        for (int i = 0; i <e.size()-1; i++) {

            minValue = e.get(i); // gets name of the object at lowest index
            minIndex = i; // stores this lowest index

            for (int j = i+1; j < e.size(); j++) { // compares to next val
                // if first string comes first alphabetically...
                if (e.get(j).getName().compareToIgnoreCase
                    (minValue.getName())<0){
                    minValue = e.get(j); // saves value at index j
                    minIndex = j; // saves index 
                }//end of if statment
            }//end of inner for loop
            e.set(minIndex, e.get(i)); // switching places
            e.set(i, minValue); // switching places
        }//end of outer for loop
    }//end of method
    
    /**
     * Method Name: passengerOptionThree
     * Performs option 3 on the passenger menu
     * @param p - passenger object
     */
    public static void passengerOptionThree(Passenger p){
        //declaring variables
        double currentBalance, newBalance, addedMoney;
        
        do{
            //prompting user for amount they want to add  
            System.out.println("Please enter the amount of $$ you would "
                    + "like to add");
            addedMoney = scanN.nextDouble(); 
        }while(addedMoney < 0);//error handling
                             
        //getting their current balance
        currentBalance = p.getPrestoBalance();
                             
        //calculating their new balance
        newBalance = currentBalance + addedMoney;
                             
        //setting their new balance
        p.setPrestoBalance(newBalance);
                            
        //displaying the new balance
        System.out.println("Your new presto balance is at: " 
                + moneyR.format(p.getPrestoBalance()));
    }//end of method
    
    /**
     * Method Name: employeeOptionFour
     * Performs option 4 on the employee menu
     * @param e - employee object
     */
    public static void employeeOptionFour(Employee e){
        //declaring variables
        double currentHours, newHours, addedHours;
        
        do{
            System.out.println("Please enter the amount of hours you wish to "
                    + "add to the current amount of hours");
            addedHours = scanN.nextDouble();
        }while(addedHours < 0);//error handling
                            
        //getting the current hours
        currentHours = e.getHours();
                            
        //calculating the new hours
        newHours = currentHours + addedHours;
                            
        //setting the new hours
        e.setHours(newHours);
                            
        //displaying the new hours
        System.out.println("Your Hours Worked is now at: " 
                + e.getHours() + " hours");
    }//end of method
    
    /**
     * Method Name: readFiles
     * Used to read any file that has been created
     * @throws IOException 
     */
    public static void readFiles() throws IOException{
        //declaring variables/objects
        File nf;
        String fileName, line;
        Scanner scanF;
        
        //do-while loop that asks user for file and checks its existence
        do{
            //prompting user for input
            System.out.println("Please enter the file you wish to read:");
            fileName = scanS.nextLine();
            
            //open file for reading
            nf = new File (fileName);
            
            //message to user if file does not exist
            if(!nf.exists()){
                System.out.println("\nThe file " + fileName + " does not exist."
                        + " Please check your spelling and try again.");
            }
        } while(!nf.exists());
        
        scanF = new Scanner(nf);//initializing file scanner
        while(scanF.hasNext()){
            line = scanF.nextLine();//obtain the next line from the file
            System.out.println(line);//printing file
        }
        scanF.close();//closing scanner
       
    }//end of method
    
    /**
     * Method Name: farewell
     * Prints farewell message for user
     * @param n - user's name
     */
    public static void farewell(String n){
        System.out.println("\n" + n + ", thanks for using the GO Transit "
                + "Operations System today.\nHope you enjoy the rest of "
                + "your day!\n\n");
    }
    
    /**
     * Method Name: searchPassenger
     * Searches the passengers array list for the positions that have an object
     * which contains the route key
     * @param p - passengers array list
     * @param key - routeKey (the route being looked for)
     * @return indicesFinal - the positions which have the objects that contain
     *                        the key route
     */
    public static int[] searchPassenger(ArrayList<Passenger> p, String key){
        //searching through passengers array to find positions key is located
        int[] indicesInitial = new int[p.size()];
        int length = 0;
        for(int i = 0; i < p.size(); i++){
            if(key.equalsIgnoreCase(p.get(i).getRoute())){
                indicesInitial[length] = i;
                length++;
            }//end of if statement
        }//end of for loop
        
        //resizing array to it's appropriate length
        int[] indicesFinal = new int[length];
        for(int i=0; i<length; i++){
            indicesFinal[i] = indicesInitial[i];
        }//end of for loop
        
        return indicesFinal;//returns the positions of where key is located
    }//end of method
    
    /**
     * Method Name: searchEmployee
     * Searches the employees array list for the positions that have an object
     * which contains the route key
     * @param e - employees array list
     * @param key - routeKey (the route being looked for)
     * @return indicesFinal - the positions which have the objects that contain
     *                        the key route
     */
    public static int[] searchEmployee(ArrayList<Employee> e, String key){
        //searching through employees array to find positions key is located
        int[] indicesInitial = new int[e.size()];
        int length = 0;
        for(int i = 0; i < e.size(); i++){
            if(key.equalsIgnoreCase(e.get(i).getRoute())){
                indicesInitial[length] = i;
                length++;
            }//end of if statement
        }//end of for loop
        
        //resizing array to it's appropriate length
        int[] indicesFinal = new int[length];
        for(int i=0; i<length; i++){
            indicesFinal[i] = indicesInitial[i];
        }//end of for loop
        
        return indicesFinal;//returns the positions of where key is located
    }//end of method
    
}//end of program