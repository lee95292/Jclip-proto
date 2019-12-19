import React from "react";
import axios from "axios";
import AddKeyword from "./addKeyword.jsx";
import Keyword from "./keyword.jsx";

let keywords = [];

class KeywordGroup extends React.Component {
  constructor(props) {
    super(props);
    keywords = [];
    this.state = { data: false };
    this.removeKeyword = this.removeKeyword.bind(this);
  }
  render() {
    return (
      <div className="keywordGroup">
        {keywords.map(keyword => {
          console.log(keyword);
          return (
            <div>
              <Keyword word={keyword.word} hostname={keyword.hostName} />
              <button onClick={this.removeKeyword}>remove</button>
            </div>
          );
        })}
        <AddKeyword />
      </div>
    );
  }

  componentDidMount() {
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
    this.setState({ data: true });
    this.setState({ data: false });
  }

  removeKeyword() {
    var token = localStorage.getItem("token");
    var requestURL =
      "/user/removekey?token=" + token + "&hostname=jbnu_main&word=test";

    if (!token) {
      return;
    }

    axios.get(requestURL).then(res => {
      console.log("--clipGroup.removeKeywords---");
      console.log(typeof res.data);
      console.log(res.data);
      keywords = res.data;
    });
    this.setState({ data: true });
    this.setState({ data: false });
  }
}

export default KeywordGroup;
