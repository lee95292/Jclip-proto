import React from "react";
import ArticleGroup from "components/articleGroup/articleGroup.jsx";
import KeywordGroup from "./keyword/keywordGroup.jsx";

class ClipGroup extends React.Component {
  render() {
    return (
      <div className="clipGroup">
        <KeywordGroup />
        <ArticleGroup fetchType="bind" />
      </div>
    );
  }
}

export default ClipGroup;
