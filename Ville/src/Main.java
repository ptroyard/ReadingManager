
public class Main {

	public static void main(String[] args)
	{
		try
		{
			Ville v1 = new Ville("Ville1",-1);
		}
		catch(NbHabitsException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Objet non créé");
		}
	}
	
}
