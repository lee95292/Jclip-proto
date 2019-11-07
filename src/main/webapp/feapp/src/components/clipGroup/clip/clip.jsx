import React from 'react';
// import './clip.css';


class Clip extends React.Component{

    render(){
        return(
            <div>
                <p>{this.props.order}</p>
                <a href={this.props.link} target="_blank">{this.props.title}</a>
                <div className="class">
                    {this.props.snippet}
                </div>
            </div>
        )
    }
}

class ClipImage extends React.Component{
    render(){
        return (
            <img src={this.props.clipImage} />
        );
   }
}

export default Clip