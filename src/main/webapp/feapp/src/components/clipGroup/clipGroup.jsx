import React from 'react';
import Clip from './clip/clip.jsx';
const clips=[
    {
        id:1,
        order:1,
        title:' 전주서곡중학교 교육봉사자 모집 안내(교직이수자)',
        link:'https://www.jbnu.ac.kr/kor/?menuID=139&pno=1&mode=view&no=41911',
        snippet:'전주서곡중학교에서는 아래와 같이 교육봉사자를 모집하오니 봉사를 희망하는 학생은 신청하시기 바랍니다.',
        clipImage: null
    }
]

class clipGroup extends React.Component{
    constructor(props){

    }

    render(){
        return(
            <div className="clipGroup">
                {clips.map( clip => {
                    return <Clip order={clips.order} title={clips.title} link={clips.link} snippet={clips.snippet} clipImage={clips.clipImage}/>
                })}
            </div>
        );
    }
}

export default clipGroup