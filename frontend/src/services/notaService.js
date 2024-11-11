import axios from 'axios';

const API_URL = 'http://localhost:8080/api/notas';

export const getAllNotas = () => {
    return axios.get(API_URL);
};

export const getNotaById = (id) => {
    return axios.get(`${API_URL}/${id}`);
};

export const createNota = (nota) => {
    return axios.post(API_URL, nota);
};

export const deleteNota = (id) => {
    return axios.delete(`${API_URL}/${id}`);
};
