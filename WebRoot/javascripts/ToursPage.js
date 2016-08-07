Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.state.*' ]);

var toursPage = new ToursPage();
Ext.onReady(function() {
	travel.prototype.toursPage = toursPage;
	toursPage.initateGrid();
});

function ToursPage() {
	var toursData;
	var tourDataStore;
	var toursGrid;
	var isAdd = false;
	this.getToursData = function() {
		var query = window.location.search.substring(1);
		var val = "-1";
		if(query != ""){
			var pos = query.indexOf('=');
			if(pos > 0){
				var key = query.substring(0,pos); // get the Query String Key
				val = query.substring(pos+1); // Get the Query String Key Value.
			}
		}
		
		Ext.Ajax.request( {
			url : "/TravelSite/showAllToursInfo.action",
			params : {
				method : 'showAllToursInfo',
				tourDestinationId: val
			},
			success : handleSuccess,
			failure : handleFailure
		});
	}
	function handleSuccess(response) {
		if (response.responseText !== null) {
			toursData = Ext.JSON.decode(response.responseText);
		}
		tourDataStore.loadData(toursData);

	}
	function handleFailure(response) {
		Ext.MessageBox.alert("FAILURE", "Request Failed");
	}
	this.initateGrid = function() {
		Ext.QuickTips.init();
		Ext.define('TourData', {
			extend : 'Ext.data.Model',
			fields : [ 'tourMasterId', 'tourName', 'tourPrice', 'tourDates' ]
		});
		tourDataStore = Ext.create('Ext.data.ArrayStore', {
			autoDestroy : true,
			model : 'TourData'
		});
		function renderTourInfo(val, meta, record){
			return "<a href='DisplayTourDetails.action?tourId="+record.data.tourMasterId+"'>" + val + "</a>";
		}
		toursGrid = Ext.create('Ext.grid.Panel', {
			store : tourDataStore,
			title : 'All Tours',
			renderTo : 'toursInfoGrid',
			iconCls : 'tours-info-grid',
			stateful : true,
			stateId : 'stateGrid',
			height : 300,			
			columns : [ {
				text : 'Tour Name',
				sortable : false,
				dataIndex : 'tourName',
				renderer : renderTourInfo,
				width:300,
				height:30
			}, {
				text : 'Tour Price',
				sortable : false,
				dataIndex : 'tourPrice',
				height:30
			}, {
				text : 'Tour Dates',
				sortable : false,
				dataIndex : 'tourDates',
				height:30
			} ],
			viewConfig : {
				stripeRows : true
			}
		});

		toursPage.getToursData();
	}

};
