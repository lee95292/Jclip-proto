import React from  'react';
import ReactDom from 'react-dom';
import App from './App';

class MainViewApp extends React.Component{
    render(){
        return (
            <App />
        );
    }   
}

ReactDom.render(<MainViewApp />,document.getElementById('root'));
 