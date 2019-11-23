/**
 * ./components에 있는 컴포넌트들 조립
 */
import React from 'react';
import './App.css';
import ClipGroup from 'components/clipGroup/clipGroup.jsx';

class App extends React.Component{
    render(){
        return(
            <div className="App">
                <ClipGroup/>
            </div>
        );
    }
}

export default App;
