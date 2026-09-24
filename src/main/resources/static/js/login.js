document.getElementById("formLogin").addEventListener("submit", function(event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const btnSubmit = document.getElementById("login-btn");

    btnSubmit.disabled = true;
    btnSubmit.innerText = "Entrando...";

    const credentials = btoa(`${username}:${password}`);

    fetch("/usuarios", {
        method: "POST",
        headers: {
            "Authorization": `Basic ${credentials}`
        }
    })
    .then(response => {
        if (response.ok) {
            window.location.href = "/produtos";
        } else {
            alert("Usuário ou senha inválidos.");
        }
    })
    .catch(error => {
        console.error("Erro de conexão:", error);
        alert("Não foi possível conectar ao servidor. Tente novamente.");
    })
    .finally(() => {
        btnSubmit.disabled = false;
        btnSubmit.innerText = "Entrar";
    });
});