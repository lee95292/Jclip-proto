import React from "react";
// import './clip.css';

class Article extends React.Component {
  render() {
    return (
      <div className="article">
        <p>
          {this.props.number}_{this.props.hostName}
          <sub>{this.props.creationTime}</sub>
        </p>
        <a href={this.props.link} target="_blank">
          {this.props.articleName} <button>CLIP!</button>
        </a>
        <div className="class">{this.props.articleContent}</div>
      </div>
    );
  }
}

class ArticleImage extends React.Component {
  render() {
    return <img src={this.props.articleImage} />;
  }
}

export default Article;
