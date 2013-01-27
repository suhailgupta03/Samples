//SERVLET-B

package FromTheClient;

import Database.GetFileNames;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author suhail
 */
public class SendNamesIfShared extends HttpServlet {

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
        String ip = request.getParameter("IP");
        GetFileNames gfn = new GetFileNames();
        boolean hasShared = gfn.hasShared(ip);
        if(hasShared) {
            // Send the name of the files this IP has shared
            ArrayList<String> list = gfn.list();
            
            Gson gson = new Gson();
            gson.toJson(list, response.getWriter());
        }else {
            // Send a message that this IP hasn't shared a file yet
            String msg = "Oops ! This IP hasn't shared a file yet.";
            ArrayList<String> message = new ArrayList<String>();
            message.add(msg);
            Gson gson = new Gson();
            gson.toJson(message,response.getWriter());
        }
        
    }
}
