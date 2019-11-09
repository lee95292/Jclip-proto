import React from  'react';
import ReactDom from 'react-dom';

import Navbar from 'components/common/navbar/navbar.jsx';
class MainViewApp extends React.Component{
    render(){
        return (
            <>
            <Navbar/>
            </>
        );
    }   
}

ReactDom.render(<MainViewApp />,document.getElementById('root'));
 