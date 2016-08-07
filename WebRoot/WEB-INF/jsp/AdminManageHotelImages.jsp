<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="adminLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text name="hotel.add.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
		<script type="text/javascript"
			src="javascripts/AdminManageHotelImages.js"></script>
		<link rel="stylesheet" type="text/css" href="css/managehotels.css" />
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div id="content" style="background-image: none;">
			<div id="topcontent">
				<h2>Add Images for Hotels</h2>
			</div>
			<div class="bg" style="background-image: none;">
				<s:form namespace="/" method="POST" id="ImageUploadForm"
					action="UploadImage" enctype="multipart/form-data" theme="simple">
					<s:hidden id="masterId" name="hotelMasterId"></s:hidden>
					<fieldset title="Hotels">
						<legend>Hotel Information</legend>
						<s:actionerror cssClass="errorMessage" />
						<s:fielderror cssClass="errorMessage" />
						<s:actionmessage cssClass="successMessage" />
						<div id="masterSaveError" class="errorMessage"></div>
						<div id="masterSaveSuccess" class="successMessage"></div>
						<div class="columns">
							<div class="firstCol">
								<s:text name="hotel.hotelname"></s:text>
							</div>
							<div class="secondCol">
								<s:select list="hotelMap" name="selectedMasterId"
									id="hotelMasterId"
									onchange="manageHotelImages.getAddressOfHotel();"
									cssClass="select"></s:select>
							</div>
							<div class="firstCol">
								<s:text name="Address"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="hotelAddress" name="hotelAddress" size="60"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="hotel.mainimage"></s:text>
							</div>
							<div class="secondCol">
								<s:file name="mainImage" id="mainImage" size="40"
									cssClass="textbox" />
							</div>

							<div class="firstCol">
								<s:text name="hotel.images"></s:text>
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
