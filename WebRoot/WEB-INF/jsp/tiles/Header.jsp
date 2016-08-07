<%@ taglib uri="/struts-tags" prefix="s"%>
<div id="header">
	<div class="loginError">
		<s:if test="%{#parameters.authFailed!=null}">
			<s:text name="errors.password.mismatch" />
		</s:if>
		<s:if test="%{#parameters.accessDenied !=null}">
			<s:text name="errors.access.denied" />
		</s:if>
	</div>
	<div class="login">
		<s:form id="loginForm" action="login" theme="simple" method="post">
			<s:textfield name="j_username" id="userName" cssClass="input"
				theme="simple" value="Login" />
			<s:password name="j_password" theme="simple" id="password"
				cssClass="input" value="Password" />
			<div class="enter">
				<a href="#" onclick="loginClicked()">Enter</a>
			</div>
			<div class="links">
				<a href="#">Forgot password</a> | <a
					href="showUserRegistration.action">Registration</a>
			</div>
		</s:form>
	</div>
	<ul id="menu">
		<li><a href="homepage.action">Home page</a></li>
		<li><a href="showToursInfo.action">Tours</a></li>
		<li><a href="ShowTourDestinations.action">Destinations</a></li>
		<li><a href="showHotelsInfo.action">Hotels</a></li>
		<li><a href="#">Cruises</a></li>
		<li><a href="#">About us</a></li>
		<li><a href="#">Contact us</a></li>
	</ul>
</div>
