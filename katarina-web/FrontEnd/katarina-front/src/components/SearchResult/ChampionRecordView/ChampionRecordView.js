import react, { Component, Fragment } from 'react'
import './ChampionRecordView.css'


class ChampionRecordView extends Component {

    
    render() {
        return (
            <Fragment>
                <div className="MostPlayed">
                {this.props.items.champion_records.map(item => (
                    <Fragment key={item.id}>
                        <div className="MostPlayed_Container">
                            <div size="36px" className="ImageWrapper">
                                <img src = {item.img} loading="lazy"/>
                            </div>
                            <div>
                                <div className="win-Rate">
                                    <p className="champion_winRate">
                                        {((item.win/(item.win+item.lose))*100).toFixed(0)}% 
                                    </p>
                                    <p className="champion_WinLose">
                                        {item.win}승 {item.lose}패
                                    </p>
                                </div>
                                <p className="champion_KDA">
                                    KDA {item.KDA}
                                </p>
                            </div>
                        </div>
                    </Fragment>
                ))}
                </div>
            </Fragment>
        )
    }

}

export default ChampionRecordView