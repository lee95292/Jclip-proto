import React from "react";
import ArticleGroup from "components/articleGroup/articleGroup.jsx";
import KeywordGroup from "./keyword/keywordGroup.jsx";

let articles = [];

class ClipGroup extends React.Component {
  render() {
    return (
      <div className="clipGroup">
        <ArticleGroup />
        <KeywordGroup />
      </div>
    );
  }
}

export default ClipGroup;
