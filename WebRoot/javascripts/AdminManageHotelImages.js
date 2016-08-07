Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.state.*' ]);

var manageHotelImages = new AdminManageHotelImages();
Ext.onReady(function() {
	travel.prototype.manageHotelImages = manageHotelImages;
	
});

function AdminManageHotelImages() {
	var hotelData;
	var hotelDataStore;
	var allHotelsGrid;
	var isAdd = false;
	this.getAddressOfHotel = function() {
		var hotelMasterId = Ext.get('hotelMasterId').getValue();
		Ext.Ajax.request( {
			url : "/TravelSite/getAddressOfHotel.action",
			params : {
				method : 'getAddressOfHotel',
				hotelMasterId : hotelMasterId
			},
			success : handleSuccessHotelsData,
			failure : handleFailureHotelsData
		});
	}
	function handleSuccessHotelsData(response) {
		if (response.responseText !== null) {
			hotelData = Ext.JSON.decode(response.responseText);
			document.getElementById('hotelAddress').value = hotelData.hotelAddress;
		}
	}
	function handleFailureHotelsData(response) {
		alert("Fail");
	}
	this.uploadImage = function() {
		alert("upload");
		document.getElementById("ImageUploadForm").action = "UploadImage.action";
		document.getElementById("ImageUploadForm").submit();
			
	}
};
