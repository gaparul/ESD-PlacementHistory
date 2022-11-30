
import './filter.css'
import PlacedStudents from './placed';
import UnPlacedStudents from './unplaced';
import Organization from '../Organization/Organization';
import Domain from '../Domain/Domain';
import Year from '../Year/Year';

function FilterSelection(){

    return (
        
        <div>
            <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Placed</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">UnPlaced</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false">Organization</button>
            </li>

            <li class="nav-item" role="presentation">
                <button class="nav-link" id="domain-tab" data-bs-toggle="tab" data-bs-target="#domain" type="button" role="tab" aria-controls="domain" aria-selected="false">Domain</button>
            </li>

            <li class="nav-item" role="presentation">
                <button class="nav-link" id="year-tab" data-bs-toggle="tab" data-bs-target="#year" type="button" role="tab" aria-controls="year" aria-selected="false">Year</button>
            </li>
            </ul>
            <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab"><PlacedStudents /></div>
            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab"><UnPlacedStudents/></div>
            <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab"><Organization/></div>
            <div class="tab-pane fade" id="domain" role="tabpanel" aria-labelledby="domain-tab"><Domain/></div>
            <div class="tab-pane fade" id="year" role="tabpanel" aria-labelledby="year-tab"><Year/></div>
            </div>
        </div>

    );
}

export default FilterSelection;