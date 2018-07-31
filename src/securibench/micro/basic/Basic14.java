/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic14.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
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
 *  @servlet description="use the servlet context and casts" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic14 extends BasicTestCase2 implements MicroTestCase {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        for(Enumeration e = new StringTokenizer(""); e.hasMoreElements(); ) {
            String s  = (String) e.nextElement();
            PrintWriter writer = resp.getWriter();  
            writer.println(s);                      /* BAD */
        }           
    }
    
    public String getDescription() {
        return "use the servlet context and casts";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}