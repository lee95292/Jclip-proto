/**
 * ./components에 있는 컴포넌트들 조립
 */
import React from 'react';

import Sidebar from 'components/common/sidebar/sidebar.jsx';
import ClipGroup from 'components/clipGroup/clipGroup.jsx';

class App extends React.Component{
    render(){
        return(
            <>
                <Sidebar/>
                <ClipGroup/>
            </>
        );
    }
}

export default App;