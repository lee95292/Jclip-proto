import React from  'react';
import ReactDom from 'react-dom';

class MainViewApp extends React.Component{
    render(){
        return <div className="main">메인 페이지 테스트</div>
    }   
}

ReactDom.render(<MainViewApp />,document.getElementById('root'));
