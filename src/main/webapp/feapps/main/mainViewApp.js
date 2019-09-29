import React from  'react';
import ReactDom from 'react-dom';

class MainViewApp extends React.Component{
    render(){
        return <div className="main">Main page</div>
    }   
}

ReactDom.render(<MainViewApp />,document.getElementById('root'));
