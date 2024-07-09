package com.example.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.util.DBUtil;

//@WebServlet("/postdetail")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		
		String no 		= request.getParameter("no");
		Post post 		= null;

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM posts WHERE no = ?")) {
			stmt.setInt(1, Integer.parseInt(no));
			
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					post = new Post();
					post.setNo(rs.getInt("no"));
					post.setTitle(rs.getString("title"));
					post.setId(rs.getString("id"));
					post.setDate(rs.getString("date"));
					
					System.out.println("rs.getInt(\"no\") = " + rs.getInt("no"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("post", post);
		request.getRequestDispatcher("/WEB-JSP/postdetail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		
		String method = request.getParameter("_method");
		if ("DELETE".equals(method)) {
			doDelete(request, response);
		} else {
			updatePost(request, response);
		}
	}
	
	private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String no = request.getParameter("no");
        String title = request.getParameter("title");
        String id = request.getParameter("id");
        String date = request.getParameter("date");

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE posts SET title = ?, id = ?, date = ? WHERE no = ?")) {
            stmt.setString(1, title);
            stmt.setString(2, id);
            stmt.setString(3, date);
            stmt.setInt(4, Integer.parseInt(no));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String no = request.getParameter("no");

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM posts WHERE no = ?")) {
            stmt.setInt(1, Integer.parseInt(no));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/");
    }
}
