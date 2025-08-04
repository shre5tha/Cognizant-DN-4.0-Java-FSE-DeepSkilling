import React from 'react';

export const books = [
  { id: 101, bname: 'Master React', price: 670 },
  { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
  { id: 103, bname: 'Mongo Essentials', price: 450 },
];

function BookDetails(props) {
  const bookdet = (
    <ul>
      {props.books.map((book) => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>Price: ₹{book.price}</h4>
        </div>
      ))}
    </ul>
  );

  // Conditional rendering using if
  if (props.showBooks) {
    return (
      <div className="st2">
        <h1>Book Details</h1>
        {bookdet}
      </div>
    );
  } 
  else {
    return <p>No books to display.</p>;
  }
}

export default BookDetails;