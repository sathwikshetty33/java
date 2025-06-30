package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class VisitCounterController {

    @GetMapping("/")
    public String visitCounter(HttpServletRequest request, HttpServletResponse response) {
        int visitCount = 1;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visitCount".equals(cookie.getName())) {
                    try {
                        visitCount = Integer.parseInt(cookie.getValue()) + 1;
                    } catch (NumberFormatException e) {
                        visitCount = 1;
                    }
                    break;
                }
            }
        }

        Cookie newCookie = new Cookie("visitCount", String.valueOf(visitCount));
        newCookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(newCookie);

        return """
            <html>
            <head><title>Visit Counter</title></head>
            <body>
                <h2>Welcome to the Visit Counter (Spring Boot)</h2>
                <p>You have visited this page %d time(s).</p>
            </body>
            </html>
        """.formatted(visitCount);
    }
}