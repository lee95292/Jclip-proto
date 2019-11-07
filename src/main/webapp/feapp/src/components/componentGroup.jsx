/**
 *  /compoenets 내부 컴포넌트 조합
 */
import React from 'react';
import ClipGroup from './clipGroup/ClipGroup.jsx';
import Navbar from './common/navbar/navbar.jsx';
import Sidebar from './common/sidebar/sidebar.jsx';

class ComponentGroup extends React.Component{
    render(){
        return(
        <div>
            <Sidebar />
            <Navbar />
            <ClipGroup />
        </div>
        );
    }
}
export default ComponentGroup;