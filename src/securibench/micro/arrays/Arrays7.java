/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Arrays7.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package securibench.micro.arrays;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import securibench.micro.BasicTestCase;
import securibench.micro.MicroTestCase;

/** 
 *  @servlet description = "test of array initializers" 
 *  @servlet vuln_count = "1" 
 *  */
public class Arrays7 extends BasicTestCase implements MicroTestCase {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name"); //source high
        String[] array = new String[] {name, "abc"};
        
        PrintWriter writer = resp.getWriter();
        writer.println(array[0]);         /* BAD */ //sink low
    }
    
    public String getDescription() {
        return "test of array initializers";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
    
    public static void main(String[] args) {
		Arrays7 a = new Arrays7();
		try {
			a.doGet(null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}