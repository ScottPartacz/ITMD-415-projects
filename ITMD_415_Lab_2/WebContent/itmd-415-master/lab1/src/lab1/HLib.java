package lab1;

public class HLib
{
	/***
	 * Remove all newlines from the String s.
	 * @param s The input String.
	 * @return A newline-stripped string.
	 */
	public static String sanitize(String s)
	{
		return s.replaceAll("[\r\n]", "");
	}
	/***
	 * Searches the string 'haystack' for the string 'needle'.
	 * 
	 * @param haystack The string to be searched for needle.
	 * @param needle
	 * @return If the String needle is in the String haystack.
	 */
	public static boolean contains(String haystack, String needle)
	{
		if(haystack.compareTo(needle) == 0)
		{
			return true;
		}

		return false;
	}

	/***
	 * 
	 * @param in Input string.<br>
	 * @param quit Marker that tells you when to quit<br>
	 * @return Whether or not the input string wants to quit.<br>
	 *         Example: <code>sC("i wanna quit","quit") -> True</code>
	 */
	public static boolean shouldContinue(String in, String quit)
	{
		if(contains(in, quit))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * @see {@link HLib#shouldContinue(String, String)}
	 */
	public static boolean shouldContinue(String in, char q)
	{
		return shouldContinue(in, String.valueOf(q));
	}
	
	/***
	 * Prepares a format specifier to display a number of a specific length.
	 * @param length The max length that the number could take on.
	 * @param base The numerical base that we should use.<br>Normally, this is ten (10).
	 * @param specifier The specifier (d, f, i, s) to be used.
	 * @return The format specifier plus a number of spacing, i.e. "%3d".<br>
	 * <br>
	 * Example:
	 * <pre>
	 * <code>
	 * mL(323, 10, "d") -> "%3d"
	 * That call would be used if you want to print a list that is represented as follows:
	 * 
	 * list[0]: 	{"some data 0"}
	 * list[1]: 	{"some data 1"}
	 * (...)
	 * list[323]: 	{"some data 323"}
	 * 
	 * as this:
	 * 
	 * [0  ]: some data 0
	 * [1  ]: some data 0
	 * (...)
	 * [323]: some data 0
	 * 
	 * because the function would return "%3d"! Yay!
	 * </pre>
	 * </code>
	 * 
	 */
	public static String maxLength(int length, int base, String specifier)
	{
		if(length < 0)
		{
			length = 1;
		}
		
		int spaces = (int) Math.ceil((double)length / (double)base);

		return "%" + spaces + specifier;
	}
	
	/**
	 * @see #maxLength(int, int, String)
	 */
	public static String maxLength(int length, String specifier)
	{
		return maxLength(length, 10, specifier);
	}

}
