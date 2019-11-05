import React from 'react';
import './clip.css';


class Clip extends React.Component{

    constructor(props){

    }

    render(){
        return(
            <p>{this.props.order}</p>
            <a href={this.props.link}>{this.props.title}</a>
            <div>
                {this.props.snippet}
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