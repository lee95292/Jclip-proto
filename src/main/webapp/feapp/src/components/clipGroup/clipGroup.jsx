import React from "react";
import axios from "axios";
import Clip from "./clip/clip.jsx";
import Keyword from "./clip/keyword.jsx";
import AddKeyword from "./addKeyword.jsx";

let articles = [];
var keywords = [];
class ClipGroup extends React.Component {
  render() {
    return (
      <div className="clipGroup">
        <div className="articleGroup">
          {articles.map(clip => {
            return (
              <Clip
                order={clip.order}
                title={clip.title}
                link={clip.link}
                snippet={clip.snippet}
                clipImage={clip.clipImage}
              />
            );
          })}
        </div>
        <div className="keywordGroup">
          {keywords.map(keyword => {
            return <Keyword word={keyword.word} hostname={keyword.hostName} />;
          })}
        </div>
        <AddKeyword />
      </div>
    );
  }
  componentDidMount() {
    getBindedArticles();
    getKeywords();
  }
}

function getBindedArticles() {
  var token = localStorage.getItem("token");
  var requestURL = "/user/article?token=" + token;

  if (!token) {
    return;
  }

  axios.get(requestURL).then(res => {
    console.log("--clipGroup.getArtricles---");
    console.log(res.status);
    console.log(res);
  });
}

function getKeywords() {
  var token = localStorage.getItem("token");
  var requestURL = "/user/keyword?token=" + token;

  if (!token) {
    return;
  }

  axios.get(requestURL).then(res => {
    console.log("--clipGroup.getKeywords---");
    console.log(res.status);
    console.log(res);
    keywords = res.data;
  });
}

export default ClipGroup;
