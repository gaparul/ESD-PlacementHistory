import { useEffect, useState } from "react";

function StudentComponent() {
    const [placedStudents, setPlacedStudents] = useState([])
    const [unPlacedStudents, setUnplacedStudents] = useState([])
     
    useEffect(() => {
        fetch("http://localhost:8080/api/placement/getStudents", {
            headers: {
                'Content-Type' : 'application/json'
            },
            method: 'GET'
        }).then(response => response.json())
        .then((data) => {
            // setPlacedStudents(data.placed);
            // setUnplacedStudents(data.u.cnplaced);
            setPlacedStudents(data.placed)
            setUnplacedStudents(data.unplaced)
        })
    });

    // return (
    //     <div>
    //        {placedStudents}
    //         {unPlacedStudents}
    //     </div>
    // )
    
    

    
    
        return (
            <div>
            
                
{/* 
                <div className="title">UnPlaced Students</div>
                <table>
                    <tr>
                    <th>Roll No</th>
                    <th>First name</th>
                    <th>EmailID</th>
                    <th>CGPA</th>
                    <th>Domain</th>
                    <th>Specialization</th>
                    </tr>
                    {unplacedS}
                </table> */}

            </div>
        )
    
}

export default StudentComponent;