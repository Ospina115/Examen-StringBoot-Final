class RegisterForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <form>
                <h2>Registrar Insumos</h2>
                <label for="insumo">Insumo:</label>
                <input type="text" id="insumo" name="insumo" required>
                <button type="submit">Registrar</button>
            </form>
        `;
    }
}

class EditForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <form>
                <h2>Editar Insumos</h2>
                <label for="insumo">Insumo:</label>
                <input type="text" id="insumo" name="insumo" required>
                <button type="submit">Editar</button>
            </form>
        `;
    }
}

// Define other forms similarly...

customElements.define('register-form', RegisterForm);
customElements.define('edit-form', EditForm);
// Define otros componentes de formulario...

document.addEventListener("DOMContentLoaded", function() {
    const rightSection = document.querySelector('.right');

    document.querySelectorAll('button').forEach(button => {
        button.addEventListener('click', function() {
            const label = this.querySelector('.label').innerText.trim();
            rightSection.innerHTML = ''; // Limpiar la sección derecha

            switch (label) {
                case 'Registrar Insumos':
                    rightSection.appendChild(document.createElement('register-form'));
                    break;
                case 'Editar Insumos':
                    rightSection.appendChild(document.createElement('edit-form'));
                    break;
                // Agregar casos para otros formularios...
            }
        });
    });
});