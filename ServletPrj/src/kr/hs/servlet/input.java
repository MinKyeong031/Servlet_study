package kr.hs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class input extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		String result;
		
		if(num%2 == 0) {
			result = "짝수";
		}else {
			result = "홀수";
		}
		
		req.setAttribute("model", result);
		
		//request 영역에 model이란 변수를 반들어서 result값을 대입한다.
		RequestDispatcher dispatcher = req.getRequestDispatcher("input_result.jsp");
		dispatcher.forward(req, resp);
	}
}
