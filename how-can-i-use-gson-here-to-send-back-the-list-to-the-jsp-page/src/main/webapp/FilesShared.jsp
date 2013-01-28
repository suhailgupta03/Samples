<%-- FilesShared.jsp that resides on the same server as Servlet-B --%>

<%-- 
    Document   : FilesShared
    Created on : Jan 23, 2013, 3:55:21 PM
    Author     : user
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Of Files Shared</title>
    </head>
    <body>
        <%! ArrayList<String> list; %>
        
        <% 
            list = (ArrayList<String>)request.getAttribute("ListOfFilesShared"); 
            if(list != null) {
              Iterator iterator = list.iterator();
              while(iterator.hasNext()) {
        %>
        <b><%= iterator.next().toString().trim() %> </b> <br />
        <% } } %> <%-- ecvhebcv --%>
    </body>
</html>
