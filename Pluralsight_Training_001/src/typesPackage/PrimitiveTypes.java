package typesPackage;

public class PrimitiveTypes {

	public static void main(String[] args)
	{
		
		byte underByte = -128;		// From -128 to 127	1 byte
		byte overByte = -128;		// From -128 to 127	1 byte (8 bits)
		
		short underShort = -32768; 	// 16 bits
		short overShort = 32767;	

		int underInt = -2147483648;		// 32 bits, -2,147,483,648
		int overInt = 2147483647;		// 32 bits, -2,147,483,648

		long underLong = -9223372036854775808L; // 64 bit
		
		//float	// 32 bit
		//double	// 64 bit decimal
		
		//boolean // ??
		//char	// ??
		
		
		System.out.println(underInt);
	}
	

}
