package com.ll.jspproject.member;

import com.ll.jspproject.Rq;

public class MemberController {
    public void showLogin(Rq rq) {
        rq.appendBody("로그인");
    }
}