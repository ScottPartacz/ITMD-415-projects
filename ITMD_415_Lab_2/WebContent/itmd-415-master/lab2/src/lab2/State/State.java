package lab2.State;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "state")
public class State
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int state_id;

    private String abbreviation;

    private String name;
    

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "state_id")
    public Integer getState_id()
    {
        return state_id;
    }

    public void setState_id(int state_id)
    {
        this.state_id = state_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    /***
     * Copy all attributes from another {@code State} into self.
     * 
     * @param updatedState The other State.
     */
    public void deepCopy(State updatedState)
    {
        this.setState_id(updatedState.getState_id());
        this.setAbbreviation(updatedState.getAbbreviation());
        this.setName(updatedState.getAbbreviation());
        
    }
    
    public String toString()
    {
        return String.format("[%2d]: %4s %s", this.getState_id(), this.getAbbreviation(), this.getName());
    }
    
    /***
     * @return A user-readable string representing this state.
     */
    public String toHumanString()
    {
        return this.getName();
    }

    
}
