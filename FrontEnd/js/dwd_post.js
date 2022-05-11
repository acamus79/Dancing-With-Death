const myForm = document.getElementById('myForm');
const urlPost = 'https://aec-dwd.herokuapp.com/dwd/new';

myForm.addEventListener('submit', function (e){
    e.preventDefault();
    $("#qrcode>").empty() //empty
    var nam = document.querySelector("#inputName");
    var mail = document.querySelector("#inputEmail");
    var f = document.querySelector("#inputDate");
    var day = f.value[8]+f.value[9]+"/"+f.value[5]+f.value[6]+"/"+f.value[0]+f.value[1]+f.value[2]+f.value[3];//format date dd/mm/yyyy
    var time = document.querySelector("#selectTime");
    
    fetch(urlPost,{
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify({dancingDate: day, dancingTime: time.value, name: nam.value, email: mail.value})
        }).then(res => res.json()).then(data => {
            var qr = document.getElementById('qrcode');
            if(!data.id == ''){
                qrCreate();
                jQuery('#qrcode').qrcode("https://acamus79.github.io/dwd/dwd_date?"+data.id);
                /*jQuery('#qrcode').qrcode({
                    width: 124, 
                    height: 124,
                    text: "Your appointment has been registered, iD: "+data.id
                });*/
                document.getElementById('msg').innerHTML = "<h5 style='color:darkgreen;'>you have a date with death</h5>";
                document.getElementById('msg2').innerHTML = "<input type='button' value='New Date' onclick='location.reload()' class='btn-outline-success p-1'></input>";
                $("#myForm>").empty() //empty
            }else if(!data.dancingTime == ''){
                error();
                qr.innerHTML = "<p>"+data.dancingTime+"</p>";
            }else if(!data.dancingDate == ''){
                error();
                qr.innerHTML = "<p>"+data.dancingDate+"</p>";
            }else if(!data.email == ''){
                error();
                qr.innerHTML = "<p>"+data.email+"</p>";
            }
        })
    .catch(err => console.log(err));
});

function qrCreate(){
    document.getElementById("qrcode").style.backgroundColor = "aliceblue";
    document.getElementById("qrcode").style.borderRadius = "15px";
    document.getElementById("qrcode").style.padding = "1em 1em 1em 1em";
    
}

function error(){
    document.getElementById("qrcode").style.backgroundColor = "indianred";
    document.getElementById("qrcode").style.borderRadius = "15px";
    document.getElementById("qrcode").style.textAlign = "center";
}