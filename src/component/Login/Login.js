import { useEffect, useState } from "react";

import { Alert } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import filterSelection from "../Filter/filterSelection";

import "./login.css";

function Login() {
    let navigate = useNavigate();
    let user = localStorage.getItem("user");
    useEffect(() => {
        // navigate to another page
    });

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [department, setDepartment] = useState("");

    // const [isSubmitted, setIsSubmitted] = useState(false);
    const [error, setError] = useState(false);

    const changeEvent = (event, isEmail, isDept) => {
        if (isEmail)
            setEmail(event.target.value);
        else if(isDept){
            
            setDepartment(event.target.value)
        }else{
            setPassword(event.target.value);
        }
    }

    const checkLogin = (event,email, password, department) => {
        event.preventDefault();
        fetch('http://localhost:8080/api/employee/login', {
            body: JSON.stringify({
                "email": email,
                "password": password,
                "department": department
            }),
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() => {
                // console.log(data);
                // if (data.status === 200) {
                //     // localStorage.setItem("user", JSON.stringify(data.object));
                //     // setIsSubmitted(true);
                    navigate('/filter')
                // } else {
                //     setError(true);
                // }
            }).catch(e => {
                setError(true);
            });


    };


    // async function fetch_department() {
    //     let response = await fetch("http://localhost:8080/api/employee/get");
    //     let departments = await response.json(); // read response body and parse as JSON
    //     console.log(departments);
    //     let dep_option = document.getElementById('departments');
    //     dep_option.innerHTML = '<option value=""> Choose...</option>';

    //     for (let i = 0; i < departments.length; i++) {
    //         dep_option.innerHTML += '<option value="' + departments[i] + '">' + departments[i] + '</option>';
    //     }
    // }

    return (
        <>
            <div className="app">
                <div className="login-form">
                    <div className="title">Log In</div>
                    <div className="form">
                        <form method="POST" onSubmit={(event) => checkLogin(event, email, password, department)}>
                            {error && <Alert variant="danger">Invalid Credentials </Alert>}
                            <div className="input-container">
                                <label>EmailID </label>
                                <input type="email" name="email" placeholder="email@domain.com" onChange={(event) => changeEvent(event, true, false)} required />
                            </div>
                            <div className="input-container">
                                <label>Password </label>
                                <input type="password" name="password" onChange={(event) => changeEvent(event, false, false)} required />
                            </div>
                            <div className="input-container">
                                <label>Department</label>
                                <select className="custom-select d-block w-100 tg2" id="departments" onChange={(event) => changeEvent(event, false, true)} required>
                                    <option value="">Choose...</option>
                                    <option value="IT">IT</option>
                                    <option value="Outreach">Outreach</option>
                                    <option value="Management">Management</option>
                                    <option value="Admissions">Admissions</option>
                                    <option value="Library">Library</option>
                                </select>
                            </div>
                            <div className="button-container">
                                <input type="submit" value="sign in" />
                            </div>
                        </form>
                    </div>
                    {/* {isSubmitted ? <div>User is successfully logged in</div> : renderForm} */}
                </div>
            </div>
        </>

    )
}

export default Login;