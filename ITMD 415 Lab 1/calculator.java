package test;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static void main(String[] args)
    {
		String math = "-,+,*,/,%,";
		 
		
		double answer = 0;
		
		Scanner scan = new Scanner(System.in);
		
			
		while(true)
		{
			
		System.out.println("Enter expression\n");
		
		String expression = scan.next();
		
		ArrayList<String> componets = new ArrayList<String>();
		
		String[] array = expression.split("[-+/%*]");
		
		for (String temp: array) {
			if(temp.equals("")){continue;}
		    componets.add(temp);
		}
	
		outerloop:
		for(int i = 0; i < expression.length(); i++)
		{
			char temp = expression.charAt(i);
			
			if(!expression.matches("[0-9+-/%*]+") || (expression.matches("[0-9]+") && !expression.matches("[+-/%*]+")) || (!expression.matches("[0-9]+") && expression.matches("[+-/%*]+")) || componets.size() > 2)
			{
				System.out.println("Invaild expression");
				break outerloop;
				
			}
			
			switch(math.indexOf(temp)) 
			{
				case 0:// Subtraction
					answer = Double.parseDouble(componets.get(0)) - Double.parseDouble(componets.get(1));
					break;
				case 2:// Addition
					answer = Double.parseDouble(componets.get(0)) + Double.parseDouble(componets.get(1));
					break;
				case 4:// Multiplication
					answer = Double.parseDouble(componets.get(0)) * Double.parseDouble(componets.get(1));
					break;
				case 6:// Division
					if(expression.charAt(++i) == '/') // Floor Division 
					{
						answer = Math.floor(Double.parseDouble(componets.get(0)) / Double.parseDouble(componets.get(1)));
					}
					else
					{
						answer = Double.parseDouble(componets.get(0)) / Double.parseDouble(componets.get(1));
					}
					
					break;
				case 8:// Modulo
					answer = Double.parseDouble(componets.get(0)) % Double.parseDouble(componets.get(1));
					break;
				default:
					if(expression.equalsIgnoreCase("exit"))
					{
						System.exit(0);
					}
					break;
			}
		
		}
		    System.out.println("");
			System.out.println(expression + " = " + answer);
		}
		
    }
		

}
