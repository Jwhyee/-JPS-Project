package com.example.likelionfirstproject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Rq{
    private HttpServletResponse resp;
    Rq(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
    }

    public int getIntParam(String command, int num) {
        return 1;
    }

    public void appendBody(String str) throws IOException {
        this.resp.getWriter().append(str);
    }
}
