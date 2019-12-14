import jwt_decode from "jwt-decode";

function decodeJWT(token) {
  return jwt_decode(token);
}

function getEmail(token) {
  var dJtwt = decodeJWT(token);
  return dJtwt.sub;
}

function getName(token) {
  var dJwt = decodeJWT(token);
  return dJwt.name;
}

export { decodeJWT, getEmail, getName };
