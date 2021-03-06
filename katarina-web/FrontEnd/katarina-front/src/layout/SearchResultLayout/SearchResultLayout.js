import { Component } from 'react'
import './SearchResultLayout.css'

import SummonerInfo from '../../components/SearchResult/SummonerInfo/SummonerInfo'
import ChampionHistoryCard from '../../components/SearchResult/ChampionHistoryCard/ChampionHistoryCard'
import FriendHistoryCard from '../../components/SearchResult/FriendHistoryCard/FriendHistoryCard'

import MatchHistoryHeader from '../../components/SearchResult/MatchHistoryHeader/MatchHistoryHeader'
import MatchHistoryList from '../../components/SearchResult/MatchHistoryList/MatchHistoryList'


const matchDataList = {
    "matches" : [
        {
            "dateDiff" : 1,
            "dateMatches" : [
                {
                    "championImage" : "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/champion/TwistedFate.png",
                    "result" : "승리",
                    "ranking" : "5th",
                    "kill" : 10,
                    "assist" : 5,
                    "death" : 8,
                    "cs" : 180,
                    "playTime" : 1000000,
                    "team_kill" : 30,
                    "gameType" : "솔로 랭크",
                    "userItems" : [
                        {
                            "imgSrc" : "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/item/2065.png",
                        },
                        {
                            "imgSrc" : "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/item/3011.png",
                        },
                        {
                            "imgSrc" : "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/item/2065.png",
                        },
                        {
                            "imgSrc" : "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/item/3011.png",
                        },
                        {
                            "imgSrc" : "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/item/2065.png",
                        },
                        {
                            "imgSrc" : "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/item/3011.png",
                        }
                    ]
                },
            ]
        },
    ]
}

const friendrecord_preload = {
    "friend_history" : [
        {
            "summonerName": "도팔",
            "profileIcon": "https://ddragon.leagueoflegends.com/cdn/11.1.1/img/profileicon/7.png",
            "win": 7,
            "lose": 4,
            "ratio": 62.4,
        },
        {
            "summonerName": "도팔",
            "profileIcon": "https://ddragon.leagueoflegends.com/cdn/11.1.1/img/profileicon/7.png",
            "win": 7,
            "lose": 4,
            "ratio": 62.4,
        },
        {
            "summonerName": "도팔",
            "profileIcon": "https://ddragon.leagueoflegends.com/cdn/11.1.1/img/profileicon/7.png",
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
                <div colspan="4" className="grid-Profile">
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
                        <ChampionHistoryCard items={championrecord_preload} />
                        <div className="search_moreFrame">
                            <a href="#" className="search_moreButton"> 더 보기 </a>
                        </div>
                    </div>

                    <div className="search_friendWrapper">
                        <div className="search_friendHeader">
                            <div className="search_friendHeaderText">
                                <p className="search_friendText">함께 플레이한 유저</p>
                            </div>
                        </div>
                        <FriendHistoryCard items={friendrecord_preload} />
                        <div className="search_moreFrame">
                            <a href="#" className="search_moreButton"> 더 보기 </a>
                        </div>
                    </div>
                </div>

                <div colspan="8" className="grid-Match">
                    <a href="#" className="search_NoticeBanner">
                        <div className="NoticeBanner-ContentsWrapper NoticeBanner-SquareWrapper">
                            <p className="NoticeBanner-Text">
                                [ 공지 ] 카타리나 베타 ver 0.1 오픈
                            </p>
                        </div>
                    </a>
                    <div className="search_Matches">
                        <MatchHistoryHeader/>
                        <MatchHistoryList items = {matchDataList}/>
                    </div>

                </div>
            </div>
        )
    }

}

export default SearchResultLayout