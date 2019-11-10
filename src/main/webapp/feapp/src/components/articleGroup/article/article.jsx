import React from 'react';
import 'article.css';

class Article extends React.Component{
    render(){
        return(
            <div className="Article">
                <p>{this.props.order}</p>
                <a href={this.props.link}>{this.props.title}</a>
                <div className="class">
                    {this.props.snippet}
                </div>
            </div>
        );
    }
}

export default Article