import axios from 'axios';

const API_URL = 'http://localhost:8080/api/estudiantes';

export const getAllEstudiantes = () => {
    return axios.get(API_URL);
};

export const getEstudianteById = (id) => {
    return axios.get(`${API_URL}/${id}`);
};

export const createEstudiante = (estudiante) => {
    return axios.post(API_URL, estudiante);
};

export const deleteEstudiante = (id) => {
    return axios.delete(`${API_URL}/${id}`);
};

