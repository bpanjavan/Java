package exceptionsPackage;

import java.io.IOException;

/*
 * All exceptions inherit from Throwable
 * 
 * Checked Exceptions:
 * 	Declared with the method signiture
 *  you (the caller) HAS to deal with it by putting it in try block or declare method can throw it
 *  
 */

public class ExceptionsMain {

	public static void ThrowExceptionIfNegative(int myNumber) throws IllegalArgumentException
	{
		if (myNumber < 0)
		{
			throw new IllegalArgumentException("Illegal Argument: " + myNumber);
		}
	}
	
}
