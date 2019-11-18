<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="google-signin-client_id" content="18865688082-motv497124a9k1assumf4db38tluvqv3.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<title>Insert title here</title>
</head>
<body>
    <div id="root"></div>
	
	<script src="/static/js/main.bundle.js"></script>
	<div class="g-signin2 data-onsource="onSignIn">sign-in</div>
	<a href="#" onclick="signOut();">Sign out</a>
	<script>
		function onSignIn(googleUser) {
		  var profile = googleUser.getBasicProfile();
		  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
		  console.log('Name: ' + profile.getName());
		  console.log('Image URL: ' + profile.getImageUrl());
		  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
		}
		
		  function signOut() {
			    var auth2 = gapi.auth2.getAuthInstance();
			    auth2.signOut().then(function () {
			      console.log('User signed out.');
			    });
			  }</script>
</body>
</html>