Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.state.*' ]);

var manageTourDestination = new AdminManageTourDestination();
Ext.onReady(function() {
	travel.prototype.manageTourDestination = manageTourDestination;
	manageTourDestination.initateGrid();
});

function AdminManageTourDestination() {
	var toursData;
	var tourDataStore;
	var toursGrid;
	var isAdd = false;
	this.getToursDestinationData = function() {
		Ext.Ajax.request( {
			url : "/TravelSite/getAllTourDestination.action",
			params : {
				method : 'getAllTourDestination'
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
		Ext.define('TourDestinationData', {
			extend : 'Ext.data.Model',
			fields : [ 'tourDestinationId', 'tourDestinationName']
		});
		tourDataStore = Ext.create('Ext.data.ArrayStore', {
			autoDestroy : true,
			model : 'TourDestinationData'
		});
		function renderTourDestination(val, meta, record){
			return "<a href='showTourDestination.action?destinationId="+record.data.tourDestinationId+"'>" + val + "</a>";
		}
		// create the Grid
		toursGrid = Ext.create('Ext.grid.Panel', {
			store : tourDataStore,
			title : 'All Tours',
			renderTo : 'toursDestinationGrid',
			iconCls : 'tours-info-grid',
			stateful : true,
			stateId : 'stateGrid',
			height : 500,
			columns : [ {
				text : 'Destination Id',
				sortable : false,
				dataIndex : 'tourDestinationId'
			}, {
				text : 'Destination Name',
				sortable : false,
				dataIndex : 'tourDestinationName',
				renderer : renderTourDestination,
				width: 300
			}],
			tbar : [ {
				text : 'Add Tour Destination',
				iconCls : 'tours-info-add',
				handler : function() {
					window.location = "addTourDestination.action";
				}
			}, {
				text : 'Remove Tour',
				iconCls : 'tours-info-remove',
				handler : function() {
					alert("remove clicked")
				}
			} ],
			viewConfig : {
				stripeRows : true
			}
		});

		manageTourDestination.getToursDestinationData();
	}

};
