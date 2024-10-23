// CREACION DE LOS WEB COMPONENTS DE TODAS LAS TABLAS PARA QUE LAS EDITE EL ADMINISTRADOR
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
        <button onclick="createCiudad()">Agregar</button>
        </div>
        <div>
        <h2>Actualizar Ciudad</h2>
        <input type="number" id="id-ciudad" placeholder="ID de la ciudad" />
        <input type="text" id="nuevo-nombre-ciudad" placeholder="Nuevo nombre de la ciudad" />
        <button onclick="updateCiudad()">Actualizar</button>
        </div>
        <div>
        <h2>Eliminar Ciudad</h2>
        <input type="number" id="eliminar-id-ciudad" placeholder="ID de la ciudad" />
        <button onclick="deleteCiudad()">Eliminar</button>
        </div>
    </div>
    `;

    this.loadCiudades();
}

async loadCiudades() {
    const response = await fetch('http://localhost:8080/api/v1/ciudades'); // URL de la API
    const ciudades = await response.json();
    const ciudadesList = this.querySelector('#ciudades-list');
    ciudadesList.innerHTML = ciudades.map(ciudad => `<li>${ciudad.nombre} (ID: ${ciudad.id})</li>`).join('');
}

async createCiudad() {
    const nombre = this.querySelector('#nombre-ciudad').value;
    await fetch('http://localhost:8080/api/v1/ciudades', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ nombre: nombre })
    });
    await this.loadCiudades(); // Recargar la lista después de agregar
}

async updateCiudad() {
    const id = this.querySelector('#id-ciudad').value;
    const nuevoNombre = this.querySelector('#nuevo-nombre-ciudad').value;
    await fetch(`http://localhost:8080/api/v1/ciudades/${id}`, {
    method: 'PUT',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ nombre: nuevoNombre })
    });
    await this.loadCiudades(); // Recargar la lista después de actualizar
}

async deleteCiudad() {
    const id = this.querySelector('#eliminar-id-ciudad').value;
    await fetch(`http://localhost:8080/api/v1/ciudades/${id}`, {
    method: 'DELETE'
    });
    await this.loadCiudades(); // Recargar la lista después de eliminar
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
                <button id="btn-agregar-pais">Agregar</button>
            </div>
            <div>
                <h2>Actualizar País</h2>
                <input type="number" id="id-pais" placeholder="ID del país" />
                <input type="text" id="nuevo-nombre-pais" placeholder="Nuevo nombre del país" />
                <button id="btn-actualizar-pais">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar País</h2>
                <input type="number" id="eliminar-id-pais" placeholder="ID del país" />
                <button id="btn-eliminar-pais">Eliminar</button>
            </div>
        </div>
        `;

        this.loadPaises();

        // Event listeners
        this.querySelector('#btn-agregar-pais').addEventListener('click', () => this.createPais());
        this.querySelector('#btn-actualizar-pais').addEventListener('click', () => this.updatePais());
        this.querySelector('#btn-eliminar-pais').addEventListener('click', () => this.deletePais());
    }

    async loadPaises() {
        const response = await fetch('http://localhost:8080/api/v1/paises'); // URL de la API
        const paises = await response.json();
        const paisesList = this.querySelector('#paises-list');
        paisesList.innerHTML = paises.map(pais => `<li>${pais.nombre} (ID: ${pais.id})</li>`).join('');
    }

    async createPais() {
        const nombre = this.querySelector('#nombre-pais').value;
        await fetch('http://localhost:8080/api/v1/paises', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nombre })
        });
        await this.loadPaises(); // Recargar la lista después de agregar
    }

    async updatePais() {
        const id = this.querySelector('#id-pais').value;
        const nuevoNombre = this.querySelector('#nuevo-nombre-pais').value;
        await fetch(`http://localhost:8080/api/v1/paises/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nuevoNombre })
        });
        await this.loadPaises(); // Recargar la lista después de actualizar
    }

    async deletePais() {
        const id = this.querySelector('#eliminar-id-pais').value;
        await fetch(`http://localhost:8080/api/v1/paises/${id}`, {
            method: 'DELETE'
        });
        await this.loadPaises(); // Recargar la lista después de eliminar
    }
}
class RegionForm extends HTMLElement { 
    connectedCallback() { 
        this.innerHTML = ` 
        <div class="form"> 
            <div> 
                <h2>Lista de Regiones</h2> 
                <ul id="regiones-list"></ul> 
            </div> 
            <div> 
                <h2>Agregar Región</h2> 
                <input type="text" id="nombre-region" placeholder="Nombre de la región" /> 
                <button id="btn-agregar-region">Agregar</button> 
            </div> 
            <div> 
                <h2>Actualizar Región</h2> 
                <input type="number" id="id-region" placeholder="ID de la región" /> 
                <input type="text" id="nuevo-nombre-region" placeholder="Nuevo nombre de la región" /> 
                <button id="btn-actualizar-region">Actualizar</button> 
            </div> 
            <div> 
                <h2>Eliminar Región</h2> 
                <input type="number" id="eliminar-id-region" placeholder="ID de la región" /> 
                <button id="btn-eliminar-region">Eliminar</button> 
            </div> 
        </div> 
        `; 

        this.loadRegiones(); 

        // Event listeners 
        this.querySelector('#btn-agregar-region').addEventListener('click', () => this.createRegion()); 
        this.querySelector('#btn-actualizar-region').addEventListener('click', () => this.updateRegion()); 
        this.querySelector('#btn-eliminar-region').addEventListener('click', () => this.deleteRegion()); 
    } 

