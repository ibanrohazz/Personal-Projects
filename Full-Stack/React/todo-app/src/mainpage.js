import React, { Component } from 'react';

class MainPage extends Component{
    constructor(props){
        super(props);
        this.state={data: "",
                firstName: "", //For capturing user input
                lastName: "", //For capturing user input
                showModal: false,
                testMessage: "",
                summary: ""}
    }
    render(){
        if ( this.state.data == null )
            return (<div>No data</div>)
        else {
            return ( 
                <div><b>PUT STUFF HERE</b></div>
            )
        }
    }
}
export default MainPage;