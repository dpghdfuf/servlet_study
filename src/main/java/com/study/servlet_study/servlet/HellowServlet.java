package com.study.servlet_study.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
// java17부터는 자카르타로 시작 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet_study.utils.ParamsConverter;

@WebServlet("/hello")
public class HellowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*                      
		// doGet은 오버라이드된 메서드인데 
		// 웹은 무조건 요청(request)과 응답(response)이 있다. -> 웹은 이 개념부터 잡아야한다.
		System.out.println(request.getMethod()); //get은 가져오겠다 // 메서드
		// <URL vs URI>
		System.out.println(request.getRequestURL()); //URL: 경로를 다 가져온다.
		System.out.println(request.getRequestURI()); //URI: 서버 주소 떼고 가져온다.
		System.out.println(response.getStatus()); // 정상적인 요청이 들어왔을 경우 응답을 해준다.
		System.out.println(response.getContentType()); // 응답된 데이터가 없다??
		// 클라이언트가 요청을 날리면 톰캣에 서블릿리퀘스트랑 리스폰스 생성해서 톰캣이 hello -> 이후로 필기 못함
		// get요청인 doGet 응답프로그램 찾다가 없으면 404 표시한다. // 톰캣이 리퀘스트랑 리스폰스 만들어서 들고온다?? 그 중간에 필터를 만든다.
		// 필터를 걸러내는 것을 만들 예정 -> 전체 경로에 필터를 만들 예정(패키지로)
		
		*/
		Map<String, String>paramsMap = ParamsConverter.convertParamsMapTomap(request.getParameterMap());
		HttpServletRequest httpRequest = (HttpServletRequest) request; // 다운캐스팅 원래 변수명은 httpServeletRequest임
		//HttpServletResponse httpResponse = (HttpServletResponse) response; // 다운캐스팅 원래 변수명은 httpServeletResponse임
		
		System.out.println(httpRequest.getMethod());
		
		String[] methods = new String[] {"POST", "PUT"}; // POST, PUT 요청할 때만 encoding을 해주겠다.
		// 배열 공간 만듬과 동시에 값 대입 //{"post", "put"} 얘를 리스트로 바꿈
		// 대소문자 다 구분하는데 이 경우에는 대문자로 해야한다.
		if(Arrays.asList(methods).contains(httpRequest.getMethod().toUpperCase())) {	// Arrays를 List로~
		// toUpperCase() -> 무조건 대문자로 만들어준다.
		// httpRequest.getMethod()가 POST를 포함하고 있니? 포함하고 있으면 (밑에 구문)에 인코딩을 해주겠다.
			httpRequest.setCharacterEncoding("utf-8");
		
		
		
		
		response.setContentType("text/plain"); //

		System.out.println(response.getContentType());
		
		response.getWriter().println("헬로"); // 응답을 줄때 사용되어지는 코드이다.
		
		System.out.println("요청이 들어옴!!!");
	}
	}
}
// 새로 고침을 할 때마다 웹 클라이언트는 새로 요청을 보낸다.