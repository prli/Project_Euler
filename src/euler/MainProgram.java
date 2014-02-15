package euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainProgram{
	
	public static void main(String[] args) throws IOException {
		boolean again = false;
		do{
			int id = getProblemId();
			
			solveProblem(id);
			System.out.println("Another problem? Y/N");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			again = Util.isYes(in.readLine());
		}while(again);
    }


	private static void solveProblem(int id) {
		switch (id){
			case 1 :
				Problem1.Main();
				break;
			case 2 :
				Problem2.Main();
				break;
			case 3 :
				Problem3.Main();
				break;
			case 4 :
				Problem4.Main();
				break;
			case 5 :
				Problem5.Main();
				break;
			case 6 :
				Problem6.Main();
				break;
			default : 
				System.out.println("ID error");
				break;
		}
	}

	private static int getProblemId() throws IOException {
		System.out.println("Enter a valid problem ID: ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String string = in.readLine();
		while(!Util.isInt(string)){
			System.out.println("Enter a valid problem ID: ");
			string = in.readLine();
		}
		return Integer.parseInt(string);
	}
	
}