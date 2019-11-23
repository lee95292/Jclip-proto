import React from 'react';
import ReactDom from 'react-dom';
import Sidebar from 'components/common/sidebar/sidebar.jsx';
import Navbar from 'components/common/navbar/navbar.jsx';
import './index.css';
class MainViewApp extends React.Component {
    componentDidMount(){
    }
    render() {
        return (
            <>
                <Sidebar />
                <Navbar />
            </>
        );
    }
}

ReactDom.render(<MainViewApp />, document.getElementById('root'));
