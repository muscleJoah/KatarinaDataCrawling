
import { Component, Fragment } from 'react'

import MatchHistoryBlock from '../MatchHistoryBlock/MatchHistoryBlock'
import './MatchHistoryList.css'




class MatchHistoryList extends Component {



    render() {

        function date_diff(b) {

        }

        function match_divider(match_list) {
            var json = {};
            json.matches = [];

            var temp = [];
        }


        return (
            <Fragment>
                <div className="MatchHistory-Container">
                        {this.props.items.matches.map(item => 
                            <MatchHistoryBlock records = {item} />
                            )}
                </div>
            </Fragment>
        )
    }

}

export default MatchHistoryList