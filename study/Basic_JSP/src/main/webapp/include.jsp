<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<%-- <%@include file="include/header.jsp" %> <!-- 정적 include 방식 --> --%>
		<jsp:include page="include/header.jsp"></jsp:include> <!--  동적 include 방식 -->
		<div id="container">
			 이곳은 내용이 포함되는 부분입니다.
		</div>
		<%-- <%@include file="include/footer.jsp" %> --%>
		<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>