package org.pwr.dataaccess.repo.impl;

import org.pwr.dataaccess.repo.CassetteRepository;
import org.pwr.dataaccess.entity.Cassette;
import org.pwr.dataaccess.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CassetteRepositoryImpl implements CassetteRepository {

    private final List<Cassette> cassetteList = new ArrayList<>();

    @Override
    public List<Cassette> findByName(String cassetteName) {
        return cassetteList.stream()
                .filter(cassette -> cassette.getName().equals(cassetteName))
                .collect(Collectors.toList());
    }

    @Override
    public Cassette findByNameAndByOwner(String cassetteName, User owner) {
        return findByName(cassetteName)
                .stream()
                .filter(cassette -> cassette.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Cassette save(Cassette cassette) {
        cassetteList.add(cassette);
        return cassette;
    }
}
