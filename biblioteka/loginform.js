const submitButton = document.querySelector("#login-button");
const registerButton = document.querySelector("#register-button")
const userInput = document.querySelector("#inputUsername");
const passwordInput = document.querySelector("#inputPassword");
const pTag = document.querySelector("#error-msg");

submitButton.addEventListener("click", e=>{
    
    e.preventDefault();
    username = userInput.value;
    password = passwordInput.value;
    
    getUser(username)
    .then(data=>{
       if(data.password != password){
        throw "wrong pass";
       } 
       else{
        sessionStorage.setItem('user', username);
        sessionStorage.setItem('id', data.id);
        
        document.location.href = "http://localhost:5050/userinterface.html";
       }
       
    })
    .catch(error=>{
        console.log(error);
        pTag.innerHTML = `<p class="none" style="color:red"><b>Username or password was incorect</b></p>`;
        userInput.value = "";
        passwordInput.value = "";
    })


});

registerButton.addEventListener("click",e=>{
    document.location.href = "http://localhost:5050/registration.html";
});