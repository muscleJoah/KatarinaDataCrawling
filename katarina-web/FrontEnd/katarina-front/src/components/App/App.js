
import React, { Component, useState, useEffect} from 'react';
import './App.css';
import Main from '../../pages/Main/Main'
import SummonerSearch from '../../pages/SearchResult/SummonerSearch'
import { render } from 'react-dom';

class App extends Component {
  /*
  const [message, setMessage] = useState("");
  useEffect(() => {
    fetch('/api/katarina')
      .then(response => response.text())
      .then(message => {
        setMessage(message);
      });
  },[])
*/

  render() {
    return (
      <div className="App">
        { /* <Main/> */ }
        <SummonerSearch/>
      </div>
    )
  }
}

export default App;
