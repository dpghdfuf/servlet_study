package com.study.servlet_study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet_study.entity.Account;
import com.study.servlet_study.entity.Product;
import com.study.servlet_study.service.ProductService;



@WebServlet("/product")
public class ProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	
	public ProductServlet() {
		super();
		productService = ProductService.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String productName = request.getParameter("productName");
		
		Product product = productService.getProduct(productName);
		response.setStatus(200);
		response.getWriter().println(product);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String productName = request.getParameter("productName");
		String price = request.getParameter("price");
		String size = request.getParameter("size");
		String color = request.getParameter("color");
		*/
		int price = 0;
		try {
			price = Integer.parseInt(request.getParameter("price"));
		} catch (NumberFormatException e) {
			response.setStatus(400);  // 응답이 바로 일어나면 된댜.
			response.getWriter().println("숫자만 입력해야 합니다.");
			return;
		}
		
		Product product = Product.builder()
				.productName(request.getParameter("productName"))
				.price(Integer.parseInt(request.getParameter("price")))
				.size(request.getParameter("size"))
				.color(request.getParameter("color"))
				.build();
		
		if(productService.getProduct(product.getProductName()) != null) {
			response.setStatus(400);  // 응답이 바로 일어나면 된댜.
			response.getWriter().println("이미 등록된 상품입니다..");
			return;
		}
		
		productService.addProduct(product);
		response.setStatus(201);
		response.getWriter().println("상품 등록이 완료되었습니다.");
		
		// 이제 앞으로는 json 형태로 응답을 해줄 예정이다.
	}
	// 만약 POST 요청시 동일한 상품명이 이미 등록되어 있으면 400코드로 응답 
	// body 데이터는 0으로 출력
	
	

}
