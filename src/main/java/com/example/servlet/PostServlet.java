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

//@WebServlet("/posts")
public class PostServlet extends HttpServlet {
    private static final int PAGE_SIZE = 10;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        List<Post> posts = new ArrayList<>();
        int totalPosts = 0;

        try (Connection conn = DBUtil.getConnection()) {
            // Get total number of posts
            PreparedStatement countStmt = conn.prepareStatement("SELECT COUNT(*) FROM posts");
            ResultSet countRs = countStmt.executeQuery();
            if (countRs.next()) {
                totalPosts = countRs.getInt(1);
            }

            // Get paginated posts
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM posts LIMIT ? OFFSET ?");
            stmt.setInt(1, PAGE_SIZE);
            stmt.setInt(2, (page - 1) * PAGE_SIZE);
            ResultSet rs = stmt.executeQuery();
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

        int totalPages = (int) Math.ceil(totalPosts / (double) PAGE_SIZE);
        request.setAttribute("posts", posts);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.getRequestDispatcher("/WEB-JSP/postlist.jsp").forward(request, response);
    }
}
