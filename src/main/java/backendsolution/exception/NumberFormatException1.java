package backendsolution.exception;

public class NumberFormatException1 {

	
	public static void main(String argvs[])
	 {
	// Input string
	 String userId = "userId & User" ;
	 try
	 {
	 // converting the input string into an integer
	 int i = Integer.parseInt(userId); // here the exception is raised.
	 System.out.println(i);
	 }
	 catch(NumberFormatException ex)
	 {
	 System.out.println("The input string is inappropriate. Hence, the conversion is not possible.");   
	 }
	 
	}
}
