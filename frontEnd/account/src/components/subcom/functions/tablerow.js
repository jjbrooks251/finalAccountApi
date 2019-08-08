import React, { Component } from 'react';

export function User(props) {
    return (
        <tbody>
            {props.data.map(element => {
                return (
                    <tr key={element._id}>
                        <td>{element.firstName}</td>
                        <td>{element.lastName}</td>
                        <td>{element.accNo}</td>
                        <td>{element.prize}</td>
                    </tr>)
            })}
        </tbody>
    )
}