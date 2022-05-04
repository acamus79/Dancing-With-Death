document.querySelector("#titulo").textContent = "EncriptAPP";
document.querySelector("#textoEncriptado").value = '';

var btnEncripta = document.querySelector("#btn-encriptar");
btnEncripta.onclick = encriptar;
var btnDesencripta = document.querySelector("#btn-desencriptar");
btnDesencripta.onclick = desencriptar;
var btnCopia = document.querySelector("#btn-copiar");
btnCopia.onclick = copiar;

function encriptar(){
    var texto = document.querySelector("#frase").value;
    texto = texto.normalize('NFD')
                 .replace(/([^n\u0300-\u036f]|n(?!\u0303(?![\u0300-\u036f])))[\u0300-\u036f]+/gi,"$1")
                 .normalize();
        //console.log(texto);

        if (texto === '') {
            alert("Ingrese una frase para Encriptar!")
        } else {
            var encriptado = texto
            .replace(/e/gi, "enter")
            .replace(/i/gi, "imes")
            .replace(/a/gi, "ai")
            .replace(/o/gi, "ober")
            .replace(/u/gi, "ufat");
            //console.log(encriptado);
            document.getElementById("textoEncriptado").style.background = "none";
            document.querySelector("#textoEncriptado").value = encriptado;
        }
        document.querySelector("#frase").value = '';
}

function desencriptar(){
    var texto = document.querySelector("#textoEncriptado").value;
    texto = texto.normalize('NFD')
                 .replace(/([^n\u0300-\u036f]|n(?!\u0303(?![\u0300-\u036f])))[\u0300-\u036f]+/gi,"$1")
                 .normalize();
        //console.log(texto);

        if (desencriptado === '') {
            alert("No exite texto para desencriptar");
        } else{
            var desencriptado = texto
                                    .replace(/enter/gi, "e")    
                                    .replace(/imes/gi, "i")
                                    .replace(/ai/gi, "a") 
                                    .replace(/ober/gi, "o")
                                    .replace(/ufat/gi, "u");
            //console.log(desencriptado);
            document.getElementById("textoEncriptado").style.background = "none";
            document.querySelector("#textoEncriptado").value = desencriptado;
        }
     
}

function copiar(){
    var copiado = document.getElementById('textoEncriptado');
    copiado.select();
    document.execCommand('copy');
    alert("Texto Copiado!")
}