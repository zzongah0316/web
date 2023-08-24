package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.service.PostService;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet(name="updateController", urlPatterns= {"/post/detail"})
public class UpdateController extends HttpServlet {
    
    private static final Logger log = LoggerFactory.getLogger(UpdateController.class);
	private static final long serialVersionUID = 1L;

	private final PostService postService = PostService.getInstance();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doGet()");		
		
		// 요청 URL의 쿼리스트립에 포함된 요청 파라미터 id(포스트 번호, PK) 값을 찾음.
		long id = Long.parseLong(request.getParameter("id")); 
		// -> getParamter는 문자열만 리턴, id는 숫자 타입이어야 하기 때문에 문자열을 숫자로 변환.
		log.info("id = {}", id);
		
		// DB에서 화면에 보여줄 포스트 내용을 검색
		Post post = postService.selectById(id);
		
		// 뷰(JSP)에 전달.
		request.setAttribute("post", post);
		
		// 뷰로 포워드
		request.getRequestDispatcher("/WEB-INF/post/detail.jsp")
            .forward(request, response);
		
		
		
		
		
		
		
	}
	
	

}
