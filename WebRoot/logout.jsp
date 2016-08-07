<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%
session.invalidate();
%>

<c:redirect url="/homepage.action" />


