<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<link rel="SHORTCUT ICON" href="images/bg.jpg" />
<link rel="stylesheet" type="text/css"
	href="css/ext-js4/ext-all-gray.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="javascripts/ext-js4/ext-all.js"></script>
<script type="text/javascript" src="javascripts/ext-js4/bootstrap.js"></script>
<script type="text/javascript" src="javascripts/travel.js"></script>
<tiles:getAsString name="headIncludes" />
</head>
<body>
	<div id="header-container">
		<tiles:insertAttribute name="header" />
		<div class="clearfix"></div>
	</div>
	<div id="wrapper">
		<div id="body-container">
			<div id="sidebar">
				<div class="logo_block">
					<a href="#"><img src="images/logo.jpg" alt="setalpm"
						width="198" height="156" /></a><br /> <span class="slogan">Best
						offers for You</span>
					<p class="text1">Great Value For Money Variety of options to
						choose from. Quality travel experience</p>
				</div>
				<img src="images/title1.gif" alt="" width="126" height="21" /><br />
				<ul id="navigation">
					<li class="color"><a href="ShowTourDestinations.action">Tour
							Destinations</a></li>
					<li class="alternaterow"><a href="showToursInfo.action">Tours</a></li>
					<li class="color"><a href="showHotelsInfo.action">Hotel
							Information</a></li>
				</ul>
			</div>
			<div id="content">
				<div class="search">
					<span></span>
				</div>
				<br />
				<tiles:insertAttribute name="body" />
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div id="footer-container">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>

