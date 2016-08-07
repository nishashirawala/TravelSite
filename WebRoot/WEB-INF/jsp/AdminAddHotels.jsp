<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="adminLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text name="hotel.add.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
		<script type="text/javascript" src="javascripts/AdminAddHotel.js"></script>
		<link rel="stylesheet" type="text/css" href="css/managehotels.css" />
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div id="content" style="background-image: none;">
			<div id="topcontent">
				<h2>Add Hotel Information</h2>
			</div>
			<div class="bg" style="background-image: none;">
				<s:form theme="simple" method="post">
					<s:hidden id="masterId" name="hotelMasterId"></s:hidden>
					<fieldset title="Hotels">
						<legend>Hotel Information</legend>
						<div id="masterSaveError" class="errorMessage"></div>
						<div id="masterSaveSuccess" class="successMessage"></div>
						<div class="columns">
							<div class="firstCol">
								<s:text name="hotel.hotelname"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="hotelName" name="hotelName" size="60"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="hotel.hoteldescription"></s:text>
							</div>
							<div class="secondCol">
								<s:textarea id="hotelDescription" wrap="true" cols="80"
									name="hotelDescription" cssClass="textarea">
								</s:textarea>
							</div>
							<div class="firstCol">
								<s:text name="hotel.hoteltype"></s:text>
							</div>
							<div class="secondCol">
								<s:select list="typeMap" name="hotelType" id="hotelType"
									cssClass="select"></s:select>
							</div>
							<div class="firstCol">
								<s:text name="hotel.starrating"></s:text>
							</div>
							<div class="secondCol">
								<s:select list="starRatingMap" name="starRating" id="starRating"
									cssClass="select"></s:select>
							</div>
							<div class="firstCol">
								<s:text name="hotel.conditions"></s:text>
							</div>
							<div class="secondCol">
								<s:textarea id="conditions" wrap="true" cols="80"
									name="conditions" cssClass="textarea">
								</s:textarea>
							</div>
							<div class="firstCol">
								<s:text name="hotel.otherinformation"></s:text>
							</div>
							<div class="secondCol">
								<s:textarea id="otherInformation" wrap="true" cols="80"
									name="otherInformation" cssClass="textarea">
								</s:textarea>
							</div>
							<div class="btnDiv">
								<input type="button" class="blackbutton" value="Save Details"
									onclick="addHotel.SaveHotelInformation()" />
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend>Hotel Address</legend>
						<div id="addressSaveError" class="errorMessage"></div>
						<div id="addressSaveSuccess" class="successMessage"></div>
						<div class="columns">
							<div class="firstCol">
								<s:text name="hotel.addressline1"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="addressLine1" name="addressLine1" size="60"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="hotel.addressline2"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="addressLine2" name="addressLine2" size="60"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="hotel.city"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="city" name="city" size="20" cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="hotel.postalcode"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="postalCode" name="postalCode" size="20"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="hotel.state"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="state" name="state" size="20"
									cssClass="textbox"></s:textfield>
							</div>
							<div class="firstCol">
								<s:text name="hotel.country"></s:text>
							</div>
							<div class="secondCol">
								<s:textfield id="country" name="country" size="20"
									cssClass="textbox"></s:textfield>
							</div>

							<div class="btnDiv">
								<input type="button" class="blackbutton" value="Save Address"
									onclick="addHotel.SaveAddressInformation()" />
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend>Hotel Facilities</legend>
						<div id="facilitySaveError" class="errorMessage"></div>
						<div id="facilitySaveSuccess" class="successMessage"></div>
						<div class="columns">
							<div class="firstCol">
								<s:text name="hotel.facilityname"></s:text>
							</div>
							<div class="secondCol">
								<s:select list="facilityMap" name="facilityName"
									id="facilityNameId"
									onchange="addHotel.selectedFacilityChanged();"
									cssClass="select"></s:select>
							</div>
							<div class="firstCol">
								<s:text name="hotel.facilitydescription"></s:text>
							</div>
							<div class="secondCol">
								<s:textarea id="facilityDescription" name="facilityDescription"
									wrap="true" cssClass="textarea">
								</s:textarea>
							</div>
							<div class="btnDiv">
								<input type="button" class="blackbutton" value="Save Facilities"
									onclick="addHotel.SaveFacilityInformation();" />
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend>Hotel Policies</legend>
						<div id="policySaveError" class="errorMessage"></div>
						<div id="policySaveSuccess" class="successMessage"></div>
						<div class="columns">
							<div class="firstCol">
								<s:text name="hotel.policyname"></s:text>
							</div>
							<div class="secondCol">
								<s:select list="policyMap" name="policyName" id="policyNameId"
									onchange="addHotel.selectedPolicyChanged();" cssClass="select"></s:select>
							</div>
							<div class="firstCol">
								<s:text name="hotel.policydescription"></s:text>
							</div>
							<div class="secondCol">
								<s:textarea id="policyDescription" name="policyDescription"
									wrap="true" cssClass="textarea">
								</s:textarea>
							</div>
							<div class="btnDiv">
								<input type="button" class="blackbutton" value="Save Policies"
									onclick="addHotel.SavePolicyInformation()" />
							</div>
						</div>
					</fieldset>
				</s:form>
			</div>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
