package testWebProject.User;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class UserManager
{
	private static final String tableS = "user";
	private static final String nameS = "name";

	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	public UserManager()
	{
		this.setup();
	}

	/***
	 * Load Hibernate Session factory.
	 */
	public void setup()
	{
		// configures settings from hibernate.cfg.xml
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

		try
		{
			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}

	// code to close Hibernate Session factory
	public void stop() throws Exception
	{
		sessionFactory.close();
	}

	/***
	 * Code to save a {@link User}.
	 */
	public int create(User u)
	{
		Session s = sessionFactory.openSession();
		Transaction t = null;
		Integer uid = null;

		try
		{
			t = s.beginTransaction();
			uid = (Integer) s.save(u);
			t.commit();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			if (t != null)
			{
				t.rollback();
			}
		}
		finally
		{
			s.close();
		}

		return uid;

	}
	
	public User read(String uname)
	{
		Session s = sessionFactory.openSession();
		
		s.close();
		
		return null;
	}

	// code to get a User
	public User read(int uid)
	{
		Session s = sessionFactory.openSession();

		User u = s.get(User.class, uid);

		s.close();

		return u;
	}

	/***
	 * Return ALL Users.
	 */
	public List<User> readAll()
	{
		Session s = sessionFactory.openSession();

		ArrayList<User> l = (ArrayList<User>) s.createCriteria(User.class).list();

		s.close();
		return l;
	}

	// code to modify a User
	public void update(int uId, User updatedUser)
	{
		Session s = sessionFactory.openSession();
		Transaction t = null;

		try
		{
			t = s.beginTransaction();
			User u = (User) s.get(User.class, uId);

			u.setUid(uId); // but retain the uId

			s.update(u);
			t.commit();
		}
		catch (HibernateException e)
		{
			if (t != null)
			{
				t.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			s.close();
		}
	}

	// code to remove a User
	public void delete(int uId)
	{
		Session s = sessionFactory.openSession();
		Transaction t = null;

		try // attempt to delete
		{
			t = s.beginTransaction();

			User u = (User) s.get(User.class, uId);
			s.delete(u);
			t.commit();
		}
		catch (HibernateException e)
		{
			if (t != null)
			{
				t.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			s.close();
		}
	}

	/***
	 * Tells you if a {@link User} with {@code username} exists and has
	 * {@code password} as their password.
	 */
	public boolean userCredsValid(String username, String password)
	{

		Session s = sessionFactory.openSession();
		Transaction t = null;

		try
		{
			t = s.beginTransaction();

			// query to get all users with 'username'.
			String queryS = "FROM " + tableS + " U WHERE " + tableS + "." + nameS + " = " + username;

			Query q = s.createQuery(queryS);

			List results = q.list();
		}
		catch (HibernateException e)
		{
			if (t != null)
			{
				t.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			s.close();
		}

		return false;
	}
	
	/***
	 * Tells you if a user with {@code username} exists.
	 */
	public boolean userExists(String username)
	{
			
		
		return false;
	}

	// code to run the program
	public static void main(String[] args)
	{
		System.out.println(UserManager.class.getName() + " main().");

		UserManager manager = new UserManager();

		manager.setup();

//		manager.create(new User(0, "Henry", "HenryFBP@gmail.com", "iamapassword", (new Date(1997, 8, 1).getTime())));

		
		List allUsers = manager.readAll();
		
		for(int i = 0; i < allUsers.size(); i++)
		{
			System.out.println(allUsers.get(i).toString());
		}
		
		try
		{
			manager.stop();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