    async loadRegiones() { 
        const response = await fetch('http://localhost:8080/api/v1/regiones'); // URL de la API 
        const regiones = await response.json(); 
        const regionesList = this.querySelector('#regiones-list'); 
        regionesList.innerHTML = regiones.map(region => `<li>${region.nombre} (ID: ${region.id})</li>`).join(''); 
    } 

    async createRegion() { 
        const nombre = this.querySelector('#nombre-region').value; 
        await fetch('http://localhost:8080/api/v1/regiones', { 
            method: 'POST', 
            headers: { 
                'Content-Type': 'application/json' 
            }, 
            body: JSON.stringify({ nombre: nombre }) 
        }); 
        await this.loadRegiones(); // Recargar la lista después de agregar 
    } 

    async updateRegion() { 
        const id = this.querySelector('#id-region').value; 
        const nuevoNombre = this.querySelector('#nuevo-nombre-region').value; 
        await fetch(`http://localhost:8080/api/v1/regiones/${id}`, { 
            method: 'PUT', 
            headers: { 
                'Content-Type': 'application/json' 
            }, 
            body: JSON.stringify({ nombre: nuevoNombre }) 
        }); 
        await this.loadRegiones(); // Recargar la lista después de actualizar 
    } 

    async deleteRegion() { 
        const id = this.querySelector('#eliminar-id-region').value; 
        await fetch(`http://localhost:8080/api/v1/regiones/${id}`, { 
            method: 'DELETE' 
        }); 
        await this.loadRegiones(); // Recargar la lista después de eliminar 
    } 
} 
class DireccionForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Direcciones</h2>
                <ul id="direcciones-list"></ul>
            </div>
            <div>
                <h2>Agregar Dirección</h2>
                <input type="text" id="calle" placeholder="Calle" />
                <input type="text" id="numero" placeholder="Número" />
                <input type="text" id="ciudad" placeholder="Ciudad" />
                <input type="text" id="provincia" placeholder="Provincia" />
                <input type="text" id="pais" placeholder="País" />
                <button id="btn-agregar-direccion">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Dirección</h2>
                <input type="number" id="id-direccion" placeholder="ID de la dirección" />
                <input type="text" id="nueva-calle" placeholder="Nueva calle" />
                <input type="text" id="nuevo-numero" placeholder="Nuevo número" />
                <input type="text" id="nueva-ciudad" placeholder="Nueva ciudad" />
                <input type="text" id="nueva-provincia" placeholder="Nueva provincia" />
                <input type="text" id="nuevo-pais" placeholder="Nuevo país" />
                <button id="btn-actualizar-direccion">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Dirección</h2>
                <input type="number" id="eliminar-id-direccion" placeholder="ID de la dirección" />
                <button id="btn-eliminar-direccion">Eliminar</button>
            </div>
        </div>
        `;

        this.loadDirecciones();

        // Event listeners
        this.querySelector('#btn-agregar-direccion').addEventListener('click', () => this.createDireccion());
        this.querySelector('#btn-actualizar-direccion').addEventListener('click', () => this.updateDireccion());
        this.querySelector('#btn-eliminar-direccion').addEventListener('click', () => this.deleteDireccion());
    }

    async loadDirecciones() {
        const response = await fetch('http://localhost:8080/api/v1/direcciones'); // URL de la API
        const direcciones = await response.json();
        const direccionesList = this.querySelector('#direcciones-list');
        direccionesList.innerHTML = direcciones.map(direccion => 
            `<li>${direccion.calle} ${direccion.numero}, ${direccion.ciudad}, ${direccion.provincia}, ${direccion.pais} (ID: ${direccion.id})</li>`
        ).join('');
    }

    async createDireccion() {
        const calle = this.querySelector('#calle').value;
        const numero = this.querySelector('#numero').value;
        const ciudad = this.querySelector('#ciudad').value;
        const provincia = this.querySelector('#provincia').value;
        const pais = this.querySelector('#pais').value;
        await fetch('http://localhost:8080/api/v1/direcciones', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ calle, numero, ciudad, provincia, pais })
        });
        await this.loadDirecciones(); // Recargar la lista después de agregar
    }

    async updateDireccion() {
        const id = this.querySelector('#id-direccion').value;
        const nuevaCalle = this.querySelector('#nueva-calle').value;
        const nuevoNumero = this.querySelector('#nuevo-numero').value;
        const nuevaCiudad = this.querySelector('#nueva-ciudad').value;
        const nuevaProvincia = this.querySelector('#nueva-provincia').value;
        const nuevoPais = this.querySelector('#nuevo-pais').value;
        await fetch(`http://localhost:8080/api/v1/direcciones/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ calle: nuevaCalle, numero: nuevoNumero, ciudad: nuevaCiudad, provincia: nuevaProvincia, pais: nuevoPais })
        });
        await this.loadDirecciones(); // Recargar la lista después de actualizar
    }

    async deleteDireccion() {
        const id = this.querySelector('#eliminar-id-direccion').value;
        await fetch(`http://localhost:8080/api/v1/direcciones/${id}`, {
            method: 'DELETE'
        });
        await this.loadDirecciones(); // Recargar la lista después de eliminar
    }
}
class EmailPersonaForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Correos Electrónicos</h2>
                <ul id="emails-list"></ul>
            </div>
            <div>
                <h2>Agregar Correo Electrónico</h2>
                <input type="text" id="email-persona" placeholder="Correo electrónico" />
                <button onclick="createEmailPersona()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Correo Electrónico</h2>
                <input type="number" id="id-email" placeholder="ID del correo electrónico" />
                <input type="text" id="nuevo-email" placeholder="Nuevo correo electrónico" />
                <button onclick="updateEmailPersona()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Correo Electrónico</h2>
                <input type="number" id="eliminar-id-email" placeholder="ID del correo electrónico" />
                <button onclick="deleteEmailPersona()">Eliminar</button>
            </div>
        </div>
        `;

        this.loadEmailPersonas();
    }

    async loadEmailPersonas() {
        const response = await fetch('http://localhost:8080/emailperson'); // URL de la API
        const emails = await response.json();
        const emailsList = this.querySelector('#emails-list');
        emailsList.innerHTML = emails.map(email => `<li>${email.email} (ID: ${email.id})</li>`).join('');
    }

    async createEmailPersona() {
        const email = this.querySelector('#email-persona').value;
        await fetch('http://localhost:8080/emailperson', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email: email })
        });
        await this.loadEmailPersonas(); // Recargar la lista después de agregar
    }

    async updateEmailPersona() {
        const id = this.querySelector('#id-email').value;
        const nuevoEmail = this.querySelector('#nuevo-email').value;
        await fetch(`http://localhost:8080/emailperson/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email: nuevoEmail })
        });
        await this.loadEmailPersonas(); // Recargar la lista después de actualizar
    }

    async deleteEmailPersona() {
        const id = this.querySelector('#eliminar-id-email').value;
        await fetch(`http://localhost:8080/emailperson/${id}`, {
            method: 'DELETE'
        });
        await this.loadEmailPersonas(); // Recargar la lista después de eliminar
    }
}
class EmpresaForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Empresas</h2>
                <ul id="empresas-list"></ul>
            </div>
            <div>
                <h2>Agregar Empresa</h2>
                <input type="text" id="nombre-empresa" placeholder="Nombre de la empresa" />
                <button onclick="createEmpresa()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Empresa</h2>
                <input type="number" id="id-empresa" placeholder="ID de la empresa" />
                <input type="text" id="nuevo-nombre-empresa" placeholder="Nuevo nombre de la empresa" />
                <button onclick="updateEmpresa()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Empresa</h2>
                <input type="number" id="eliminar-id-empresa" placeholder="ID de la empresa" />
                <button onclick="deleteEmpresa()">Eliminar</button>
            </div>
        </div>
        `;

        this.loadEmpresas();
    }

    async loadEmpresas() {
        const response = await fetch('http://localhost:8080/empresas'); // URL de la API
        const empresas = await response.json();
        const empresasList = this.querySelector('#empresas-list');
        empresasList.innerHTML = empresas.map(empresa => `<li>${empresa.nombre} (ID: ${empresa.id})</li>`).join('');
    }

    async createEmpresa() {
        const nombre = this.querySelector('#nombre-empresa').value;
        await fetch('http://localhost:8080/empresas', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nombre })
        });
        await this.loadEmpresas(); // Recargar la lista después de agregar
    }

    async updateEmpresa() {
        const id = this.querySelector('#id-empresa').value;
        const nuevoNombre = this.querySelector('#nuevo-nombre-empresa').value;
        await fetch(`http://localhost:8080/empresas/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nuevoNombre })
        });
        await this.loadEmpresas(); // Recargar la lista después de actualizar
    }

    async deleteEmpresa() {
        const id = this.querySelector('#eliminar-id-empresa').value;
        await fetch(`http://localhost:8080/empresas/${id}`, {
            method: 'DELETE'
        });
        await this.loadEmpresas(); // Recargar la lista después de eliminar
    }
}
class EstadoAprovacionForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Estados de Aprobación</h2>
                <ul id="estados-aprovacion-list"></ul>
            </div>
            <div>
                <h2>Agregar Estado de Aprobación</h2>
                <input type="text" id="nombre-estado" placeholder="Nombre del estado de aprobación" />
                <button onclick="createEstadoAprovacion()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Estado de Aprobación</h2>
                <input type="number" id="id-estado" placeholder="ID del estado de aprobación" />
                <input type="text" id="nuevo-nombre-estado" placeholder="Nuevo nombre del estado de aprobación" />
                <button onclick="updateEstadoAprovacion()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Estado de Aprobación</h2>
                <input type="number" id="eliminar-id-estado" placeholder="ID del estado de aprobación" />
                <button onclick="deleteEstadoAprovacion()">Eliminar</button>
            </div>
        </div>
        `;

        this.loadEstadosAprovacion();
    }

    async loadEstadosAprovacion() {
        const response = await fetch('http://localhost:8080/estaprovacion'); // URL de la API
        const estados = await response.json();
        const estadosList = this.querySelector('#estados-aprovacion-list');
        estadosList.innerHTML = estados.map(estado => `<li>${estado.nombre} (ID: ${estado.id})</li>`).join('');
    }

    async createEstadoAprovacion() {
        const nombre = this.querySelector('#nombre-estado').value;
        await fetch('http://localhost:8080/estaprovacion', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nombre })
        });
        await this.loadEstadosAprovacion(); // Recargar la lista después de agregar
    }

    async updateEstadoAprovacion() {
        const id = this.querySelector('#id-estado').value;
        const nuevoNombre = this.querySelector('#nuevo-nombre-estado').value;
        await fetch(`http://localhost:8080/estaprovacion/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nuevoNombre })
        });
        await this.loadEstadosAprovacion(); // Recargar la lista después de actualizar
    }

    async deleteEstadoAprovacion() {
        const id = this.querySelector('#eliminar-id-estado').value;
        await fetch(`http://localhost:8080/estaprovacion/${id}`, {
            method: 'DELETE'
        });
        await this.loadEstadosAprovacion(); // Recargar la lista después de eliminar
    }
}
class EstadoOrdenForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Estados de Orden</h2>
                <ul id="estados-orden-list"></ul>
            </div>
            <div>
                <h2>Agregar Estado de Orden</h2>
                <input type="text" id="nombre-estado-orden" placeholder="Nombre del estado de orden" />
                <button onclick="createEstadoOrden()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Estado de Orden</h2>
                <input type="number" id="id-estado-orden" placeholder="ID del estado de orden" />
                <input type="text" id="nuevo-nombre-estado-orden" placeholder="Nuevo nombre del estado de orden" />
                <button onclick="updateEstadoOrden()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Estado de Orden</h2>
                <input type="number" id="eliminar-id-estado-orden" placeholder="ID del estado de orden" />
                <button onclick="deleteEstadoOrden()">Eliminar</button>
            </div> 
        </div>
        `;

        this.loadEstadosOrden();
    }

    async loadEstadosOrden() {
        const response = await fetch('/api/estado-orden'); // Cambia la URL según tu API
        const estadosOrden = await response.json();
        const estadosOrdenList = this.querySelector('#estados-orden-list');
        estadosOrdenList.innerHTML = estadosOrden.map(estado => `<li>${estado.nombre} (ID: ${estado.id})</li>`).join('');
    }

    async createEstadoOrden() {
        const nombre = this.querySelector('#nombre-estado-orden').value;
        await fetch('/api/estado-orden', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nombre })
        });
        await this.loadEstadosOrden(); // Recargar la lista después de agregar
    }

    async updateEstadoOrden() {
        const id = this.querySelector('#id-estado-orden').value;
        const nuevoNombre = this.querySelector('#nuevo-nombre-estado-orden').value;
        await fetch(`/api/estado-orden/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nuevoNombre })
        });
        await this.loadEstadosOrden(); // Recargar la lista después de actualizar
    }

    async deleteEstadoOrden() {
        const id = this.querySelector('#eliminar-id-estado-orden').value;
        await fetch(`/api/estado-orden/${id}`, {
            method: 'DELETE'
        });
        await this.loadEstadosOrden(); // Recargar la lista después de eliminar
    }
}
class InsumoForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Insumos</h2>
                <ul id="insumos-list"></ul>
            </div>
            <div>
                <h2>Agregar Insumo</h2>
                <input type="text" id="nombre-insumo" placeholder="Nombre del insumo" />
                <button onclick="createInsumo()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Insumo</h2>
                <input type="number" id="id-insumo" placeholder="ID del insumo" />
                <input type="text" id="nuevo-nombre-insumo" placeholder="Nuevo nombre del insumo" />
                <button onclick="updateInsumo()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Insumo</h2>
                <input type="number" id="eliminar-id-insumo" placeholder="ID del insumo" />
                <button onclick="deleteInsumo()">Eliminar</button>
            </div>
        </div>
        `;

        this.loadInsumos();
    }

    async loadInsumos() {
        const response = await fetch('http://localhost:8080/insumo'); // URL de la API
        const insumos = await response.json();
        const insumosList = this.querySelector('#insumos-list');
        insumosList.innerHTML = insumos.map(insumo => `<li>${insumo.nombre} (ID: ${insumo.id})</li>`).join('');
    }

    async createInsumo() {
        const nombre = this.querySelector('#nombre-insumo').value;
        await fetch('http://localhost:8080/insumo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nombre })
        });
        await this.loadInsumos(); // Recargar la lista después de agregar
    }

    async updateInsumo() {
        const id = this.querySelector('#id-insumo').value;
        const nuevoNombre = this.querySelector('#nuevo-nombre-insumo').value;
        await fetch(`http://localhost:8080/insumo/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nuevoNombre })
        });
        await this.loadInsumos(); // Recargar la lista después de actualizar
    }

    async deleteInsumo() {
        const id = this.querySelector('#eliminar-id-insumo').value;
        await fetch(`http://localhost:8080/insumo/${id}`, {
            method: 'DELETE'
        });
        await this.loadInsumos(); // Recargar la lista después de eliminar
    }
}
class OrdenServicioForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Órdenes de Servicio</h2>
                <ul id="ordenes-servicio-list"></ul>
            </div>
            <div>
                <h2>Agregar Orden de Servicio</h2>
                <input type="text" id="nombre-orden" placeholder="Nombre de la orden" />
                <button onclick="createOrdenServicio()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Orden de Servicio</h2>
                <input type="number" id="id-orden" placeholder="ID de la orden" />
                <input type="text" id="nuevo-nombre-orden" placeholder="Nuevo nombre de la orden" />
                <button onclick="updateOrdenServicio()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Orden de Servicio</h2>
                <input type="number" id="eliminar-id-orden" placeholder="ID de la orden" />
                <button onclick="deleteOrdenServicio()">Eliminar</button>
            </div>
        </div>
        `;

        this.loadOrdenesServicio();
    }

    async loadOrdenesServicio() {
        const response = await fetch('http://localhost:8080/ordenservicio'); // URL de la API
        const ordenes = await response.json();
        const ordenesList = this.querySelector('#ordenes-servicio-list');
        ordenesList.innerHTML = ordenes.map(orden => `<li>${orden.nombre} (ID: ${orden.id})</li>`).join('');
    }

    async createOrdenServicio() {
        const nombre = this.querySelector('#nombre-orden').value;
        await fetch('http://localhost:8080/ordenservicio', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nombre })
        });
        await this.loadOrdenesServicio(); // Recargar la lista después de agregar
    }

    async updateOrdenServicio() {
        const id = this.querySelector('#id-orden').value;
        const nuevoNombre = this.querySelector('#nuevo-nombre-orden').value;
        await fetch(`http://localhost:8080/ordenservicio/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nuevoNombre })
        });
        await this.loadOrdenesServicio(); // Recargar la lista después de actualizar
    }

    async deleteOrdenServicio() {
        const id = this.querySelector('#eliminar-id-orden').value;
        await fetch(`http://localhost:8080/ordenservicio/${id}`, {
            method: 'DELETE'
        });
        await this.loadOrdenesServicio(); // Recargar la lista después de eliminar
    }
}
class OrdenTrabajoForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Órdenes de Trabajo</h2>
                <ul id="ordenes-trabajo-list"></ul>
            </div>
            <div>
                <h2>Agregar Orden de Trabajo</h2>
                <input type="text" id="nombre-orden-trabajo" placeholder="Nombre de la orden de trabajo" />
                <button onclick="createOrdenTrabajo()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Orden de Trabajo</h2>
                <input type="number" id="id-orden-trabajo" placeholder="ID de la orden de trabajo" />
                <input type="text" id="nuevo-nombre-orden-trabajo" placeholder="Nuevo nombre de la orden de trabajo" />
                <button onclick="updateOrdenTrabajo()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Orden de Trabajo</h2>
                <input type="number" id="eliminar-id-orden-trabajo" placeholder="ID de la orden de trabajo" />
                <button onclick="deleteOrdenTrabajo()">Eliminar</button>
            </div>
        </div>
        `;

        this.loadOrdenesTrabajo();
    }

    async loadOrdenesTrabajo() {
        const response = await fetch('http://localhost:8080/ordtrabajo'); // URL de la API
        const ordenes = await response.json();
        const ordenesList = this.querySelector('#ordenes-trabajo-list');
        ordenesList.innerHTML = ordenes.map(orden => `<li>${orden.nombre} (ID: ${orden.id})</li>`).join('');
    }

    async createOrdenTrabajo() {
        const nombre = this.querySelector('#nombre-orden-trabajo').value;
        await fetch('http://localhost:8080/ordtrabajo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nombre })
        });
        await this.loadOrdenesTrabajo(); // Recargar la lista después de agregar
    }

    async updateOrdenTrabajo() {
        const id = this.querySelector('#id-orden-trabajo').value;
        const nuevoNombre = this.querySelector('#nuevo-nombre-orden-trabajo').value;
        await fetch(`http://localhost:8080/ordtrabajo/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nuevoNombre })
        });
        await this.loadOrdenesTrabajo(); // Recargar la lista después de actualizar
    }

    async deleteOrdenTrabajo() {
        const id = this.querySelector('#eliminar-id-orden-trabajo').value;
        await fetch(`http://localhost:8080/ordtrabajo/${id}`, {
            method: 'DELETE'
        });
        await this.loadOrdenesTrabajo(); // Recargar la lista después de eliminar
    }
}
class PersonaForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Personas</h2>
                <ul id="personas-list"></ul>
            </div>
            <div>
                <h2>Agregar Persona</h2>
                <input type="text" id="nombre-persona" placeholder="Nombre de la persona" />
                <input type="text" id="apellido-persona" placeholder="Apellido de la persona" />
                <button onclick="createPersona()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Persona</h2>
                <input type="number" id="id-persona" placeholder="ID de la persona" />
                <input type="text" id="nuevo-nombre-persona" placeholder="Nuevo nombre de la persona" />
                <input type="text" id="nuevo-apellido-persona" placeholder="Nuevo apellido de la persona" />
                <button onclick="updatePersona()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Persona</h2>
                <input type="number" id="eliminar-id-persona" placeholder="ID de la persona" />
                <button onclick="deletePersona()">Eliminar</button>
            </div>
        </div>
        `;

        this.loadPersonas();
    }

    async loadPersonas() {
        const response = await fetch('http://localhost:8080/persona'); // URL de la API
        const personas = await response.json();
        const personasList = this.querySelector('#personas-list');
        personasList.innerHTML = personas.map(persona => `<li>${persona.nombre} ${persona.apellido} (ID: ${persona.id})</li>`).join('');
    }

    async createPersona() {
        const nombre = this.querySelector('#nombre-persona').value;
        const apellido = this.querySelector('#apellido-persona').value;
        await fetch('http://localhost:8080/persona', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nombre, apellido: apellido })
        });
        await this.loadPersonas(); // Recargar la lista después de agregar
    }

    async updatePersona() {
        const id = this.querySelector('#id-persona').value;
        const nuevoNombre = this.querySelector('#nuevo-nombre-persona').value;
        const nuevoApellido = this.querySelector('#nuevo-apellido-persona').value;
        await fetch(`http://localhost:8080/persona/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nuevoNombre, apellido: nuevoApellido })
        });
        await this.loadPersonas(); // Recargar la lista después de actualizar
    }

    async deletePersona() {
        const id = this.querySelector('#eliminar-id-persona').value;
        await fetch(`http://localhost:8080/persona/${id}`, {
            method: 'DELETE'
        });
        await this.loadPersonas(); // Recargar la lista después de eliminar
    }
}
class SucursalForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Sucursales</h2>
                <ul id="sucursales-list"></ul>
            </div>
            <div>
                <h2>Agregar Sucursal</h2>
                <input type="text" id="nombre-sucursal" placeholder="Nombre de la sucursal" />
                <input type="text" id="direccion-sucursal" placeholder="Dirección de la sucursal" />
                <button onclick="createSucursal()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Sucursal</h2>
                <input type="number" id="id-sucursal" placeholder="ID de la sucursal" />
                <input type="text" id="nuevo-nombre-sucursal" placeholder="Nuevo nombre de la sucursal" />
                <input type="text" id="nueva-direccion-sucursal" placeholder="Nueva dirección de la sucursal" />
                <button onclick="updateSucursal()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Sucursal</h2>
                <input type="number" id="eliminar-id-sucursal" placeholder="ID de la sucursal" />
                <button onclick="deleteSucursal()">Eliminar</button>
            </div>
        </div>
        `;

        this.loadSucursales();
    }

    async loadSucursales() {
        const response = await fetch('http://localhost:8080/sucursales'); // URL de la API
        const sucursales = await response.json();
        const sucursalesList = this.querySelector('#sucursales-list');
        sucursalesList.innerHTML = sucursales.map(sucursal => `<li>${sucursal.nombre} - ${sucursal.direccion} (ID: ${sucursal.id})</li>`).join('');
    }

    async createSucursal() {
        const nombre = this.querySelector('#nombre-sucursal').value;
        const direccion = this.querySelector('#direccion-sucursal').value;
        await fetch('http://localhost:8080/sucursales', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nombre, direccion: direccion })
        });
        await this.loadSucursales(); // Recargar la lista después de agregar
    }

    async updateSucursal() {
        const id = this.querySelector('#id-sucursal').value;
        const nuevoNombre = this.querySelector('#nuevo-nombre-sucursal').value;
        const nuevaDireccion = this.querySelector('#nueva-direccion-sucursal').value;
        await fetch(`http://localhost:8080/sucursales/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nuevoNombre, direccion: nuevaDireccion })
        });
        await this.loadSucursales(); // Recargar la lista después de actualizar
    }

    async deleteSucursal() {
        const id = this.querySelector('#eliminar-id-sucursal').value;
        await fetch(`http://localhost:8080/sucursales/${id}`, {
            method: 'DELETE'
        });
        await this.loadSucursales(); // Recargar la lista después de eliminar
    }
}
class TipoEmailForm extends HTMLElement {
connectedCallback() {
    this.innerHTML = `
    <div class="form">
        <div>
        <h2>Lista de Tipos de Email</h2>
        <ul id="tipos-email-list"></ul>
        </div>
        <div>
        <h2>Agregar Tipo de Email</h2>
        <input type="text" id="nombre-tipo-email" placeholder="Nombre del tipo de email" />
        <button onclick="createTipoEmail()">Agregar</button>
        </div>
        <div>
        <h2>Actualizar Tipo de Email</h2>
        <input type="number" id="id-tipo-email" placeholder="ID del tipo de email" />
        <input type="text" id="nuevo-nombre-tipo-email" placeholder="Nuevo nombre del tipo de email" />
        <button onclick="updateTipoEmail()">Actualizar</button>
        </div>
        <div>
        <h2>Eliminar Tipo de Email</h2>
        <input type="number" id="eliminar-id-tipo-email" placeholder="ID del tipo de email" />
        <button onclick="deleteTipoEmail()">Eliminar</button>
        </div>
    </div>
    `;

    this.loadTiposEmail();
}

async loadTiposEmail() {
    const response = await fetch('http://localhost:8080/tpemail'); // URL de la API
    const tiposEmail = await response.json();
    const tiposEmailList = this.querySelector('#tipos-email-list');
    tiposEmailList.innerHTML = tiposEmail.map(tipoEmail => `<li>${tipoEmail.nombre} (ID: ${tipoEmail.id})</li>`).join('');
}

async createTipoEmail() {
    const nombre = this.querySelector('#nombre-tipo-email').value;
    await fetch('http://localhost:8080/tpemail', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ nombre: nombre })
    });
    await this.loadTiposEmail(); // Recargar la lista después de agregar
}

