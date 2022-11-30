import React, { useState } from "react";
import ReactDOM from "react-dom";
import Login from "./component/Login";
import StudentComponent from "./component/StudentComponent"
import { createBrowserRouter,  Navigate,  Switch, RouterProvider, Route } from 'react-router-dom';
import "./styles.css";
import FilterSelection from "./component/Filter/filterSelection";

function App(props) {
  const router = createBrowserRouter([
    {
      path:"/",
      element: (
          <Login/>
        )
      }, {
        path : "/login",
        element :(
          <Navigate to="/" replace={true}/>
        )
    }, {
      path : "/filter",
      element :(
        <FilterSelection/>
      )
    }
    
  ]);

  props.renderRoot(<RouterProvider router={router} />);

  // return (
  //   // <Router>
  //   //   <Switch>
  //   //     <Route path="http://localhost:3000/login"><Login/></Route>
  //   //   </Switch>
  //   // </Router>
  //   <Login/>


  // );

}

export default App;