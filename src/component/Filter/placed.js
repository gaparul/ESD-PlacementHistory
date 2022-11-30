import StudentComponent from "../StudentComponent";
import { useEffect, useState } from "react";

function PlacedStudents() {

    const [placedStudents, setPlacedStudents] = useState([])
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
        })
    });
    
    const placedS = placedStudents && placedStudents.length > 0 && placedStudents.map((value) => {
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
            <div className="title">Placed Students</div>
            <table>
                <tr>
                    <th>Roll No</th>
                    <th>First name</th>
                    <th>EmailID</th>
                    <th>CGPA</th>
                    <th>Domain</th>
                    <th>Specialization</th>
                </tr>
                {placedS}
            </table>
        </div>
    );
}

export default PlacedStudents;