async updateTipoEmail() {
    const id = this.querySelector('#id-tipo-email').value;
    const nuevoNombre = this.querySelector('#nuevo-nombre-tipo-email').value;
    await fetch(`http://localhost:8080/tpemail/${id}`, {
    method: 'PUT',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ nombre: nuevoNombre })
    });
    await this.loadTiposEmail(); // Recargar la lista después de actualizar
}

async deleteTipoEmail() {
    const id = this.querySelector('#eliminar-id-tipo-email').value;
    await fetch(`http://localhost:8080/tpemail/${id}`, {
    method: 'DELETE'
    });
    await this.loadTiposEmail(); // Recargar la lista después de eliminar
}
}
class TipoEmpresaForm extends HTMLElement {
connectedCallback() {
    this.innerHTML = `
    <div class="form">
        <div>
        <h2>Lista de Tipos de Empresa</h2>
        <ul id="tipos-empresa-list"></ul>
        </div>
        <div>
        <h2>Agregar Tipo de Empresa</h2>
        <input type="text" id="nombre-tipo-empresa" placeholder="Nombre del tipo de empresa" />
        <button onclick="createTipoEmpresa()">Agregar</button>
        </div>
        <div>
        <h2>Actualizar Tipo de Empresa</h2>
        <input type="number" id="id-tipo-empresa" placeholder="ID del tipo de empresa" />
        <input type="text" id="nuevo-nombre-tipo-empresa" placeholder="Nuevo nombre del tipo de empresa" />
        <button onclick="updateTipoEmpresa()">Actualizar</button>
        </div>
        <div>
        <h2>Eliminar Tipo de Empresa</h2>
        <input type="number" id="eliminar-id-tipo-empresa" placeholder="ID del tipo de empresa" />
        <button onclick="deleteTipoEmpresa()">Eliminar</button>
        </div>
    </div>
    `;

    this.loadTiposEmpresa();
}

async loadTiposEmpresa() {
    const response = await fetch('http://localhost:8080/tpempresas'); // URL de la API
    const tiposEmpresa = await response.json();
    const tiposEmpresaList = this.querySelector('#tipos-empresa-list');
    tiposEmpresaList.innerHTML = tiposEmpresa.map(tipoEmpresa => `<li>${tipoEmpresa.nombre} (ID: ${tipoEmpresa.id})</li>`).join('');
}

async createTipoEmpresa() {
    const nombre = this.querySelector('#nombre-tipo-empresa').value;
    await fetch('http://localhost:8080/tpempresas', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ nombre: nombre })
    });
    await this.loadTiposEmpresa(); // Recargar la lista después de agregar
}

