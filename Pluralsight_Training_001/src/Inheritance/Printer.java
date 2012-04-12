package Inheritance;

public class Printer extends Machine
{

	public Printer(boolean isOn)
	{
		super(isOn);
		// then do something else
	}
	
	@Override
	public void TurnOn()
	{
		super.TurnOn();
		System.out.println("Printer Turned On");
	}
	
}
