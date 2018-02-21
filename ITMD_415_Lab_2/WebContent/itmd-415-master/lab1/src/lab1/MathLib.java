package lab1;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class MathLib
{
	/***
	 * @return A random, valid String that can be turned into a {@link Statement} object.
	 * Example: gQ() -> "23.13 ** 7.3"
	 */
	public static String generateQuery()
	{
		return (MathLib.generateNumber() + MathLib.generateOperator() + MathLib.generateNumber());
	}
	
	/***
	 * @return A valid, random String that can be used as a {@link Statement}'s operator.
	 */
	public static String generateOperator()
	{
		Random random = new Random();

		int choice = random.nextInt(MathE.VALID_OPS.length - 1); // 0 to max length
		
		return MathE.VALID_OPS[choice];
	}
	
	/***
	 * @return A valid, random double from 0 to 100 that
	 * can be used as one of a {@link Statement}'s two operands.
	 */
	public static double generateNumber()
	{
		Random random = new Random();
		
		double n = random.nextDouble();
		
		return random.nextDouble() * 100.0;
	}
	
	/***
	 * @param o The string operator (+-/*%).
	 * @return A {@link Function} that takes two numbers in an {@link ArrayList} and
	 *         applies the operator that matches with it.
	 */
	public static Function<ArrayList<Double>, Double> operator(String o)
	{
		if(HLib.contains(o, MathE.DIVIDEF.s()))
		{
			return (n) -> Math.floor(n.get(0) / n.get(1));
		}
		else if(HLib.contains(o, MathE.POW.s()))
		{
			return (n) -> Math.pow(n.get(0), n.get(1));
		}
		else if(HLib.contains(o, MathE.PLUS.s()))
		{
			return (n) -> n.get(0) + n.get(1);
		}
		else if(HLib.contains(o, MathE.MINUS.s()))
		{
			return (n) -> n.get(0) - n.get(1);
		}
		else if(HLib.contains(o, MathE.TIMES.s()))
		{
			return (n) -> n.get(0) * n.get(1);
		}
		else if(HLib.contains(o, MathE.DIVIDE.s()))
		{
			return (n) -> n.get(0) / n.get(1);
		}
		else if(HLib.contains(o, MathE.MODULO.s()))
		{
			return (n) -> n.get(0) % n.get(1);
		}
		return null;
	}
}
