<%@ include file="common/taglibs.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="adminLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text name="tour.add.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
		<script type="text/javascript" src="javascripts/AdminAddTours.js"></script>
		<link rel="stylesheet" type="text/css" href="css/managetours.css" />
	</tiles:putAttribute>
	<tiles:putAttribute name="body">

		<div id="content" style="background-image: none;">
			<div id="topcontent">
				<h2>Add Tour Information</h2>
			</div>
			<div class="bg" style="background-image: none;">
				<s:form theme="simple" method="post">
					<s:hidden id="tourId" name="tourId"></s:hidden>
					<fieldset title="Tours">
						<legend>Tour Information</legend>
						<div id="masterSaveError" class="errorMessage"></div>
						<div id="masterSaveSuccess" class="successMessage"></div>
						<div class="columns">
							<div class="firstCol">
								<s:text name="tour.tourname"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="tourName" name="tourName" size="60"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="tour.destination.name"></s:text>
							</div>
							<div class="secondCol">
								<s:select list="tourDestinationMap" name="selectedDestinationId"
									id="tourDestinationId" cssClass="select"></s:select>
							</div>
							<div class="firstCol">
								<s:text name="tour.tourdescription"></s:text>
							</div>
							<div class="secondCol">
								<s:textarea id="tourDescription" wrap="true"
									name="tourDescription" cssClass="textarea">
								</s:textarea>
							</div>
							<div class="firstCol">
								<s:text name="tour.tourprice"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="tourPrice" name="tourPrice" size="60"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="tour.tourdates"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="tourDate" name="tourDate" size="60"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="btnDiv">
								<input type="button" class="blackbutton" value="Save Tours"
									onclick="addTours.SaveToursInformation()" />
							</div>
						</div>
					</fieldset>
					<fieldset title="Tours">
						<legend>Tour Itinerary</legend>
						<div id="itinerarySaveError" class="errorMessage"></div>
						<div id="itinerarySaveSuccess" class="successMessage"></div>
						<div class="columns">
							<div class="firstCol">
								<s:text name="tour.itinerary.days"></s:text>
							</div>
							<div class="secondCol">
								<s:select list="tourItineraryDayMap" name="tourItineraryDay"
									id="tourItineraryDay"
									onchange="addTours.getTourItineraryByDay()" cssClass="select"></s:select>
							</div>
							<div class="firstCol">
								<s:text name="tour.itinerary.title"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="tourItineraryTitle" name="tourItineraryTitle"
									size="60" cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="tour.itinerary.description"></s:text>
							</div>
							<div class="secondCol">
								<s:textarea id="tourItineraryDescription" wrap="true"
									cssClass="textarea" name="tourItineraryDescription">
								</s:textarea>
							</div>
							<div class="btnDiv">
								<input type="button" class="blackbutton" value="Save Itinerary"
									onclick="addTours.ItinerarySaveToursInformation()" />
							</div>
						</div>
					</fieldset>
				</s:form>
			</div>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
