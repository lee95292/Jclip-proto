import React from 'react';
import ReactDom from 'react-dom';
import './css/App.css';

class LoginForm extends React.Component {
    render(){
        return (
            <form action="/login" method="POST" >
                <p>Name : <input type="text" placeholder="User Name" name="userName" /></p>        
                <p>E-mail <input type="text" placeholder="Login Email" name="userPassword" /></p>
                <p><input type="password" placeholder="Password" name="userPassword" /></p>
                <p><input type="submit" value="submit" /></p>
            </form>
        );
    }
}

export default LoginForm;