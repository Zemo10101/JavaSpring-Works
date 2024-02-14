  
  var c = 0;
  var punteggio=0;
  var punteggioMax=0;
  var TOTquiz=0;
  
  var tempo;
  var tempoRimanente = 0;
  var tempoMassimo = 30;
  
 var timer = document.getElementById('timer');
  var punteggioLabel = document.getElementById("punteggio");
  
  var domandeLabel =document.getElementById("domande");
  
 var btnGioca = document.getElementById('giocaBtn');
 
 var btnRispondi = document.getElementById('rispondiBtn');
 
 var btnRiprova = document.getElementById('riprovaBtn');
 
 var avviso = document.getElementById('avviso'); 
 
  btnRispondi.style.display='none';
        btnRiprova.style.display='none';
 
 window.onload =(() => {
	 
	 fetch("/visualizza/durata",{
		method: "get",
		headers: {
			'content-type':'application/json'
		}
	}).then(response => response.json() )
	       .then(data =>{TOTquiz=data
	       console.log(data);
	       
	       if(TOTquiz<5){	
			   
        btnGioca.style.display='none';
        avviso.innerHTML='OPSS!! <br> Sembrerebbe non siano stati inseriti abbastanza Quiz, <br> Inserirne almeno 5! <br> <br> Per inserire i tuoi Quiz accedi come ADMIN,<br> e vai sulla pagina Inserisci Quiz';
        
      document.getElementById('quizInseriti').innerHTML='Quiz Inseriti: '+TOTquiz;
       
    }
    else{
		
		avviso.innerHTML='';
		btnGioca.style.display='block';
	}
	 
 });
 
 });
 

  btnGioca.onclick = function(event){
	 event.preventDefault();
	 switchBtn();
	 ottieniquiz();
	 tempoRimanente = tempoMassimo;
	 aggiornaTimer();
	 time();
 };
 
 btnRispondi.onclick = function(event){
	 event.preventDefault();
	 ottieniquiz();
	 c++;
	 
	var radioSelect = document.getElementsByName('opzioni');

   for (var i = 0; i < radioSelect.length; i++) {
    if (radioSelect[i].checked && radioSelect[i].value === 'true') {
            punteggio++;
      }
 }
                	 
 };
 
 btnRiprova.onclick = function(event){
	 event.preventDefault();
	 c=0;
	 punteggio=0;
	 ottieniquiz();
	 switchBtn3();
	 tempoRimanente = tempoMassimo;
	 aggiornaTimer();
	 time();
	 
 };

function ottieniquiz(){
	
	
	fetch("/visualizza/listaDomande",{
		method: "post",
		headers: {
			'content-type':'application/json'
		}	
	}).then(response => response.json())
	       .then(data =>{   
              console.log(data);
			  domandeLabel.innerHTML=data.testo;
           });

 var list1 = document.getElementById("risposte");
 list1.style.display='block';
 
   fetch("/visualizza/listaRisposte",{
	   method: "post", 
		headers: {
			'content-type':'application/json'
		}
	}).then(response => response.json())
	       .then(data =>{
			   list1.textContent='';
			 data.forEach(function(ele){
				 
				 if(c<TOTquiz){
		        
				 var contenitore= document.createElement('li');
				 contenitore.className='ele';
				 var radio= document.createElement('input');
				 radio.type='radio';
				 radio.name='opzioni';
				 radio.value=ele.val;
				 contenitore.textContent = ele.testo;
				 list1.appendChild(contenitore);
				 contenitore.appendChild(radio);	
				 
				 
				  } else{
					 domandeLabel.textContent='';
					  punteggioLabel.innerHTML=" Punteggio Quiz:  "+ punteggio+" su "+TOTquiz;
					  punteggioLabel.style.display='block';
					 switchBtn2();
					 clearTimeout(tempo);
					 timer.style.display='none';
				 }
					 
				 });
				 	 
		      
			 });  	
};
	   

function switchBtn(){

   var btn1 = document.getElementById('giocaBtn');
    var btn2 = document.getElementById('rispondiBtn');

        if(btn1.style.display === 'none'){
			btn1.style.display='block';
			btn2.style.display='none';
		} else{
			btn1.style.display='none';
			btn2.style.display='block';		
		}
};

function switchBtn2(){

   var btn1 = document.getElementById('rispondiBtn');
    var btn2 = document.getElementById('riprovaBtn');
   btn1.style.display='block';
   
        if(btn1.style.display === 'none'){
			btn1.style.display='block';
			btn2.style.display='none';
		} else{
			btn1.style.display='none';
			btn2.style.display='block';		
		}
};

function switchBtn3(){

   var btn1 = document.getElementById('riprovaBtn');
    var btn2 = document.getElementById('rispondiBtn');
   btn1.style.display='block';
   
        if(btn1.style.display === 'none'){
			btn1.style.display='block';
			btn2.style.display='none';
		} else{
			btn1.style.display='none';
			btn2.style.display='block';	
			punteggioLabel.style.display='none';	
		}
};

  
function time(){
	
	timer.style.display='block';
	
	if (tempoRimanente > 0) {
         tempo = setTimeout(function() {
            tempoRimanente--;
            aggiornaTimer(); 
            if (tempoRimanente <= 0) {
                
                terminaQuiz();
            } else {
                
                time();
            }
        }, 1000); 
    }
}
	  

function terminaQuiz() {
    
    switchBtn2();
    
    domandeLabel.textContent='';
    document.getElementById("risposte").style.display='none';
    
    punteggioLabel.innerHTML = "Tempo scaduto! Punteggio Quiz: " + punteggio + " su " + TOTquiz;
    punteggioLabel.style.display = 'block';
    
}

function aggiornaTimer() {
    
    timer.textContent = 'Tempo rimanente: ' + tempoRimanente + ' secondi';
}

