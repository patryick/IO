package org.pwr.logic;

import org.pwr.api.response.RentResponse;
import org.pwr.dataaccess.entity.User;
import org.pwr.logic.usecase.UcCreateUserAccount;
import org.pwr.logic.usecase.UcRentCassette;
import org.pwr.logic.usecase.UcReturnCassette;

public class CassetteRentalAppImpl implements CassetteRentalApp {

    private UcReturnCassette ucReturnCassette;
    private UcCreateUserAccount ucCreateUserAccount;
    private UcRentCassette ucRentCassette;

    @Override
    public User createAccount(User user) {
        return ucCreateUserAccount.createAccount(user);
    }

    @Override
    public RentResponse rentCassette(User user, String cassetteName) {
        return ucRentCassette.rentCassette(user, cassetteName);
    }

    @Override
    public RentResponse returnCassette(User user, String cassetteName) {
        return ucReturnCassette.returnCassette(user, cassetteName);
    }

    public void setUcReturnCassette(UcReturnCassette ucReturnCassette) {
        this.ucReturnCassette = ucReturnCassette;
    }

    public void setUcCreateUserAccount(UcCreateUserAccount ucCreateUserAccount) {
        this.ucCreateUserAccount = ucCreateUserAccount;
    }

    public void setUcRentCassette(UcRentCassette ucRentCassette) {
        this.ucRentCassette = ucRentCassette;
    }
}
