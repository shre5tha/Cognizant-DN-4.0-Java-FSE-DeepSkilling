import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: "Jack", score: 50 },
    { name: "Michael", score: 70 },
    { name: "John", score: 40 },
    { name: "Ann", score: 61 },
    { name: "Elisabeth", score: 61 },
    { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 100 },
    { name: "Virat", score: 84 },
    { name: "Jadeja", score: 64 },
    { name: "Raina", score: 75 },
    { name: "Rohit", score: 80 }
  ];

const below70 = [];
  players.map((item) => {
    if (item.score <= 70) {
      below70.push(item);
    }
    return null;
  });

 return (
    <div>
      <h1>List of Players</h1>
      {
        players.map((item, index) => {
          return (
            <div key={index}>
              <li>Mr. {item.name} <span>{item.score}</span></li>
            </div>
          );
        })
      }

      <h1>List of Players having Scores less than 70</h1>
      {
        below70.map((item, index) => {
          return (
            <div key={index}>
              <li>Mr. {item.name} <span>{item.score}</span></li>
            </div>
          );
        })
      }
    </div>
  );
};


export default ListofPlayers;