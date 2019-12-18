import React from "react";
import axios from "axios";
import AddKeyword from "./addKeyword.jsx";
import Keyword from "./keyword.jsx";

let keywords = [];

class KeywordGroup extends React.Component {
  render() {
    return (
      <div className="keywordGroup">
        {keywords.map(keyword => {
          console.log(keyword);
          return <Keyword word={keyword.word} hostname={keyword.hostName} />;
        })}
        <AddKeyword />
      </div>
    );
  }

  componentDidMount() {
    getKeywords();
  }
}

function getKeywords() {
  var token = localStorage.getItem("token");
  var requestURL = "/user/keyword?token=" + token;

  if (!token) {
    return;
  }

  axios.get(requestURL).then(res => {
    console.log("--clipGroup.getKeywords---");
    console.log(typeof res.data);
    console.log(res.data);
    keywords = res.data;
  });
}

export default KeywordGroup;
