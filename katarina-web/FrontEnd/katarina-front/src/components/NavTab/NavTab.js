import react, { Component } from 'react'
import './NavTab.css'


class NavTab extends Component {

    
    render() {
        return (
            <div>
                <nav className="NavTab_navFrame">
                    <ol className="NavTab_navList">
                        <a className="NavTab_navItem">
                            <p className="NavTab_navText nav_onSelected">
                                전적 조회
                            </p>
                        </a>

                        <a className="NavTab_navItem">
                            <p className="NavTab_navText">
                                챔피언 정보
                            </p>
                        </a>

                        <a className="NavTab_navItem">
                            <p className="NavTab_navText">
                                랭킹
                            </p>
                        </a>

                    </ol>
                </nav>
            </div>
        )
    }

}

export default NavTab