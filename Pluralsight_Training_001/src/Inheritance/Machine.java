package Inheritance;

public class Machine implements IMachine
{

	private boolean _isOn;
	
	public Machine(boolean isOn)
	{
		this._isOn = isOn;
	}
	
	public  void TurnOn()
	{
		this._isOn = true;
	}
	
	public void TurnOff()
	{
		this._isOn = false;
	}
	
	
}
