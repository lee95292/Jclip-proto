import React from "react";
import axios from "axios";
class Keyword extends React.Component {
  render() {
    return (
      <div className="keyword">
        {this.props.word}:{this.props.hostname}
      </div>
    );
  }
}

export default Keyword;
