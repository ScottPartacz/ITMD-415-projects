package lab2;

import java.util.Scanner;

import lab2.Customer.Customer;
import lab2.State.State;
import lab2.State.StateManager;

public class Validation
{
 
    /***
     * Tells you if the entirety of a customer is valid.
     */
    public static boolean customerIsValid(Customer c)
    {
        return (
                thingIsValid(c.getName(), c.nameI) &&
                thingIsValid(c.getSSN(), c.SSNI) &&
                thingIsValid(c.getZip(), c.zipI) &&
                thingIsValid(c.getEmail(), c.emailI) &&
                thingIsValid(c.getAddress(), c.addressI) &&
                thingIsValid(c.getCity(), c.cityI) &&
                thingIsValid(c.getState().getState_id(), c.stateI));
    }
    
    public static Boolean thingIsValid(Object thing, int place)
    {
        switch(place)
        {
            case Customer.nameI: return nameIsValid((String) thing);
            case Customer.SSNI: return sSecurityIsValid((String) thing);
            case Customer.zipI: return zipIsValid((String) thing);
            case Customer.emailI: return emailIsValid((String) thing);
            case Customer.addressI: return addressIsValid((String) thing);
            case Customer.cityI: return cityIsValid((String) thing);
            case Customer.stateI:

                if(thing instanceof String)
                {
                    thing = (Integer)Integer.parseInt((String)thing);
                }
                
                return stateIsValid((Integer) thing);
        
        }
        return null;
    }

    public static boolean nameIsValid(String name)
    {
        return ((name.length() >= 4) & (name.length() <= 50));
    }// end of nameIsValid

    public static boolean sSecurityIsValid(String ss)
    {
        int nums = 0;

        for(int i = 0; i < ss.length(); i++)
        {
          if(Character.isDigit(ss.charAt(i)))
          {
              nums++;
          }
          
          if(nums >= 11) //at least 11 numbers.
          {
              return true;
          }
          
        }
        return false;
    }// end of sSecurityIsValid

    public static boolean zipIsValid(String zip)
    {
        if(zip.length() != 10)
        {
            return false;
        }

        for(int i = 0; i < zip.length(); i++)
        {
            if(i == 5)
            {
                if(!(zip.charAt(i) == '-'))
                {
                    return false;
                }
            }
            else
            {
                if(!(Character.isDigit(zip.charAt(i))))
                {
                    return false;
                }
            }
        }
        return true;
    }// end of zipIsValid

    public static boolean emailIsValid(String email)
    {
        return email.length() > 7;
    }// end of emailIsValid

    public static boolean addressIsValid(String address)
    {
        return ((address.length() >= 4) & (address.length() <= 50));
    }// end of addressIsValid

    public static boolean cityIsValid(String city)
    {
        return ((city.length() >= 3) & (city.length() <= 50));
    }// end of cityIs Valid

    /***
     * Go through all states, check if ours exists.
     */
    public static boolean stateIsValid(int stateID)
    { //does this state exist?
        StateManager sm = new StateManager();

        try
        {
            State s = sm.read(stateID);
            if(s != null)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return false;
    }
    
    /***
     * To test our {@link Validation} class.
     */
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String in = "";
        boolean valid = false;

        while(true)
        {
            System.out.println("Enter name: ");
            in = s.nextLine();
            valid = nameIsValid(in);

            if(valid)
            {
                break;
            }

            System.out.printf("Name '%s' not valid.\n", in);
        }
        
        while(true)
        {
            System.out.println("Enter Social Security #: ");
            in = s.nextLine();
            valid = sSecurityIsValid(in);

            if(valid)
            {
                break;
            }

            System.out.printf("Social Security # '%s' not valid.\n", in);
        }
        
        while(true)
        {
            System.out.println("Enter Zip Code: ");
            in = s.nextLine();
            valid = zipIsValid(in);

            if(valid)
            {
                break;
            }

            System.out.printf("Name '%s' not valid.\n", in);
        }
        
        while(true)
        {
            System.out.println("Enter Email Address: ");
            in = s.nextLine();
            valid = emailIsValid(in);

            if(valid)
            {
                break;
            }

            System.out.printf("Email Address '%s' not valid.\n", in);
        }
        
        while(true)
        {
            System.out.println("Enter Address: ");
            in = s.nextLine();
            valid = addressIsValid(in);

            if(valid)
            {
                break;
            }

            System.out.printf("Address '%s' not valid.\n", in);
        }
        
        while(true)
        {
            System.out.println("Enter City: ");
            in = s.nextLine();
            valid = cityIsValid(in);

            if(valid)
            {
                break;
            }

            System.out.printf("City '%s' not valid.\n", in);
        }

        s.close();

    }

}// end of class