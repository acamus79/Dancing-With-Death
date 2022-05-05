//const app = document.querySelector('.container');
const url = 'http://localhost:8080/dwd/new';

const btnDay = document.querySelector("#dwdBtn");
btnDay.onclick = postAppointment; 

function postAppointment(){

    var f = document.querySelector("#inputDate").value;
    var day = f[8]+f[9]+"/"+f[5]+f[6]+"/"+f[0]+f[1]+f[2]+f[3];

    var time = document.querySelector("#selectTime");

    fetch(url,{
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify({dancingDate: day,
                              dancingTime: time,
                              name:	nam,
                              email: mail
                            })
        }).then(res => res.json()).then(data => {
            
        })
    .catch(err => console.log(err));


    document.getElementById("textoEncriptado").style.background = "none";
}