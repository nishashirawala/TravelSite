<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="pageLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text
			name="registeruser.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div id="content" style="background-image: none;">
			<div id="headcontent"></div>
			<br />
			<div class="bg" style="background-image: none;">
				<fieldset title="Registration">
					<legend>
						<s:text name="registeruser.title" />
					</legend>
					<s:form theme="simple" method="post" action="saveUserRegistration">
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
							<div class="firstCol">
								<s:text name="registeruser.confirmpassword" />
							</div>
							<div class="secondCol">
								<s:password id="confirmPassword" name="confirmPassword"
									size="50" cssClass="textbox"></s:password>
							</div>
							<div class="firstCol">
								<s:text name="registeruser.firstname" />
							</div>
							<div class="secondCol">
								<s:textfield id="firstName" name="firstName" size="50"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="registeruser.lastname" />
							</div>
							<div class="secondCol">
								<s:textfield id="lastName" name="lastName" size="50"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="registeruser.email" />
							</div>
							<div class="secondCol">
								<s:textfield id="email" name="email" size="50"
									cssClass="textbox"></s:textfield>
							</div>
							<br />
							<div class="btnDiv">
								<s:submit value="Register" cssClass="blackbutton" />
							</div>
						</div>
					</s:form>
				</fieldset>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
