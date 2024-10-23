class RegisterForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <form id="register-form">
            <h2>Registrar Insumo</h2>
            <input placeholder="Codigo Interno" type="text" id="insumo" name="insumo" required>
            <input placeholder="Nombre del Insumo" type="text" id="nombre" name="nombre">
            <input placeholder="Valor Unidad" type="number" id="precio" name>
            <input placeholder="Cantidad" type="number" id="cantidad" name>
            <input placeholder="Stock Minimo" type="number" id="stock_min" name>
            <input placeholder="Stock Maximo" type="number" id="stock_max" name>
            <div class="buttons">
                <button type="submit">Registrar</button>
                <button type="button" id="clear-button">Limpiar</button>        
            </div>

        </form>
        `;

        this.querySelector('#clear-button').addEventListener('click', () => {
            this.resetForm();
        });
    }

    resetForm() {
        const form = this.querySelector('#register-form');
        form.reset(); // Resetea todos los campos del formulario
    }
}

class EditForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <form id="edit-form">
                <h2>Editar Insumos</h2>
                <input placeholder="Codigo Interno" type="text" id="insumo" name="insumo" required>
                <input placeholder="Nombre del Insumo" type="text" id="nombre" name="nombre">
                <input placeholder="Valor Unidad" type="number" id="precio" name>
                <input placeholder="Cantidad" type="number" id="cantidad" name>
                <input placeholder="Stock Minimo" type="number" id="stock_min" name>
                <input placeholder="Stock Maximo" type="number" id="stock_max" name>    
                <div class="buttons">
                    <button type="submit">Editar</button>
                    <button type="button" id="clear-button">Limpiar</button>        
                </div>
            </form>
        `;

        this.querySelector('#clear-button').addEventListener('click', () => {
            this.resetForm();
        });
    }

    resetForm() {
        const form = this.querySelector('#edit-form');
        form.reset(); // Resetea todos los campos del formulario
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