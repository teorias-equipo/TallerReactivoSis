import React, { useState } from 'react';
import { createNota } from '../services/notaService';

const NotaForm = ({ estudianteId }) => {
    const [nota, setNota] = useState({ valor: '', porcentaje: '', observacion: '' });

    const handleSubmit = (e) => {
        e.preventDefault();
        createNota({ ...nota, estudianteId }).then(() => {
            alert('Nota creada exitosamente');
        }).catch(error => {
            alert('Error creando nota: ' + error.response?.data?.message || error.message);
        });
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setNota(prevNota => ({ ...prevNota, [name]: value }));
    };

    return (
        <form onSubmit={handleSubmit}>
            <h3>Registrar Nota</h3>
            <div>
                <label>Valor:</label>
                <input type="number" name="valor" value={nota.valor} onChange={handleChange} required />
            </div>
            <div>
                <label>Porcentaje:</label>
                <input type="number" name="porcentaje" value={nota.porcentaje} onChange={handleChange} required />
            </div>
            <div>
                <label>Observación:</label>
                <input type="text" name="observacion" value={nota.observacion} onChange={handleChange} />
            </div>
            <button type="submit">Guardar Nota</button>
        </form>
    );
};

export default NotaForm;
