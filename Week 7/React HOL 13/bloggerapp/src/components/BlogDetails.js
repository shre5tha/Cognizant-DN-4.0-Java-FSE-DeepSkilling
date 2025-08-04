import React from 'react';

function BlogDetails({ showBlogs }) {
  const blogs = [
    { id: 1, title: "React Hooks in Depth" },
    { id: 2, title: "Understanding State and Props" },
  ];

  // Conditional rendering using ternary operator
  return (
    <div className="v1">
      <h1>Blog Details</h1>
      {showBlogs ? (
        <ul>
          {blogs.map((blog) => (
            <li key={blog.id}>{blog.title}</li>
          ))}
        </ul>
      ) : (
        <p>No blog data found.</p>
      )}
    </div>
  );
}

export default BlogDetails;
