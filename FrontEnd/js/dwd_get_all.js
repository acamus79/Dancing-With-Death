const app = document.querySelector('.container');
const url = 'http://localhost:8080/dwd/all';
    
    fetch(url)
    .then(res => res.json())
    .then(data => {
        data.forEach(api => {
            //var y = new Date().getFullYear();//para obtener el año actual
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
            app.appendChild(api)
        });
    })
    .catch(err => console.log(err));