async updateTipoEmpresa() {
    const id = this.querySelector('#id-tipo-empresa').value;
    const nuevoNombre = this.querySelector('#nuevo-nombre-tipo-empresa').value;
    await fetch(`http://localhost:8080/tpempresas/${id}`, {
    method: 'PUT',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ nombre: nuevoNombre })
    });
    await this.loadTiposEmpresa(); // Recargar la lista después de actualizar
}

async deleteTipoEmpresa() {
    const id = this.querySelector('#eliminar-id-tipo-empresa').value;
    await fetch(`http://localhost:8080/tpempresas/${id}`, {
    method: 'DELETE'
    });
    await this.loadTiposEmpresa(); // Recargar la lista después de eliminar
}
}
class TipoPersonaForm extends HTMLElement {
connectedCallback() {
    this.innerHTML = `
    <div class="form">
        <div>
        <h2>Lista de Tipos de Persona</h2>
        <ul id="tipos-persona-list"></ul>
        </div>
        <div>
        <h2>Agregar Tipo de Persona</h2>
        <input type="text" id="nombre-tipo-persona" placeholder="Nombre del tipo de persona" />
        <button onclick="createTipoPersona()">Agregar</button>
        </div>
        <div>
        <h2>Actualizar Tipo de Persona</h2>
        <input type="number" id="id-tipo-persona" placeholder="ID del tipo de persona" />
        <input type="text" id="nuevo-nombre-tipo-persona" placeholder="Nuevo nombre del tipo de persona" />
        <button onclick="updateTipoPersona()">Actualizar</button>
        </div>
        <div>
        <h2>Eliminar Tipo de Persona</h2>
        <input type="number" id="eliminar-id-tipo-persona" placeholder="ID del tipo de persona" />
        <button onclick="deleteTipoPersona()">Eliminar</button>
        </div>
    </div>
    `;

    this.loadTiposPersona();
}

async loadTiposPersona() {
    const response = await fetch('http://localhost:8080/tipopersona'); // URL de la API
    const tiposPersona = await response.json();
    const tiposPersonaList = this.querySelector('#tipos-persona-list');
    tiposPersonaList.innerHTML = tiposPersona.map(tipoPersona => `<li>${tipoPersona.nombre} (ID: ${tipoPersona.id})</li>`).join('');
}

async createTipoPersona() {
    const nombre = this.querySelector('#nombre-tipo-persona').value;
    await fetch('http://localhost:8080/tipopersona', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ nombre: nombre })
    });
    await this.loadTiposPersona(); // Recargar la lista después de agregar
}

