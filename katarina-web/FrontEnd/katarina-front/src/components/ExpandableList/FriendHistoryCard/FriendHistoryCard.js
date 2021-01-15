import react, { Component, Fragment } from 'react'
import './FriendHistoryCard.css'


class FriendHistoryCard extends Component {

    
    render() {
        return (
            <Fragment>
                <div className="FriendStats">
                {this.props.items.friend_history.map(item => (
                    <Fragment key={item.id}>
                        <a href="#" className="friendStat-link ">
                            <div className="friendStat-iconWrapper ">
                                <img src={item.profileIcon} loading="lazy" className="friendStat-icon"/>
                                <p className="friendStat-summonerName">{item.summonerName}</p>
                            </div>
                            <div className="friendStat-frame">
                                <p className="friendStat-records stat-column">
                                    {item.win}승 {item.lose}패
                                </p>
                                <p className="friendStat-ratio">
                                    승률 : {item.ratio}
                                </p>
                            </div>
                        </a>
                    </Fragment>
                ))}
                </div>
            </Fragment>
        )
    }

}

export default FriendHistoryCard