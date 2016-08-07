<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="pageLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text name="homepage.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="" />
	<tiles:putAttribute name="body">
		<div class="bg">
			<div class="column1">
				<img src="images/title2.gif" alt="" width="258" height="21" /><br />
				<p>Travel brings the world closer and Travel Operator makes
					world travel easier than ever. We work hard to secure the best
					rates in the most popular destinations. Now it's easy to shop our
					featured cities for the top travel deals from Canada. Take a look
					and see what you'll save.
				<div>Booking your next tour with us is simple. Take a look at
					some of the most popular tour destinations below to help you find a
					great price.</div>
				</p>
				<img src="images/title3.gif" alt="" width="258" height="21" /><br />
				<div id="items">
					<c_rt:forEach var="tour" items="${allTours}" begin="0" end="3"
						step="1">
						<div class="item">
							<a
								href="DisplayTourDetails.action?tourId=<c_rt:out value="${tour.id}"/>"><img
								src="<c_rt:out value="${tour.mainImage}" />" class="imageclass"
								width="200" height="150" /></a> <span style="color: white;"><c_rt:out
									value="${tour.tourName}"></c_rt:out></span>
						</div>
					</c_rt:forEach>
				</div>
			</div>
			<div class="column2">
				<img src="images/title4.gif" alt="" width="133" height="18" /><br />
				<div class="news">
					<span>15 Dec 2011</span><br />
					<p>Do you have plans to travel to India or other international
						destinations? Enjoy hassle-free flights booking and get discount
						on air tickets with Paradise. From amazing vacation deals to hotel
						booking, avail the widest array of tours &amp; travel packages.</p>
				</div>
				<div class="news">
					<span>12 Dec 2011</span><br /> <img src="images/pic5.jpg" alt=""
						width="183" height="97" />
					<p>Check out our featured tour destinations and discover
						incredible travel deals and tours from Canada to the most exciting
						holiday destinations across the globe! Our exclusive vacation
						packages are specially designed to ensure you have the time of
						your life at value for your money. So go ahead, choose your
						perfect vacations from our featured tours!</p>

				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
