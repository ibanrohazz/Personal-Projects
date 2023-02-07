import React, { Component } from 'react';

class MainPage extends Component{
    constructor(props){
        super(props);
        this.state={data: "",
                // input: "", //For capturing user input
                showModal: false,
                testMessage: "",
                summary: ""}
    }

    updateData = (apiResponse) => {
        this.setState({data: apiResponse})
    }
    fetchData = () => {
        //With Flask CORS enabled, we can directly call the server on port 5000
        fetch('http://localhost:5000/tasks')
         .then(
             response => response.json() 
             )//The promise response is returned, then we extract the json data
         .then (jsonOutput => //jsonOutput now has result of the data extraction
                  {
                      this.updateData(jsonOutput)
                    }
              )
    }
    
    componentDidMount(){
        this.fetchData();
    }

    render(){
        if ( this.state.data == null )
            return (<div>No data</div>)
        else {
            return ( 
                <div className='TaskList'>
                    <h1>List of tasks</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Task</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    {this.state.data}
                </div>
            )
        }
    }
}
export default MainPage;