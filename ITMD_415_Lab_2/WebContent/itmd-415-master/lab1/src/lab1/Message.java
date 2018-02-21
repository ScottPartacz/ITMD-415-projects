package lab1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/***
 * A class that represents a message.<br>
 * 
 * This class was made because the PrintWriter and BufferedReader are both<br>
 * blocking, and to avoid blocking, this class sends object through an
 * ObjectOutputStream.<br>
 * <br>
 * Example:<br>
 * 
 * <pre>
 * <code>
 * Sending AL{"hello","world"} -> {
 * 	pw.printLine("2\r\n");
 * 	pw.printLine("hello\r\n");
 * 	pw.printLine("world\r\n");
 * 	return;
 * }
 * </pre></code>
 *
 */
public class Message implements Cloneable, Serializable
{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> contents;
	public Object result;

	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	public Message()
	{
		contents = new ArrayList<>();
	}
	
	public Message(Object o)
	{
		this.result = o;
	}

	public Message(String s)
	{
		ArrayList<String> a = new ArrayList<>();
		a.add(s);

		this.contents = a;
	}
	
	public Message(ArrayList<String> a, Object o)
	{
		this.add(a);
		this.result = o;
	}

	public Message(ArrayList<String> a)
	{
		for(int i = 0; i < a.size(); i++)
		{
			this.add(a.get(i));
		}
	}

	/***
	 * Sends self as a message to an ObjectOutputStream.<br>
	 * 
	 * @param out
	 */
	public void send(ObjectOutputStream out)
	{
		try
		{
			out.writeObject((Message) this.clone());
			out.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}

	/***
	 * @see {@link Message#send(ObjectOutputStream)}
	 */
	public void send(ObjectOutputStream out, boolean v)
	{
		if(v == true)
		{
			System.out.println("Sending this: ");
			System.out.println(this.toString());
		}

		this.send(out);
	}

	/**
	 * Add a piece to this message.<br>
	 * All newlines will be removed from this message.<br>
	 * 
	 * @param s The piece.
	 */
	public void add(String s)
	{
		contents.add(HLib.sanitize(s));
	}
	
	/***
	 * Like {@link #add(String)} but with String.format().
	 * @param format
	 * @param params
	 */
	public void addF(String format, Object... params)
	{
		contents.add(String.format(format, params));
	}
	
	public void add(ArrayList<String> a)
	{
		for(String s : a)
		{
			contents.add(s);
		}
	}

	/***
	 * Flattens a Message into one long String.
	 * 
	 * @param sep The separator.
	 * @return The flattened Message as a String.
	 */
	public String flatten(String sep)
	{
		String ret = "";

		for(int i = 0; i < this.length(); i++)
		{
			ret += this.get(i);
		}

		return ret;
	}

	public String flatten()
	{
		return this.flatten("\n");
	}

	public String get(int i)
	{
		return contents.get(i);
	}

	public int length()
	{
		return this.contents.size();
	}
	
	public boolean empty()
	{
		return (this.length() == 0 ? true : false);
	}

	public String toString()
	{
		String ret = String.format("Message[%d]: \n", this.length());

		for(int i = 0; i < this.length(); i++)
		{
			ret += String.format(HLib.maxLength(this.length(), "d") + ": %s", i, this.get(i)) + "\n";
		}

		return ret;
	}

	public void toString(OutputStream os)
	{
		toString(os, "\n");
	}

	public void toString(OutputStream os, String sep)
	{
		for(int i = 0; i < this.length(); i++)
		{
			try
			{
				os.write((this.get(i) + sep).getBytes());
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
