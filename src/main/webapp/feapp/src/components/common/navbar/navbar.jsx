import React from 'react';
import NavItem from './navItem.jsx';
import './navStyle.css';
/**
 *  props of nav-item
 *  1. navItem order
 *  2. navigation link
 *  3. navItem name
 *  4. 
 */

//  navItems=[
//      {
//         order:
//         link: 
//         name:
//      },
//  ]
class Navbar extends React.Component{
    render(){
        return(
            <div className="nav-container">
                <NavItem />
                <NavItem />
                <NavItem />
            </div>
        );
    }
}

export default Navbar