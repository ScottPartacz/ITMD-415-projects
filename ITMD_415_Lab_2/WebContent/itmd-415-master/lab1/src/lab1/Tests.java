package lab1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class Tests
{
	public static void main(String[] args)
	{
		//Tests.testClientConnectivity(100);
		Tests.testClientMassUse(100, 50);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Press enter to quit tests.");
		scan.nextLine();
		
		//Tests.runTests(); // test library funcs

		// localClient();

		//MathLib.generateQuery();
	}

	public static void testStatementMatching(String str)
	{
		Statement statement = new Statement(str);
	
		System.out.println(String.format("'%15s' -> %s", str, statement.toString()));
	}

	public static void testsStatementMatching()
	{
		Tests.testStatementMatching("1 + 1");
		Tests.testStatementMatching("1.3-1.023");
		Tests.testStatementMatching("2 **3.0");
		Tests.testStatementMatching("200.0// 1.5");
		Tests.testStatementMatching("200.0  /  1.5");
	}

	public static void testsMathLib()
	{
		Tests.testMathlib("+", 2.0, 5.5);
		Tests.testMathlib("*", 4.0, 4.0);
		Tests.testMathlib("-", 2.0, 5.5);
		Tests.testMathlib("/", 2.0, 5.5);
		Tests.testMathlib("//", 101.0, 5.0);
		Tests.testMathlib("/", 101.0, 5.0);
	}

	/***
	 * Pretend to be a CLI client that can ask the 'math server' (not a server here)
	 * some math. Used to test the statement parser.
	 */
	public static void localClient()
	{
		String in = "";
		Scanner s = new Scanner(System.in);

		System.out.println("(Q) will quit.");
		while(in.compareToIgnoreCase("Q") != 0)
		{
			System.out.print("Enter statement to be parsed by MathOTron9000: \n > ");
			in = s.nextLine();

			testStatementMatching(in);
		}
	}

	public static void runTests()
	{
		System.out.println("MATH FUNCTION TEST:");
		Tests.testsMathLib();
		System.out.println();

		System.out.println("STATEMENT PARSING TEST:");
		Tests.testsStatementMatching();
		System.out.println();
	}

	/***
	 * Tests {@link #lab1.MathLib}'s function-parsing capabilities.
	 */
	public static void testMathlib(String op, double x, double y)
	{

		Function<ArrayList<Double>, Double> f = MathLib.operator(op);

		ArrayList<Double> ops = new ArrayList<>();

		ops.add(x);
		ops.add(y);

		double b = f.apply(ops);

		System.out.println(String.format("%.2f %s %.2f = %.2f", ops.get(0), op, ops.get(1), b));
	}

	/***
	 * Tests if we can make n connections. Does not query for math.
	 * @param n Number of connections to make.
	 */
	public static void testClientConnectivity(int n)
	{
		ArrayList<MathClient> threads = new ArrayList<MathClient>();
		for(int i = 0; i < n; i++)
		{
			threads.add(new MathClient(MathE.HOST.s(), MathE.PORT.i()));
		}//fills the array list with all asked for clients
	}

	/***
	 * Connects 'clients' worth of clients to the server, who will ask 'ops' number of random Statements before terminating.
	 * @param clients How many clients to create.
	 * @param ops How many questions each client will ask before terminating.
	 */
	public static void testClientMassUse(int clients, int ops)
	{
		ArrayList<Thread> clientList = new ArrayList<Thread>();

		// generate clients
		for(int i = 0; i < clients; i++)
		{
			clientList.add(new MathClient(MathE.HOST.s(), MathE.PORT.i()));
		}

		// ask n questions for each client, then quit, serially. (not actually all at once :'( that must be done with runnable/more threading.)
		for(int i = 0; i < clientList.size(); i++)
		{
			MathClient client = (MathClient) clientList.get(i);
			
			// client n asks k
			for(int k = 0; k < ops; k++)
			{
				client.calculate(MathLib.generateQuery());
			}

			try
			{
				client.quit(); // client n quits after asking is done
			}
			catch(IOException e)
			{
				System.out.println("Can't quit! I quit at quitting!");
				e.printStackTrace();
			} 
		}

	}
}
