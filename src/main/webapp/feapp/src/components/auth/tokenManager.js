function setAuthToken(token) {
  localStorage.setItem("token", token);
}

function getAuthToken() {
  token = localStorage.getItem("token");

  if (!token) console.log("tokenManager.getAuthtoken: token is null");
  return token;
}

export { setAuthToken, getAuthToken };
