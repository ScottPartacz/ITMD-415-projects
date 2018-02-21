package lab2.State;

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

public class StateManager
{
    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;

    public StateManager()
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
     * Code to save a {@link State}.
     */
    public int create(State st)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;
        Integer stateID = null;

        try
        {
            t = s.beginTransaction();
            stateID = (Integer) s.save(st);
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

        return stateID;

    }

    // code to get a State
    public State read(int stateID)
    {
        Session s = sessionFactory.openSession();

        State st = s.get(State.class, stateID);

        s.close();

        return st;
    }

    /***
     * Return ALL States.
     */
    @SuppressWarnings("unchecked")
    public List<State> readAll()
    {
        Session s = sessionFactory.openSession();

        ArrayList<State> l = (ArrayList<State>) s.createCriteria(State.class).list();

        s.close();
        return l;
    }

    // code to modify a State
    public void update(int stateID, State updatedState)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;

        try
        {
            t = s.beginTransaction();
            State st = (State) s.get(State.class, stateID);

            st.deepCopy(updatedState); // copy all things
            st.setState_id(stateID); // but retain the stateID

            s.update(st);
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

    // code to remove a State
    public void delete(int stateID)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;

        try // attempt to delete
        {
            t = s.beginTransaction();

            State st = (State) s.get(State.class, stateID);
            s.delete(st);
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
        System.out.println(StateManager.class.getName() + " main().");

        StateManager manager = new StateManager();
        
        ArrayList<State> states = (ArrayList<State>) manager.readAll();
        
        for(State st : states)
        {
            System.out.println(st.toString());
        }

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
