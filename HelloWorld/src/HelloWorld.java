import testPackage.TestClass;



public class HelloWorld {

	public static void main(String[] args)
	{
		System.out.println("Frag Out!");

		{
			// I can declare a block out of the blue
			int blockVariable = 5;
			System.out.println("Block Variable: " + blockVariable);
		}
		
		int blockVariable = 10;
		System.out.println("Block Variable: " + blockVariable);

		TestClass t = new TestClass();
		
	}
	
}
