import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';

function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}

function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

function UserGreeting() {
  return (
    <div>
      <h2>Welcome, Logged-in User!</h2>
      <h3>✈️ Book Your Flights Below:</h3>
      <ul>
        <li>Flight: Air India | From: Delhi | To: Mumbai | Price: ₹4500 <button>Book</button></li>
        <li>Flight: Indigo | From: Bangalore | To: Chennai | Price: ₹3200 <button>Book</button></li>
        <li>Flight: Vistara | From: Pune | To: Kolkata | Price: ₹6000 <button>Book</button></li>
      </ul>
    </div>
  );
}

function GuestGreeting() {
  return (
    <div>
      <h2>Welcome, Guest!</h2>
      <h3> Flights Available:</h3>
      <ul>
        <li>Flight: Air India | From: Delhi | To: Mumbai | Price: ₹4500</li>
        <li>Flight: Indigo | From: Bangalore | To: Chennai | Price: ₹3200</li>
        <li>Flight: Vistara | From: Pune | To: Kolkata | Price: ₹6000</li>
      </ul>
      <p>☝️Please login to book tickets.</p>
    </div>
  );
}

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };

  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  let button;

  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogoutClick} />;
  } 
  else {
    button = <LoginButton onClick={handleLoginClick} />;
  }

  return (
    <div className="App">
      <h1> Ticket Booking App</h1>
      {button}
      <hr />
      <Greeting isLoggedIn={isLoggedIn} />
    </div>
  );
}

export default App;
