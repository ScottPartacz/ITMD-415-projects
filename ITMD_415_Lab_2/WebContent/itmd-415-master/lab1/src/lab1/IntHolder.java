package lab1;

/***
 * To allow passing integers by reference.
 * @author henryfbp
 *
 */
public class IntHolder
{
	private Integer value;
	
	public IntHolder()
	{
		this.value = 0;
	}
	
	public IntHolder(int v)
	{
		this.value = v;
	}
	
	public Integer getValue()
	{
		return this.value;
	}
	
	public void setValue(int n)
	{
		this.value = n;
	}
	
	public void increment()
	{
		this.increment(1);
	}
	
	public void increment(int n)
	{
		this.value += n;
	}
	
	public void decrement()
	{
		this.decrement(1);
	}
	
	public void decrement(int n)
	{
		this.value -= n;
	}
	
	public String toString()
	{
		return String.valueOf(this.getValue());
	}
}
