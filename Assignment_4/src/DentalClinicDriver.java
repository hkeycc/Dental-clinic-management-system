// ---------------------------------------------------------
// Assignment 3
// Written by: Hanad-Keysse Mohamed Hassan Student Id: 40299566
// For COMP 248 Section W – Winter 2024
// ---------------------------------------------------------


/* This code will print a selection of choices for the user and prompt them to choose between 10 options where they can add
 * a clinic name, clinic dentists, clinic assistants, patients and their charges. They can also opt to remove or add patients/assistants.
 * Finally, they can see a scoresheet that has all of that information (clinic name, etc...) and another scoresheet with patients and their charges
 */


//Imports scanners
import java.util.Scanner;

public class DentalClinicDriver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        
        //Prints board for user selection
        welcomeMessage();

        	//Makes user selection invalid
        int userSelection = -1;

        

        Clinic myClinic = new Clinic();

        
        
        
        //Validation loop for int
        while (true)
        {
            if(in.hasNextInt()){
                break;

            } else {

                System.out.print("Enter a code, from the aformentioned, that corresponds to your task: ");

                in.next();
            }

        }
        //Iterates while user doesn't write exit code
        while(userSelection!=1010) {
            while (!in.hasNextInt()) {
                System.out.print("\nKindly continue by entering a valid code, from the aformentioned, that corresponds to your task: ");
                in.next();

            }



            userSelection = in.nextInt();

            switch(userSelection){

                case 1001: {System.out.println("\n...Define Office/Clinic...");

                    System.out.println(".........................");

                    System.out.println("Enter Office/Clinic information (ClinicName ClinicCode Term/Permit) as a single-line entry:");

                    
                    
                    //Sets clinic name, clinic code and clinic term to the three word input of the user
                    myClinic.setClinicName(in.next());

                    

                    myClinic.setClinicCode(in.next());

                    

                    myClinic.setClinicTerm(in.next());

                    

                    
                    System.out.print("\nSuccessful operation! Kindly continue by entering a valid code, from the aformentioned, that corresponds to your task: ");





                }

                break;

                case 1002: {System.out.println("\n...Add Dentist for Office/Clinic...");

                    System.out.println(".........................");

                    System.out.println("Enter dentist's information (EmployeeID FirstName LastName) as a single-line entry:");
                    //Sets the first name, last name and Id of the dentist with the three term user input
                    String Id = in.next();
                    String firstName = in.next();

                    
                    String lastName = in.next();

                    

                    

                    

                    myClinic.setDentist(new Individual(Id, firstName, lastName));

                    System.out.print("\nSuccessful operation! Kindly continue by entering a valid code, from the aformentioned, that corresponds to your task: ");



                }

                break;

                case 1003: {
                	
                	
                	System.out.println("\n...Register Dentist Assistant(s) for Office/Clinic...");

                    System.out.println(".........................");

                    System.out.println("Enter Dental Assistants information (ID1,FirstName1,LastName1;ID2,FirstName2,LastName2): ");
                    
                    //Consumes new line 
                    in.nextLine();
                    
                    
                    //user input string
                    String asstList = in.nextLine();
                    
                    //method that transforms array of strings into array of individual objects
                    Individual[] assistants = Individual.inStrToIndividualArr(asstList);
                    Individual[] addedAssistants = new Individual[assistants.length];
                    int count =0;
                    boolean isDuplicate;
                    
                    	//Iterates for every element of the array 
                    for (Individual newAssistant : assistants) {
                    	//Check if new assistant is not a null object
                        if (newAssistant != null) {  // Add null check for newAssistant
                            isDuplicate = false;
                            //Checks if it isn't null and if its id is equal to that of newAssistant and prints Already exists
                            if(myClinic.getDentalAsst()!=null) {
                            for (Individual existingAssistant : myClinic.getDentalAsst()) {
                                if (existingAssistant != null && existingAssistant.equals(newAssistant)) {
                                    System.out.println("Already exists: " + newAssistant.getEntityID());
                                    isDuplicate = true;
                                    break;
                                }
                            }}
                            //Prints successfully added
                            if (!isDuplicate||myClinic.getDentalAsst()==null) {
                               
                                System.out.println("Successfully added: "+newAssistant.toString());
                                addedAssistants[count++]= newAssistant;
                            }
                       
                        }
                        
                        
                    }
                    myClinic.appendToIndividualArr(addedAssistants, 1003);
                    System.out.print("\nKindly continue by entering a valid code, from the aformentioned, that corresponds to your task: ");
                    break;
                }




                case 1004: {
                    System.out.println("\n...Register Patient(s) for Office/Clinic...");
                    
                    System.out.println(".........................");
                    
                    System.out.println("Enter Patients information (ID1,FirstName1,LastName1;ID2,FirstName2,LastName2): ");
                    in.nextLine();
                    String patientList = in.nextLine();
                    Individual[] patients = Individual.inStrToIndividualArr(patientList);
                    Individual[] addedPatients = new Individual[patients.length];
                    int count =0;
                    boolean isDuplicate;
                    
                    	//Iterates for every element of the array 
                    for (Individual newPatient : patients) {
                    	//Check if new Patient is not a null object
                        if (newPatient != null) {  // Add null check for newAssistant
                            isDuplicate = false;
                            //Checks if it isn't null and if its id is equal to that of newPatient and prints Already exists
                            if(myClinic.getPatient()!=null) {
                            for (Individual existingPatient : myClinic.getPatient()) {
                                if (existingPatient != null && existingPatient.equals(newPatient)) {
                                    System.out.println("Already exists: " + newPatient.toString());
                                    isDuplicate = true;
                                    break;
                                }}
                            }
                            //Prints successfully added
                            if (!isDuplicate) {
                               
                                System.out.println("Successfully added: "+newPatient.toString());
                                addedPatients[count++]= newPatient;
                            }
                       
                        }
                        
                        
                    }
                    myClinic.appendToIndividualArr(addedPatients, 1004);
                    System.out.print("\nKindly continue by entering a valid code, from the aformentioned, that corresponds to your task: ");
                    
                    break;
                }

                //Only works for patients Array
                case 1005: {
                	System.out.println("Which entity do you wish to deregister? Write 1 if you wish to deregister a dental assistant.\n\n"
                			+ "Write 2 if you wish to deregister a patient.");
                	int userInput=0;
                	while (true) {
                        // Check if the next token is an integer
                        if (in.hasNextInt()) {
                            userInput = in.nextInt();
                            
                            // Validate the integer input
                            if (userInput == 1 || userInput == 2) {
                                break; // Valid input, exit the loop
                            } else {
                                System.out.println("Wrong entry. Write 1 if you wish to deregister a dental assistant.\n"
                                        + "Write 2 if you wish to deregister a patient.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number (1 or 2).");
                            in.next(); // Clear the invalid input
                        }
                    }
                	if(userInput==1) {
                	System.out.println("Enter information of entities to deregister assistants (ID1;ID2): ");
                	in.nextLine();
                	//Consumes new line
                	
                	
                	String idList = in.nextLine();
                	//Invokes the delete method and prints which individuals have been deleted
                	String output = myClinic.deleteFromIndividualArr(idList,1);
                	System.out.println(output);
                	}
                	
                	if(userInput==2) {
                		System.out.println("Enter information of entities to deregister assistants (ID1;ID2): ");
                    	in.nextLine();
                    	//Consumes new line
                    	
                    	
                    	String idList = in.nextLine();
                    	//Invokes the delete method and prints which individuals have been deleted
                    	String output = myClinic.deleteFromIndividualArr(idList,2);
                    	System.out.println(output);
                	}
                	
                	System.out.print("Kindly continue by entering a valid code, from the aformentioned, that corresponds to your task: ");
                	
                	
                	
                	
                }

                break;   
                //not functional
                case 1006: {System.out.print("Enter information of entities to update the charge of the patients (ID1,charge1;ID2,charge2): ");
                
                in.nextLine();
                
                String input = in.nextLine();
                	myClinic.updateIndividualCharge(input, 1006);
                	
                	
                	
                	System.out.print("Kindly continue by entering a valid code, from the aformentioned, that corresponds to your task: ");
                			
                }
                    break;
                    
                case 1007: {
                	if(myClinic.getClinicName()==null||myClinic.getClinicCode()==null||myClinic.getClinicTerm()==null||myClinic.getDentalAsst()==null
                			||myClinic.getDentist()==null||myClinic.getPatient()==null) {
                		System.out.println("Cannot proceed. Make sure to add a clinic name, term, and register patients.");
                		break;
                	}
                	System.out.println("..................................Display Patients' Statistics....................................................");
                	System.out.println("..................................................................................................................");
                	 System.out.printf(". %-22s: %-50s %n", "Clinic name",myClinic.getClinicName().toUpperCase() );
                	 System.out.printf(". %-22s: %-50s %n", "Clinic Code",myClinic.getClinicCode().toUpperCase() );
                	 System.out.printf(". %-22s: %-50s %n", "Term/Permit",myClinic.getClinicTerm() );
                	 System.out.printf(". %-22s: %-50s %n", "Dentist name","Dr "+myClinic.getDentist().toString() );
                	for (int i = 0; i < myClinic.getPatient().length; i++) {
                	    
                	    
                	    System.out.printf(". %-20s%-2d: %-50s %n", "Patient", i+1,myClinic.getPatient()[i].toString() );
                	}
                	System.out.printf(". %-22s: %-50s %n", "Registered assistants",myClinic.getDentalAsst().length );
                
                System.out.println("..................................................................................................................");
                System.out.print("\nKindly continue by entering a valid code, from the aformentioned, that corresponds to your task: ");}
                    break;

                case 1008:{
                	//Invokes clinicStats method and shows scoresheet
                	
                	myClinic.clinicStats("a");
                	System.out.print("\nKindly continue by entering a valid code, from the aformentioned, that corresponds to your task: ");
                	}

                    break;
                    
                    
                case 1009: {
                    if (myClinic.getPatient() == null || myClinic.getPatient().length == 0) {
                    
                        System.out.println("No patients registered. Cannot display chargesheet.");
                    } 
                    
                    
                    else {
                        System.out.println("..................................Display Chargesheet......................................................");
                        System.out.println("...........................................................................................................");
                        for (int i = 0; i < myClinic.getPatient().length; i++) {
                            Individual patient = myClinic.getPatient()[i];
                            System.out.printf(". %-20s%-2d: %-50s %-10s %n", "Patient", i + 1, patient.toString(), patient.getChargePercent() + "%");
                        }
                        System.out.println("...........................................................................................................");
                    }
                    System.out.print("\nKindly continue by entering a valid code, from the aforementioned, that corresponds to your task: ");
                }
                break;


                   

                case 1010: System.out.println("Simple SMDCMS >>> Exiting...");

                    break;



                default:{//Prompts user to enter a valid input

                    System.out.print("\nKindly continue by entering a valid code, from the aformentioned, that corresponds to your task: ");

                    break;

                }



            }

            

            

       
        }
        System.out.println("Thank you for fostering our Simple Mobile Dental Clinic Management System (SMDCMS)." );
        in.close();
    }
    
private static void welcomeMessage() {
	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

    System.out.println("+ Welcome to the Simple Mobile Dental Clinic Management System (SMDCMS) +");

    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

    System.out.println("Code -> Description");

    System.out.println("+++++++++++++++++++");

    System.out.println(" 1001 -> Define Office/Clinic");

    System.out.println(" 1002 -> Add Dentist to Office/Clinic");

    System.out.println(" 1003 -> Add Dental Assistants (Hygienists/Clerks) to Office/Clinic");

    System.out.println(" 1004 -> Register Patient(s) to Office/Clinic");

    System.out.println(" 1005 -> Deregistrer Dental Assistant(s) and/or Patient(s)");

    System.out.println(" 1006 -> Enter/Update Patient(s) Charges");

    System.out.println(" 1007 -> Display Patients' Statistics");

    System.out.println(" 1008 -> Display Office/Clinic Statistics");

    System.out.println(" 1009 -> Display Chargesheet");

    System.out.println(" 1010 -> Exit\n");

    System.out.print("Please enter a Code, from the aforementioned that corresponds to your task : ");
}
}
