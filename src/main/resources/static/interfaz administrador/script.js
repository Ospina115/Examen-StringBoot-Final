class CiudadForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Ciudades</h2>
                <ul id="ciudades-list"></ul>
            </div>
            <div>
                <h2>Agregar Ciudad</h2>
                <input type="text" id="nombre-ciudad" placeholder="Nombre de la ciudad" />
                <input type="number" id="id-region" placeholder="ID de la region" />
                <button onclick="createCiudad()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Ciudad</h2>
                <input type="number" id="id-ciudad" placeholder="ID de la ciudad" />
                <input type="text" id="nuevo-nombre-ciudad" placeholder="Nuevo nombre de la ciudad" />
                <input type="number"  id="nuevo-id-region" placeholder="Nuevo ID de la region" />
                <button onclick="updateCiudad()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Ciudad</h2>
                <input type="number" id="eliminar-id-ciudad" placeholder="ID de la ciudad" />
                <button onclick="deleteCiudad()">Eliminar</button>
            </div> 
        </div>
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

class PaisForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Países</h2>
                <ul id="paises-list"></ul>
            </div>
            <div>
                <h2>Agregar País</h2>
                <input type="text" id="nombre-pais" placeholder="Nombre del país" />
                <button onclick="createPais()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar País</h2>
                <input type="number" id="id-pais" placeholder="ID del país" />
                <input type="text" id="nuevo-nombre-pais" placeholder="Nuevo nombre del país" />
                <button onclick="updatePais()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar País</h2>
                <input type="number" id="eliminar-id-pais" placeholder="ID del país" />
                <button onclick="deletePais()">Eliminar</button>
            </div>  
        </div>
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

class RegionForm extends HTMLElement {
        connectedCallback() {
            this.innerHTML = `<div class="form">
            <div>
                <h2>Lista de Regiones</h2>
                <ul id="regiones-list"></ul>
            </div>
            <div>
                <h2>Agregar Región</h2>
                <input type="text" id="nombre-region" placeholder="Nombre de la región" />
                <button onclick="createRegion()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Región</h2>
                <input type="number" id="id-region" placeholder="ID de la región" />
                <input type="text" id="nuevo-nombre-region" placeholder="Nuevo nombre de la región" />
                <button onclick="updateRegion()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Región</h2>
                <input type="number" id="eliminar-id-region" placeholder="ID de la región" />
                <button onclick="deleteRegion()">Eliminar</button>
            </div> 
        </div>
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

customElements.define('ciudad-form', CiudadForm);
customElements.define('pais-form', PaisForm);
customElements.define('region-form', RegionForm);
// Define otros componentes de formulario...

document.addEventListener("DOMContentLoaded", function() {
    const rightSection = document.querySelector('.right');

    document.querySelectorAll('button').forEach(button => {
        button.addEventListener('click', function() {
            const label = this.querySelector('.label').innerText.trim();
            rightSection.innerHTML = ''; // Limpiar la sección derecha

            switch (label) {
                case 'Ciudades':
                    rightSection.appendChild(document.createElement('ciudad-form'));
                    break;
                case 'Paises':
                    rightSection.appendChild(document.createElement('pais-form'));
                    break;
                case 'Regiones':
                    rightSection.appendChild(document.createElement('region-form'));
                    break;
                // AGREGAR LOS OTROS CASOS DE LOS WEB COMPONENTS
            }
        });
    });
});