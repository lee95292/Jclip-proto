import React from 'react';
import {BrowserRouter,Route,NavLink} from 'react-router-dom';
import './navStyle.css';
import About from 'ComponentRoot/contents/about.jsx'
import App from 'ComponentRoot/App';
// import ClipGroup from ''
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
            <BrowserRouter>
                <NavLink exact to="/"><img src="" alt=""/>home</NavLink>
                <NavLink exact to="/about">About</NavLink>
                <NavLink exact to="/clips">Clips</NavLink>
                <NavLink exact to="/articles">Articles</NavLink>

                <Route exact path="/" component={App}/>
                <Route exact path="/about" component={About}/>
            </BrowserRouter>
        );
    }
}

export default Navbar