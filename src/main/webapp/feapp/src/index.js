import React from "react";
import ReactDom from "react-dom";
// import Sidebar from 'components/common/sidebar/sidebar.jsx';
import Navbar from "components/common/navbar/navbar.jsx";
import "./index.css";
class MainViewApp extends React.Component {
  render() {
    return (
      <>
        <Navbar />
      </>
    );
  }
  componentDidMount() {
    axios.get("https://localhost:8443/login/google").then(res => {
      console.log(res.status);
    });
    // axios.get("https://localhost:8443").then(res => {
    //   console.log("root" + res);
    // });
  }
}

ReactDom.render(<MainViewApp />, document.getElementById("root"));
