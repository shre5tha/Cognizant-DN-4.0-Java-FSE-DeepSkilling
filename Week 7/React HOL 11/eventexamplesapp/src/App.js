import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';
import logo from './logo.svg';
import './App.css';

function App() {
  const [counter, setCounter] = useState(0);

  const handleIncrease = () => {
    incrementCounter();
    sayHello();
  };

  const incrementCounter = () => {
    setCounter(counter + 1);
  };

  const sayHello = () => {
    alert("Hello! This is a static message.");
  };

  const handleDecrease = () => {
    setCounter(counter - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleClick = (event) => {
    alert("I was clicked");
  };

  return (
    <div className="App">
      <h1>Event Examples App</h1>

      <h2>Counter: {counter}</h2>
      <button onClick={handleIncrease}>Increment</button>
      <button onClick={handleDecrease}>Decrement</button>

      <br /><br />
      <button onClick={() => sayWelcome("Welcome to the Event Handling App!")}>
        Say Welcome
      </button>

      <br /><br />
      <button onClick={handleClick}>Click Me</button>

      <hr />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
