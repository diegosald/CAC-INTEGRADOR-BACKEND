// veo si vienen parametros - si es vienen es por que llame actualizar
const valores = window.location.search;
const urlParams = new URLSearchParams(valores);
const id = urlParams.get('id');
const titulo = urlParams.get('titulo');
const genero = urlParams.get('genero');
const precio = urlParams.get('precio');

if (id != null){
	document.getElementById("form-nuevo").className = "row";
	document.getElementById("form-action").setAttribute('action', 'ActJuego')
	document.getElementById("id-txt").className = "form-control" 
	document.getElementById("id-txt").value = id
	document.getElementById("titulo-txt").value = titulo
	document.getElementById("genero-txt").value = genero
	document.getElementById("precio-txt").value = precio
	document.getElementById("exampleModalLabel").innerHTML = "ACTUALIZA REGISTRO ID " + id
	
	var myModal = new bootstrap.Modal(document.getElementById('exampleModal'), {
            keyboard: false
        })
        
        myModal.show()
	
}



let datos;
/*function ajax() {
  // De esta forma se obtiene la instancia del objeto XMLHttpRequest
 
   connection = new XMLHttpRequest();
 
 
 
  // Preparando la función de respuesta
  connection.onreadystatechange = response;
 
  // Realizando la petición HTTP con método POST
  connection.open('GET', 'ListaDest');
  connection.send()
}
 
function response() {
  if(connection.readyState == 4) {
    datos =  JSON.parse(connection.responseText)
    alert(connection.responseText)
   for (i = 0 ; i < datos.length ; i++){
	     alert(datos[i]["id"] + " " + datos[i]["destino"])  
   } 
   
   
  }
 
}
   
ajax();

//alert(datos[0]["id"])

	*/

function abrirNuevo(){

	  document.getElementById("form-nuevo").className = "row" ;
	  document.getElementById("form-action").setAttribute('action', 'AddJuego')
	  document.getElementById("id-txt").className = "d-none"
	  document.getElementById("exampleModalLabel").innerHTML = "NUEVO REGISTRO"
	  var myModal = new bootstrap.Modal(document.getElementById('exampleModal'), {
            keyboard: false
        })
        
        myModal.show()
	  
	  
	  limpiarForm();

	}

	
function limpiarForm(){
	 document.getElementById("precio-txt").value = ""
	 document.getElementById("titulo-txt").value = ""
	 document.getElementById("genero-txt").value = ""
	 document.getElementById("id-txt").value = "d-none"
	 document.getElementById("id-txt").value = ""
}