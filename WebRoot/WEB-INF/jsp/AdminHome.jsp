<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="adminLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text name="homepage.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="" />
	<tiles:putAttribute name="body">
		<div id="content">
			<div id="topcontent">
				<img alt="" src="images/Admin/HomePageHeader.jpg">
			</div>
			<div class="bg" style="background-image: none;">
				<br /> <br />
				<div
					style="color: gray; font-size: medium; border: 1px solid gray; padding: 20px; border-radius: 25px">
					<span> <b>Welcome to management section of travel
							website</b>
					</span>
					<p>
						<span> <b> Admin users can maintain website by doing
								following activities</b>
						</span>
					</p>
					<br />
					<ul>
						<li>Add/Update Tour Information</li>
						<li>Upload pictures for tours</li>
						<li>Add/Update Hotel Information</li>
						<li>Upload pictures for hotels</li>
					</ul>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
