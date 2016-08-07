<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="pageLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text
			name="user.loginpage.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div id="content" style="background-image: none;">

			<div class="bg" style="background-image: none;">
				<fieldset title="Login">
					<legend>Login</legend>
					<br />
					<s:form theme="simple" method="post" action="loginUserRegistration">
						<s:actionerror cssClass="errorMessage" />
						<s:fielderror cssClass="errorMessage" />
						<s:actionmessage cssClass="successMessage" />
						<div class="columns">
							<div class="firstCol">
								<s:text name="registeruser.username" />
							</div>
							<div class="secondCol">
								<s:textfield id="userName" name="userName" size="50"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="registeruser.password" />
							</div>
							<div class="secondCol">
								<s:password id="password" name="password" size="50"
									cssClass="textbox"></s:password>
							</div>
							<br />
							<div class="btnDiv">
								<s:submit value="Login" cssClass="blackbutton" />
							</div>
						</div>
					</s:form>
				</fieldset>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
