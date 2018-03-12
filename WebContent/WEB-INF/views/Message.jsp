<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  
    <c:if test="${empty requestScope.message}">
                <h2>模板为空</h2>
    </c:if>
    <c:forEach items="${requestScope.message}" var="item">                  
                <c:out value = "${item.value}" />    
                <c:if test="${null != item.key.messageID}">                    
                    <c:out value = "${item.key}" />                     
                </c:if>   
                <br>
                       
    </c:forEach>    
    <c:forEach items="${requestScope.message}" var="item">                                      
                <c:if test="${':31C:' == item.value}">                    
                    <c:out value = "${item.key.messageID}" />                     
                </c:if>   
                <br>
                       
    </c:forEach>  
    

</body>
</html>