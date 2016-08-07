<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="pageLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text name="hotel.list.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
		<script type="text/javascript" src="javascripts/HotelsPage.js"></script>
		<link rel="stylesheet" type="text/css" href="css/managehotels.css" />
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="bg">
			<div id="hotelsInfoGrid"></div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
