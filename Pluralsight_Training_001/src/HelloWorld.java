import testPackage.TestClass;
import Inheritance.IMachine;
import Inheritance.Machine;
import Inheritance.Printer;
import Recursion.Reverser;
import exceptionsPackage.ExceptionsMain;
import generics.NameTag;

// Test Update on 2011.01.02 @ 1210pm
public class HelloWorld {

	public static void main(String[] args)
	{
		System.out.println("Frag Out!");
		ExceptionsMain.ThrowExceptionIfNegative(-1);

//		try
//		{
//			ExceptionsMain.ThrowExceptionIfNegative(-1);			
//		}
//		catch(IllegalArgumentException ex)
//		{
//			System.out.println(ex.getMessage());
//		}
//		catch(Exception ex)
//		{
//			// more general exception
//		}
//		finally
//		{
//			System.out.println("Finally Block Executed");
//		}
	}

	private static void Test_006_Generics()
	{
		NameTag<TestClass> myNameTag1 = new NameTag<TestClass>(new TestClass());
		myNameTag1.PrintName();
		//NameTag<int> myNameTag = new NameTag<int>(56);	// can't use primitive types as generics
		NameTag<Integer> myNameTag2 = new NameTag<Integer>(new Integer(56));	
		myNameTag2.PrintName();
		
		//static generic method
		NameTag.PrintNameStatic(new Integer(42)); // auto-inferred type
		
		// Bounded Generic
		// NameTag.PrintNameStatic_MachineOnly(new Integer(54));	// won't compile
		NameTag.PrintNameStatic_MachineOnly(new Printer(true));

		// Wildcard
		PrintNameofMachineTag(new NameTag(new Printer(true)));
		PrintNameofMachineTag(new NameTag(new Integer(65)));	// interesting, NOT caught @ compile time
		
		// Erasure -- Generics are NOT real!!  ONLY the compiler uses generics, they're NOT in the byte code
		// This SUCKS because you can't check the generic type at runtime
		// so at runtime, it translates them all to type: Object
		
	}
	
	private static void PrintNameofMachineTag(NameTag<? extends IMachine> myNameTag)
	{
			myNameTag.getMyMember().TurnOn();	// compiles because it knows it's of type IMachine
			myNameTag.PrintName();
	}
	
	private static void Test_005_Block()
	{
		{
			// I can declare a block out of the blue
			int blockVariable = 5;
			System.out.println("Block Variable: " + blockVariable);
		}
		
		int blockVariable = 10;
		System.out.println("Block Variable: " + blockVariable);

		TestClass t = new TestClass();
		
	}
	
	private static void Test_004_Inheritance()
	{
		Machine m = new Machine(true);
		m = new Printer(true);
		m.TurnOn();
		
	}
	
	private static void Test_003_Switch()
	{
		String myString = "Suiteup";

		/*
		switch(myString) // can NOT switch on string on java version under 1.7
		{
			case "Nova":
				break;
			case "Ark":
				break;
		}
		*/
	}
	
	private static void Test_002()
	{
		System.out.println(Reverser.ReverseString("RaceCar"));
	}
	
	private static void Test_001()
	{
		System.out.println("Frag Out!");
		TestClass.LogInfo("main method exiting");		
		
	}

	
}







