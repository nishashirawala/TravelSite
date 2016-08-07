<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="pageLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - Error page
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="" />
	<tiles:putAttribute name="body">
		<div class="bg">
			<br />
			<p>Some problem while performing the operation. Please try again.
			</p>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
