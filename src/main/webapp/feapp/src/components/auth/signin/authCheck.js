import { decodeJWT } from "components/utils/jwtDecoder.js";

function checkAuth() {
  if (getAuthToken() == null || getAuthToken() == undefined) {
    return false;
  } else {
    return true;
  }
}
/*
    @param - token (json)
*/
function setAuthToken(token) {
  localStorage.setItem("token", token);
}
//TODO: need refactor : error - [getAuthToken] is not a function
function getAuthToken() {
  var token = localStorage.getItem("token");

  dJwt = decodeJWT(token);

  if (dJwt == null || dJwt == undefined) {
    return null;
  }
  return dJwt;
}
export { checkAuth, getAuthToken, setAuthToken };
