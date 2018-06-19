/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Aliasing3.java,v 1.1 2006/04/21 17:14:27 livshits Exp $
 */
package securibench.micro.aliasing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import securibench.micro.BasicTestCase;
import securibench.micro.MicroTestCase;

/** 
 *  @servlet description="simple aliasing of an array element" 
 *  @servlet vuln_count = "1" 
 *  */
public class Aliasing3 extends BasicTestCase implements MicroTestCase {
	private static final String FIELD_NAME = "name";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       String name = req.getParameter(FIELD_NAME); //source high
       String[] a = new String[10];
       String str = a[5];
       a[5] = name;
       name = str;
              
       PrintWriter writer = resp.getWriter();
       writer.println(str);                              /* BAD */ //sink low
    }
    
    public String getDescription() {
        return "simple aliasing of an array element";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
    
    public static void main(String[] args) {
		Aliasing3 a = new Aliasing3();
		try {
			a.doGet(null, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}