<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="pageLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text
			name="tour.master.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
		<script type="text/javascript" src="javascripts/ToursDetailsPage.js"></script>
		<link rel="stylesheet" type="text/css" href="css/managetours.css" />
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="bg" style="background-image: none;">
			<s:form theme="simple">
				<div id="tourDestinations" style="margin: 30px;">
					<c_rt:forEach var="destination" items="${tourDestinationList}">
						<div class="item">
							<a
								href="showToursInfo.action?tourDestinationId=<c_rt:out value="${destination.id}"/>"><img
								src="<c_rt:out value="${destination.destinationImage}" />"
								class="imageclass" width="200" height="150" /></a> <span><c_rt:out
									value="${destination.destinationName}"></c_rt:out></span>
						</div>
					</c_rt:forEach>
				</div>
			</s:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
