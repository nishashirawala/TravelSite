Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.state.*' ]);

var manageHotels = new AdminManageHotels();
Ext.onReady(function() {
	travel.prototype.manageHotels = manageHotels;
	manageHotels.initateGrid();
});

function AdminManageHotels() {
	var hotelData;
	var hotelDataStore;
	var allHotelsGrid;
	var isAdd = false;
	this.getHotelsData = function() {
		Ext.Ajax.request( {
			url : "/TravelSite/getAllHotels.action",
			params : {
				method : 'getAllHotels'
			},
			success : handleSuccessHotelsData,
			failure : handleFailureHotelsData
		});
	}
	function handleSuccessHotelsData(response) {
		if (response.responseText !== null) {
			hotelData = Ext.JSON.decode(response.responseText);
		}
		hotelDataStore.loadData(hotelData);

	}
	function handleFailureHotelsData(response) {
		Ext.MessageBox.alert("FAILURE", "Request Failed");
	}
	this.initateGrid = function() {
		Ext.QuickTips.init();
		Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));
		Ext.define('HotelData', {
			extend : 'Ext.data.Model',
			fields : [ 'hotelMasterId', 'hotelName', 'hotelAddress', 'city',
					'state', 'hotelType', 'starRating' ]
		});
		hotelDataStore = Ext.create('Ext.data.ArrayStore', {
			autoDestroy : true,
			model : 'HotelData'
		});
		function renderHotelMasterId(val, meta, record){
			return "<a href='showInformationForHotel.action?hotelMasterId="+record.data.hotelMasterId+"'>" + val + "</a>";
		}
		// create the Grid
		allHotelsGrid = Ext.create('Ext.grid.Panel', {
			store : hotelDataStore,
			title : 'All Hotels',
			renderTo : 'hotelsInfoGrid',
			iconCls : 'hotels-info-grid',
			stateful : true,
			stateId : 'stateGrid',
			height : 500,
			columns : [ {
				text : 'Hotel Name',
				flex : 1,
				sortable : false,
				dataIndex : 'hotelName',
				renderer : renderHotelMasterId	
			}, {
				text : 'Hotel Address',
				flex : 1,
				sortable : false,
				dataIndex : 'hotelAddress'
			}, {
				text : 'City',
				flex : 1,
				sortable : false,
				dataIndex : 'city'
			}, {
				text : 'State',
				flex : 1,
				sortable : false,
				dataIndex : 'state'
			}, {
				text : 'Hotel Type',
				flex : 1,
				sortable : false,
				dataIndex : 'hotelType'
			}, {
				text : 'Star Rating',
				flex : 1,
				sortable : false,
				dataIndex : 'starRating'
			} ],
			tbar : [ {
				text : 'Add Category',
				iconCls : 'hotels-info-add',
				handler : function() {
					window.location = "AddCategory.action";
				}
			}, {
				text : 'Remove Category',
				iconCls : 'hotels-info-remove',
				handler : function() {
					alert("remove clicked")
				}
			} ],
			viewConfig : {
				stripeRows : true
			}
		});

		manageHotels.getHotelsData();
	}

};
