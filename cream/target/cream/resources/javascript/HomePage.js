/**
 * 
 */

var ourRequest = new XMLHttpRequest();
var url = "http://localhost:8080/cream/get.user.login";
//var url = "https://pokeapi.co/api/v2/pokemon/5";
	ourRequest.open('Get',url);
	
	ourRequest.onload = function(){
		console.log("in onload function");
		var ourData = JSON.parse(ourRequest.responseText);
		console.log("fishing");
		//console.log(ourData.name);
	};

	ourRequest.send();