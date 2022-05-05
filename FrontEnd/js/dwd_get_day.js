var day = null;

//const app = document.querySelector("#inputDate");
const url = 'http://localhost:8080/dwd/date/';


$(document).ready(function(){
    
    $('#fecha').change(function(){
    
        $("#tb> tbody"). empty()

        //se asigna un id al input date y se obtiene el contenido
        var f = $('#fecha').val();
    //Se da el formato de acuerdo a las posiciones
        day = f[8]+f[9]+"/"+f[5]+f[6]+"/"+f[0]+f[1]+f[2]+f[3];
        
        //alert(day);

        fetch(url,{
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify({dancingDate: day})
        })
        .then(res => res.json())
        .then(data => {
            data.forEach(api => {
                //var y = new Date().getFullYear();//para obtener el año actual
                var table = document.getElementById('miTabla')//genero un elemento html segun su Id


                    for (var i = 0; i < data.length; i++)
                    {
                        var fila = 
                            `<tr>
                                <td>${i+1}</td>    
                                <td>${data[i].name}</td>
                                <td>${data[i].email}</td>
                                <td>${data[i].dancingDate}</td>
                                <td>${data[i].dancingTime}</td>
                            </tr>`
                    table.innerHTML += fila
                    }
                app.appendChild(api)
            });
        })
        .catch(err => console.log(err));
    });
});


/*
fetch(url+day)
    .then(res => res.json())
    .then(data => {
        data.forEach(api => {
            //var y = new Date().getFullYear();//para obtener el año actual
            var table = document.getElementById('miTabla')//genero un elemento html segun su Id
                for (var i = 0; i < data.length; i++)
                {
                    var fila = 
                        `<tr>
                            <td>${i+1}</td>    
                            <td>${data[i].name}</td>
                            <td>${data[i].email}</td>
                            <td>${data[i].dancingDate}</td>
                            <td>${data[i].dancingTime}</td>
                        </tr>`
                table.innerHTML += fila
                }
            app.appendChild(api)
        });
    })
    .catch(err => console.log(err));
*/
    function getDay(){

        alert(day);
    }