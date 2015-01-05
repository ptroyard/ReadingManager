
public class Ville {

	String nameTown;
	int nbHabits;
	
	//Constructors 
	public Ville()
	{
		this.nameTown="";
		this.nbHabits=0;
	}
	public Ville(String pNameTown, int pNbHabits) throws NbHabitsException
	{
		if(pNbHabits>0)
		{
			this.nameTown=pNameTown;
			this.nbHabits=pNbHabits;
			System.out.println("Objet créé");
		}
		
		else throw new NbHabitsException("Nombre négatif");
	}
	
	

}
