import React, { Component } from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  loadPosts = () => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => response.json())
      .then((data) => {
        const postList = data.map((item) => new Post(item.id, item.title, item.body));
        this.setState({ posts: postList });
      })
      .catch((error) => {
        console.error("Error fetching posts:", error);
      });
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    console.error("Error in component: ", error);
    console.error("Error info:", info);
    alert("An error occured while loading posts");
  }

  render() {
    return (
      <div>
        <h2>Blog Posts</h2>
        <ul>
          {this.state.posts.map((post) => (
            <li key={post.id}>
              <h3>{post.title}</h3>
              <p>{post.body}</p>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default Posts;