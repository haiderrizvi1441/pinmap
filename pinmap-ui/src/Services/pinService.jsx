import React from 'react'
import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/pins';
const pinService = {

    getAllPins : () => {
        return axios.get(BASE_URL);
    },
    
    createPin: (pin) => {
        return axios.post(BASE_URL, pin)
    },

    getPinById: (id) => {
        return axios.get(BASE_URL + '/' + id)
    },

    updatePin: (id) => {
        return axios.put(BASE_URL + '/' + id)
    },

    deletePin: (id) => {
        return axios.delete(BASE_URL + '/' + id)
    }

    
}

export default pinService