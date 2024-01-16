package com.study.servlet_study.filter;

// request, charactor, enconding
//맵을 만드는 2가지 방법(한 가지 방법이 어려우면 getParameter 쓰기)

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class RequestCharactorEncodingFilter extends HttpFilter implements Filter {
       
    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 전처리 과정이다.
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
		}
		
		
		
		// 전처리 영역
		chain.doFilter(request, response);  // doGet으로~ // 다음 필터가 없으니 최종필터인 hello의 ~.request, response의 주소로 간다.
		// 후처리 영역
		//httpResponse.getWriter().println("무조건 후처리함");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}
}
// 여기서 맵을 만드는 2가지 방법(한 가지 방법이 어려우면 getParameter 쓰기)