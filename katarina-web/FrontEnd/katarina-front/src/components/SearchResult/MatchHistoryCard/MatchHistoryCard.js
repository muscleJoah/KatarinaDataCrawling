import react, { Component, Fragment } from 'react'
import './MatchHistoryCard.css'


class MatchHistoryCard extends Component {

    
    render() {
        return (
            <Fragment>
                <ol className="FriendStats">
                {this.props.items.matches.map(item => (
                    <Fragment key={item.id}>
                        <li>

                            <a href="#" className="friendStat-link ">
                                <div className="friendStat-iconWrapper ">
                                    <img src={item.profileIcon} loading="lazy" className="friendStat-icon"/>
                                    <p className="friendStat-summonerName friendStat-typography">{item.summonerName}</p>
                                </div>
                                <div className="friendStat-frame">
                                    <p className="friendStat-records stat-column friendStat-typography">
                                        {item.win}승 {item.lose}패
                                    </p>
                                    <p className="friendStat-ratio stat-column friendStat-typography">
                                        승률 : {item.ratio}
                                    </p>
                                </div>
                            </a>

                        </li>
                    </Fragment>
                ))}
                </ol>
            </Fragment>
        )
    }

}

export default MatchHistoryCard