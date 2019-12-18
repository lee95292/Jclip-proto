import React from "react";
import { BrowserRouter, Route, NavLink } from "react-router-dom";
import "./navStyle.css";
import About from "components/contents/about.jsx";
import App from "App";
import AuthProvider from "components/auth/signin/authProvider.js";
import ArticleGroup from "components/articleGroup/articleGroup.jsx";
import ClipGroup from "components/clipGroup/clipGroup.jsx";
/**
 *  props of nav-item
 *  1. navItem order
 *  2. navigation link
 *  3. navItem name
 *  4.
 */

class Navbar extends React.Component {
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
          <a href="/login/google">
            <img
              src="/static/img/1x/btn_google_signin_dark_pressed_web.png"
              alt=""
            />
          </a>
        </div>

        <Route exact path="/" component={App} />
        <Route exact path="/about" component={About} />
        <Route exact path="/clips" component={ClipGroup} />
        <Route exact path="/articles" component={ArticleGroup} />
      </BrowserRouter>
    );
  }
}

export default Navbar;
