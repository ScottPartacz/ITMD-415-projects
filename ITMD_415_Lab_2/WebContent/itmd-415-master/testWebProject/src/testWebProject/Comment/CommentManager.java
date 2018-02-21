package testWebProject.Comment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class CommentManager
{
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	public CommentManager()
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
		catch(Exception e)
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
	 * Code to save a {@link Comment}.
	 */
	public int create(Comment c)
	{
		Session s = sessionFactory.openSession();
		Transaction t = null;
		Integer cID = null;

		try
		{
			t = s.beginTransaction();
			cID = (Integer) s.save(c);
			t.commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			if(t != null)
			{
				t.rollback();
			}
		}
		finally
		{
			s.close();
		}

		return cID;

	}

	// code to get a comment
	public Comment read(int cID)
	{
		Session s = sessionFactory.openSession();

		Comment c = s.get(Comment.class, cID);

		s.close();

		return c;
	}

	/***
	 * Return ALL comments.
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> readAll()
	{
		Session s = sessionFactory.openSession();

		ArrayList<Comment> l = (ArrayList<Comment>) s.createCriteria(Comment.class).list();

		s.close();
		return l;
	}

	// code to modify a comment
	public void update(int cID, Comment updatedComment)
	{
		Session s = sessionFactory.openSession();
		Transaction t = null;

		try
		{
			t = s.beginTransaction();
			Comment c = (Comment) s.get(Comment.class, cID);

			c.deepCopy(updatedComment); // copy all things
			c.setCid(cID); // but retain the cID

			s.update(c);
			t.commit();
		}
		catch(HibernateException e)
		{
			if(t != null)
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

	// code to remove a comment
	public void delete(int cID)
	{
		Session s = sessionFactory.openSession();
		Transaction t = null;

		try // attempt to delete
		{
			t = s.beginTransaction();

			Comment c = (Comment) s.get(Comment.class, cID);
			s.delete(c);
			t.commit();
		}
		catch(HibernateException e)
		{
			if(t != null)
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

	// code to run the program
	public static void main(String[] args)
	{
		System.out.println(CommentManager.class.getName() + " main().");

		CommentManager manager = new CommentManager();

		manager.setup();

		try
		{
			manager.stop();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
