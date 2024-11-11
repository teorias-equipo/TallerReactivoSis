import axios from 'axios';

const API_URL = 'http://localhost:8080/api/cursos';

export const getAllCursos = () => {
    return axios.get(API_URL);
};

export const getCursoById = (codigo) => {
    return axios.get(`${API_URL}/${codigo}`);
};

export const createCurso = (curso) => {
    return axios.post(API_URL, curso);
};

export const deleteCurso = (codigo) => {
    return axios.delete(`${API_URL}/${codigo}`);
};
