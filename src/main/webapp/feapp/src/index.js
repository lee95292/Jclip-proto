import React from "react";
import ReactDom from "react-dom";
import axios from "axios";
// import Sidebar from 'components/common/sidebar/sidebar.jsx';
import Navbar from "components/common/navbar/navbar.jsx";
import "./index.css";
import {
  checkAuth,
  setAuthToken,
  getAuthToken
} from "components/auth/signin/authCheck.js";
import AuthProvider from "components/auth/signin/authProvider.js";

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
    // console.log(getAuthToken());
    // if (checkAuth() != undefined) {
    //  AuthProvider.setState({ isLoggedIn: true });
    // } else {

    axios.get("https://localhost:8443/login/google").then(res => {
      setAuthToken(res.headers.token);
    });
  }
}

ReactDom.render(<MainViewApp />, document.getElementById("root"));
