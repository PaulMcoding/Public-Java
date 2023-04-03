package Assignment;

import java.io.*;

public class Probability {
	String input_data, input_data2, input_data3;
	String[] column_num;
	int total_lines = 0;
	
	//Priors (or all normal data)
	int gender, parent, job, location, business;
	double genderP, parentP, jobP, locationP, businessP;
	double initial_guess_e, initial_guess_n, forEtrepeneur, AgainstEtrepeneur;
	
	//variables for if the student is an etrepeneur (e prefix) (P suffix for Probability)
	int eGender; // 0 = female, 1 = male
	int eParent; // 1 = business owner, 0 = not
	int eJob; // 1 = has job, 0 = doesnt
	int eRural, eUrban; // 1 = Rural, 0 = urban
	int eBusiness; // 1 = studies business, 0 = doesnt
	int eEtrepeneur; // 1 = became etrepeneur, 0 = didnt
	double eGenderP, eParentP, eJobP, eRuralP, eUrbanP, eBusinessP, eEtrepeneurP;
	double etrepeneur_probability, evidence;
	
	//Variables for if the student is not (n prefix) (P suffix for Probability)
	int nGender, nParent, nJob, nRural, nUrban, nBusiness; 
	int nNotEtrepeneur; //in this case it counts people who arent etrepeneurs
	double nGenderP, nParentP, nJobP, nUrbanP, nRuralP, nBusinessP, nEtrepeneurP;
	double normal_probability;
	
	//user input values
	double etre, netre;
	
	//Constructor to send in the CSV file
	public Probability(String input_data)
	{
		this.input_data = input_data;
		this.input_data2 = input_data;
		this.input_data3 = input_data;
	}
	
