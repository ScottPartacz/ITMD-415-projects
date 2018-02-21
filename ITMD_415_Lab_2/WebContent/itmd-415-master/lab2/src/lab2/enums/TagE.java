package lab2.enums;

/***
 * Enum for HTML tags.
 */
public enum TagE
{
	TAG_LI		("li"),
	TAG_UL		("ul"),
	TAG_A		("a"),
	TAG_Q		("q"),
	TAG_H1		("h1"),		
	TAG_H2		("h2"),
	TAG_H3		("h3"),
	TAG_H4		("h4"),
	TAG_H5		("h5"),
	TAG_H6		("h6"),
	;

	private Object constants;

	private TagE(String s)
	{
		this.constants = s;
	}

	private TagE(Character c)
	{
		this.constants = c;
	}

	private TagE(int i)
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
