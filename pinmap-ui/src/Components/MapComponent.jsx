import React, { useState } from 'react'
import {GoogleMap, LoadScript, Marker} from '@react-google-maps/api';

const MapComponent = () => {

    const api_key = process.env.REACT_APP_API_KEY;
    console.log("API",api_key);

    const [pins, setPins] = useState([]);
    const [newPin, setNewPin] = useState({title:'', description:'',latitude:0, longitude:0});

    // Function to add a new Pin when user Clicks on the Map
    const handleMapClick = (event) => {
        setNewPin({...newPin, latitude:event.latLng.lat(), longitude:event.latLng.lng() });
    }

    // Function to handle Submitting the form and adding a pin to the map
    const handleAddPin = () => {
        setPins([...pins, newPin]);
        setNewPin({title:'', description:'', latitude:0,longitude:0})
    }

  return (
    <LoadScript googleMapsApiKey=''>
    <GoogleMap>
        {pins.map((pin, index) => {
            <Marker key={index} position={{lat: pin.latitude , lng:pin.longitude}} />
        })}
    </GoogleMap>

    {/* FORM TO ADD PIN */}
    <div>
        <h2>Add Pin</h2>
        <form action="">

            {/* Title Input */}
            <input type="text" 
            placeholder='Title' 
            value={newPin.title} 
            onChange={(e) => setNewPin({...newPin, title: e.target.value})} />

            {/* Description Input  */}
            <input type="text"
            placeholder='Description'
            value={newPin.description}
            onChange={(e) => setNewPin({...newPin, description:e.target.value})} />

            {/* Latitude Input */}
            <input type="number"
            placeholder='Latitude'
            value={newPin.latitude}
            onChange={(e) => setNewPin({ ...newPin, latitude:parseFloat(e.target.value)})} />

            {/* Longitude Input  */}
            <input type="input"
            placeholder='Longitude'
            vlaue={newPin.longitude}
            onChange={(e) => setNewPin({...newPin, longitude:parseFloat(e.target.value)})} />

            {/* Add Pin Button  */}
            <button type='button' onClick={handleAddPin}> Add Pin</button>
        </form>
    </div>

    </LoadScript>
  )
}

export default MapComponent