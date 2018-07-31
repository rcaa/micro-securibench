/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id$
 */
package securibench.micro.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import securibench.micro.BasicTestCase2;
import securibench.micro.MicroTestCase;

/** 
 *  @servlet description="use getInitParameterNames" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic42 extends BasicTestCase2 implements MicroTestCase {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {        
        //ServletContext context = getServletConfig().getServletContext();
        Enumeration e = new StringTokenizer("");
        while(e.hasMoreElements()) {
            String name = (String) e.nextElement();
            Object value = e.nextElement(); 
            PrintWriter writer = resp.getWriter();
            writer.println(value.toString());          					 /* BAD */
        }
    }
    
    public String getDescription() {
        return "use getInitParameterNames";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
    
    public static void main(String[] args) {
		Basic42 b = new Basic42();
		try {
			b.doGet(null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}