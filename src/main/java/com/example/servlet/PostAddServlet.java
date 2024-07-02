package com.example.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.util.DBUtil;

// @WebServlet("/postadd")
public class PostAddServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===== PostAddServlet.java의 doGet 을 실행합니다. =====");
        request.getRequestDispatcher("/WEB-JSP/postadd.jsp").forward(request, response);
    }
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===== PostAddServlet.java의 doPost 을 실행합니다. =====");
		
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String id = request.getParameter("id");
        String date = request.getParameter("date");

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO posts (title, id, date) VALUES (?, ?, ?)")) {
            stmt.setString(1, title);
            stmt.setString(2, id);
            stmt.setString(3, date);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/");
        // response.sendRedirect("/posts");
    }
}
