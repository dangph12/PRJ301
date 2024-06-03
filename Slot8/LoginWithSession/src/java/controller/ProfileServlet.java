
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);

        HttpSession session = request.getSession(false);
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            String namec = ck[1].getValue();
            if (!namec.equals("") || namec != null) {
                out.print("<b>Welcome to Profile</b>");
                out.print("<br>Welcome, " + namec + "<br>");
            }
            if (session != null) {
                String names = (String) session.getAttribute("names");
                out.print("Hello, " + names + " Welcome to Profile");
            }
        } else {
            out.print("Please login first");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}
