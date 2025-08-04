import logo from './logo.svg';
import './App.css';

import React from 'react';
import ListofPlayers from './components/ListofPlayers';
import { IndianPlayers, OddPlayers, EvenPlayers } from './components/IndianPlayers';
import ShowMergedPlayers from './components/IndianPlayers';

function App() {
  const showListPlayers = false;

  let content;

  if (showListPlayers) {
    content = <ListofPlayers />;
  } else {
    content = (
      <>
        <OddPlayers players={IndianPlayers} />
        <EvenPlayers players={IndianPlayers} />
        <ShowMergedPlayers />
      </>
    );
  }

  return (
    <div className="App">
      {content}
    </div>
  );
}

export default App;
