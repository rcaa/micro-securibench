/**
   $Id: BasicTestCase.java,v 1.5 2006/04/21 17:14:24 livshits Exp $
*/
package securibench.micro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BasicTestCase2 {//extends HttpServlet {
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        // do nothing
    }

    protected void doHead(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        // do nothing
    }
    
    protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        // do nothing     
    }
    
    protected void doDelete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        // do nothing        
    }
    
    protected void doPut(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        // do nothing        
    }
    
}