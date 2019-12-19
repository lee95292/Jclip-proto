import React from "react";
import axios from "axios";
import Article from "./article/article.jsx";
let articles = [];

class ArticleGroup extends React.Component {
  constructor(props) {
    super(props);
    articles = [];
    this.state = { data: false };
  }
  render() {
    return (
      <div className="articleGroup">
        {articles.map(article => {
          console.log(article);
          var snippet = article.articleContent.substr(0, 60);
          return (
            <Article
              number={article.number}
              link={article.articleHyperlink}
              creationTime={article.creationTime}
              hostName={article.hostName}
              articleName={article.articleName}
              articleContent={snippet}
            />
          );
        })}
      </div>
    );
  }

  componentDidMount() {
    this.setState({ data: true });

    var token = localStorage.getItem("token");
    var requestURL;

    if (this.props.fetchType == "bind") {
      requestURL = "/user/article?token=" + token;
    } else if (this.props.fetchType == "new") {
      requestURL = "/article?token=" + token + "&hostname=jbnu_main";
    }
    if (!token) {
      return;
    }

    axios.get(requestURL).then(res => {
      console.log("--articleGroup.getArtricles---");
      console.log(typeof res.data);
      console.log(res);
      articles = res.data;
      this.setState({ data: true });
      this.setState({ data: false });

      console.log(this.state);
    });
  }
}

ArticleGroup.defaultProps = {
  fetchType: "new"
};
export default ArticleGroup;
