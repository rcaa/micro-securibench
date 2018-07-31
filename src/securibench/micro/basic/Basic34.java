/**
   @author Benjamin Livshits <livshits@cs.stanford.edu>
   
   $Id: Basic34.java,v 1.2 2006/04/04 20:00:40 livshits Exp $
 */
package securibench.micro.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import securibench.micro.BasicTestCase;
import securibench.micro.MicroTestCase;

/**
 * @servlet description="values obtained from headers"
 * @servlet vuln_count = "2"
 */
public class Basic34 extends BasicTestCase implements MicroTestCase {
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Enumeration e = req.getHeaderNames(); //source high
        while(e.hasMoreElements()) {
            String headerName = (String) e.nextElement();
            String headerValue = (String) req.getHeader(headerName);
         
            PrintWriter writer = resp.getWriter();
            // I believe arbitrary header names can be forged
            // TODO: double-check this
            writer.println(headerName);                       /* BAD */ //sink low
            writer.println(headerValue);                      /* BAD */ //sink low
        }        
    }

    public String getDescription() {
        return "values obtained from headers";
    }

    public int getVulnerabilityCount() {
        return 2;
    }
    
    public static void main(String[] args) {
		Basic34 b = new Basic34();
		try {
			b.doGet(null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}