Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.state.*' ]);

var manageTours = new AdminManageTours();
Ext.onReady(function() {
	travel.prototype.manageTours = manageTours;
	manageTours.initateGrid();
});

function AdminManageTours() {
	var toursData;
	var tourDataStore;
	var toursGrid;
	var isAdd = false;
	this.getToursData = function() {
		Ext.Ajax.request( {
			url : "/TravelSite/getAllTours.action",
			params : {
				method : 'getAllTours'
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
		Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));
		Ext.define('TourData', {
			extend : 'Ext.data.Model',
			fields : [ 'tourMasterId', 'tourName', 'tourPrice', 'tourDates' ]
		});
		tourDataStore = Ext.create('Ext.data.ArrayStore', {
			autoDestroy : true,
			model : 'TourData'
		});
		function renderTourInfo(val, meta, record){
			return "<a href='showTourInformation.action?tourId="+record.data.tourMasterId+"'>" + val + "</a>";
		}
		// create the Grid
		toursGrid = Ext.create('Ext.grid.Panel', {
			store : tourDataStore,
			title : 'All Tours',
			renderTo : 'toursInfoGrid',
			iconCls : 'tours-info-grid',
			stateful : true,
			stateId : 'stateGrid',
			height : 500,
			columns : [ {
				text : 'Tour Name',
				flex : 1,
				sortable : false,
				dataIndex : 'tourName',
				renderer : renderTourInfo
			}, {
				text : 'Tour Price',
				flex : 1,
				sortable : false,
				dataIndex : 'tourPrice'
			}, {
				text : 'Tour Dates',
				flex : 1,
				sortable : false,
				dataIndex : 'tourDates'
			} ],
			tbar : [ {
				text : 'Add Tour',
				iconCls : 'tours-info-add',
				handler : function() {
					window.location = "addTourInformation.action";
				}
			}, {
				text : 'Remove Tour',
				iconCls : 'tours-info-remove',
				handler : function() {
					alert("To be implemented")
				}
			} ],
			viewConfig : {
				stripeRows : true
			}
		});

		manageTours.getToursData();
	}

};
