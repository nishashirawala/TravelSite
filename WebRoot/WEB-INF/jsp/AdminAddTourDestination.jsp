<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="adminLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text
			name="tour.destination.add.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
		<link rel="stylesheet" type="text/css" href="css/managetours.css" />
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div id="content" style="background-image: none;">
			<div id="topcontent">
				<h2>Add Tour Destination Information</h2>
			</div>
			<div class="bg" style="background-image: none;">
				<s:form theme="simple" method="post" action="saveTourDestination">
					<fieldset title="Destination">
						<legend>Tour Destination</legend>
						<s:actionmessage cssClass="successMessage" />
						<s:actionerror cssClass="errorMessage" />
						<s:hidden name="destinationId" id="destinationId"></s:hidden>
						<div class="columns">
							<div class="firstCol">
								<s:text name="tour.destination.name"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="destinationName" name="destinationName"
									size="60" cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="tour.destination.description"></s:text>
							</div>
							<div class="secondCol">
								<s:textarea id="destinationDescription" wrap="true"
									cssClass="textarea" name="destinationDescription">
								</s:textarea>
							</div>
							<div class="btnDiv">
								<s:submit id="submitbtn" cssClass="blackbutton"
									value="Save Tour Destination" cssStyle="margin-top:30px;"></s:submit>
							</div>
						</div>
					</fieldset>
				</s:form>
			</div>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
