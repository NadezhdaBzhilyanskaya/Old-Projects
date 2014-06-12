import java.util.Scanner;


public class Tester {
	
	
	public static void main(String[]args)
	{
		Scanner kb= new Scanner(System.in);
		System.out.println("\t\t\tTower of Hanoi\n");
		System.out.print("How tall would you like your tower to be (preferably 3-8): ");   //Limited by memory
		int size = kb.nextInt();
		System.out.println();

		Hanoi test=new Hanoi(size);
		test.solveIntitaler();
	}

}
