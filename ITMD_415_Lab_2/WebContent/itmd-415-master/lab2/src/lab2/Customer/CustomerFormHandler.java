package lab2.Customer;

import javax.servlet.http.HttpServletRequest;

import lab2.Validation;
import lab2.lib;
import lab2.State.State;
import lab2.State.StateManager;

/***
 * @author Jarron Bailey - Came up with this cool idea. Thanks dude! I'm gonna
 *         use this programming pattern in the future.
 */

public class CustomerFormHandler
{
    /***
     * Turns a request object into a Customer. Does not check validity.
     * 
     * @param request The HTTP request.
     * @return A {@code Customer}.
     */
    public static Customer handleForm(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String ssn = request.getParameter("ssn");
        String zip = request.getParameter("zip");
        String email = request.getParameter("email");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        int stateID = Integer.parseInt(request.getParameter("state"));

        StateManager sm = new StateManager();
        
        State state = sm.read(stateID);
        
        return new Customer(name, ssn, zip, email, street, city, state);
    }

    /***
     * Turn a Customer object into an HTML string that tells you what you did right
     * or wrong.
     */
    public static String displayValidity(Customer c)
    {
        String ret = "";

        String[][] data = c.getFields();

        for(int i = 0; i < data[0].length; i++)
        {
            String field = data[0][i];
            String value = data[1][i];
            String humanValue = data[2][i];
            
            String fieldCap = lib.capitalizeFirst(field);

            System.out.printf("Looking at %dth field, %s = %s\n", i, fieldCap, value);
            Boolean valid = Validation.thingIsValid(data[1][i], i);

            String oneField = ""; // name: "hi" VALID

            String validModifier = "valid"; //#invalid or just nothing
            
            oneField += lib.wrapClassID(fieldCap, "a", "field", null);
            oneField += lib.wrapClassID(humanValue, "a", "value "+field, null);
            oneField += "\n";
            
            if(!valid)
            {
              validModifier = "invalid";
            }
            
            ret += lib.wrapClassID(oneField, "li", validModifier, null);
        }

        ret = lib.wrap(ret, "ul");
        return ret;
    }
}
