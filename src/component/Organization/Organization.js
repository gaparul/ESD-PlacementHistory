import { useEffect, useState } from "react"

function Organization() {
    const [orgs, setOrgs] = useState([])
    const [selectOption, setSelectedOption] = useState(orgs !== null ? orgs[0] : "");
    const [filteredOrgs, setFilteredOrgs] = useState([]);

    const [alumni, setAlumni] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/placement/getOrg")
        .then(response => response.json())
        .then((data) => {
            setOrgs(data);
        })
    }, [])
    const handleDropdown = (e) => {
        setSelectedOption(e.target.value)
    }
    const filterOption = () => {
        fetch(`http://localhost:8080/api/placement/getByOrg/${selectOption}`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            setFilteredOrgs(data)
        })
    }

    const alumniOption = () => {
      fetch(`http://localhost:8080/api/alumni/details/${selectOption}`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            setAlumni(data)
        })
    }
  return (
    <>
      <select
        id="Organizaions"
        // name={program + " " + batch}
        onClick={(e) => {
          handleDropdown(e);
        }}
      >
        <option key="default" value="default">
          <>Select Org</>
        </option>
        {orgs.length > 0 &&
          orgs.map((item, index) => (
            <option key={index} value={item}>
              {item}
            </option>
          ))}
      </select>
      <div>
        {/* <div> */}
        <button onClick={() => filterOption()}>Filter</button>
      </div>

      <div>
        {/* <div> */}
        <button onClick={() => alumniOption()}>Alumni Details</button>
      </div>

      {filteredOrgs.length > 0 && <div>
        <div>
          <div className="title">Placed Students</div>
          <table>
            <tr>
              <th>Roll No</th>
              <th>First name</th>
              <th>EmailID</th>
              <th>Organization</th>

            </tr>
            {filteredOrgs.map((value) => {
              return (
                <tr>
                  <td>{value[0]}</td>

                  <td>{value[1]}</td>
                  <td>{value[2]}</td>
                  <td>{value[3]}</td>

                </tr>
              )
            })}
          </table>
        </div>
      </div>}

      <div>

      {alumni.length > 0 && <div>
        <div>
          <div className="title">Alumni</div>
          <table>
            <tr>
              <th>Email</th>
              <th>Contact Number</th>
              <th>Joining date</th>
              <th>Leaving date</th>
              <th>Position</th>
              <th>
                Organization
              </th>

            </tr>
            {alumni.map((value) => {
              return (
                <tr>
                  <td>{value[0]}</td>

                  <td>{value[1]}</td>
                  <td>{value[2]}</td>
                  <td>{value[3]}</td>
                  <td>
                    {value[4]}
                  </td>
                  <td>{value[5]}</td>

                </tr>
              )
            })}
          </table>
        </div>
      </div>}
      </div>
    </>
  )
}

export default Organization;