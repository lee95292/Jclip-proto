import jwt_decode from "jwt-decode";

function decodeJWT(token) {
  return jwt_decode(token);
}
export default decodeJWT;
