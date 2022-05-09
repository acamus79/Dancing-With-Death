const url = 'https://aec-dwd.herokuapp.com/dwd/'+window.location.search.replace('?','');
const urlPut = 'https://aec-dwd.herokuapp.com/dwd/update';
const myForm = document.getElementById('myForm');

fetch(url)
        .then(res => res.json()).then(objet => {
            var date = document.getElementById('date');
            if(!objet.name == ''){
                document.getElementById('msg').innerHTML = "<span style='color:darkgreen;'>"+objet.id+"</span>";
                document.getElementById('msg2').innerHTML = "<span style='color:darkgreen;'>"+objet.name+"</span>";
                document.getElementById('msg3').innerHTML = "<span style='color:darkgreen;'>"+objet.email+"</span>";
            }else{
                error();
                date.innerHTML = "<p>Appointment does not exist</p>";
            }
        })
    .catch(err => console.log(err));

/* - PUT - */
myForm.addEventListener('submit', function (e){
    e.preventDefault();
    $("#date>").empty() //empty
    let someData = {
        id: window.location.search.replace('?',''),
        name: document.querySelector('#inputName').value,
        email: document.querySelector('#inputEmail').value
    };

    const putMethod = {
        method: 'PUT',
        headers: {
        'Content-type': 'application/json; charset=UTF-8' // Indicates the content 
        },
        body: JSON.stringify(someData) // We send data in JSON format
    };

    fetch(urlPut, putMethod)
        .then(response => response.json())
        .then(data => {
            if(!data.name==''){
                pointCreate();
            }else{
                error();
                console.log(data);
            }
    }).catch(err => console.log(err)) // Do something with the error
});

function pointCreate(){
    document.getElementById("date").style.backgroundColor = "darkgreen";
    document.getElementById("date").style.borderRadius = "15px";
    document.getElementById("date").style.padding = "1em 1em 1em 1em";
    document.getElementById("date").style.textAlign = "center";
    document.getElementById("date").innerHTML = "<h5 style='color:black;'>Update!</h5><hr><input type='button' value='Reload' onclick='location.reload()' class='btn-outline-success p-2'></input>";
}

function error(){
    document.getElementById("date").style.backgroundColor = "indianred";
    document.getElementById("date").style.borderRadius = "15px";
    document.getElementById("date").style.textAlign = "center";
    document.getElementById("date").innerHTML = "<h5 style='color:black;'>Error!</h5><hr><input type='button' value='Reload' onclick='location.reload()' class='btn-outline-success p-2'></input>";
}