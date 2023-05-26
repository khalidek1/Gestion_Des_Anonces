import React, { useState } from "react";
import {
  MapContainer,
  TileLayer,
  Marker,
  Popup,
  useMapEvents,
} from "react-leaflet";
import axios from "axios";
import "./Form.css";
import "leaflet/dist/leaflet.css";
import L from "leaflet";
import icon from "leaflet/dist/images/marker-icon.png";
import iconShadow from "leaflet/dist/images/marker-shadow.png";
delete L.Icon.Default.prototype._getIconUrl;

const Form = () => {
  const center_position = [33.66492, -7.817975];
  const [markerPosition, setMarkerPosition] = useState({
    lat: 33.66492,
    lng: -7.817975,
  });
  const handleMapClick = (e) => setMarkerPosition(e.latlng);

  const handleClick = () => {
    if (markerPosition) {
      alert(markerPosition.lat, markerPosition.lng);
    } else {
      alert("No marker selected.");
    }
  };

  const handleFileChange = (event) => {
    const files = event.target.files;
    // Do something with the selected files
    console.log(files);
  };

  const MapClickEvents = () => {
    useMapEvents({
      click: handleMapClick,
    });
    return null;
  };

  const [currentStep, setCurrentStep] = useState(1);
  const [formData, setFormData] = useState({
    AnonceType: "",
    proprieterType: "",
    Prix: "0",
    Surface: "0",
    numberChambre: "0",
    sallebien: "0",
    NumeroEtage: "0",
    etat: "0",
  });
  const [formErrors, setFormErrors] = useState({});

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleNext = () => {
    if (validateForm()) {
      setCurrentStep(currentStep + 1);
      setFormErrors({});
    }
  };

  const handlePrevious = () => {
    setCurrentStep(currentStep - 1);
    setFormErrors({});
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validateForm()) {
      //   try {
      //     const response = await axios.post(
      //       "http://localhost:8080/Anonce",
      //       formData
      //     );
      //     console.log(response.data); // Handle the response as needed
      //     }
      //   catch (error) {
      //     console.error(error);
      //   }
      axios
        .post("http://localhost:8080/api/form", formData)
        .then((response) => {
          console.log(response.data); // Handle success response
        })
        .catch((err) => {
          console.log(err); // Handle error response
        });
    }
  };

  const validateForm = () => {
    const errors = {};
    let isValid = true;

    if (currentStep === 1) {
      if (!formData.AnonceType) {
        errors.AnonceType = "Anonce Type is required";
        isValid = false;
      }
      if (!formData.proprieterType) {
        errors.proprieterType = "proprieter Type is required";
        isValid = false;
      }
    } else if (currentStep === 2) {
      if (!formData.Prix.trim()) {
        errors.Prix = "Prix is required";
        isValid = false;
      }
      if (!formData.Surface.trim()) {
        errors.Surface = "Surface is required";
        isValid = false;
      }
      if (!formData.numberChambre.trim()) {
        errors.numberChambre = "number chambre is required";
        isValid = false;
      }
      if (!formData.sallebien.trim()) {
        errors.sallebien = "number salle de bien is required";
        isValid = false;
      }
      if (!formData.NumeroEtage.trim()) {
        errors.NumeroEtage = "Numero etage salle de bien is required";
        isValid = false;
      }
    }

    setFormErrors(errors);
    return isValid;
  };

  return (
    <section>
      <div className="form-container">
        <form onSubmit={handleSubmit}>
          {currentStep === 1 && (
            <div>
              <h2>Step 1: Personal Information</h2>
              <div className="form-group">
                <select
                  name="AnonceType"
                  value={formData.AnonceType}
                  className=""
                  onChange={handleInputChange}
                >
                  <option value="">Select</option>
                  <option value="louer">louer</option>
                  <option value="Vente">Vente</option>
                </select>
                {formErrors.AnonceType && (
                  <span className="error">{formErrors.AnonceType}</span>
                )}
              </div>
              <div className="form-group">
                <select
                  name="proprieterType"
                  value={formData.proprieterType}
                  className=""
                  onChange={handleInputChange}
                >
                  <option value="">Select</option>
                  <option value="appartement">appartement</option>
                  <option value="maison">maison</option>
                  <option value="villa">villa</option>
                  <option value="riad">riad</option>
                </select>
                {formErrors.proprieterType && (
                  <span className="error">{formErrors.proprieterType}</span>
                )}
              </div>
            </div>
          )}
          {currentStep === 2 && (
            <div>
              <h2>Step 2: Details Information</h2>
              <div className="form-detail">
                <div className="form-group">
                  <input
                    type="number"
                    name="Prix"
                    placeholder="Prix dh"
                    value={formData.Prix}
                    onChange={handleInputChange}
                  />
                  {formErrors.Prix && (
                    <span className="error">{formErrors.Prix}</span>
                  )}
                </div>
                <div className="form-group">
                  <input
                    type="number"
                    name="Surface"
                    placeholder="Surface m2"
                    value={formData.Surface}
                    onChange={handleInputChange}
                  />
                  {formErrors.Surface && (
                    <span className="error">{formErrors.Surface}</span>
                  )}
                </div>
              </div>
              <div className="form-detail">
                <div className="form-group">
                  <input
                    type="number"
                    name="numberChambre"
                    placeholder="number chambre"
                    value={formData.numberChambre}
                    onChange={handleInputChange}
                  />
                  {formErrors.numberChambre && (
                    <span className="error">{formErrors.numberChambre}</span>
                  )}
                </div>
                <div className="form-group">
                  <input
                    type="number"
                    name="sallebien"
                    placeholder="numbere de salle de bien"
                    value={formData.sallebien}
                    onChange={handleInputChange}
                  />
                  {formErrors.sallebien && (
                    <span className="error">{formErrors.sallebien}</span>
                  )}
                </div>
              </div>
              <div className="form-detail">
                <div className="form-group">
                  <input
                    type="number"
                    name="NumeroEtage"
                    placeholder="Numero etage"
                    value={formData.NumeroEtage}
                    onChange={handleInputChange}
                  />
                  {formErrors.NumeroEtage && (
                    <span className="error">{formErrors.NumeroEtage}</span>
                  )}
                </div>
                <div className="form-group">
                  <input
                    type="number"
                    name="etat"
                    placeholder="etat proprietaire "
                    value={formData.etat}
                    onChange={handleInputChange}
                  />
                  {formErrors.etat && (
                    <span className="error">{formErrors.etat}</span>
                  )}
                </div>
              </div>
            </div>
          )}
          {currentStep === 3 && (
            <div>
              <h2>Step 3: maps</h2>
              <div className="maps">
                <MapContainer
                  center={center_position}
                  zoom={7}
                  scrollWheelZoom={false}
                >
                  <TileLayer
                    attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                  />
                  <Marker
                    position={[markerPosition.lat, markerPosition.lng]}
                    draggable={true}
                    eventHandlers={{
                      move: (e) => {
                        console.log(e.target.getLatLng());
                        setMarkerPosition(e.target.getLatLng());
                      },
                    }}
                  >
                    <Popup>
                      A pretty CSS3 popup. <br /> Easily customizable. Marker
                      Position:
                    </Popup>
                  </Marker>
                </MapContainer>
                <div>
                  <div>
                    <select id="region" name="region" className="region">
                      <option value="option1-1">Option 1-1</option>
                      <option value="option1-2">Option 1-2</option>
                      <option value="option1-3">Option 1-3</option>
                    </select>
                  </div>
                  <div>
                    <select id="optvilleion1" name="ville" className="ville">
                      <option value="option1-1">Option 1-1</option>
                      <option value="option1-2">Option 1-2</option>
                      <option value="option1-3">Option 1-3</option>
                    </select>
                  </div>
                  <input
                    type="text"
                    placeholder="adresse"
                    className="adresse"
                  />
                </div>
              </div>
            </div>
          )}
          {currentStep === 4 && (
            <div>
              <h2>Step 4: title</h2>
              <input type="text" placeholder="adresse" className="adresse" />
              <textarea
                name="dexcription"
                id=""
                placeholder="dexcription"
                cols="20"
                rows="6"
              ></textarea>
            </div>
          )}
          {currentStep === 5 && (
            <div>
              <h2>Step 5: Confirmation</h2>
              {currentStep === 5 && (
                <div>
                  <div className="">
                    <label htmlFor="image" className="">
                      Select an image:
                    </label>
                    <input
                      type="file"
                      id="image"
                      name="image"
                      accept="image/jpeg,image/png, image/jpg"
                      className=""
                      onChange={handleFileChange}
                    />
                  </div>
                </div>
              )}
            </div>
          )}
          {currentStep === 6 && (
            <div>
              <h2>Step 6: Confirmation</h2>
              <p>AnonceType: {formData.AnonceType}</p>
              <p>proprieterType: {formData.proprieterType}</p>
              <p>Prix: {formData.Prix}</p>
              <p>Surface: {formData.Surface}</p>
              <p>numberChambre: {formData.numberChambre}</p>
              <p>sallebien: {formData.sallebien}</p>
              <p>sallebien: [markerPosition.lat, markerPosition.lng]</p>
            </div>
          )}
          <div className="button-group">
            {currentStep > 1 && (
              <button
                type="button"
                className="prev-button"
                onClick={handlePrevious}
              >
                Previous
              </button>
            )}
            {currentStep < 6 ? (
              <button
                type="button"
                className="next-button "
                onClick={handleNext}
              >
                Next
              </button>
            ) : (
              <button type="submit" className="submit-button">
                Submit
              </button>
            )}
          </div>
        </form>
      </div>
    </section>
  );
};

let DefaultIcon = L.icon({
  iconUrl: icon,
  shadowUrl: iconShadow,
});

L.Marker.prototype.options.icon = DefaultIcon;

export default Form;
