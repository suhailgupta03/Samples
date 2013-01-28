// SERVLET-A



import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 *
 * @author suhail
 */
public class GetFileNamesIfShared extends HttpServlet {

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = new String(request.getRequestURL()); 
        // Of the form http://localhost:8084/D_Nappster/NewServlet
        String ip = url.substring(url.indexOf("//") + 2 ,url.lastIndexOf(":"));
        try {
            //URI uri = new URI("http",null,ServerIP.IP,ServerPort.port,"/" + Constants.AddressInformation.urlToCheckIfFileIsShared,"IP=" + ip,null);
        	
        	URI uri = new URI("http",null,"127.0.0.1",8080,"/" + "test/servletB","IP=" + ip,null);
        	
            URL sUrl = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) sUrl.openConnection();
            if(connection.getResponseCode() == 200) {
                System.out.println("*****Inside the if statement****");
                Gson gson = new Gson();
                ArrayList<String> list = gson.fromJson(new InputStreamReader(connection.getInputStream()),ArrayList.class);
                System.out.println("LIST---------------------->" + list); // PRINTS NULL FOR THE USER THAT HAS SHARED A FILE !
                request.setAttribute("ListOfFilesShared",list);
                RequestDispatcher rd = request.getRequestDispatcher("FilesShared.jsp");
                rd.forward(request, response);
            }else {
                System.out.println("Inside the else statement");
                // Error : Unable to send the parameters
                System.out.println("Error : Unable to send the parameters for file to download");
            }
        }catch(Exception exc) {
            exc.printStackTrace();
        }
    }
}
