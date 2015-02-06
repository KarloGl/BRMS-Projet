package com.processuscomplexeAssuranceAuto;


import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Person {

    private String name;
    private int age;
    private int salaire; // annuel
    private boolean estEnCouple; // si en couple, +10 points
    private int pts = 0;
    private boolean aUnEmploi;
    private Car car;
  



	public static final void main(String[] args) {
       
            // initialisation de la base de connaissances kieservices pour r�gles
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            //--------------------------------------------------------
            //--------------------------------------------------------
        	// C EST ICI QU ON INITIALISE LA PERSONNE EN LUI DONNANT LES PARAMETRES
        	
        					//type de caisse,s�cu,occase, kilom�trage
        	Car car = new Car(CarType.SMALL, true, true, 150); // son type de voiture
            Person person = new Person("John Café", 23, 38000,false, false, car); 
            						// son nom,   age,salaire,couple,emploi)
            // POINTS MINI 12 POINTS MAX 120 LIMITE 50
            //--------------------------------------------------------
            //--------------------------------------------------------
            
            kSession.insert(person);
            kSession.fireAllRules();
            
            // DIRE SI LA PERSONNE EST ELIGIBLE
            
           if(person.getPts() > 60){
        	   int points = person.getPts();
               System.out.println(points+" points");
               System.out.println("\n-----------------------------------------\n\n"
               		+ "Vous êtes éligible, bienvenue chez nous.");
               points = (140-(points))*8;
               System.out.println("Vous allez payer: "+ points+"€");
           }
           else{ 
        	   System.out.println(person.getPts()+"\nVous n'êtes pas éligible, sortez.");
        	   }
    }
	public Person(String name, int age, int salaire, boolean cple, boolean emploi,Car car){
		this.name = name;
		this.age = age;
		this.salaire  = salaire;
		this.estEnCouple = cple;
		 // plus on a de points, plus on est �ligible � l'assurance. minimum: 60 
		this.aUnEmploi = emploi;
		this.car = car;
		this.pts = 0;
		
	}
 

	public String getName() {
		return name;

     
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getSalaire() {
		return salaire;
	}


	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}


	public boolean isEstEnCouple() {
		return estEnCouple;
	}


	public void setEstEnCouple(boolean estEnCouple) {
		this.estEnCouple = estEnCouple;
	}


    public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	public boolean isaUnEmploi() {
		return aUnEmploi;
	}
	public void setaUnEmploi(boolean aUnEmploi) {
		this.aUnEmploi = aUnEmploi;
	}
	public int getPts() {
		return pts;
	}
	public void setPts(int pts) {
		this.pts = pts;
	
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}


}