async updateTipoPersona() {
    const id = this.querySelector('#id-tipo-persona').value;
    const nuevoNombre = this.querySelector('#nuevo-nombre-tipo-persona').value;
    await fetch(`http://localhost:8080/tipopersona/${id}`, {
    method: 'PUT',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ nombre: nuevoNombre })
    });
    await this.loadTiposPersona(); // Recargar la lista después de actualizar
}

async deleteTipoPersona() {
    const id = this.querySelector('#eliminar-id-tipo-persona').value;
    await fetch(`http://localhost:8080/tipopersona/${id}`, {
    method: 'DELETE'
    });
    await this.loadTiposPersona(); // Recargar la lista después de eliminar
}
}
class PersonaInsumoForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Personas Insumo</h2>
                <ul id="personas-insumo-list"></ul>
            </div>
            <div>
                <h2>Agregar Persona Insumo</h2>
                <input type="text" id="nombre-persona-insumo" placeholder="Nombre de la persona insumo" />
                <button onclick="createPersonaInsumo()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Persona Insumo</h2>
                <input type="number" id="id-persona-insumo" placeholder="ID de la persona insumo" />
                <input type="text" id="nuevo-nombre-persona-insumo" placeholder="Nuevo nombre de la persona insumo" />
                <button onclick="updatePersonaInsumo()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Persona Insumo</h2>
                <input type="number" id="eliminar-id-persona-insumo" placeholder="ID de la persona insumo" />
                <button onclick="deletePersonaInsumo()">Eliminar</button>
            </div>
        </div>
        `;

        this.loadPersonasInsumo();
    }

    async loadPersonasInsumo() {
        const response = await fetch('http://localhost:8080/perinsumo'); // URL de la API
        const personasInsumo = await response.json();
        const personasInsumoList = this.querySelector('#personas-insumo-list');
        personasInsumoList.innerHTML = personasInsumo.map(persona => `<li>${persona.nombre} (ID: ${persona.id})</li>`).join('');
    }

    async createPersonaInsumo() {
        const nombre = this.querySelector('#nombre-persona-insumo').value;
        await fetch('http://localhost:8080/perinsumo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nombre }) // Asegúrate de que el objeto tenga la estructura correcta
        });
        await this.loadPersonasInsumo(); // Recargar la lista después de agregar
    }

    async updatePersonaInsumo() {
        const id = this.querySelector('#id-persona-insumo').value;
        const nuevoNombre = this.querySelector('#nuevo-nombre-persona-insumo').value;
        await fetch(`http://localhost:8080/perinsumo/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nuevoNombre }) // Asegúrate de que el objeto tenga la estructura correcta
        });
        await this.loadPersonasInsumo(); // Recargar la lista después de actualizar
    }

    async deletePersonaInsumo() {
        const id = this.querySelector('#eliminar-id-persona-insumo').value;
        await fetch(`http://localhost:8080/perinsumo/${id}`, {
            method: 'DELETE'
        });
        await this.loadPersonasInsumo(); // Recargar la lista después de eliminar
    }
}
class ServicioForm extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="form">
            <div>
                <h2>Lista de Servicios</h2>
                <ul id="servicios-list"></ul>
            </div>
            <div>
                <h2>Agregar Servicio</h2>
                <input type="text" id="nombre-servicio" placeholder="Nombre del servicio" />
                <button onclick="createServicio()">Agregar</button>
            </div>
            <div>
                <h2>Actualizar Servicio</h2>
                <input type="number" id="id-servicio" placeholder="ID del servicio" />
                <input type="text" id="nuevo-nombre-servicio" placeholder="Nuevo nombre del servicio" />
                <button onclick="updateServicio()">Actualizar</button>
            </div>
            <div>
                <h2>Eliminar Servicio</h2>
                <input type="number" id="eliminar-id-servicio" placeholder="ID del servicio" />
                <button onclick="deleteServicio()">Eliminar</button>
            </div>
        </div>
        `;

        this.loadServicios();
    }

    async loadServicios() {
        const response = await fetch('http://localhost:8080/Servicio'); // URL de la API
        const servicios = await response.json();
        const serviciosList = this.querySelector('#servicios-list');
        serviciosList.innerHTML = servicios.map(servicio => `<li>${servicio.nombre} (ID: ${servicio.id})</li>`).join('');
    }

    async createServicio() {
        const nombre = this.querySelector('#nombre-servicio').value;
        await fetch('http://localhost:8080/Servicio', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nombre })
        });
        await this.loadServicios(); // Recargar la lista después de agregar
    }

    async updateServicio() {
        const id = this.querySelector('#id-servicio').value;
        const nuevoNombre = this.querySelector('#nuevo-nombre-servicio').value;
        await fetch(`http://localhost:8080/Servicio/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: nuevoNombre })
        });
        await this.loadServicios(); // Recargar la lista después de actualizar
    }

    async deleteServicio() {
        const id = this.querySelector('#eliminar-id-servicio').value;
        await fetch(`http://localhost:8080/Servicio/${id}`, {
            method: 'DELETE'
        });
        await this.loadServicios(); // Recargar la lista después de eliminar
    }
}

