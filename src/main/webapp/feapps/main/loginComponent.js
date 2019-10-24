import React from 'react';
import ReactDom from 'react-dom';

class LoginForm extends React.Component {
    render(){
        return (
            <form action="/login" method="POST" >
                <label>Name : <input type="text" placeholder="User Name" name="userName" /></label>
                <label>E-mail <input type="text" placeholder="Login Email" name="userPassword" /></label>
                <label><input type="password" placeholder="Password" name="userPassword" /></label>
                <label><input type="submit" value="submit" /></label>
            </form>
        );
    }
}

export default LoginForm;