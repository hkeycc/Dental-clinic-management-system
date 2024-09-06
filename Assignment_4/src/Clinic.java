public class Clinic {


	//objects of the clinic class
    private String clinicName;

    private static String clinicCode;

    private String clinicTerm;

    private Individual dentist;

    private Individual[] dentalAsst;

    private Individual[] patient;



    public  String getClinicName() {

        return clinicName;



    }


  //getter
    public  String getClinicCode() {

        return clinicCode;

    }
  //getter
    public  String getClinicTerm() {

        return clinicTerm;

    }
  //getter
    public  Individual getDentist() {

        return dentist;	}
    //getter
    public  Individual[] getDentalAsst() {

        return dentalAsst;

    }
    //getter
    public  Individual[] getPatient() {

        return patient;

    }
    //setter
    public void setClinicName(String inClinicName) {

        this.clinicName = inClinicName;

    }


    //setter
    public void setClinicCode(String inClinicCode) {

        this.clinicCode = inClinicCode;



    }
    
    

    //setter
    public void setClinicTerm(String inClinicTerm) {

        this.clinicTerm = inClinicTerm;



    }


    //setter
    public void setDentist(Individual inDentist) {

        this.dentist = inDentist;



    }


    //setter
    public void setDentalAsst(Individual[] inDentalAsst) {

        this.dentalAsst = inDentalAsst;
    }



    public void setPatient(Individual[] inPatient) {

        this.patient =inPatient;

    }





    {}

    public Clinic() {}



    public Clinic(String inClinicName, String inClinicCode, String inClinicTerm, Individual inDentist, Individual[] inDentalAsst, Individual[] inPatient) {

        clinicName = inClinicName;
        clinicCode = inClinicCode;
        clinicTerm = inClinicTerm;
        dentist = inDentist;
        dentalAsst = inDentalAsst;
        patient = inPatient;

    }
    @Override
    public String toString() {
    	return clinicName+", "+clinicCode+", "+clinicTerm+", "+dentist.toString()+", "+"count("+dentalAsst.length+"), count("+patient.length+")";
    }
    
    public String appendToIndividualArr(Individual[] arr1, int mode) {
    	int count = 0;
        for (Individual individual : arr1) {
            if (individual != null) {
                count++;
            }
        }
        	//Trimmed array(no null values)
        Individual[] app = new Individual[count];
        
        int index = 0;
        for (Individual individual : arr1) {
            if (individual != null) {
                app[index++] = individual;
                
            }
        }
        
    	if(mode==1003){
    	int originalLength=0;
    	if(this.getDentalAsst()!=null) {
    		originalLength=this.getDentalAsst().length;
    	}
    	
    	Individual[] arr = new Individual[app.length+originalLength];
    	for(int i=0;i<originalLength;i++) {
    		arr[i] = this.dentalAsst[i];
    		
    	}
    	for (int i=0;i<app.length;i++) {
    		arr[originalLength+i]=app[i];
    		
    	}
    	this.setDentalAsst(arr);
    	return "Successful operation";
    	}
    	
    	if (mode==1004) {
    		int originalLength =0;
    		if(this.getPatient()!=null) {
    		 originalLength=this.patient.length;
    		 }
    		
        	Individual[] arr = new Individual[app.length+originalLength];
        	for(int i=0;i<originalLength;i++) {
        		arr[i] = this.patient[i];
        	}
        	for (int i=0;i<app.length;i++) {
        		arr[originalLength+i]=app[i];
        	}
        	this.setPatient(arr);
        	return "Successful operation";
        	}
    	return "Invalid query";
    	
    }
    
    
    
    public String deleteFromIndividualArr(String inStr, int mode) {
    	if(mode==2) {
    		
        Individual[] patients = getPatient(); 
        String firstName = "";
        String lastName = "";
        
        if (patients == null) {
        	
            return "No patients are registered.";
        }
        //Split into array of strings
        String[] listOfIDs = inStr.split(";"); 
        boolean deleted = false;
        String deletedIds = "";

        // Iterate  each ID object
        for (String id : listOfIDs) {
            boolean found = false;
            // Search for this ID in the patient array
            for (int i = 0; i < patients.length; i++) {
                if (patients[i] != null && patients[i].getEntityID().equals(id)) {
                	firstName = patients[i].getFirstName();
                	lastName = patients[i].getLastName();
                    patients[i] = null; 
                    found = true;
                    deleted = true;
                    deletedIds +="Successfully Deleted: "+lastName.toUpperCase()+", "+firstName+" ("+id+")\n" ;
                    break;
                }
            }
            if (!found) {
                deletedIds += "Entity NOT Found: "+ id + "\n";
            }
        }
        boolean allNull = true;
        for (Individual patient : patients) {
            if (patient != null) {
            	
                allNull = false;
                break;
            }
        }
        if (allNull) {
        	
        	this.setPatient(new Individual[0]);
        }
        
        if (!deleted) {
            return "Entity not found";
        } else {
            	//Count the non-null elements
            int count = 0;
            for (int i = 0; i < patients.length; i++) {
                if (patients[i] != null) {
                    count++;
                }
            }

            	//Creates a new array with the size of count (non-null elements)
            Individual[] resizedP = new Individual[count];
            int index = 0;
            for (int i = 0; i < patients.length; i++) {
                if (patients[i] != null) {
                    resizedP[index++] = patients[i];
                }
            }

            	//Setter
            this.setPatient(resizedP);

            return deletedIds;
        }
    }
    		if(mode==1) {
    			
    		Individual[] assts = getDentalAsst(); 
            String firstName = "";
            String lastName = "";
            
            if (assts == null) {
                return "No patients are registered.";
            }
            
            String[] listOfIDs = inStr.split(";"); 
            boolean deleted = false;
            String deletedIds = "";

            	// Iterate  each ID object
            for (String id : listOfIDs) {
            	
                boolean found = false;
                // Search for this ID in the patient array
                for (int i = 0; i < assts.length; i++) {
                    if (assts[i] != null && assts[i].getEntityID().equals(id)) {
                    	firstName = assts[i].getFirstName();
                    	lastName = assts[i].getLastName();
                        assts[i] = null; 
                        found = true;
                        deleted = true;
                        deletedIds +="Successfully Deleted: "+lastName.toUpperCase()+", "+firstName+" ("+id+")\n" ;
                        break;
                    }
                }
                if (!found) {
                    deletedIds += "Entity NOT Found: "+ id + "\n";
                }
            }
            boolean allNull = true;
            for (Individual asst : assts) {
                if (asst != null) {
                	
                    allNull = false;
                    break;
                }
            }
            if (allNull) {
            	System.out.println("allnull is true");
                this.setDentalAsst(new Individual[0]);
            }
            
            if (!deleted) {
                return "Entity not found";
            } 
            else {
                
                int count = 0;
                for (int i = 0; i < assts.length; i++) {
                    if (assts[i] != null) {
                        count++;
                    }
                }

                
                Individual[] resizedA = new Individual[count];
                int index = 0;
                for (int i = 0; i < assts.length; i++) {
                    if (assts[i] != null) {
                        resizedA[index++] = assts[i];
                    }
                }

                
                this.setDentalAsst(resizedA);

                return deletedIds;
            }
    	}
    	else
    		return "";
    }
    
    
    public void updateIndividualCharge(String inStr, int mode) {
    	
        String[] IDandCharge = inStr.split("[,;]");
       
        for (int i = 0; i < IDandCharge.length; i += 2) {
            String entityID = IDandCharge[i].trim();
            double charge = Double.parseDouble(IDandCharge[i + 1].trim());
            boolean found = false;

            for (int j = 0; j < patient.length; j++) {
                if (entityID.equals(patient[j].getEntityID())) {
                    patient[j].setChargePercent(charge);
                    System.out.println(patient[j].toString() + " has been assigned a charge of " + charge + "%");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("There is no patient with ID: " + entityID);
            }
        }
    }
    public void clinicStats(String inStr){
    	if(this.getClinicName()==null||this.getClinicCode()==null||this.getClinicTerm()==null||this.getDentalAsst()==null
    			||this.getDentist()==null||this.getPatient()==null) {
    		System.out.println("Cannot proceed. Make sure to add a clinic name, term, and register patients.");
    		return;
    	}
    	System.out.println("..................................Office/Clinic Statistics........................................................");
    	System.out.println("..................................................................................................................");
    	 System.out.printf(". %-22s: %-50s %n", "Clinic name",this.getClinicName().toUpperCase() );
    	 System.out.printf(". %-22s: %-50s %n", "Clinic Code",this.getClinicCode().toUpperCase() );
    	 System.out.printf(". %-22s: %-50s %n", "Term/Permit",this.getClinicTerm() );
    	 System.out.printf(". %-22s: %-50s %n", "Dentist name","Dr. "+this.getDentist().toString() );
    	for (int i = 0; i < this.getPatient().length; i++) {
    	    
    	    
    	    System.out.printf(". %-20s%-2d: %-50s %n", "Dental Assistant", i+1,this.getDentalAsst()[i].toString() );
    	}
    	System.out.printf(". %-22s: %-50s %n", "Registered patients",this.getPatient().length );
    
    System.out.println("..................................................................................................................");
    System.out.print("\nKindly continue by entering a valid code, from the aformentioned, that corresponds to your task: ");
    	
    	
    }
    
    
	  
}
	  
	  
	  
	  
  

