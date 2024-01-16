package com.study.servlet_study.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*") // 모든 경로에서 이 필터를 거쳐라.
public class ResponseCharactorEncodingFilter extends HttpFilter implements Filter {

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 전처리 과정이다.
		HttpServletRequest httpRequest = (HttpServletRequest) request; // 다운캐스팅 원래 변수명은 httpServeletRequest임
		HttpServletResponse httpResponse = (HttpServletResponse) response; // 다운캐스팅 원래 변수명은 httpServeletResponse임
		
		httpResponse.setCharacterEncoding("utf-8"); // 
		
		// 전처리 영역
		chain.doFilter(request, response);  // doGet으로~ // 다음 필터가 없으니 최종필터인 hello의 ~.request, response의 주소로 간다.
		// 후처리 영역
		//httpResponse.getWriter().println("무조건 후처리함");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

//톰캣은 request와 response 객체를 만들어서 doFilter 으로 들어와서 처음에는 http으로 들어오지만 업캐스팅해서 http관련된 것 없이
//ServletRequest request으로 오지만 (자식이 부모를 생성해서 업캐스팅한 것을 다운 캐스팅이 되니까. 반대의 경우는 X.) http
