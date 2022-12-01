package com.academia.placementhistory.DAO;

import com.academia.placementhistory.Bean.Alumni;
import com.academia.placementhistory.Bean.Organisation;

import java.util.List;

public interface AlumniDAO {
    void addAlumni(Alumni a);

    List<Object> getAlumniDetails(Organisation o);
}
