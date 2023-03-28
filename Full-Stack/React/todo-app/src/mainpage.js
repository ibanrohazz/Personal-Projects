import React, { Component } from 'react';

class MainPage extends Component{
    constructor(props){
        super(props);
        this.state={data: "",
                input: "", //For capturing user input
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
                    {/* display the data in table format  */}
                    <table>
                        <thead>
                            <tr>
                                <th>Task Name</th>
                                <th>Task</th>
                                <th>Task Status</th>
                                {/* <th>Completed</th> */}
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.data.map((task) => (
                                <tr key={task.task_id}>
                                    <td>{task.task_name}</td>
                                    <td>{task.task}</td>
                                    <td>task.task_status</td>
                                    {/* <td>{task.due_date}</td>
                                    <td>{task.priority}</td>
                                    <td>{task.completed}</td> */}
                                </tr>
                            ))}
                        </tbody>
                    </table>
            </div>
            );
        }
    }
}
export default MainPage;