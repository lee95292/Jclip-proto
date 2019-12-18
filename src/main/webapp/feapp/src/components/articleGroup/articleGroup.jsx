import React from "react";
import axios from "axios";
import Article from "./article/article.jsx";
let articles = [];

class ArticleGroup extends React.Component {
  render() {
    return (
      <div className="articleGroup">
        {articles.map(article => {
          console.log(article);
          return <Article />;
        })}
      </div>
    );
  }
  componentDidMount() {
    getBindedArticles();
  }
}

function getBindedArticles() {
  var token = localStorage.getItem("token");
  var requestURL = "/user/article?token=" + token;

  if (!token) {
    return;
  }

  axios.get(requestURL).then(res => {
    console.log("--articleGroup.getArtricles---");
    console.log(typeof res.data);
    console.log(res);
    this.articles = res.data;
  });
}

export default ArticleGroup;
