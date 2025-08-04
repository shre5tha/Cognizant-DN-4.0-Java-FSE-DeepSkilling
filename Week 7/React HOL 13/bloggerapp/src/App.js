import React, { useState } from 'react';
import BookDetails, { books } from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';
import logo from './logo.svg';
import './App.css';

function App() {
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);
  const [showCourses, setShowCourses] = useState(true);

  return (
    <div className="App">
      <h1>📘 Blogger App</h1>

      <button onClick={() => setShowBooks(!showBooks)}>
        Toggle Book Details
      </button>
      <button onClick={() => setShowBlogs(!showBlogs)}>
        Toggle Blog Details
      </button>
      <button onClick={() => setShowCourses(!showCourses)}>
        Toggle Course Details
      </button>

      <hr />

      <div className="details-container">
        <BookDetails books={books} showBooks={showBooks} />
        <BlogDetails showBlogs={showBlogs} />
        <CourseDetails showCourses={showCourses} />
      </div>
      
    </div>
  );
}

export default App;
