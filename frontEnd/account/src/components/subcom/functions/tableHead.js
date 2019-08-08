import React, { Component } from 'react';
import { Table } from 'reactstrap';
import { User } from './tablerow.js'

export function UserList(props) {
    return (
        <div>
            <Table>
                <thead>
                    <tr>
                        <th>first name</th>
                        <th>last name</th>
                        <th>acc No.</th>
                        <th>Prize</th>
                    </tr>
                </thead>
                <User data={props.data}/>
            </Table>
        </div>
    )
 }