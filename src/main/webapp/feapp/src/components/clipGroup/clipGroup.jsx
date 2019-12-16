import React from "react";
import Clip from "./clip/clip.jsx";
import axios from "axios";
const clips = [
  {
    id: 1,
    order: 1,
    title: " 전주서곡중학교 교육봉사자 모집 안내(교직이수자)",
    link: "https://www.jbnu.ac.kr/kor/?menuID=139&pno=1&mode=view&no=41911",
    snippet:
      "전주서곡중학교에서는 아래와 같이 교육봉사자를 모집하오니 봉사를 희망하는 학생은 신청하시기 바랍니다.",
    clipImage: null
  },
  {
    id: 2,
    order: 2,
    title: "기관 및 지업 직무인턴 모집(2018.8월 및 2019.2월 졸업자 대상)",
    link: "https://www.jbnu.ac.kr/kor/?menuID=139&mode=view&no=41936",
    snippet:
      "문의사항 : 270-2353(취업지원부) 대상자 외 신청이 불가합니다. 전북테크노파크는 11월8일(금)까지만 신청가능",
    clipImage: null
  },
  {
    id: 3,
    order: 3,
    title: "11월 IT교육 수강안내-정보전산원",
    link: "https://www.jbnu.ac.kr/kor/?menuID=139&mode=view&no=41935",
    snippet: " ​itedu@jbnu.ac.kr 메일로 보내주시면 포인트 지급 ",
    clipImage: null
  }
];
var testclip;
class ClipGroup extends React.Component {
  render() {
    return (
      <div className="clipGroup">
        {clips.map(clip => {
          return (
            <Clip
              order={clip.order}
              title={clip.title}
              link={clip.link}
              snippet={clip.snippet}
              clipImage={clip.clipImage}
            />
          );
        })}
      </div>
    );
  }
  componentDidMount() {
    getArticles();
  }
}

function getArticles() {
  var token = localStorage.getItem("token");
  var requestURL = "article?token=" + token;

  if (!token) {
    return;
  }

  axios.get(requestURL).then(res => {
    console.log(res.status);
    console.log(requestURL);
    console.log(res);
  });
}

export default ClipGroup;
