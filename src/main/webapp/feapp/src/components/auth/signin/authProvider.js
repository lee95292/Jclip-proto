import React from "react";
import { checkAuth } from "components/auth/signin/authCheck.js";

class AuthProvider extends React.Component {
  constructor(props) {
    this.state = {
      isLoggedIn: false,
      loginChecked: false
    };
    this.handleLogin = this.handleLogin.bind(this);
  }

  handleLogin() {
    if (checkAuth()) {
      this.setState({ isLoggedIn: true });
    } else if (!this.state.loginChecked) {
      axios.get("https://localhost:8443/login/google").then(res => {
        if (res.headers.token != undefined) {
          setAuthToken(res.headers.token);
          console.log(res.headers.token);
        } else {
        }
      });
      this.setState({ loginChecked: true });
    }
  }
  componentDidMount() {
    if (!this.state.loginChecked) {
      this.handleLogin();
    }
  }

  componentDidUpdate(prevProps, prevState) {}
  render() {
    return null;
  }
}
export default AuthProvider;
