
import react, { Component, Fragment } from 'react'
import './MatchHistoryList.css'




class MatchHistoryList extends Component {



    render() {
        return (
            <Fragment>
                <div className="MatchHistory-Container">
                    <div className="">
                        {this.props.items.matches.map(item => 
                            <Fragment>
                                

                            </Fragment>
                            )}
                    </div>
                </div>
            </Fragment>
        )
    }

}

export default MatchHistoryList