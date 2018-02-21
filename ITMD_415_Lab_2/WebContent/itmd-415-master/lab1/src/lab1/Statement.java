package lab1;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statement
{
	public double opA;
	public double opB;
	public String op;
	private Double result = null;

	private static Pattern RX_Op = Pattern.compile(MathE.RX_ONLY_OP.s());

	/***
	 * @param o Operator o.
	 * @param oa Operand a.
	 * @param ob Operand b.
	 */
	public Statement(String o, double oa, double ob)
	{
		this.op = o;
		this.opA = oa;
		this.opB = ob;
	}

	/***
	 * @param s The String representing a math statement.
	 */
	public Statement(String s1)
	{
		String s = s1.replaceAll(MathE.RX_WSPACE.s(), "");

		// System.out.printf("Stripped string = '%s'.\n",s);

		Matcher m = this.RX_Op.matcher(s);
		m.find();

		String[] nums = s.split(MathE.RX_ONLY_OP.s()); // get numbers around an op

		String o = m.group(0);

		this.op = o;
		this.opA = Double.parseDouble(nums[0]);
		this.opB = Double.parseDouble(nums[1]);

	}

	/**
	 * @return The numerical value that executing this {@link Statement} object
	 *         would yield.
	 */
	public double result()
	{
		if(this.result == null)
		{
			Function<ArrayList<Double>, Double> f = MathLib.operator(this.op);
	
			ArrayList<Double> operands = new ArrayList<>();
	
			operands.add(this.opA);
			operands.add(this.opB);
			
			this.result = f.apply(operands);
		}

		return this.result;
	}

	@Override
	public String toString()
	{
		String ret = "";

		ret += String.format("[%6.2f %3s %6.2f] = [%6.2f]", this.opA, this.op, this.opB, this.result());

		return ret;
	}
}
