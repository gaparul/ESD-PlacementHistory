import { useEffect, useState } from "react";
function UnPlacedStudents (){


    const [unPlacedStudents, setUnPlacedStudents] = useState([])
    useEffect(() => {
        fetch("http://localhost:8080/api/placement/getStudents", {
            headers: {
                'Content-Type' : 'application/json'
            },
            method: 'GET'
        }).then(response => response.json())
        .then((data) => {
            // setPlacedStudents(data.placed);
            setUnPlacedStudents(data.unplaced);
            
        })
    });

    const unplacedS = unPlacedStudents && unPlacedStudents.length > 0 && unPlacedStudents.map((value) => {
        return (<tr>
        <td>{value.rollNo}</td>
        
        <td>{value.firstName}</td>
        <td>{value.email}</td>
        <td>{value.cgpa}</td>
        <td>{value.domain}</td>
        <td>
            {value.specialization}
        </td>
        </tr>)
    }); 

    return (
        <div>
        
            

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
            </table>

        </div>
    )
}

export default UnPlacedStudents