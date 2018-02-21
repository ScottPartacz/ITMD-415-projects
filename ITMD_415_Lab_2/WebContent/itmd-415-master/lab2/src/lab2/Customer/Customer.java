package lab2.Customer;
import lab2.State.State;

public class Customer
{
    public static final int nameI = 0;
    public static final int SSNI = 1;
    public static final int zipI = 2;
    public static final int emailI = 3;
    public static final int addressI = 4;
    public static final int cityI = 5;
    public static final int stateI = 6;
    
	private String name;
	private String SSN;
	private String zip;
	private String email;
	private String address;
	private String city;
	private State state;

	public Customer(String name, String ssn, String zip, String email, String address, String city, State state)
	{
		this.name = name;
		this.SSN = ssn;
		this.zip = zip;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
	}
	
	/***
	 * Get a {@link Customer} object in the form of a 2-d array.
	 */
	public String[][] getFields()
	{
        String[] fieldNames =       {"name", "SSN", "zip", "email", "address", "city", "state"};
        String[] fields =           { name,   SSN,   zip,   email,   address,   city,   this.state.getState_id().toString()};
        String[] humanReadable =    { name,   SSN,   zip,   email,   address,   city,   this.state.toHumanString()};
        
        return new String[][] {fieldNames, fields, humanReadable};
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSSN()
	{
		return SSN;
	}

	public void setSSN(String sSN)
	{
		SSN = sSN;
	}

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}
	
	public String getHumanState()
	{
	    return state.toHumanString();
	}
}
