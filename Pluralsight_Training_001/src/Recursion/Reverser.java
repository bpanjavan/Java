package Recursion;

public class Reverser {

	public static String ReverseString(String stringToReverse)
	{
		return (stringToReverse.length() == 0) 
					? stringToReverse 
					: ReverseString(stringToReverse.substring(1)) + stringToReverse.charAt(0);
	}
}
