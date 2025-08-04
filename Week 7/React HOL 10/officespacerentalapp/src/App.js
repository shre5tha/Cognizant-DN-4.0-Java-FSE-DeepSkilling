import React from 'react';
import logo from './logo.svg';
import office from './officeSpacePhoto.jpg';
import './App.css';

const element = "Office Space";

const jsxatt = <img src={office} alt="Office Space" className="office-img" />;

const officeList = [
  {Name: "DBS", Rent: 50000, Address: "Chennai"},
  { Name: "RedHat", Rent: 85000, Address: "Bangalore" },
  { Name: "Cisco", Rent: 59500, Address: "Hyderabad" },
  { Name: "Amdocs", Rent: 60500, Address: "Pune" }
];

function App() {
  return (
    <div className="App">
      <h1>{element}, at Affordable Range</h1>
      {jsxatt}

      <div className="office-grid">
        {officeList.map((office, index) => {
          let colors = [];
          if (office.Rent <= 60000) {
            colors.push('textRed');
          } else {
            colors.push('textGreen');
         }

         return (
            <div key={index} className="office-card">
            <h3>Name: {office.Name}</h3>
            <h3 className={colors.join(' ')}>Rent: Rs. {office.Rent}</h3>
            <h3>Address: {office.Address}</h3>
          </div>
        );
      })}
    </div>
      
    </div>
  );
}

export default App;
