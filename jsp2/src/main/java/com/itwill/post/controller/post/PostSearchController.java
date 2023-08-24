package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.service.PostService;

@WebServlet(name="postSearchController", urlPatterns = {"/post/search"})
/**
 * Servlet implementation class PostSearchController
 */
public class PostSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(PostSearchController.class);

	private final PostService postService = PostService.getInstance();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		log.info("doGet()");
		
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		
		log.info(category);
		log.info(keyword);
	
//		<option value="t">제목</option>
//        <option value="c">내용</option>
//        <option value="tc">제목 + 내용</option>
//        <option value="a">작성자</option>
		 List<Post> posts = new ArrayList<>();
		if(category.equals("t")) {
		   posts  = postService.searchT(keyword);
		} else if(category.equals("c")) {
		   posts  = postService.searchC(keyword); 
		} else if(category.equals("tc")) {
		   posts  = postService.searchTc(keyword);
		} 
		else if(category.equals("a")) {
		    posts  = postService.searchA(keyword);
		}
		
		
		request.setAttribute("posts", posts);
		
		request.getRequestDispatcher("/WEB-INF/post/post.jsp")
        .forward(request, response);
		}

	
}
