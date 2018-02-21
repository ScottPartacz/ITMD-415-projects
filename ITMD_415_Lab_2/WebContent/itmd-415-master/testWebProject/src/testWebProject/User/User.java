package testWebProject.User;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User implements Serializable
{

	private static final long serialVersionUID = 1635601937986452018L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;

	private String name;
	private String email;
	private String password;
	private long dob;

	
	protected User()
	{
		uid = -1;
		name = "Default_Person";
		email = "default@goggles.ru";
		password = "wordpass";
		dob = -1L;
	}
	
	protected User(int u, String n, String e, String p, long d)
	{
		uid = u;
		name = n;
		email = e;
		password = p;
		dob = d;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "user_id")
	protected int getUid()
	{
		return uid;
	}

	protected void setUid(int p)
	{
		uid = p;
	}

	protected String getName()
	{
		return name;
	}

	protected void setName(String n)
	{
		name = n;
	}

	protected String getEmail()
	{
		return email;
	}

	protected void setEmail(String e)
	{
		email = e;
	}

	protected String getPassword()
	{
		return password;
	}

	protected void setPassword(String p)
	{
		password = p;
	}

	protected long getDob()
	{
		return dob;
	}

	protected void setDob(long d)
	{
		dob = d;
	}

	@Override
	public String toString()
	{
		return String.format("%d: [%-10s : %-15s] <%-25s> '%d'", getUid(), getName(), getPassword(), getEmail(), getDob());
	}

}
