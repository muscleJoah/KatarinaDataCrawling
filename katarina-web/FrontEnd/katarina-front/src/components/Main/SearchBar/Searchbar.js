import react, { Component } from 'react'
import './Searchbar.css'
import searchIcon from '../../searchIcon.svg'


class Searchbar extends Component {

    
    render() {
        return (
            <div className="searchbar-ContentWrapper">
                <div className="search_Container">
                    <div className="search_InfoWrapper">
                        <div className="search_InfoContent">
                            <span className="platform">
                                KR
                            </span>
                        </div>
                    </div>
                    <div className="search_InputBox">
                        <input className="search_InputItem" name="summonerName" placeholder="소환사명 검색" />
                        <div className="search_IconWrapper">
                            <img src={searchIcon} className="searchIcon" alt="Summoner Search"/>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}

export default Searchbar