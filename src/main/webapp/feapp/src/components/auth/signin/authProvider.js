import { setAuthToken, getAuthToken } from "components/auth/tokenManager.js";
import axios from "axios";

let isLoggedIn = false;

//login token 받아오기
function handleLogin() {
  console.log("authProvider.handleLogin working... ");

  axios.get("login/google").then(res => {
    if (res.headers.token != undefined) {
      setAuthToken(res.headers.token);

      isLoggedIn = true;
      console.log(res.headers.token);
      console.log("authProvider.handleLogin :login successful");
    } else {
      alert("login failed");
    }
  });
}

function handleLogout() {
  isLoggedIn = false;
}

function getLoginState() {
  return isLoggedIn;
}

export { handleLogin, handleLogout, getLoginState };
