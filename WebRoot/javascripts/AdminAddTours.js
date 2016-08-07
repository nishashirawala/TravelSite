Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.state.*' ]);

var addTours = new AddTours();
Ext.onReady(function() {
	travel.prototype.addTours = addTours;
});

function AddTours() {
	this.SaveToursInformation = function() {
		var tourName = Ext.get('tourName').getValue();
		var tourDescription = Ext.get('tourDescription').getValue();
		var tourPrice = Ext.get('tourPrice').getValue();
		var tourDate = Ext.get('tourDate').getValue();
		var tourDestinationId = Ext.get('tourDestinationId').getValue();
		var tourMasterId = Ext.get('tourId').getValue();
		Ext.Ajax.request( {
			url : "/TravelSite/saveTours.action",
			params : {
				method : 'saveTours',
				tourName : tourName,
				tourDescription : tourDescription,
				tourPrice : tourPrice,
				tourDate : tourDate,
				tourDestinationId : tourDestinationId,
				tourId: tourMasterId,
			},
			success : handleSuccessTourMasterDataSave,
			failure : handleSaveFailure
		});
	}
	function handleSuccessTourMasterDataSave(response) {
		if (response.responseText !== undefined) {
			var responseData = Ext.JSON.decode(response.responseText);
			if (responseData.response == "success") {
				var message = responseData.responseMessage;
				document.getElementById("masterSaveSuccess").innerHTML = message;
			} else {
				var message = responseData.responseMessage;
				document.getElementById("masterSaveError").innerHTML = message;
			}
			document.getElementById("tourId").value = responseData.tourMasterId;
		}

	}
	function handleSaveFailure() {
		alert("fail");
	}
	this.ItinerarySaveToursInformation = function() 
	{
		var itineraryDay = Ext.get('tourItineraryDay').getValue();
		var itineraryTitle = Ext.get('tourItineraryTitle').getValue();
		var itineraryDesc = Ext.get('tourItineraryDescription').getValue();
		var tourMasterId = Ext.get('tourId').getValue();
		Ext.Ajax.request( {
			url : "/TravelSite/itinerarySaveTours.action",
			params : {
				method : 'itinerarySaveTours',
				tourItineraryDay : itineraryDay,
				tourItineraryTitle : itineraryTitle,
				tourItineraryDescription : itineraryDesc,
				tourId : tourMasterId,
			},
			success : handleSuccessTourItineraryDataSave,
			failure : handleSaveFailure
		});
	}
	function handleSuccessTourItineraryDataSave(response) {
		if (response.responseText !== undefined) {
			var responseData = Ext.JSON.decode(response.responseText);
			if (responseData.response == "success") {
				var message = responseData.responseMessage;
				document.getElementById("itinerarySaveSuccess").innerHTML = message;
			} else {
				var message = responseData.responseMessage;
				document.getElementById("itinerarySaveError").innerHTML = message;
			}
		}
	}
	
	this.getTourItineraryByDay = function() {
		var itineraryDay = Ext.get('tourItineraryDay').getValue();
		var tourMasterId = Ext.get('tourId').getValue();
		Ext.Ajax.request( {
			url : "/TravelSite/getItineraryByDayTourInformation.action",
			params : {
				method : 'getItineraryByDayTourInformation',
				tourItineraryDay : itineraryDay,
				tourId : tourMasterId,
			},
			success : handleSuccessTourItineraryByDay,
			failure : handleSaveFailure
		});
	}
	
	function handleSuccessTourItineraryByDay(response) 
	{
		if (response.responseText !== undefined) {
			var responseData = Ext.JSON.decode(response.responseText);
			var itineraryTitle = responseData.tourItineraryTitle;
			var itineraryDesc = responseData.tourItineraryDescription;
			document.getElementById("itinerarySaveSuccess").innerHTML = "";
			document.getElementById("itinerarySaveError").innerHTML = "";
			document.getElementById('tourItineraryTitle').value = itineraryTitle;
			document.getElementById('tourItineraryDescription').value = itineraryDesc;
		}
	}
}