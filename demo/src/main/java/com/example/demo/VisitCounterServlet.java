package com.example.demo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

public class VisitCounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        int visitCount = 0;

        // Check if the "visitCount" cookie exists
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    try {
                        visitCount = Integer.parseInt(cookie.getValue());
                        visitCount++; // Increment the visit count
                    } catch (NumberFormatException e) {
                        visitCount = 1; // Reset if invalid value
                    }
                    break;
                }
            }
        } else {
            visitCount = 1; // Initialize if no cookies exist
        }

        // Create or update the "visitCount" cookie
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24 * 30); // Expires in 30 days
        visitCookie.setPath("/"); // Make the cookie available across the entire app
        response.addCookie(visitCookie);

        // Set the response content type
        response.setContentType("text/html");

        // Write the HTML response
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Visit Counter Servlet</title></head><body>");
        out.println("<h2>Welcome to the Visit Counter Servlet</h2>");
        out.println("<p>You have visited this page " + visitCount + " time(s).</p>");
        out.println("</body></html>");
    }
}


// mvn clean install
// mvn spring-boot:run