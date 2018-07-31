/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic13.java,v 1.5 2006/04/04 20:00:40 livshits Exp $
 */
package securibench.micro.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import securibench.micro.BasicTestCase2;
import securibench.micro.MicroTestCase;

/** 
 *  @servlet description="use getInitParameter instead" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic13 extends BasicTestCase2 implements MicroTestCase {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {        
        String s =  new StringTokenizer("").nextToken();
        PrintWriter writer = resp.getWriter();
        writer.println(s);           /* BAD */
    }
    
    public String getDescription() {
        return "use getInitParameterInstead";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
    
    public static void main(String[] args) {
		Basic13 b = new Basic13();
		try {
			b.doGet(null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}