Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.state.*',
		'Ext.tab.*' ]);

var hotelsDetailsPage = new HotelsDetailsPage();
Ext.onReady(function() {
	travel.prototype.hotelsDetailsPage = hotelsDetailsPage;
	hotelsDetailsPage.initateTabs();
});

function HotelsDetailsPage() {

	this.initateTabs = function() {
		var tabs = Ext.createWidget('tabpanel', {
			renderTo : 'tabs1',
			width : 700,
			activeTab : 0,
			defaults : {
				bodyPadding : 10
			},
			items : [ {
				contentEl : 'hotelMaster',
				title : 'Hotel Information'
			}, {
				contentEl : 'hotelPolicies',
				title : 'Hotel Policies'
			}, {
				contentEl : 'hotelFacilities',
				title : 'Hotel Facilities'
			}, {
				contentEl : 'hotelImages',
				title : 'Hotel Photo Gallery'
			} ]
		});
	}

};
