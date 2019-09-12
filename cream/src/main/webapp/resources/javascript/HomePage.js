/**
 * 
 */
window.onload = function(){
	
	//using ajax
	/*let ourRequest = new XMLHttpRequest();
	var url = "http://localhost:8080/cream/user.get";
	ourRequest.open('Get',url);
		
	ourRequest.onload = function(){
		console.log("window onload function again");
		let ourData = JSON.parse(ourRequest.responseText);
		console.log("fishing");//
		console.log(ourData.userName);
		ourDOMManipulation(ourData);
		};
		
	ourRequest.send();
	*/

//-----------------------ajaxquery way---------------------- 
	
/*	function handlerError(jqXHR, textStatus, error){
		console.log(error);
	}//end of handlerError function 
	
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/cream/user.get",
		success: cbProducts,
		error: handlerError
	});
	
	function cbProducts(data){
		console.log(data);
		
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/cream/product.get",
			success: print,
			error: handlerError
		});
	}//end of cbProducts functions 
	
	function print(data){
		console.log(data);
	}//end of print function
*/
	
//-----------------using promises-------------------
	function get (url){
		return new Promise(function(resolve, reject){
			let xhttp = new XMLHttpRequest();
			
			xhttp.open("GET",url,true);
			xhttp.onload = function(){
				if(xhttp.readyState==4 && xhttp.status == 200){
					resolve(JSON.parse(xhttp.response));
				}else{//end of if block
					reject(xhttp.statusText);
				}//end of else block
			};//end of onload = function block
			xhttp.send();
		});//end of Promise(function(resolve, reject) block
	}//end of get function
	
let promise = get("http://localhost:8080/cream/user.get");

promise.then(function(user){
	console.log(user);
	
	return get("http://localhost:8080/cream/product.get");
})//end of then block
.then(function(products){
	console.log(products);
})//end of then block
.catch(function (error){
	console.log(error);
});//end of catch block
	
	
};//end of window.onload function

/*function ourDOMManipulation(user){
	//display username on login button
	loginDOMManipulation(user);
}

function loginDOMManipulation(user){
	console.log('inside loginDOMManipulation');
	let profileName = user.userName;
	let profileButton = document.getElementById('login_button');
	profileButton.textContent = profileName;

}//end of loginDOMManipulation
*/