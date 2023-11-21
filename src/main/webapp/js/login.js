const valores = window.location.search;
const urlParams = new URLSearchParams(valores);
const error = urlParams.get('mensaje');

if (error != null){
    document.getElementById("error").className = "d-flex"
    document.getElementById("error").innerHTML = "USUARIO Y CONTRASEÑA INCORRECTOS" 
    
}

