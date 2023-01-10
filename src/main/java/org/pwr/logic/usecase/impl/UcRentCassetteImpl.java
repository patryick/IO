package org.pwr.logic.usecase.impl;

import org.pwr.api.response.RentResponse;
import org.pwr.dataaccess.entity.Cassette;
import org.pwr.dataaccess.entity.User;
import org.pwr.logic.general.AbstractUc;
import org.pwr.logic.usecase.UcCreateUserAccount;
import org.pwr.logic.usecase.UcRentCassette;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UcRentCassetteImpl extends AbstractUc implements UcRentCassette {

    private UcCreateUserAccount ucCreateUserAccount; //TODO to nie jest konieczne
    private RentResponse rentResponse;

    @Override
    public RentResponse rentCassette(User user, String cassetteName) {

        rentResponse = new RentResponse(new ArrayList<>(), "");

        User userEntity = validateUser(user);
        if (userEntity != null) {

            Cassette availableCassette = findCassetteToRent(cassetteName);

            if (availableCassette != null) {

                availableCassette.setRented(true);
                availableCassette.setOwner(userEntity);
                userEntity.getRentedCassettes().add(availableCassette);

                rentResponse.getCassetteList().add(availableCassette);
                rentResponse.setInfo("Cassette rented successful");
            }
        }
        return rentResponse;
    }

    private User validateUser (User user) {

        Objects.requireNonNull(user);

        User userEntity = userRepository.findByPersonalId(user.getPersonalId());
        if (userEntity == null) {
            userEntity = ucCreateUserAccount.createAccount(user); //TODO coś tu śmierdzi, validowanie danych
        }


        if (userEntity.getRentedCassettes().size() >= 5) {
            rentResponse.setInfo("Too many cassettes rented by this customer");
            return null;
        }
        return userEntity;
    }

    private Cassette findCassetteToRent(String cassetteName) {

        List<Cassette> foundCassettes = cassetteRepository.findByName(cassetteName);
        Cassette availableCassette = null;

        if (foundCassettes.isEmpty()) {
            rentResponse.setInfo("Cassette doesn't exist in repository");
        }
        else {
            availableCassette = foundCassettes.stream()
                    .filter(cassette -> !cassette.isRented())
                    .findFirst()
                    .orElse(null);

            if (availableCassette == null) {
                rentResponse.getCassetteList().addAll(foundCassettes);
                rentResponse.setInfo("Cassette exists in repository, but all copies are rented");
            }
        }

        return availableCassette;
    }

    public void setUcCreateUserAccount(UcCreateUserAccount ucCreateUserAccount) {
        this.ucCreateUserAccount = ucCreateUserAccount;
    }
}
