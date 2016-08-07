<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<tiles:insertDefinition name="pageLayout">
	<tiles:putAttribute name="title" type="string">
		<s:text name="application.title" /> - <s:text name="homepage.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="headIncludes" value="" />
	<tiles:putAttribute name="body">
		<div class="bg" style="background-image: none;">
			<div class="column1">
				<div class="tree">
					<a href="#">Tours</a> &raquo; Maldives
				</div>
				<img src="images/title5.gif" alt="" width="255" height="19" /><br />
				<div class="gallery">
					<img src="images/photo.jpg" width="476" height="270" /><br />
					<div>
						<a href="#" class="arrow"><img src="images/arrow_l.gif" alt=""
							width="8" height="46" /></a>
						<div>
							<a href="#"><img src="images/photo1.jpg" alt="" width="78"
								height="58" /></a> <a href="#"><img src="images/photo2.jpg"
								alt="" width="78" height="58" /></a> <a href="#"><img
								src="images/photo3.jpg" alt="" width="78" height="58" /></a> <a
								href="#"><img src="images/photo4.jpg" alt="" width="78"
								height="58" /></a> <a href="#"><img src="images/photo5.jpg"
								alt="" width="78" height="58" /></a> <a href="#"><img
								src="images/photo6.jpg" alt="" width="78" height="58" /></a> <a
								href="#"><img src="images/photo7.jpg" alt="" width="78"
								height="58" /></a> <a href="#"><img src="images/photo8.jpg"
								alt="" width="78" height="58" /></a> <a href="#"><img
								src="images/photo9.jpg" alt="" width="78" height="58" /></a> <a
								href="#"><img src="images/photo10.jpg" alt="" width="78"
								height="58" /></a>
						</div>
						<a href="#" class="arrow"><img src="images/arrow_r.gif" alt=""
							width="8" height="46" /></a>
					</div>
				</div>
			</div>
			<div class="column2">
				<img src="images/title6.gif" alt="" width="104" height="19" /><br />
				<p class="info">Lorem ipsum dolor sit amet, sectetu adip scing
					varius interdum incid unt quis, libero. Aenean mturpis. Maecenas
					hendrerit masa laoreet iaculipede mnisl ulamcorper. Tellus er
					sodales enim, in tincidunt mauris in odio. Massa ac laoreet
					iaculipede nisl ullamcorpermassa, ac consectetuer feipsum eget
					pede. Proin nunc. Donec massa. Nulla pulvinar, nisl ac convallis
					nonummy, tellus eros sodales enim, in tincidunt mauris in odio.
					massa ac laoreet iaculipede nisl ullamcorpermassa,consectetuer
					feipsum eget pede. Proin nunc. Donec massa. Nulla pulvinar, nisl ac
					convallis nonummy, tellus eros sodales enim, in tincidunt mauris in
				</p>
				<a href="#" class="button">more info</a>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
