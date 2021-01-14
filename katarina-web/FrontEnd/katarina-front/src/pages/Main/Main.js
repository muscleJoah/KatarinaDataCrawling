import react, { Component } from 'react'
import './Main.css'
import Searchbar from '../../components/SearchBar/Searchbar'
import logo from '../../logo.svg'



class Main extends Component {

    
    render() {
        return (
            <div className="katarina-app">
                <div className="MainView">
                    <div className="Container">
                        { /* 로고 + 검색창 */ }
                        <div className="ContentWrapper">
                            <div className="logo-wrapper">
                                <img src={logo} className="Logo" alt="Welcome to Katarina"/>
                            </div>
                            <div className="main_searchContainer">
                                <Searchbar/>
                            </div>
                        </div>
                        { /* 소개 컴포넌트 or 랭킹 정보 ( 예정 )  */ }
                        <div className="IntroductionWrapper">
                            
                        </div>
                    </div>
                </div>
                <div className="">

                </div>
            </div>
        )
    }

}

export default Main