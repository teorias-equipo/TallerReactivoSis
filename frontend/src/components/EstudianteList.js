import React, { useEffect, useState } from 'react';
import { getAllEstudiantes } from '../services/estudianteService';

const EstudianteList = ({ cursoCodigo, onSelectEstudiante }) => {
    const [estudiantes, setEstudiantes] = useState([]);

    useEffect(() => {
        getAllEstudiantes().then(response => {
            setEstudiantes(response.data.filter(estudiante => estudiante.cursoCodigo === cursoCodigo));
        }).catch(error => {
            console.error('Error fetching estudiantes:', error);
        });
    }, [cursoCodigo]);

    return (
        <div>
            <h2>Estudiantes del Curso</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {estudiantes.map(estudiante => (
                        <tr key={estudiante.id}>
                            <td>{estudiante.id}</td>
                            <td>{estudiante.nombre}</td>
                            <td>{estudiante.apellido}</td>
                            <td>
                                <button onClick={() => onSelectEstudiante(estudiante.id)}>
                                    Ver Notas
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default EstudianteList;
