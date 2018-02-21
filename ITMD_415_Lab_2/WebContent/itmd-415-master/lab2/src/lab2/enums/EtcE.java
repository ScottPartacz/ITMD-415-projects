package lab2.enums;

/***
 * Misc enum.
 */
public enum EtcE
{
	/*** Formats like this:<br>10 September 2016 05:31:02 PM ***/
	DATEF_HUMAN		("dd MMMM yyyy hh:mm:ss a"),
	;
	

	private Object constants;

	private EtcE(String s)
	{
		this.constants = s;
	}

	private EtcE(Character c)
	{
		this.constants = c;
	}

	private EtcE(int i)
	{
		this.constants = i;
	}

	@Override
	public String toString()
	{
		return (String) this.constants;
	}

	public char toChar()
	{
		return (Character) this.constants;
	}

	public int toInt()
	{
		return (Integer) this.constants;
	}

	public String s()
	{
		return this.toString();
	}

	public char c()
	{
		return this.toChar();
	}

	public int i()
	{
		return this.toInt();
	}
}
