import { Component, Fragment } from 'react'
import './ChampionHistoryCard.css'


class ChampionHistoryCard extends Component {

    
    render() {
        return (
            <Fragment>
                <ol className="championStats">
                {this.props.items.champion_history.map(item => (
                    <Fragment key={item.id}>
                        <li>
                            <a href="#" className="championStat-link ">
                                <div className="championStat-iconFrame">
                                    <img src={item.championIcon} loading="lazy" className="championStat-icon"/>
                                </div>
                                <div className="championStat-leftFrame">
                                    <p className="championStat-text">
                                        {item.champion}
                                    </p>
                                    <p className="championStat-text">
                                        {item.gameCount} 게임
                                    </p>
                                </div>
                                <div className="championStat-rightFrame">
                                    <p className="championStat-text">
                                        KDA : {item.kda}
                                    </p>
                                    <p className="championStat-text">
                                        승 률 : {item.winRate}%
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

export default ChampionHistoryCard