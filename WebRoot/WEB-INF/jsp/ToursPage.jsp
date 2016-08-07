<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="pageLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text
			name="tour.master.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
		<script type="text/javascript" src="javascripts/ToursPage.js"></script>
		<link rel="stylesheet" type="text/css" href="css/managetours.css" />
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="bg">
			<div id="toursInfoGrid"></div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
