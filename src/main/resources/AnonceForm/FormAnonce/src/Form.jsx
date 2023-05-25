import React, { useState } from "react";
import axios from "axios";
import "./Form.css";

const Form = () => {
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
              <h2>Step 3: Confirmation</h2>
              <p>AnonceType: {formData.AnonceType}</p>
              <p>proprieterType: {formData.proprieterType}</p>
              <p>Prix: {formData.Prix}</p>
              <p>Surface: {formData.Surface}</p>
              <p>numberChambre: {formData.numberChambre}</p>
              <p>sallebien: {formData.sallebien}</p>
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
            {currentStep < 3 ? (
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

export default Form;
