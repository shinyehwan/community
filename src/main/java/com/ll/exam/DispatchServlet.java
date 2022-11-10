package com.ll.exam;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Map;

import com.ll.exam.article.ArticleController;
import com.ll.exam.member.MemberController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Rq rq = new Rq(req, resp);

		MemberController memberController = new MemberController();
		ArticleController articleController = new ArticleController();

		String url = req.getRequestURI();

		switch (url) {
			case ("/usr/article/list/free"):
				articleController.showArticle(rq);
			case ("/usr/member/login"):
				memberController.showLogin(rq);
		}
	}




}
