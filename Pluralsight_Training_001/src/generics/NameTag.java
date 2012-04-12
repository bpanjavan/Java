/**
 * 
 */
package generics;

import Inheritance.IMachine;

/**
 * @author bpanjavan
 *
 */
public class NameTag<T>
{
	private T _myMember;
	
	public NameTag(T myMember)
	{
		this._myMember = myMember;
	}

	public T getMyMember()
	{
		return this._myMember;
	}
	
	public void PrintName()
	{
		System.out.println("Hello, my name is " + _myMember.toString()
							+ " and I am a " + _myMember.getClass().toString());
	}
	
	public static <U> void PrintNameStatic(U memberToPrint)
	{
		System.out.println("Hello, my name is " + memberToPrint.toString()
							+ " and I am a " + memberToPrint.getClass().toString());
	}

	public static <U extends IMachine> void PrintNameStatic_MachineOnly(U memberToPrint)
	{
		memberToPrint.TurnOn();	// This WILL compile since it's a machine		
		System.out.println("Hello, my name is " + memberToPrint.toString()
							+ " and I am a " + memberToPrint.getClass().toString());
	}
		
}































