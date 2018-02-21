package lab2.State;

import java.util.ArrayList;

import lab2.lib;

public class StateFormHandler
{
    /***
     * Generates an HTML string from the list of all {@link State} objects.
     */
    public static String generateOptions()
    {
        String ret = "";
        
        StateManager sm = new StateManager();
        
        ArrayList<State> states = (ArrayList<State>) sm.readAll();
        
        
        for(State s : states)
        {
            String abbr = s.getAbbreviation();
            String name = s.getName();
            Integer id = s.getState_id();
                    
            ret += lib.wrapAttr(abbr + " - " + name, "value", id.toString(), "option");
            ret += "\n";
        }
        
        return ret;
    }
}