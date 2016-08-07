Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.state.*',
		'Ext.tab.*' ]);

var toursDetailsPage = new ToursDetailsPage();
Ext.onReady(function() {
	travel.prototype.toursDetailsPage = toursDetailsPage;
	toursDetailsPage.initateTabs();
});

function ToursDetailsPage() {

	this.initateTabs = function() {
		var tabs = Ext.createWidget('tabpanel', {
			renderTo : 'tabs1',
			width : 700,
			activeTab : 0,
			defaults : {
				bodyPadding : 10
			},
			items : [ {
				contentEl : 'tourMaster',
				title : 'Tour Information'
			}, {
				contentEl : 'tourItinerary',
				title : 'Tour Itinerary'
			}, {
				contentEl : 'tourPhotoGallery',
				title : 'Tour Photo Gallery'
			} ]
		});
	}

};
