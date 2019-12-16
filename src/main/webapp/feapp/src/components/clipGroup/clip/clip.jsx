import React from "react";
// import './clip.css';

class Clip extends React.Component {
  render() {
    return (
      <div>
        <p>{this.props.order}</p>
        <a href={this.props.link} target="_blank">
          {this.props.title} <button>CLIP!</button>
        </a>
        <div className="class">{this.props.snippet}</div>
      </div>
    );
  }
}
function addKeyword() {
  //TODO
  var reqURL = "/bind?hostname=jbnu_main";
}
class ClipImage extends React.Component {
  render() {
    return <img src={this.props.clipImage} />;
  }
}

export default Clip;
