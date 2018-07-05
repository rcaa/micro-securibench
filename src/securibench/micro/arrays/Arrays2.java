/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Arrays2.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package securibench.micro.arrays;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import securibench.micro.BasicTestCase;
import securibench.micro.MicroTestCase;

/** 
 *  @servlet description = "a more complex array test" 
 *  @servlet vuln_count = "1" 
 *  */
public class Arrays2 extends BasicTestCase implements MicroTestCase {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String s1 = req.getParameter("name"); //source high
        String[] array = new String[10];
        array[0] = s1;
        
        PrintWriter writer = resp.getWriter();
        writer.println(array[0]);         /* BAD */ //sink low
        writer.println(array[1]);         /* OK */ //sink low
        writer.println(array[2]);         /* OK */ //sink low 
    }
    
    public String getDescription() {
        return "a more complex array test";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
    
    public static void main(String[] args) {
		Arrays2 a = new Arrays2();
		try {
			a.doGet(null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}