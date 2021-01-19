
import { Component, Fragment } from 'react'

import './MatchHistoryBlock.css'


class MatchHistoryBlock extends Component {

    render(){
        function playTimeParser(millisec) {
            var seconds = (millisec / 1000).toFixed(0);
            var minutes = Math.floor(seconds / 60);
            var hours = "";
            if (minutes > 59) {
                hours = Math.floor(minutes / 60);
                hours = (hours >= 10) ? hours : "0" + hours;
                minutes = minutes - (hours * 60);
                minutes = (minutes >= 10) ? minutes : "0" + minutes;
            }
    
            seconds = Math.floor(seconds % 60);
            seconds = (seconds >= 10) ? seconds : "0" + seconds;
            if (hours != "") {
                return hours + "시간 " + minutes + "분 " + seconds + "초";
            }
            return minutes + "분 " + seconds + "초";
        }

        return (
            <Fragment>
                <div className="MatchBlockWrapper">
                    <div className="MatchBlock_Header">
                        <p className="HeaderText HeaderConstraints">
                            {this.props.records.dateDiff}일 전
                        </p>
                    </div>

                    <div>
                        {this.props.records.dateMatches.map( item => (
                            <Fragment key={item.id}>
                                <a href="#" className="MatchHistory-ContentsWrapper" >
                                    <div className="match_profile">
                                        <div className="match_profile_highlight"/>
                                        <div className="match_profile_ChampionImage" style={{backgroundImage: "url(" + item.championImage + ")" }}>
                                            <div className="match_profile_LaneIcon"> 
                                                {/* svg lane icon implementation */}
                                            </div>
                                        </div>
                                        <div className="match_profile_UserStat">
                                            <div className="match-title">
                                                <p className="match-result">
                                                    {item.result}
                                                </p>
                                                <p className="match-result-ranking">
                                                    {item.ranking}
                                                </p>
                                            </div>
                                            <div class="match-kda">
                                                <p className="match-info-title">
                                                    KDA {((item.kill+item.assist)/item.death).toFixed(2)}
                                                </p>
                                                <p className="match-info-sub">
                                                    {item.kill} / {item.death} / {item.assist}
                                                </p>
                                            </div>
                                            <div class="match-influence">
                                                <p className="match-info-title">
                                                    킬관여율 {((item.kill+item.assist)/item.team_kill*100).toFixed(0)}%
                                                </p>
                                                <p className="match-info-sub">
                                                    {item.cs} ({(item.cs/(item.playTime/1000/60)).toFixed(1)}) CS
                                                </p>
                                            </div>
                                            <div className="match-items">
                                                {item.userItems.map( userItem =>
                                                    <Fragment key={userItem.id}>
                                                        <div className="match-item">
                                                            <img src={userItem.imgSrc} className="match-item-image" />
                                                        </div>
                                                    </Fragment>
                                                )}
                                            </div>
                                            <div class="match-details">
                                                <p className="match-info-title">
                                                    {item.gameType}
                                                </p>
                                                <p className="match-info-sub">
                                                    {playTimeParser(item.playTime)}
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </a>

                            </Fragment>                                
                            ))}
                    </div>
                </div>
            </Fragment>

        )
    }
}

export default MatchHistoryBlock