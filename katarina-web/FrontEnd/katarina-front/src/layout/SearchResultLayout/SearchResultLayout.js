import react, { Component } from 'react'
import './SearchResultLayout.css'

import SummonerInfo from '../../components/SummonerInfo/SummonerInfo'
import ChampionHistoryCard from '../../components/ExpandableList/ChampionHistoryCard/ChampionHistoryCard'

const friendrecord_preload = {
    "friend_history" : [
        {
            "summonerName": "도팔",
            "profileIcon": "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/champion/TwistedFate.png",
            "win": 7,
            "lose": 4,
            "ratio": 62.4,
        },
        {
            "summonerName": "도팔",
            "profileIcon": "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/champion/TwistedFate.png",
            "win": 7,
            "lose": 4,
            "ratio": 62.4,
        },
        {
            "summonerName": "도팔",
            "profileIcon": "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/champion/TwistedFate.png",
            "win": 7,
            "lose": 4,
            "ratio": 62.4,
        },
    ]
}

const championrecord_preload = {
    "season" : "2021 시즌",

    "champion_history" : [
      {
        "champion": "트위스티드 페이트",
        "championIcon": "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/champion/TwistedFate.png",
        "gameCount": 10,
        "winRate": 47.4,
        "kda": 3.14,
      },

      {
        "champion": "애니",
        "championIcon": "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/champion/Annie.png",
        "gameCount": 10,
        "winRate": 61.2,
        "kda": 2.1,
      },


      {
        "champion": "다리우스",
        "championIcon": "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/champion/Darius.png",
        "gameCount": 10,
        "winRate": 31.8,
        "kda": 3.9,
      },
    ]
  }

class SearchResultLayout extends Component {

    
    render() {
        return (
            <div className="searchResult_gridLayout">
                <div colspan="4" className="grid_set">
                    <SummonerInfo/>
                    <div className="search_championWrapper">
                        <div className="search_championHeader">
                            <a href="#" className="search_championHeaderLink">
                                <p className="search_championSeasonText">{championrecord_preload.season} 챔피언 통계</p>
                                <svg viewBox="0 0 32 32" class="search_svgRightArrow">
                                    <title>chevron-right</title>
                                    <path d="M13.236 8l-1.903 1.88 6.181 6.12-6.181 6.12 1.903 1.88 8.097-8z"></path>
                                </svg>
                            </a>
                        </div>
                        <ChampionHistoryCard items={championrecord_preload}/>
                        <div className="search_moreFrame">
                            <a href="#" className="search_moreButton"> 더 보기 </a>
                        </div>
                    </div>

                    <div className="search_friendWrapper">
                        <div className="search_friendWrapper">
                            <div className="search_friendHeaderText">
                                <p className="search_friendText">함께 플레이한 유저</p>
                            </div>
                        </div>
                        
                    </div>
                </div>

                <div colspan="8" >

                </div>
            </div>
        )
    }

}

export default SearchResultLayout