	//Run all the data and get values
	public void readData() throws FileNotFoundException
	{
		BufferedReader read_data = new BufferedReader(new FileReader(input_data)); 
			try 
			{
				while((input_data = read_data.readLine()) != null )
				{
					column_num = input_data.split(",");
					
					if(column_num[0].equals("Female")||column_num[0].equals("Male"))
					{
						total_lines++;
					}
					if(column_num[5].equals("Yes"))
					{
						eEtrepeneur++;
						
						if(column_num[0].equals("Male"))
						{
							eGender++;
						}
						if(column_num[1].equals("Yes"))
						{
							eParent++;
						}
						if(column_num[2].equals("Yes"))
						{
							eJob++;
						}
						if(column_num[3].equals("Rural"))
						{
							eRural++;
						}
						if(column_num[4].equals("Yes"))
						{
							eBusiness++;
						}
					}
					else if(column_num[5].equals("No"))
					{
						nNotEtrepeneur++;
						
						if(column_num[0].equals("Male"))
						{
							nGender++;
						}
						if(column_num[1].equals("Yes"))
						{
							nParent++;
						}
						if(column_num[2].equals("Yes"))
						{
							nJob++;
						}
						if(column_num[3].equals("Rural"))
						{
							nRural++;
						}
						if(column_num[4].equals("Yes"))
						{
							nBusiness++;
						}
					}
				}
				read_data.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			runCalculations();
	}
	
	public void runCalculations()
	{
		//Getting all prior data
		gender = eGender+nGender;
		parent = eParent+nParent;
		job = eJob+nJob;
		location = eRural+nRural+eUrban+nUrban;
		business = eBusiness+nBusiness;
		nUrban = nNotEtrepeneur - nRural;
		eUrban = eEtrepeneur - eRural;
		initial_guess_e = (double)eEtrepeneur / (eEtrepeneur+nNotEtrepeneur);
		initial_guess_n = (double)nNotEtrepeneur / (eEtrepeneur+nNotEtrepeneur);
		
		//Calculating general Probabilities for each column
		genderP = (double)gender / total_lines;
		parentP = (double)parent / total_lines;
		jobP = (double)job / total_lines;
		locationP = (double)location / total_lines;
		businessP = (double)business / total_lines;
		
		//Calculating Etrepeneur Probabilities for each column
		eGenderP = (double)eGender / eEtrepeneur;
		eParentP = (double)eParent / eEtrepeneur;
		eJobP = (double)eJob / eEtrepeneur;
		eRuralP = (double)eRural / eEtrepeneur;
		eUrbanP = (double)eUrban / eEtrepeneur;
		eBusinessP = (double)eBusiness / eEtrepeneur;
		
		//Calculating Normal Probabilities for each column
		nGenderP = (double)nGender / nNotEtrepeneur;
		nParentP = (double)nParent / nNotEtrepeneur;
		nJobP = (double)nJob / nNotEtrepeneur;
		nRuralP = (double)nRural / nNotEtrepeneur;
		nUrbanP = (double)nUrban / nNotEtrepeneur;
		nBusinessP = (double)nBusiness / nNotEtrepeneur;

		evidence = (double)genderP*parentP*jobP*locationP*businessP;
		forEtrepeneur = eGenderP*eParentP*eJobP*eRuralP*eBusinessP*initial_guess_e;
		AgainstEtrepeneur = nGenderP*nParentP*nJobP*nRuralP*nBusinessP*initial_guess_n;
		
//		System.out.println("Etrepeneur Probability: " +forEtrepeneur);
//		System.out.println("Not Probability: "+ AgainstEtrepeneur);
//		System.out.println("Etrepeneurs: " + eEtrepeneur);
//		System.out.println("not: "+nNotEtrepeneur);
//		System.out.println(eRural+nRural);
		
//		System.out.println(nGender);
//		System.out.println(nParent);
//		System.out.println(nJob);
//		System.out.println(nBusiness);
//		System.out.println((double)(eEtrepeneur - eGender)/eEtrepeneur);
//		System.out.println(initial_guess_n);
	}

	public void user_values(String gender, String pEtre, String part_time, String studies, String Area, int chc)
	{
		if(chc == 1)
		{
			runCalculations();
		}
		else
		{}
		double e_g, e_p, e_part, e_b, e_a;
		
		if(gender.equals("Female"))
		{
			e_g = eGenderP;
		}
		else
		{
			e_g = 1-eGenderP;
		}
		
		if(pEtre.equals("Yes"))
		{
			e_p = eParentP;
		}
		else
		{
			e_p = 1-eParentP;
		}
		
		if(part_time.equals("Yes"))
		{
			e_part = eJobP;
		}
		else
		{
			e_part = 1-eJobP;
		}
		
		if(studies.equals("Yes"))
		{
			e_b = eBusinessP;
		}
		else
		{
			e_b = 1-eBusinessP;
		}
		
		if(Area.equals("Rural"))
		{
			e_a = eRuralP;
		}
		else
		{
			e_a = 1-eRuralP;
		}
		
		etre = e_g*e_p*e_part*e_b*e_a*initial_guess_e;
		
		
		System.out.println(etre);
		
		if(etre<forEtrepeneur) 
		{
			System.out.print("Not etrepeneur");;
		}
		else
		{
			System.out.print("Etrepeneur");;
		}
		System.out.print("\n\n");;
	}
	
	public void Testing() throws FileNotFoundException
	{
		int in_lines = 0;
		double local_lines = total_lines * 0.7;
		String[] in_dataset, in_dataset2;
		int correct = 0;
		int incorrect = 0;
		
		BufferedReader read_data2 = new BufferedReader(new FileReader(input_data2)); 
		try 
		{
				while((input_data = read_data2.readLine()) != null )
				{
					if(in_lines < local_lines)
					{
						in_dataset = input_data.split(",");
						
						if(in_dataset[0].equals("Female")||column_num[0].equals("Male"))
						{
							in_lines++;
						}
						if(in_dataset[5].equals("Yes"))
						{
							eEtrepeneur++;
							
							if(in_dataset[0].equals("Male"))
							{
								eGender++;
							}
							if(in_dataset[1].equals("Yes"))
							{
								eParent++;
							}
							if(in_dataset[2].equals("Yes"))
							{
								eJob++;
							}
							if(in_dataset[3].equals("Rural"))
							{
								eRural++;
							}
							if(in_dataset[4].equals("Yes"))
							{
								eBusiness++;
							}
						}
						else if(in_dataset[5].equals("No"))
						{
							nNotEtrepeneur++;
							
							if(in_dataset[0].equals("Male"))
							{
								nGender++;
							}
							if(in_dataset[1].equals("Yes"))
							{
								nParent++;
							}
							if(in_dataset[2].equals("Yes"))
							{
								nJob++;
							}
							if(in_dataset[3].equals("Rural"))
							{
								nRural++;
							}
							if(in_dataset[4].equals("Yes"))
							{
								nBusiness++;
							}
						}
					}
				}
			read_data2.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		runCalculations();
		System.out.println(forEtrepeneur + " " + AgainstEtrepeneur + "\n\n");
		
		int test_amount = total_lines - in_lines;
		BufferedReader read_data3 = new BufferedReader(new FileReader(input_data3)); 
		try 
		{
				while((input_data = read_data3.readLine()) != null )
				{
					in_dataset2 = input_data.split(",");
					
					if(in_lines < total_lines)
					{
						user_values(in_dataset2[0], in_dataset2[1], in_dataset2[2], in_dataset2[3], in_dataset2[4], 0);
						in_lines++;
						
						if(etre < forEtrepeneur)
						{
							if(in_dataset2[5].equals("No")) 
							{
								correct++;
							}
							else
							{
								incorrect++;
							}
						}
						else if(etre > forEtrepeneur)
						{
							if(in_dataset2[5].equals("Yes")) 
							{
								correct++;
							}
							else
							{
								incorrect++;
							}
						}
					}
				}
				
			read_data2.close();
			double accuracy = (double)correct/test_amount;
			accuracy = accuracy * 100;
			System.out.println("Accuracy score: " + accuracy + "%");
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		runCalculations();
	}
	
	public double getForEtrepeneur() {
		return forEtrepeneur;
	}

	public double getAgainstEtrepeneur() {
		return AgainstEtrepeneur;
	}
	
	
	
}
