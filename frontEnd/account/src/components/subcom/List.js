import React, { Component } from 'react';
import { NavLink as RRNavLink, BrowserRouter as Router, Route, Link } from "react-router-dom";
import axios from 'axios';
import { UserList } from './functions/tableHead.js';

export class List extends Component {

    constructor() {
        super()
        this.state = {
            users: []
        }
    }

    results = () => {
        axios.get("http://localhost:8080/accounts/getAll").then(res => {
            this.setState({
                users: res.data
            });
        }).catch(res => {
            console.log(res);
        });
    }
    
    render() {
        return (
            <div>
                <br></br>
                <UserList data={this.state.users}/>
            </div>
        )
    }

    componentDidMount() {
        this.results()
    }

}