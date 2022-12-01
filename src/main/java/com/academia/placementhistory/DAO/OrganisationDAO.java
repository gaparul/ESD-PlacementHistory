package com.academia.placementhistory.DAO;

import com.academia.placementhistory.Bean.Organisation;

import java.util.List;

public interface OrganisationDAO {
    void addOrganisation(Organisation o);

    List<String> getOrganisation();
}
