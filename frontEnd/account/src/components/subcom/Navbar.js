import React, { Component } from 'react';
import { NavLink as RRNavLink} from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink
} from 'reactstrap';


export class NavBar extends Component {
    constructor(props) {
        super(props);

        this.toggleNavbar = this.toggleNavbar.bind(this);
        this.state = {
            collapsed: true
        };
    }

    toggleNavbar() {
        this.setState({
            collapsed: !this.state.collapsed
        });
    }
    render() {
        return (
            <div>
                <Navbar color="light" light expand="md">
                    <NavbarBrand tag={RRNavLink} to="/">Register Assessment</NavbarBrand>
                    <NavbarToggler onClick={this.toggle} />
                    <Collapse isOpen={this.state.isOpen} navbar>
                        <Nav className="ml-auto" navbar>
                            <NavItem>
                                <NavLink tag={RRNavLink} to="./register">
                                    <FontAwesomeIcon icon='user-plus'></FontAwesomeIcon>
                                    <p>Register</p></NavLink>
                            </NavItem>
                            <NavItem>
                                <NavLink tag={RRNavLink} to="./results">
                                    <FontAwesomeIcon icon='user-plus'></FontAwesomeIcon>
                                    <p>results</p></NavLink>
                            </NavItem>
                        </Nav>
                    </Collapse>
                </Navbar>
            </div>
        );
    }
}