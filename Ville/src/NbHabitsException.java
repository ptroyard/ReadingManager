//Cependant, jamais créer ses propres exception... Galere pour reutilisation. Utiliser les coonues (ici numberformatexception)
// Ainsi ca évite ici d'appeller super, et même de déclarer la classe !!!
public class NbHabitsException extends Exception {

	public NbHabitsException(String pMessage)
	{
		super(pMessage);
	}
}
