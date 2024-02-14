

window.onload = (() =>{
	
	generaAllQuiz();
	
});

var radioSelect = document.getElementsByName('opzioni');

var btnCancella= document.getElementById('cancella');

 btnCancella.onclick = function(event){
	 event.preventDefault();
	 
    var almenoUnaSelezionata = false;

    for (var i = 0; i < radioSelect.length; i++) {
        if (radioSelect[i].checked) {
            almenoUnaSelezionata = true;
            break;
        }
    }

    if (almenoUnaSelezionata) {
        
        EliminaQuiz();
        
    } else {
       
        alert("Seleziona almeno un quiz prima di procedere.");
        
    }
	 
 };
 
 

function generaAllQuiz(){
	
	n=1;
	
	var box = document.getElementById("box");
	box.className="box";
	
	fetch("/cancella/load",{
		 method: "get", 
		headers: {
			'content-type':'application/json'
		}
	}).then(response => response.json())
	       .then(data =>{
			  
	
	 data.forEach(function(ele){
		 
		 var label = document.createElement("label");
		 label.textContent = ele.testo;
		 
			 var eleBox = document.createElement("div");
			 eleBox.className='eleBox';
			 
		    var label2 = document.createElement("label");
		     box.appendChild(document.createElement("br"));
			 box.appendChild(document.createElement("br"));
			 box.appendChild(document.createElement("br"));
			 label2.textContent = "Quiz numero: "+(n);
			 
			  var radio= document.createElement("input");
			  radio.type="radio";
			  radio.name='opzioni';
			  radio.value=ele.idDomande;
			 label2.appendChild(radio)
			 
			  eleBox.appendChild(label2);
			   eleBox.appendChild(label);
			  box.appendChild(eleBox);
			  
			n++; 
		 
		 });
	
	
});

}

function EliminaQuiz(){
	
	
    var id;
    
   for (var i = 0; i < radioSelect.length; i++) {
    if (radioSelect[i].checked) {
          id = radioSelect[i].value;
      }
    }
      console.log(id);
      
      fetch("/cancella/delete",{
				
				method:"post",
				
				headers: {
			'content-Type':'application/json'
		       },
		       
		       body: JSON.stringify(id)
		       
			}).then(response =>{
				
				location.reload();
				
			}).catch(error => console.error('Error: ', error));

  
}
