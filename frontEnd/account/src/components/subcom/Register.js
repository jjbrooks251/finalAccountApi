import React, { Component } from 'react';
import axios from 'axios';
import { Col, Button, Form, FormGroup, Label, Input, FormText, FormFeedback } from 'reactstrap';

export class Register extends Component {

    addUser = (e) => {
        e.preventDefault();

        let account = {
            firstName: e.target[0].value,
            lastName: e.target[1].value,
            email: e.target[2].value
        }

        if (account.email.indexOf(".") === -1) {
            document.getElementById("emailError").innerText = "Email requires a '.'"
        } else {
                axios.post("http://localhost:8080/accounts/createAccount", account).then(res => {
                    console.log(res);
                }).then(() => {
                    window.location.reload();
                }).catch(res => {
                    console.log(res);
                })
            
        }

    }

    firstEntry = (e) => {
        const re = /[a-zA-Z]+/g;
        if (!re.test(e.key)) {
            e.preventDefault();
            document.getElementById("firstError").innerText = "Username cannot contain " + e.key
            console.log(e.key + ' is not valid')
        }
    }

    lastEntry = (e) => {
        const re = /[a-zA-Z]+/g;
        if (!re.test(e.key)) {
            e.preventDefault();
            document.getElementById("lastError").innerText = "Username cannot contain " + e.key
            console.log(e.key + ' is not valid')
        }
    }

    render() {
        return (
            <div>
                <Form onSubmit={this.addUser} className="register-form">
                    <FormGroup row>
                        <Col sm={2}>
                            <Label for="firstName">first Name</Label>
                        </Col>
                        <Col sm={3}>
                            <Input type="text" name="firstName" placeholder="Enter first Name" onKeyPress={(e) => this.firstEntry(e)} required />
                        </Col>
                        <Col sm={3}>
                            <p id='firstError' style={{ color: 'red' }}></p>
                        </Col>
                    </FormGroup>
                    <FormGroup row>
                        <Col sm={2}>
                            <Label for="lastName">last Name</Label>
                        </Col>
                        <Col sm={3}>
                            <Input type="text" name="lastName" placeholder="Enter last Name" onKeyPress={(e) => this.lastEntry(e)} required />
                        </Col>
                        <Col sm={3}>
                            <p id='lastError' style={{ color: 'red' }}></p>
                        </Col>
                    </FormGroup>
                    <FormGroup row>
                        <Col sm={2}>
                            <Label for="Email">Email</Label>
                        </Col>
                        <Col sm={3}>
                            <Input type="email" name="email" placeholder="Enter Email" required />
                        </Col>
                        <Col sm={3}>
                            <p id='emailError' style={{ color: 'red' }}></p>
                        </Col>
                    </FormGroup>
                    <FormGroup check row>
                        <Col sm={{ size: 2, offset: 2 }}>
                            <Button>Create Account</Button>
                        </Col>
                    </FormGroup>
                </Form>
            </div>
        )
    }
}