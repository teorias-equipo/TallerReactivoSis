import React, { useState } from 'react';
import CursoList from './components/CursoList';
import EstudianteList from './components/EstudianteList';
import NotaForm from './components/NotaForm';

function App() {
    const [selectedCurso, setSelectedCurso] = useState(null);
    const [selectedEstudiante, setSelectedEstudiante] = useState(null);

    const handleSelectCurso = (cursoCodigo) => {
        setSelectedCurso(cursoCodigo);
        setSelectedEstudiante(null);a
    };

    const handleSelectEstudiante = (estudianteId) => {
        setSelectedEstudiante(estudianteId);
    };

    return (
        <div className="App">
            <h1>Gestión de Cursos</h1>
            {!selectedCurso && <CursoList onSelectCurso={handleSelectCurso} />}
            {selectedCurso && !selectedEstudiante && (
                <EstudianteList cursoCodigo={selectedCurso} onSelectEstudiante={handleSelectEstudiante} />
            )}
            {selectedEstudiante && <NotaForm estudianteId={selectedEstudiante} />}
        </div>
    );
}

export default App;
