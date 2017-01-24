/**
 * 
 */


function loadFile(fileinput, table) {
	var input, file, fr;
	
	if (typeof window.FileReader !== 'function') {
      alert("The file API isn't supported on this browser yet.");
      return;
    }

    input = document.getElementById(fileinput);
    if (!input) {
      alert("Fileinput element not found.");
    }
    else if (!input.files) {
      alert("This browser doesn't seem to support the `files` property of file inputs.");
    }
    else if (!input.files[0]) {
      alert("Please select a file before clicking 'Load'");
    }
    else {
    	file = input.files[0];
        fr = new FileReader();
        fr.onload = (function(f){
        	return function(e) {
        		var format = "<tr><td>Name</td><td>DOB</td><td>SSN</td></tr>"
        		document.getElementById(table).innerHTML = format;
        		var data = JSON.parse(e.target.result);
        		
        		var t = "";
            	for (var i = 0; i < data.length; i++) {
            		var tr = "<tr>";
            		tr += "<td>"+data[i].name.firstName+" "+data[i].name.lastName+"</td>";
            		tr += "<td>"+data[i].dob+"</td>";
            		tr += "<td>"+data[i].ssn+"</td>";
            		tr += "</tr>";
            		t += tr;
            	}
            	document.getElementById(table).innerHTML += t;
        	};
        })(file);
        fr.readAsText(file);
        compareTables();
    }

    function compareTables() {
    	//compare tables and highlight differences
    }
	  
}

