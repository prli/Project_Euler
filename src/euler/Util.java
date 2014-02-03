package euler;

public class Util{

	final static String YES = "yes";
	final static String NO = "no";
	
	public static boolean isInt(String stringInput) {
		try{
			Integer.parseInt(stringInput);
			return true;
		}catch(NumberFormatException  e){
			return false;
		}
	}

	public static boolean isYes(String string) {
		if(string.equalsIgnoreCase("Y") || string.equalsIgnoreCase(YES)){
			return true;
		}else{
			return false;
		}
	}
}