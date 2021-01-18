import react, { Component } from 'react'
import './SummonerInfo.css'
import gold from '../../../assets/img/Emblem_Gold.png'

const img_URL= "http://ddragon.leagueoflegends.com/cdn/11.1.1/img/profileicon/4450.png";
const tier_URL = ""
const winrate=33.3
const level= 288
const name= "DopaL"
const revisiondate = (new Date(1610525920000)).getDay();


class SummonerInfo extends Component {

    
    render() {
        return (
            <header className="summonerCard_profile">
                <div className="summoner-profile">
                    <div className="summoner-profileWrapper">
                        <div className="summoner-icon">
                            <div className="icon-imageFrame">
                                <img src={img_URL} />
                            </div>
                        </div>

                        <div className="summoner-levelWrapper">
                            <p className="summoner-level">{ level }</p>
                        </div>
                        
                    </div>

                    <div>
                        <h1 className="summoner-name">
                            { name }
                        </h1>
                        <p className="summoner-revisiondate">
                            마지막 업데이트 : { revisiondate }
                        </p>
                    </div>

                </div>
                <div className="summoner-tier">
                    <div className="tier-frame">
                        <div className="tier-rank">
                            <div className="tier-info">
                                { /* tier Boundary */}
                                <svg width="108" height="108" viewBox="0 0 100 100" className="">
                                    <circle 
                                    r="48" 
                                    cx="50%" cy="50%" fill="transparent" 
                                    stroke-dasharray="302" 
                                    stroke-dashoffset="1" 
                                    className="percentage_circle_background" />

                                    <circle 
                                    r="48" 
                                    cx="50%" cy="50%" fill="transparent" 
                                    stroke-dasharray="302" 
                                    stroke-dashoffset={ 302 - (302 * winrate / 100) }
                                    className="percentage_circle_winrate" />
                                </svg>
                                <div className="tier-icon">
                                    <img src={gold} width="72px"/>
                                </div>
                            </div>

                            <div className="tier-detail">
                                <div className="tier-selectTier">
                                    <div className="dropdown_Wrapper">
                                        <div>
                                            <div className="dropdown_padding">
                                                <span>전체 전적</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div>
                                    <p className="tier-string">골드 2</p>
                                    <p className="tier-sstring">10 LP</p>
                                    <p className="tier-sstring">
                                        100승 50패 <span className="tier-winrate"> 33.3% </span>
                                    </p>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
            </header>
        )
    }

}

export default SummonerInfo