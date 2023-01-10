package org.pwr.logic.usecase.impl;

import org.pwr.api.response.RentResponse;
import org.pwr.dataaccess.entity.Cassette;
import org.pwr.dataaccess.entity.User;
import org.pwr.logic.general.AbstractUc;
import org.pwr.logic.usecase.UcReturnCassette;

import java.util.ArrayList;
import java.util.Objects;

public class UcReturnCassetteImpl extends AbstractUc implements UcReturnCassette {

    private RentResponse rentResponse;

    @Override
    public RentResponse returnCassette(User user, String cassetteName) {

        rentResponse = new RentResponse(new ArrayList<>(), "");

        Objects.requireNonNull(user);

        User userEntity = userRepository.findByPersonalId(user.getPersonalId());

        if (userEntity == null) {
            rentResponse.setInfo("There is no such account");
        }
        else {
            Cassette cassetteEntity = cassetteRepository.findByNameAndByOwner(cassetteName, userEntity);

            if (cassetteEntity == null) {
                rentResponse.setInfo("There is no such cassette rented by this account");
            }
            else {
                if (cassetteEntity.getDelay() > 0) {

                }
                cassetteEntity.setOwner(null);
                cassetteEntity.setRented(false);
                user.getRentedCassettes().remove(cassetteEntity);

                rentResponse.getCassetteList().add(cassetteEntity);
                rentResponse.setInfo("Cassette " + cassetteEntity + "successfully returned");
            }
        }
        return rentResponse;
    }
}
