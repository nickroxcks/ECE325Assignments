/**
 * Assignment 2: Java regular expressions <br />
 * Test cookies using regular expressions
 */
//Nicholas Serrano ECE 325 Assignment 2
import java.util.regex.*;

public class CookieTest {

    /**
     * Verify a cookie and return the verification result
     * @param cookie        {@code String}  The cookie string
     * @return              {@code boolean} True for a legal cookie; false for an illegal one
     */
    public static boolean verifyCookie(String cookie) {
        boolean legal = false;
        // TODO: Assignment 2 -- compose your regular expression, and use it to verify the cookie
        
        //continuing
        
        String httponlyav = "HttpOnly";
        String secureav = "Secure";
        String pathvalue = "[^;\\u0000\\u0007\\u0008\\n\\v\\f\\r\\u001B]";  //semi-colen and CTL's
        String pathav = "Path=" + pathvalue;
        
        //Domain stuff:
       
        String ldhstr = "(([A-Za-z0-9])|(\\-))|" + "(((([A-Za-z0-9])|(\\-))" + ")*)";
        String label = "[A-Za-z]" + "((" + ldhstr + ")*" + "[A-Za-z0-9]" + ")*";
        String subdomain = "(" + label + ")|((" + "." + label + ")*)";
        String domainvalue = "(" + subdomain + ")*" + "(." + subdomain + ")*";
        
        //other stuff
        String domainav = "Domain=" + domainvalue;
        String maxageav = "Max-Age=" + "[1-9]" + "[0-9]*";
        String month = "(Jan)*(Feb)*(Mar)*(Apr)*(May)*(Jun)*(Jul)*(Aug)*(Sep)*(Oct)*(Nov)*(Dec)*";
        String wkday = "(Mon)*(Tue)*(Wed)*(Thu)*(Fri)*(Sat)*(Sun)*";
        String time = "[0-9]{2}:[0-9]{2}:[0-9]{2}";
        String date1 = "[0-9]{2} " + month + " [0-9]{4}";
        
        String rfc1123date = wkday + ", " + date1 + " " + time + " GMT"; 
        String expiresav = "Expires=" + rfc1123date;
        String cookieav = "(" + expiresav + ")*" + "(" + maxageav + ")*" + "(" + domainav + ")*"
        		+ "(" + pathav + ")*" + "(" + secureav + ")*" + "(" + httponlyav + ")*";
        		
        String cookieoctet = "([!#$%&'()*+\\-./a-zA-Z0-9:<=>\\?@\\[\\]`\\^_{\\|}~])*";
        String cookievalue = "(" + cookieoctet + ")*" + "(" + "\"" + cookieoctet + "\"" + ")*";
        
        //cookie name contains seperators and CTL that cannot be in the name
        String cookiename = "[^\\\\()<>@,;:\"/\\[\\]\\?={} \\t\\u0000\\u0007\\u0008\\n\\v\\f\\r\\u001B]+";
        String cookiepair = cookiename + "=" + cookievalue;
        String setcookiestring = cookiepair + "(" + "; " + cookieav + ")*";
        String setcookieheader = "Set-Cookie:" + " " + setcookiestring;
        
        Pattern start = Pattern.compile(setcookieheader);
        
        Matcher m = start.matcher(cookie);  
 
        if(m.matches()) {
        	
        	legal = true;
        }
        
        return legal;
    }

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        String [] cookies = {
            // Legal cookies:
            "Set-Cookie: ns1=\"alss/0.foobar^\"",                                           // 01 name=value
            "Set-Cookie: ns1=",                                                             // 02 empty value
            "Set-Cookie: ns1=\"alss/0.foobar^\"; Expires=Tue, 18 Nov 2008 16:35:39 GMT",    // 03 Expires=time_stamp
            "Set-Cookie: ns1=; Domain=",                                                    // 04 empty domain
            "Set-Cookie: ns1=; Domain=.srv.a.com-0",                                        // 05 Domain=host_name
            "Set-Cookie: lu=Rg3v; Expires=Tue, 18 Nov 2008 16:35:39 GMT; Path=/; Domain=.example.com; HttpOnly", // 06
            // Illegal cookies:
            "Set-Cookie:",                                              // 07 empty cookie-pair
            "Set-Cookie: sd",                                           // 08 illegal cookie-pair: no "="
            "Set-Cookie: =alss/0.foobar^",                              // 09 illegal cookie-pair: empty name
            "Set-Cookie: ns@1=alss/0.foobar^",                          // 10 illegal cookie-pair: illegal name
            "Set-Cookie: ns1=alss/0.foobar^;",                          // 11 trailing ";"
            "Set-Cookie: ns1=; Expires=Tue 18 Nov 2008 16:35:39 GMT",   // 12 illegal Expires value
            "Set-Cookie: ns1=alss/0.foobar^; Max-Age=01",               // 13 illegal Max-Age: starting 0
            "Set-Cookie: ns1=alss/0.foobar^; Domain=.0com",             // 14 illegal Domain: starting 0
            "Set-Cookie: ns1=alss/0.foobar^; Domain=.com-",             // 15 illegal Domain: trailing non-letter-digit
            "Set-Cookie: ns1=alss/0.foobar^; Path=",                    // 16 illegal Path: empty
            "Set-Cookie: ns1=alss/0.foobar^; httponly",                 // 17 lower case
        };
        for (int i = 0; i < cookies.length; i++)
            System.out.println(String.format("Cookie %2d: %s", i+1, verifyCookie(cookies[i]) ? "Legal" : "Illegal"));
    }

}
