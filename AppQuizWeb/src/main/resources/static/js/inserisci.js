
var btnSalva= document.getElementById('salva');

btnSalva.onclick = function(event){
	 event.preventDefault();
	 inserisci();
	 
 };

function inserisci() {
           
           
            var d1 = document.getElementById('d1').value;
            var r1 = document.getElementById('r1').value;
            var r2 = document.getElementById('r2').value;
            var r3 = document.getElementById('r3').value;
            var r4 = document.getElementById('r4').value;
            
            var val1=false;
            var val2=false;
            var val3=false;
            var val4=false;

           
            var radioButtons = document.getElementsByName('radio');
       
            for (var i = 0; i < radioButtons.length; i++) {
                if (radioButtons[i].checked) {
                    if(radioButtons[i].value==='1'){
						val1=true;
					}
					else if(radioButtons[i].value==='2'){
						val2=true;
					} 
					else if(radioButtons[i].value==='3'){
						val3=true;
					}
					else if(radioButtons[i].value==='4'){
						val4=true;
					}
                }
            }
            
            let objR={
            
           d1: d1,
            r1: r1,
            r2: r2,
           r3: r3,
          r4: r4,
            
            val1: val1,
             val2: val2,
             val3: val3,
              val4: val4
          };     
               console.log(objR);

            fetch("/invio",{
				
				method:"post",
				
				headers: {
			'content-Type':'application/json;charset=UTF-8'
		       },
		       
		       body: JSON.stringify(objR)
		       
			}).then(response =>{
				location.reload();
				
			}).catch(error => console.error('Error: ', error));
			
				
		
        }
  
