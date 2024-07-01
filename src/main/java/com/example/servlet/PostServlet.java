package com.example.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.util.DBUtil;

//@WebServlet("/PostServelet")
//@WebServlet("/posts")
public class PostServlet extends HttpServlet {
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> posts = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();	
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM posts");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Post post = new Post();
                post.setNo(rs.getInt("no"));
                post.setTitle(rs.getString("title"));
                post.setId(rs.getString("id"));
                post.setDate(rs.getString("date"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("===== PostServlet.java의 doGet 을 실행합니다. =====");
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("/WEB-JSP/postlist.jsp").forward(request, response);
        // request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    // ===========================================================
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        // response.sendRedirect("PostServlet");
        System.out.println("===== PostServlet.java의 doPost 을 실행합니다. =====");
        response.sendRedirect("/");
    }
}
