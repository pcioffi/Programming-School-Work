(function (){
	
	var btn1 = document.getElementById("btn1");
	var btn2 = document.getElementById("btn2");
	
	
	var calculate1 = function(){
		var left = document.getElementById("left");
		var dml = left.getElementsByClassName("dev-money");
		var length = dml.length;
		var total = 0;
		
		for(var i = 0; i < length; i++){
		    total +=  Number(dml[i].innerHTML);
		}
		
		var answer = document.getElementById("answer1");
		answer.innerHTML = total;
	};
	
	
	var calculate2 = function(){
		var right = document.getElementById("right");
		var dmr = right.getElementsByClassName("dev-money");
		var length = dmr.length;
		var total = 0;
		
		for(var i = 0; i < length; i++){
		    total +=  Number(dmr[i].innerHTML);
		}
		
		var answer = document.getElementById("answer2");
		answer.innerHTML = total;
	};
	
	btn1.addEventListener("click", calculate1);
	btn2.addEventListener("click", calculate2);
	
})();