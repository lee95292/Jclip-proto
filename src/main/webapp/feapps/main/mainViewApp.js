import React from  'react';
import ReactDom from 'react-dom';
import LoginForm from './loginComponent';
class MainViewApp extends React.Component{
    render(){
        return (
            <LoginForm />
        );
    }   
}

ReactDom.render(<MainViewApp />,document.getElementById('root'));
