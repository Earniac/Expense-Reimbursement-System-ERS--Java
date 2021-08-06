console.log("in js file");


/*
	If you're confused on WHEN to use AJAX vs a FORM....use this guideline (not a rule, just a guide).
	
	If you're looking to change pages then consider a FORM.
	If you're looking for a JSON then consider an AJAX request.
*/

window.onload = function(){
	//document.getElementById("....stuff....").addEventListener("click", ajaxGetAllVills);

	ajaxGetAllVills();
}

function ajaxGetAllVills(){
	console.log("starting the ajax request");
	
	
	
	fetch('http://localhost:8080/ReimbursementApplication/app/userdeclined')
		.then(function(daResponse){
					const convertedResponse = daResponse.json();
					return convertedResponse;
				})
		.then(function(daSecondResponse){
					console.log(daSecondResponse);
					ourDOMManipulation(daSecondResponse);
					
				})
}

function ourDOMManipulation(ourJSON){
	//we are about to do some HEAVY DOM manipulation
	
	/*
		you COULD check to see if they are a employee or manager then dynamically add new buttons
		and/or html elements
	*/
	
	for(let i = 0; i< ourJSON.length; i++){
		////////////CREATE ELEMENTS DYNAMICALLY////////////////
		
		//step1: creating our new element
		let newTR = document.createElement("tr");
		let newTH = document.createElement("td");
		let newTD1 = document.createElement("td");
		let newTD2 = document.createElement("td");
		let newTD3 = document.createElement("td");
		let newTD4 = document.createElement("td");
		let newTD5 = document.createElement("td");
		let newTD6 = document.createElement("td");
		let newTD7 = document.createElement("td");
		
		
		
		//step 2: populate creations
		newTH.setAttribute("scope", "row");
		let myTextH = document.createTextNode(ourJSON[i].id);
		let myTextD1 = document.createTextNode(ourJSON[i].username);
		let myTextD2 = document.createTextNode(ourJSON[i].reimburseDescrip);
		let myTextD3 = document.createTextNode(ourJSON[i].reimburseType);
		let myTextD4 = document.createTextNode(ourJSON[i].status);
		let myTextD5 = document.createTextNode(ourJSON[i].resolvedBy);
		let myTextD6 = document.createTextNode(ourJSON[i].time_submitted);
		let myTextD7 = document.createTextNode(ourJSON[i].resolved_time);
		
		
		//all appending
		newTH.appendChild(myTextH);
		newTD1.appendChild(myTextD1);
		newTD2.appendChild(myTextD2);
		newTD3.appendChild(myTextD3);
		newTD4.appendChild(myTextD4);
		newTD5.appendChild(myTextD5);
		newTD6.appendChild(myTextD6);
		newTD7.appendChild(myTextD7);
		
		
		
		
		newTR.appendChild(newTH);
		newTR.appendChild(newTD1);
		newTR.appendChild(newTD2);
		newTR.appendChild(newTD3);
		newTR.appendChild(newTD4);
		newTR.appendChild(newTD5);
		newTR.appendChild(newTD6);
		newTR.appendChild(newTD7);
		
				
		let newSelection = document.querySelector("#myReimbursement");
		newSelection.appendChild(newTR);

	}
}







