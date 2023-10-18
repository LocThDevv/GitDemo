<%-- 
    Document   : logout
    Created on : Jun 30, 2023, 4:07:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cookie[] c = request.getCookies();
    if (c != null) {
        for (Cookie cc : c) {
            if (cc.getName().equals("quantri")) {
                cc.setMaxAge(0);
                cc.setPath("/");
                response.addCookie(cc);
                break;
            }
        }
    }
    HttpSession sessionToInvalidate = request.getSession();
    sessionToInvalidate.invalidate();
    response.sendRedirect("home");
%>
