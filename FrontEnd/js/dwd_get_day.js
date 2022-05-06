var day = null;
const url = 'http://localhost:8080/dwd/date/';

$(document).ready(function(){
    $('#fecha').change(function(){
        $("#tb> tbody"). empty() //empty table
        var f = $('#fecha').val();
        day = f[8]+f[9]+"/"+f[5]+f[6]+"/"+f[0]+f[1]+f[2]+f[3];//format dd/mm/yyyy
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
                var table = document.getElementById('miTabla')//element html by iD
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
                table.appendChild(api)
            });
        })
        .catch(err => console.log(err));
    });
});