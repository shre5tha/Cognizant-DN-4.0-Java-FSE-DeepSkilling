import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState(null);

  const conversionRate = 0.0099;

  const handleSubmit = (event) => {
    event.preventDefault();
    const converted = rupees * conversionRate;
    setEuro(converted.toFixed(2));
  };

  return (
    <div>
      <h2>Currency Convertor</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Enter Amount in ₹:
          <input
            type="number"
            value={rupees}
            onChange={(e) => setRupees(e.target.value)}
            required
          />
        </label>
        <button type="submit">Convert</button>
      </form>

    <h3>Equivalent in Euros: €{euro}</h3>

    </div>
  );
}

export default CurrencyConvertor;
