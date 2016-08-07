Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.state.*' ]);

var addHotel = new AddHotel();
Ext.onReady(function() {
	travel.prototype.addHotel = addHotel;
});

function AddHotel() {
	this.SaveHotelInformation = function() {
		var hotelName = Ext.get('hotelName').getValue();
		var hotelDescription = Ext.get('hotelDescription').getValue();
		var hotelType = Ext.get('hotelType').getValue();
		var starRating = Ext.get('starRating').getValue();
		var conditions = Ext.get('conditions').getValue();
		var otherInfo = Ext.get('otherInformation').getValue();
		var hotelMasterId = Ext.get('masterId').getValue();
		Ext.Ajax.request( {
			url : "/TravelSite/saveMasterInformationForHotel.action",
			params : {
				method : 'saveMasterInformationForHotel',
				hotelMasterId : hotelMasterId,
				hotelName : hotelName,
				hotelDescription : hotelDescription,
				hotelType : hotelType,
				starRating : starRating,
				conditions : conditions,
				otherInformation : otherInfo
			},
			success : handleSuccessHotelMasterDataSave,
			failure : handleSaveFailure
		});
	}
	function handleSuccessHotelMasterDataSave(response) {

		if (response.responseText !== undefined) {
			var responseData = Ext.JSON.decode(response.responseText);
			if (responseData.response == "success") {
				var message = responseData.responseMessage;
				document.getElementById("masterSaveSuccess").innerHTML = message;
			} else {
				var message = responseData.responseMessage;
				document.getElementById("masterSaveError").innerHTML = message;
			}
			document.getElementById("masterId").value = responseData.hotelMasterId;
		}

	}
	function handleSaveFailure() {
		alert("fail");
	}

	this.SaveImageInformation = function() {
		document.getElementById("saveImageInformationForHotel").submit();
	}

	function handleSuccessHotelAddressDataSave(response) {
		if (response.responseText !== undefined) {
			var responseData = Ext.JSON.decode(response.responseText);
			if (responseData.response == "success") {
				var message = responseData.responseMessage;
				document.getElementById("addressSaveSuccess").innerHTML = message;
			} else {
				var message = responseData.responseMessage;
				document.getElementById("addressSaveError").innerHTML = message;
			}
		}
	}
	this.SaveAddressInformation = function() {
		var hotelName = Ext.get('hotelName').getValue();
		var hotelMasterId = Ext.get('masterId').getValue();
		var line1 = Ext.get('addressLine1').getValue();
		var line2 = Ext.get('addressLine2').getValue();
		var city = Ext.get('city').getValue();
		var state = Ext.get('state').getValue();
		var postalCode = Ext.get('postalCode').getValue();
		var country = Ext.get('country').getValue();
		Ext.Ajax.request( {
			url : "/TravelSite/saveAddressInformationForHotel.action",
			params : {
				method : 'saveAddressInformationForHotel',
				hotelMasterId : hotelMasterId,
				hotelName : hotelName,
				addressLine1 : line1,
				addressLine2 : line2,
				city : city,
				state : state,
				country : country,
				postalCode : postalCode
			},
			success : handleSuccessHotelAddressDataSave,
			failure : handleSaveFailure
		});
	}

	function handleSuccessHotelPolicyDataSave(response) {
		if (response.responseText !== undefined) {
			var responseData = Ext.JSON.decode(response.responseText);
			if (responseData.response == "success") {
				var message = responseData.responseMessage;
				document.getElementById("policySaveSuccess").innerHTML = message;
			} else {
				var message = responseData.responseMessage;
				document.getElementById("policySaveError").innerHTML = message;
			}
		}
	}

	this.SavePolicyInformation = function() {
		var hotelName = Ext.get('hotelName').getValue();
		var hotelMasterId = Ext.get('masterId').getValue();
		var policyName = Ext.get('policyNameId').getValue();
		var policyDesc = Ext.get('policyDescription').getValue();
		Ext.Ajax.request( {
			url : "/TravelSite/savePolicyInformationForHotel.action",
			params : {
				method : 'savePolicyInformationForHotel',
				hotelMasterId : hotelMasterId,
				hotelName : hotelName,
				policyName : policyName,
				policyDescription : policyDesc
			},
			success : handleSuccessHotelPolicyDataSave,
			failure : handleSaveFailure
		});
	}

	function handleSuccessPolicyChange(response) {
		if (response.responseText !== undefined) {
			var responseData = Ext.JSON.decode(response.responseText);
			var policyDesc = responseData.policyDesc;
			document.getElementById('policyDescription').value = policyDesc;
		}
	}
	this.selectedPolicyChanged = function() {
		var selectedPolicyName = Ext.get('policyNameId').getValue();
		var hotelMasterId = Ext.get('masterId').getValue();
		Ext.Ajax.request( {
			url : "/TravelSite/getSelectedPolicyInformationForHotel.action",
			params : {
				method : 'getSelectedPolicyInformationForHotel',
				hotelMasterId : hotelMasterId,
				policyName : selectedPolicyName
			},
			success : handleSuccessPolicyChange,
			failure : handleSaveFailure
		});
	}

	function handleSuccessFacilityChange(response) {
		if (response.responseText !== undefined) {
			var responseData = Ext.JSON.decode(response.responseText);
			var facilityDesc = responseData.facilityDesc;
			document.getElementById('facilityDescription').value = facilityDesc;
		}
	}
	this.selectedFacilityChanged = function() {
		var selectedFacilityName = Ext.get('facilityNameId').getValue();
		var hotelMasterId = Ext.get('masterId').getValue();
		Ext.Ajax.request( {
			url : "/TravelSite/getSelectedFacilityInformationForHotel.action",
			params : {
				method : 'getSelectedFacilityInformationForHotel',
				hotelMasterId : hotelMasterId,
				facilityName : selectedFacilityName
			},
			success : handleSuccessFacilityChange,
			failure : handleSaveFailure
		});
	}
	
	function handleSuccessHotelFacilityDataSave(response) {
		if (response.responseText !== undefined) {
			var responseData = Ext.JSON.decode(response.responseText);
			if (responseData.response == "success") {
				var message = responseData.responseMessage;
				document.getElementById("facilitySaveSuccess").innerHTML = message;
			} else {
				var message = responseData.responseMessage;
				document.getElementById("facilitySaveError").innerHTML = message;
			}
		}
	}
	this.SaveFacilityInformation = function() {
		var hotelName = Ext.get('hotelName').getValue();
		var hotelMasterId = Ext.get('masterId').getValue();
		var facilityName = Ext.get('facilityNameId').getValue();
		var facilityDesc = Ext.get('facilityDescription').getValue();
		Ext.Ajax.request( {
			url : "/TravelSite/saveFacilityInformationForHotel.action",
			params : {
				method : 'saveFacilityInformationForHotel',
				hotelMasterId : hotelMasterId,
				hotelName : hotelName,
				facilityName : facilityName,
				facilityDescription : facilityDesc
			},
			success : handleSuccessHotelFacilityDataSave,
			failure : handleSaveFailure
		});
	}
}