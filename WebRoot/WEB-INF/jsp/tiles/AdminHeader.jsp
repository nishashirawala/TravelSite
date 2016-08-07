<%@ taglib uri="/struts-tags" prefix="s"%>
<div id="header">
	<div class="login">
		<s:form id="loginForm" action="login" theme="simple" method="post">
			<div class="links" style="float: right">
				Welcome
				<%= session.getAttribute("name") %>
				| <a href="logout.jsp">Logout</a>
			</div>
		</s:form>
	</div>
	<ul id="menu" style="margin-top: 30px;">
		<li><a href="homepage.action">Home page</a></li>
		<li><a href="showToursInfo.action">Tours</a></li>
		<li><a href="ShowTourDestinations.action">Destinations</a></li>
		<li><a href="showHotelsInfo.action">Hotels</a></li>
		<li><a href="index2.html">Cruises</a></li>
	</ul>
</div>
