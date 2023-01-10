package org.pwr.dataaccess.repo;

import org.pwr.dataaccess.entity.Cassette;
import org.pwr.dataaccess.entity.User;

import java.util.List;

public interface CassetteRepository {

    List<Cassette> findByName(String cassetteName);
    Cassette findByNameAndByOwner(String cassetteName, User owner);
    Cassette save(Cassette cassette);
}
