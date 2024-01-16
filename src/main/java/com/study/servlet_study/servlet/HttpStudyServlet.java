package com.study.servlet_study.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/http")
public class HttpStudyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HttpStudyServlet() { // 생성자
        super();
    }  
    // HTTP 메소드
    // Post 요청 -> C reate 추가 ex) 회원가입, (예외적으로)로그인(로그인 된 사용자가 추가됐다고 생각하기)
    // Get 요청 -> R ead 조회 ex) 로그인 아니다!!(약속)
    // Put 요청 -> U pdate 수정 
    // Delete 요청 -> D elete 삭제 저장된 데이터 삭제
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 현재 request에 있는 파일이다. request를 할 때도 encoding 해줘야하는데 Post요청은 encoding해줘야한다.
    	//request.setCharacterEncoding("utf-8"); 
    	
    	Map<String, String> paramsMap = new HashMap<>(); 
    	
    	request.getParameterMap().forEach((k, v) -> { // forEach를 k에 value는 배열 중 하나
    		
    		//String[] valueArray = v;  // 
    		StringBuilder builder = new StringBuilder(); // 잘려있는 문자열을 합칠 때
    		Arrays.asList(v).forEach(value -> builder.append(value)); // 스태틱 리스트를 Arrays리스트로 바꿔준다. List<String>
    		// v는 String 배열. 어떤 배열이든 List배열 가능. forEach써서 
    		paramsMap.put(k, builder.toString());  // String과 String으로 바꿔준다.
    		
    		// name, String배열 // 배열을 리스트로 만들어서 합칠 예정
    		// builder.toString()를 통해 문자열로 변환. // 여기까지 getParameterMap을 사용한 것이다.
		}); 
    	
    	System.out.println(paramsMap); // 방법1
    	
    	System.out.println(request.getParameter("name")); // 방법2
    	
    	Map<String, String> paramsMap2 = new HashMap<>();
    	Iterator<String> ir = request.getParameterNames().asIterator(); //이걸 활용해서 parameter value를 이용하거나 반복을 돌려서 하는 방법도 있다.
    	while(ir.hasNext()) {
    		String key = ir.next();    // key값을 뺀다.
    		paramsMap2.put(key, request.getParameter(key));
    	}
    }
    	
    	/* ?
    	String nameParams = request.getParameter("name"); // request -> 요청시에 모두 문자열이다.
		String phoneParams = request.getParameter("phone"); // 하나씩 꺼내야 하고 키값을 제시하지 않으면 안된다.
		String emailParams = request.getParameter("email");
		String addressParams = request.getParameter("address");
		
		System.out.println(nameParams); // Hong-ryul
		System.out.println(phoneParams);
		System.out.println(emailParams);
		System.out.println(addressParams);
		*/
		
    

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}

	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
