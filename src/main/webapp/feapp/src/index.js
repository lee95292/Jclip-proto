import React from 'react';
import ReactDom from 'react-dom';
import Sidebar from 'components/common/sidebar/sidebar.jsx';
import Navbar from 'components/common/navbar/navbar.jsx';
class MainViewApp extends React.Component {
    render() {
        return (
            <>
                <Navbar />
                <Sidebar />
            </>
        );
    }
}

ReactDom.render(<MainViewApp />, document.getElementById('root'));
