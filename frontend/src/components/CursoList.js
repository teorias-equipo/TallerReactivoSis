import React, { useEffect, useState } from 'react';
import { getAllCursos } from '../services/cursoService';

const CursoList = ({ onSelectCurso }) => {
    const [cursos, setCursos] = useState([]);

    useEffect(() => {
        getAllCursos().then(response => {
            console.log('Cursos obtenidos:', response.data);
            setCursos(response.data);
        }).catch(error => {
            console.error('Error fetching cursos:', error);
        });
    }, []);


    return (
        <div>
            <h2>Lista de Cursos</h2>
            <table>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Materia ID</th>
                        <th>Profesor ID</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {cursos.map(curso => (
                        <tr key={curso.codigo}>
                            <td>{curso.codigo}</td>
                            <td>{curso.materiaId}</td>
                            <td>{curso.profesorId}</td>
                            <td>
                                <button onClick={() => onSelectCurso(curso.codigo)}>
                                    Ver Estudiantes
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default CursoList;
