<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="adminLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text
			name="tour.images.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
		<script type="text/javascript"
			src="javascripts/AdminManageTourImages.js"></script>
		<link rel="stylesheet" type="text/css" href="css/managetours.css" />
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div id="content" style="background-image: none;">
			<div id="topcontent">
				<h2>Add Images for Tours</h2>
			</div>
			<div class="bg" style="background-image: none;">
				<s:form namespace="/" method="POST" id="ImageUploadForm"
					action="UploadTourImage" enctype="multipart/form-data"
					theme="simple">
					<s:hidden id="masterId" name="tourMasterId"></s:hidden>
					<fieldset title="Tour Images">
						<legend>Upload Images for Tours</legend>
						<s:actionerror cssClass="errorMessage" />
						<s:fielderror cssClass="errorMessage" />
						<s:actionmessage cssClass="successMessage" />
						<div class="columns">
							<div class="firstCol">
								<s:text name="tour.tourname"></s:text>
							</div>
							<div class="secondCol">
								<s:select list="tourMap" name="selectedTourId" id="tourMasterId"
									cssClass="select"></s:select>
							</div>
							<div class="firstCol">
								<s:text name="tour.mainimage"></s:text>
							</div>
							<div class="secondCol">
								<s:file name="mainImage" id="mainImage" size="40"
									cssClass="textbox" />
							</div>

							<div class="firstCol">
								<s:text name="tour.images"></s:text>
							</div>
							<div class="secondCol">
								<s:file name="thumbnailImage" id="thumbnailImage" size="40"
									cssClass="textbox" />
							</div>
							<div class="firstCol"></div>
							<div class="secondCol">
								<s:file name="thumbnailImage" id="thumbnailImage" size="40"
									cssClass="textbox" />
							</div>
							<div class="firstCol"></div>
							<div class="secondCol">
								<s:file name="thumbnailImage" id="thumbnailImage" size="40"
									cssClass="textbox" />
							</div>
							<div class="firstCol"></div>
							<div class="secondCol">
								<s:file name="thumbnailImage" id="thumbnailImage" size="40"
									cssClass="textbox" />
							</div>
							<div class="firstCol"></div>
							<div class="secondCol">
								<s:file name="thumbnailImage" id="thumbnailImage" size="40"
									cssClass="textbox" />
							</div>
							<div class="firstCol"></div>
							<div class="secondCol">
								<s:file name="thumbnailImage" id="thumbnailImage" size="40"
									cssClass="textbox" />
							</div>
							<div class="btnDiv">
								<s:submit value="Save Images" cssClass="blackbutton" />
							</div>
						</div>
					</fieldset>
				</s:form>

			</div>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
