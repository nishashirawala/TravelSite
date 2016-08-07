<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="adminLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text
			name="tour.destination.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
		<script type="text/javascript"
			src="javascripts/AdminManageTourDestination.js"></script>
		<link rel="stylesheet" type="text/css" href="css/managetours.css" />
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div id="content" style="background-image: none;">
			<div id="topcontent">
				<img alt="" src="images/Admin/HomePageHeader.jpg">
			</div>
			<div class="bg">
				<div id="toursDestinationGrid"></div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
