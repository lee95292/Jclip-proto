import React from 'react';
import {Router,Link} from 'react-router-dom';
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
                <Link to="/" component={App}><img src="" alt=""/>home</Link>
                <Link to="/about" compoennt={About}></Link>
                
            </div>
        );
    }
}

export default Navbar