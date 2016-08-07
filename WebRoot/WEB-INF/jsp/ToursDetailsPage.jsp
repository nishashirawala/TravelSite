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
				<div id="details">
					<div id="tourBasicInfoDiv" class="basicDiv">
						<b><c:out value="Destination : " /> <s:property
								id="tourDestination" value="tourDestination" /> <br /> <c:out
								value=" Tour : " /> <s:property id="tourName" value="tourName" /></b>
						<s:url action="bookToursInfo.action" id="bookTourURL">
							<s:param name="tourId">
								<s:property id="tourId" value="tourId" />
							</s:param>
						</s:url>
						<s:a href="%{bookTourURL}" cssClass="blackbutton"
							cssStyle="float:right;">Book Tour</s:a>
					</div>
				</div>
				<br />
				<s:actionmessage cssClass="successMessage"
					cssStyle="font-size: medium;" />
				<s:actionerror cssClass="errorMessage" cssStyle="font-size: medium;" />
				<br />
				<div id="tabs1">
					<div id="tourMaster" class="x-hide-display">
						<div id="tourMasterInfo" style="width: 100%">
							<div style="float: left">
								<img
									src="<s:property id="tourMainImage" value="tourMainImage"/>"
									class="imageclass" />
							</div>
							<div
								style="clear: all; font-size: medium; color: MidnightBlue; padding-left: 400px;">
								<s:property id="tourName" value="tourName" />
							</div>
							<div
								style="font-size: medium; color: MidnightBlue; padding-left: 400px;">
								<s:property id="tourDescription" value="tourDescription" />
							</div>
							<div
								style="font-size: medium; color: MidnightBlue; padding-left: 400px;">
								<s:property id="tourPrice" value="tourPrice" />
							</div>
							<div
								style="font-size: medium; color: MidnightBlue; padding-left: 400px;">
								<s:property id="tourDate" value="tourDate" />
							</div>
						</div>
					</div>
					<div id="tourItinerary" class="x-hide-display"
						style="font-size: small; color: MidnightBlue;">
						<c_rt:forEach var="itinerary" items="${tourItineraryList}"
							varStatus="status">
							<table>
								<tr>
									<td><br /></td>
								</tr>
								<tr>
									<td><b>Day ${status.count} &nbsp;&nbsp;<c_rt:out
												value="${itinerary.itineraryTitle}" /></b></td>
								</tr>
								<tr>
									<td><br /></td>
								</tr>
								<tr>
									<td><c_rt:out value="${itinerary.itineraryDescription}"></c_rt:out>
									</td>
								</tr>
								<tr>
									<td><br /></td>
								</tr>
							</table>
						</c_rt:forEach>
					</div>
					<div id="tourPhotoGallery" class="x-hide-display">
						<table>
							<tr>
								<c_rt:forEach var="images" items="${tourImages}" begin="0"
									end="3" step="1">
									<td><img src="<c_rt:out value="${images.imageSource}" />"
										class="imageclass" width="150" height="100" /></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td><c_rt:out value="${images.imageDescription}"></c_rt:out>
									</td>
								</c_rt:forEach>
							</tr>
						</table>
						<br />
						<table>
							<tr>
								<c_rt:forEach var="images" items="${tourImages}" begin="4"
									step="1">
									<td><img src="<c_rt:out value="${images.imageSource}" />"
										class="imageclass" width="150" height="100" /></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td><c_rt:out value="${images.imageDescription}"></c_rt:out>
									</td>
								</c_rt:forEach>
							</tr>
						</table>
					</div>
					<br>

				</div>
			</s:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