// DEFINICION DE LOS COMPONENTES DEL FORMULARIO
customElements.define('ciudad-form', CiudadForm);
customElements.define('pais-form', PaisForm);
customElements.define('region-form', RegionForm);
customElements.define('direccion-form', DireccionForm);
customElements.define('email-persona-form', EmailPersonaForm);
customElements.define('empresa-form', EmpresaForm);
customElements.define('estado-aprovacion-form', EstadoAprovacionForm);
customElements.define('estado-orden-form', EstadoOrdenForm); //este no se ha actializado
customElements.define('insumo-form', InsumoForm);
customElements.define('orden-servicio-form', OrdenServicioForm);
customElements.define('orden-trabajo-form', OrdenTrabajoForm);
customElements.define('persona-form', PersonaForm);
customElements.define('sucursal-form', SucursalForm);
customElements.define('tipo-email-form', TipoEmailForm);
customElements.define('tipo-empresa-form', TipoEmpresaForm);
customElements.define('tipo-persona-form', TipoPersonaForm);

customElements.define('persona-insumo-form', PersonaInsumoForm);
customElements.define('servicio-form',  ServicioForm);

document.addEventListener("DOMContentLoaded", function() { 
    const rightSection = document.querySelector('.right'); 

    document.querySelectorAll('button').forEach(button => { 
        button.addEventListener('click', function() { 
            const label = this.querySelector('.label').innerText.trim(); 
            rightSection.innerHTML = '';

            // MOSTRAR EL COMPONENTE SEGUN EL BOTON QUE PULSEN
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
                case 'Direcciones': 
                    rightSection.appendChild(document.createElement('direccion-form')); 
                    break; 
                case 'Emails': 
                    rightSection.appendChild(document.createElement('email-persona-form')); 
                    break; 
                case 'Empresas': 
                    rightSection.appendChild(document.createElement('empresa-form')); 
                    break; 
                case 'Estados de Aprobación': 
                    rightSection.appendChild(document.createElement('estado-aprovacion-form')); 
                    break; 
                case 'Estados de Orden': 
                    rightSection.appendChild(document.createElement('estado-orden-form')); 
                    break; 
                case 'Insumos': 
                    rightSection.appendChild(document.createElement('insumo-form')); 
                    break; 
                case 'Órdenes de Servicio': 
                    rightSection.appendChild(document.createElement('orden-servicio-form')); 
                    break; 
                case 'Órdenes de Trabajo': 
                    rightSection.appendChild(document.createElement('orden-trabajo-form')); 
                    break; 
                case 'Personas': 
                    rightSection.appendChild(document.createElement('persona-form')); 
                    break; 
                case 'Sucursales': 
                    rightSection.appendChild(document.createElement('sucursal-form')); 
                    break; 
                case 'Tipo Email': 
                    rightSection.appendChild(document.createElement('tipo-email-form')); 
                    break;
                case 'Tipo Empresa': 
                    rightSection.appendChild(document.createElement('tipo-empresa-form')); 
                    break;
                case 'Tipo Persona': 
                    rightSection.appendChild(document.createElement('tipo-persona-form')); 
                    break;
                case 'Persona Insumo':
                    rightSection.appendChild(document.createElement('persona-insumo-form'));
                    break;
                case 'Servicio':
                    rightSection.appendChild(document.createElement('servicio-form'));
                    break;
                // TODOS LOS CASOS DE LOS COMPONENTES YA DEFINIDOS
            } 
        }); 
    }); 
});