import React, { Component } from 'react';
import { BrowserRouter as Router, Route} from "react-router-dom";
import { NavBar } from './subcom/Navbar.js';
import { Home } from './subcom/Home.js';
import { Register } from './subcom/Register.js';
import { List } from './subcom/List.js';

export class RouterHome extends Component {
    render() {
        return (
            <Router>
                <div>
                    <NavBar />
                    <Route exact path='/' render={() => <Home />} />
                    <Route path='/register' render={() => <Register />} />
                    <Route path='/results' render={() => <List />} />
                    </div>
            </Router>
        )
    }
}