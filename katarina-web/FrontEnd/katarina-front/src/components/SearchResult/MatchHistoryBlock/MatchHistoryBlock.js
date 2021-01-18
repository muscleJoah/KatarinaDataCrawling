
import react, { Component, Fragment } from 'react'

import './MatchHistoryBlock.css'


class MatchHistoryBlock extends Component {

    


    render(){
        return (
            <Fragment>
                <div className="MatchBlockWrapper">
                    <div className="MatchBlock_Header">
                        <p className="HeaderText HeaderConstraints">
                            {this.props.items.dateDiff}일 전
                        </p>
                    </div>
                    <div>
                        {this.props.items.records.map( item => (
                            <Fragment key={item.id}>
                                <a href="#" className="MatchHistory-ContentsWrapper" >
                                    <div className="match_profile">
                                        <div className="match_profile_highlight"/>
                                        <div className="match_profile_ChampionImage" style={{backgroundImage = url(item.championImage) }}>
                                            <div className="match_profile_LaneIcon"> 
                                                {/* svg lane icon implementation */}
                                            </div>
                                        </div>
                                        <div className="match_profile_UserStat">
                                            <div className="match-title">
                                                <p className="match-result">
                                                    {item.result}
                                                </p>
                                                <p className="math-result-ranking">
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
                                                    킬관여율 {item.influence}%
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
                                                    {item.playTime}
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