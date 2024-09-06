public class Individual {
	//objects of the class Individual
    private String entityID;

    private String firstName;

    private String lastName;

    private double chargePercent;


  //getter
    public String getEntityID() {

        return entityID;

    }


  //getter
    public String getFirstName() {

        return firstName;

    }



    //getter
    public String getLastName() {

        return lastName;

    }


  //getter
    public double getChargePercent() {

        return chargePercent;

    }


//setter
    public void setEntityID(String inEntityID) {

        this.entityID = inEntityID;

    }
  //setter
    public void setFirstName(String inFirstName) {

        this.firstName = inFirstName;

    }
  //setter
    public void setLastName(String inLastName) {

        this.lastName = inLastName;

    }
  //setter
    public void setChargePercent(double inChargePercent) {

        this.chargePercent = inChargePercent;

    }

    public Individual() {}

    public Individual(String inEntityId, String inFirstName, String inLastName) {
    	this.entityID = inEntityId;
    	this.firstName=inFirstName;
    	this.lastName=inLastName;
    	
    	
    }

    public Individual(Individual objIndividual) {
    	this.entityID = objIndividual.entityID;
        this.firstName = objIndividual.firstName;
        this.lastName = objIndividual.lastName;
        this.chargePercent = objIndividual.chargePercent;
    	
    }

    public boolean equals(Individual anotherIndividual){
        if(anotherIndividual==null)
            return false;

        if(this.entityID.equals(anotherIndividual.entityID))
            return true;

        return false;

    }

    @Override

    public String toString() {
    	//returns WILLIAM, Bob (1234567)
        return lastName.toUpperCase()+", "+upperCamelCase(firstName)+" "+" ("+entityID+") ";

    }
   public String upperCamelCase(String inStr) {
	   inStr = inStr.trim();
	   return inStr.substring(0,1)+inStr.substring(1);
   }
   
   public String multiUpperCamelCase(String inStr) {
	   String[] wordList = inStr.split(" ");
	   String result = "";
	   for(String word : wordList) {
		   result += upperCamelCase(word)+" ";
	   }
	   return result.trim();
   }
   
   public String upperCase(String inStr)
   {
	   return inStr.toUpperCase().trim();
   }
   

    public static Individual[] inStrToIndividualArr(String inStr)

    {
    	//array of strings split after each , and ;
        String[] dentalAsst = inStr.split("[,;]");
        //initializes array of individuals
        Individual[] individuals = new Individual[dentalAsst.length];

        int index=0;
        //Sets ID name and last name for each assistant and stores it into people
        for(int i=0;i<dentalAsst.length; i=i+3) {

            String id = dentalAsst[i].trim();

            String firstName = dentalAsst[i+1].trim();

            String lastName = dentalAsst[i+2].trim();

            

            individuals[index++]=new Individual(id,firstName,lastName);
        }
        //returns array of individuals
        return individuals;
    }

}