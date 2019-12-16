import React from "react";
import ReactDom from "react-dom";
import Navbar from "components/common/navbar/navbar.jsx";
import "./index.css";
import { handleLogin } from "components/auth/signin/authProvider.js";

class MainViewApp extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <>
        <Navbar />
      </>
    );
  }
  componentDidMount() {
    handleLogin();
  }
}

ReactDom.render(<MainViewApp />, document.getElementById("root"));
