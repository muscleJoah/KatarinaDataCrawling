import react, { Component, Fragment } from 'react'
import './MatchHistoryHeader.css'

import ChampionRecordView from '../ChampionRecordView/ChampionRecordView'

const champion_records = {
    "champion_records" : [
        {
            "img" : "https://ddragon.leagueoflegends.com/cdn/11.1.1/img/champion/Malphite.png",
            "win" : 7,
            "lose" : 3,
            "KDA" : 3.7,
        }, 
        {
            "img" : "https://ddragon.leagueoflegends.com/cdn/11.1.1/img/champion/Aatrox.png",
            "win" : 5,
            "lose" : 2,
            "KDA" : 4.1,
        }, 
        {
            "img" : "https://ddragon.leagueoflegends.com/cdn/11.1.1/img/champion/Annie.png",
            "win" : 3,
            "lose" : 1,
            "KDA" : 1.2,
        },
    ]
};

const championImg = "https://ddragon.leagueoflegends.com/cdn/11.1.1/img/champion/Malphite.png"

class MatchHistoryHeader extends Component {

    
    render() {
        return (
            <div className="MatchHistoryHeader_Container">
                <div className="ContentsWrapper">
                    <div className="RecentStats">
                        <div>
                            <p className="WinLose">
                                20승 10패
                            </p>
                            <p className="GameCount">
                                최근 30게임
                            </p>
                        </div>
                        <div>
                            <p className="KDA">
                                KDA 3.18
                            </p>
                            <p className="KDA_detail">
                                7.3 / 7.3 / 13.0
                            </p>
                        </div>
                        <div className="WinRateBar">
                            <div className="winRate" style={{width: "40%"}}/>
                        </div>
                    </div>
                    <ChampionRecordView items={champion_records} />
                </div>

            </div>
        )
    }

}

export default MatchHistoryHeader