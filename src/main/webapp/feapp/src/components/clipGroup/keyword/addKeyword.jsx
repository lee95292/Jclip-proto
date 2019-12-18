import React from "react";
import axios from "axios";

class AddKeyword extends React.Component {
  constructor(props) {
    super(props);
    this.addKeywordRequest = this.addKeywordRequest.bind(this);
  }

  addKeywordRequest() {
    console.log("request");
    var token = localStorage.getItem("token");
    var item = document.getElementById("addWord").value;
    var hostname = "jbnu_main"; //TODO:refactor
    if (!token) {
      alert("로그인되어있지 않습니다.");
      item = "";
      return;
    }
    var requsetURL =
      "/bind?keyword=" + item + "&hostname=" + hostname + "&token=" + token;
    axios.get(requsetURL).then(res => {
      if (res.status == 200) {
        console.log(item + "added");
        console.log(res.data);
        document.getElementById("addWord").value = "";
      }
      //keyword group의 keywords 변수 변경하는 방법
    });
  }
  render() {
    return (
      <div className="addKeyword">
        <input type="text" id="addWord" />{" "}
        <button type="button" onClick={this.addKeywordRequest}>
          append
        </button>
      </div>
    );
  }
}

export default AddKeyword;
