package lab03;

public class Main {

	public static void main(String[] args) {
		
		Kregielnia k = new Kregielnia();
		
		UserI userInterface = new UserI(k);
		userInterface.show();
		
		k.saveState();
		System.out.println("koniec");
	}

}
