package com.academia.placementhistory.DAO;

import com.academia.placementhistory.Bean.PlacementStudent;

import java.util.List;

public interface PlacementStudentDAO {

    void addPlacedStudent(PlacementStudent ps);
    List<String> getYear();
}
