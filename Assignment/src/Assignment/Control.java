package Assignment;

import java.io.FileNotFoundException;

public class Control {

	public static void main(String[] args) {
		
		Probability paul = new Probability("/Users/paul/Documents/GitHub/College-Work-Java/Assignment/src/Assignment/MLdata.csv");
		try {
			paul.readData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		double NetP = paul.getAgainstEtrepeneur();
		double etP = paul.getForEtrepeneur();
		
		paul.user_values("Male", "Yes", "Yes", "Yes", "Rural", 1);
		try {
			paul.Testing();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Peanis");
			e.printStackTrace();
		}
		try {
		paul.Testing();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("Peanis");
		e.printStackTrace();
	}
		
		GUI gorp = new GUI("GORP", etP, NetP);
	}

}
