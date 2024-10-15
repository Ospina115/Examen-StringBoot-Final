// POS SI NO SE HA LLENADO TODO DEL FORMULARIO
const crearCuentaButton = document.querySelector('.create-account');

crearCuentaButton.addEventListener('click', (e) => {

    e.preventDefault();
    const inputs = document.querySelectorAll('.form-group input, .form-group select');

    let formularioValido = true;
    inputs.forEach((input) => {
        if (input.value.trim() === '') {
            input.classList.add('error');
            formularioValido = false;
            
        } else {
            input.classList.remove('error');
        }
    });

    if (formularioValido) {
    // AQUI VA LA LOGICA PARA ENVIAR EL FORMULARIO
    console.log('Formulario válido');
    } else {
    console.log('Formulario inválido');
    }

});


// POR SI LAS CONTRASEÑAS NO COINCIDEN
const passwordInput = document.querySelector('input[placeholder="Contraseña"]');
const repeatPasswordInput = document.querySelector('input[placeholder="Repetir Contraseña"]');

crearCuentaButton.addEventListener('click', (e) => {

    if (passwordInput.value !== repeatPasswordInput.value) {
        passwordInput.classList.add('error');
        repeatPasswordInput.classList.add('error');
        formularioValido = false;
    } else {
        passwordInput.classList.remove('error');
        repeatPasswordInput.classList.remove('error');
    }

});