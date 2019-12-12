import React from "react";
import { BrowserRouter, Route, NavLink } from "react-router-dom";
import "./navStyle.css";
import About from "components/contents/about.jsx";
import App from "App";
/**
 *  props of nav-item
 *  1. navItem order
 *  2. navigation link
 *  3. navItem name
 *  4.
 */

class Navbar extends React.Component {
  Navbar() {}
  render() {
    return (
      <BrowserRouter>
        <div className="Navbar">
          <NavLink exact to="/">
            <img src="" alt="" />
            home
          </NavLink>
          <NavLink exact to="/about">
            About
          </NavLink>
          <NavLink exact to="/clips">
            Clips
          </NavLink>
          <NavLink exact to="/articles">
            Articles
          </NavLink>
          <NavLink exact to="/login/google" href="/login/google">
            <img
              src="/static/img/1x/btn_google_signin_dark_pressed_web.png"
              alt=""
            />
          </NavLink>
        </div>

        <Route exact path="/" component={App} />
        <Route exact path="/about" component={About} />
      </BrowserRouter>
    );
  }
}

export default Navbar;
