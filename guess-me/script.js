function fn1(){
var user_name=document.getElementById("name").value;

fetch("http://localhost:8080/start-game?username="+user_name,{
    method: "POST",
    headers: {
        Accept:"application/json",
        "Content-Type":"application/json"
    }
}).then(function(response){
    return response.json(); 
}).then(function(jsonData){
    console.log(jsonData);
    var jsonD=jsonData;
    // var id=jsonData.PromiseResult;
    // var idElement=document.createElement("h2");
    // idElement.innerHTML=jsonData;
    // document.body.appendChild(idElement);
    window.location= "guess.html?ID_Shown="+jsonD;
    window.getElementById("ID_Shown").value=jsonD;
    // console.log(id);
})
}

function fn2(){
    var id=document.getElementById("id").value;
    var guessNumber=document.getElementById("guessNumber").value;
    
    fetch("http://localhost:8080/guess?id="+id+"&guessNumber="+guessNumber,{
    method: "POST",
    headers: {
        Accept:"application/json",
        "Content-Type":"application/json"
    }
}).then(function(response){
    return response.text(); 
}).then(function(stringData){
    console.log(stringData);
    // var id=jsonData.PromiseResult;
    // var stringElement=document.createElement("h2");
    // alert(stringData);
    // stringElement.innerHTML=stringData;
    // document.body.appendChild(stringElement);
    document.getElementById("Response").value=stringData;
    // console.log(id);
})
}