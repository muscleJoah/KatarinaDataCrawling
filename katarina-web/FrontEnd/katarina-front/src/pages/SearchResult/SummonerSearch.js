import react, {Component} from 'react'
import './SummonerSearch.css'
import NavTab from '../../components/NavTab/NavTab'
import SearchResultLayout from '../../layout/SearchResultLayout/SearchResultLayout'

class SummonerSearch extends Component {

    render() {
        return (

            <div className="navResult_Container">
                <div className="navResult_bodyWrapper scroll">
                    <div className="scrollView_bodyWrapper with_Ads">
                        <div className="navResult_ContentsWrapper">
                            <div className="NavTab_Wrapper">
                                <NavTab />
                                <SearchResultLayout />
                            </div>
                            오<br/>
                            오<br/>
                            오<br/>
                            오<br/>
                            오<br/>
                            오<br/>
                            오<br/>
                            오<br/>

                        </div>

                    </div>


                </div>

                    HI
            </div>

        )
    }

}

export default SummonerSearch