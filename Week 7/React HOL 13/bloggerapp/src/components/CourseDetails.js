import React from 'react';

function CourseDetails({ showCourses }) {
  const courses = [
    { id: 1, cname: 'React for Beginners', duration: '4 Weeks' },
    { id: 2, cname: 'Advanced Node.js', duration: '6 Weeks' },
  ];

  // Conditional rendering using && and IIFE
  return (
    <div className="mystyle1">
      <h1>Course Details</h1>

      {/* Using && */}
      {showCourses && (
        <ul>
          {courses.map((course) => (
            <li key={course.id}>
              {course.cname} - {course.duration}
            </li>
          ))}
        </ul>
      )}

      {/* Using IIFE */}
      {(() => {
        if (!showCourses) {
          return <p>No courses available at the moment.</p>;
        }
      })()}
    </div>
  );
}

export default CourseDetails;
