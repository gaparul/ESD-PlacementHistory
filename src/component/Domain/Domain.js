import { useEffect, useState } from "react"

function Domain() {
    const [orgs, setOrgs] = useState([])
    const [selectOption, setSelectedOption] = useState(orgs !== null ? orgs[0] : "");
    const [filteredOrgs, setFilteredOrgs] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/placement/getDomain")
        .then(response => response.json())
        .then((data) => {
            setOrgs(data);
        })
    }, [])
    const handleDropdown = (e) => {
        setSelectedOption(e.target.value)
    }
    const filterOption = () => {
        fetch(`http://localhost:8080/api/placement/getByDomain/${selectOption}`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            setFilteredOrgs(data)
        })
    }
  return (
    <>
      <select
        id="Domain"
        // name={program + " " + batch}
        onClick={(e) => {
          handleDropdown(e);
        }}
      >
        <option key="default" value="default">
          <>Select...</>
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

      {filteredOrgs.length > 0 && <div>
        <div>
          <div className="title">Placed Students</div>
          <table>
            <tr>
              <th>Roll No</th>
              <th>First name</th>
              <th>EmailID</th>
              <th>Domain</th>

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
    </>
  )
}

export default Domain;