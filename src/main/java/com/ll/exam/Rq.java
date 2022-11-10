package com.ll.exam;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Rq {
	private final HttpServletRequest req;
	private final HttpServletResponse resp;

	public Rq(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;

		try {
			req.setCharacterEncoding("UTF-8"); // 들어오는 데이터를 UTF-8 로 해석하겠다.
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		resp.setCharacterEncoding("UTF-8"); // 완성되는 HTML의 인코딩을 UTF-로 하겠다.
		resp.setContentType("text/html; charset=utf-8"); // 브라우저에게 우리가 만든 결과물이 UTF-8 이다 라고 알리는 의미
	}

	public int getIntParam(String paramName, int defaultValue) {
		String value = req.getParameter(paramName);

		if (value == null) {
			return defaultValue;
		}

		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public void appendBody(String str) {
		try {
			resp.getWriter().append(str);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}