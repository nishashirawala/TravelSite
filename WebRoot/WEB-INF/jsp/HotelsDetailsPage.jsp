<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="pageLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text name="hotel.info.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="String">
		<script type="text/javascript" src="javascripts/HotelsDetailsPage.js"></script>
		<link rel="stylesheet" type="text/css" href="css/managehotels.css" />
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="bg" style="background-image: none;">
			<s:form theme="simple">
				<div id="details">
					<div id="hotelBasicInfoDiv" class="basicDiv">
						<b><s:property id="hotelName" value="hotelName" /> <br /></b>
						<s:property id="hotelAddress" value="hotelAddress" />
						<s:url action="bookHotelsInfo.action" id="bookHotelURL">
							<s:param name="hotelMasterId">
								<s:property id="hotelMasterId" value="hotelMasterId" />
							</s:param>
						</s:url>
						<s:a href="%{bookHotelURL}" cssClass="blackbutton"
							cssStyle="float:right;">Book Hotel</s:a>
					</div>
				</div>
				<br />
				<s:actionmessage cssClass="successMessage"
					cssStyle="font-size: medium;" />
				<s:actionerror cssClass="errorMessage" cssStyle="font-size: medium;" />
				<br />
				<div id="tabs1">
					<div id="hotelMaster" class="x-hide-display">
						<div id="hotelMasterInfo"
							style="width: 100%; font-size: medium; color: navy;">
							<div style="float: left">
								<img
									src="<s:property id="hotelMainImage" value="hotelMainImage"/>"
									class="imageclass" />
							</div>
							<div style="clear: all; padding-left: 400px;">
								<s:property id="hotelName" value="hotelName" />
							</div>
							<br />
							<div style="font-size: small; padding-left: 400px;">
								<s:property id="hotelDescription" value="hotelDescription" />
							</div>
							<br />
							<div style="padding-left: 400px;">
								<s:property id="starRating" value="starRating" />
							</div>
							<br />
							<div style="padding-left: 400px;">
								Hotel Type :
								<s:property id="hotelType" value="hotelType" />
							</div>
						</div>
					</div>
					<div id="hotelPolicies" class="x-hide-display"
						style="font-size: small; color: navy;">
						<c_rt:if test="${hotelPolicyList!=null}">
							<c_rt:forEach var="policy" items="${hotelPolicyList}">
								<table>
									<tr>
										<td><br /></td>
									</tr>
									<tr>
										<td><b><c_rt:out value="${policy.policyName}" /></b></td>
									</tr>
									<tr>
										<td><br /></td>
									</tr>
									<tr>
										<td><c_rt:out value="${policy.policyDescription}"></c_rt:out>
										</td>
									</tr>
									<tr>
										<td><br /></td>
									</tr>
								</table>
							</c_rt:forEach>
						</c_rt:if>
					</div>
					<div id="hotelFacilities" class="x-hide-display"
						style="font-size: small; color: navy;">
						<c_rt:if test="${hotelFaclityList!=null}">
							<c_rt:forEach var="facility" items="${hotelFaclityList}">
								<table>
									<tr>
										<td><br /></td>
									</tr>
									<tr>
										<td><b><c_rt:out value="${facility.facilityName}" /></b>
										</td>
									</tr>
									<tr>
										<td><br /></td>
									</tr>
									<tr>
										<td><c_rt:out value="${facility.facilityDescription}"></c_rt:out>
										</td>
									</tr>
									<tr>
										<td><br /></td>
									</tr>
								</table>
							</c_rt:forEach>
						</c_rt:if>
					</div>
					<div id="hotelImages" class="x-hide-display">
						<c_rt:if test="${hotelImages!=null}">
							<table>
								<tr>
									<c_rt:forEach var="images" items="${hotelImages}" begin="0"
										end="3" step="1">
										<td><img src="<c_rt:out value="${images.imageFile}" />"
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
									<c_rt:forEach var="images" items="${hotelImages}" begin="4"
										step="1">
										<td><img src="<c_rt:out value="${images.imageFile}" />"
											class="imageclass" width="150" height="100" /></td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td><c_rt:out value="${images.imageDescription}"></c_rt:out>
										</td>
									</c_rt:forEach>
								</tr>
							</table>
						</c_rt:if>
					</div>
					<br>

				</div>
			</s:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
