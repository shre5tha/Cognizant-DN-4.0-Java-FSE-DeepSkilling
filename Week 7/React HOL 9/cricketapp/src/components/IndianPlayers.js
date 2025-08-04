import React from 'react';

export function OddPlayers(props) {
  const [first, , third, , fifth] = props.players;

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        <li>First: {first}</li>
        <li>Third: {third}</li>
        <li>Fifth: {fifth}</li>
      </ul>
    </div>
  );
}

export function EvenPlayers(props) {
  const [, second, , fourth, , sixth] = props.players;

  return (
    <div>
      <h2>Even Team Players</h2>
      <ul>
        <li>Second: {second}</li>
        <li>Fourth: {fourth}</li>
        <li>Sixth: {sixth}</li>
      </ul>
    </div>
  );
}


const T20Players = ['Sachin1', 'Virat3', 'Yuvaraj5'];
const RanjiTrophyPlayers = ['Dhoni2', 'Rohit4', 'Raina6'];

export const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

export default function ShowMergedPlayers() {
  return (
    <div>
      <h1>List of Indian Players Merged:</h1>
      <ul>
        {IndianPlayers.map((player, index) => (
          <li key={index}>Mr. {player}</li>
        ))}
      </ul>
    </div>
  );
}
