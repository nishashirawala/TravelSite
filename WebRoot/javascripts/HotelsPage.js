Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.state.*' ]);

var hotelsPage = new HotelsPage();
Ext.onReady(function() {
	travel.prototype.hotelsPage = hotelsPage;
	hotelsPage.initateGrid();
});

function HotelsPage() {
	var hotelsData;
	var hotelsDataStore;
	var hotelsGrid;
	var isAdd = false;
	this.getHotelData = function() {
		Ext.Ajax.request( {
			url : "/TravelSite/showAllHotelsInfo.action",
			params : {
				method : 'showAllHotelsInfo'
			},
			success : handleSuccess,
			failure : handleFailure
		});
	}
	function handleSuccess(response) {
		if (response.responseText !== null) {
			hotelsData = Ext.JSON.decode(response.responseText);
		}
	    hotelsDataStore.loadData(hotelsData);
	}
	function handleFailure(response) {
		Ext.MessageBox.alert("FAILURE", "Request Failed");
	}
	
	function renderHotelInfo(val, meta, record){
			return "<a href='DisplayHotelsDetails.action?hotelMasterId="+record.data.hotelMasterId+"'>" + val + "</a>";
		}
	
	this.initateGrid = function() {
		Ext.QuickTips.init();
		Ext.define('HotelsData', {
			extend : 'Ext.data.Model',
			fields : [ 'hotelStarRating', 'hotelName', 'hotelMasterId', 'hotelType' ]
		});
		hotelsDataStore = Ext.create('Ext.data.ArrayStore', {
			autoDestroy : true,
			model : 'HotelsData'
		});
		hotelsGrid = Ext.create('Ext.grid.Panel', {
			store : hotelsDataStore,
			title : 'All Hotels',
			renderTo : 'hotelsInfoGrid',
			iconCls : 'hotels-info-grid',
			stateful : true,
			stateId : 'stateGrid',
			height : 300,			
			columns : [ {
				text : 'Hotel Name',
				flex : 1,
				sortable : false,
				dataIndex : 'hotelName',				
				height:30,
				renderer:renderHotelInfo
			}, {
				text : 'Hotel Type',
				flex : 1,
				sortable : false,
				dataIndex : 'hotelType',
				height:30
			}, {
				text : 'Star Rating',
				flex : 1,
				sortable : false,
				dataIndex : 'hotelStarRating',
				height:30
			} ],
			viewConfig : {
				stripeRows : true
			}
		});
		hotelsPage.getHotelData();
	}
};
