package lab1;

public enum MathE
{
	NAMEH("Henry Post"),
	NAMED("Dennis Chase"),
	
	HOST("localhost"),
	PORT(1234),
	
	QUIT		("QUIT"), 	// String that tells us they're done 
	COUNT		("COUNT"), 	// String that asks for a count of connected clients.

	/*** This matches any math operator (*, **, /, //, %, -, +), but not dots (.). ***/
	RX_ONLY_OP	("[^\\s\\d\\.]+"),
	
	/*** This matches spaces and return characters. ***/
	RX_WSPACE 	("[ \r\n]"),
	
	PLUS		("+"),
	MINUS		("-"),
	TIMES		("*"),
	POW			("**"),
	DIVIDE		("/"),
	DIVIDEF		("//"),
	MODULO		("%"),
	;

	private Object constants;
	
	// list of valid operators.
	public static String[] VALID_OPS = { MathE.PLUS.s(), MathE.MINUS.s(), MathE.TIMES.s(),
			MathE.POW.s(), MathE.DIVIDE.s(), MathE.DIVIDEF.s(), MathE.MODULO.s() };

	private MathE(String s)
	{
		this.constants = s;
	}
	
	private MathE(Character c)
	{
		this.constants = c;
	}
	
	private MathE(int i)
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
		return (int) this.constants;
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
