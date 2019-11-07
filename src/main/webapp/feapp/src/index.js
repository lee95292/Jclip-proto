import React from  'react';
import ReactDom from 'react-dom';
import ComponentGroup from './components/componentGroup.jsx';

class MainViewApp extends React.Component{
    render(){
        return (
            <ComponentGroup />
        );
    }   
}

ReactDom.render(<MainViewApp />,document.getElementById('root'));
 