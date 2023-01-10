package org.pwr.logic.usecase.impl;

import org.pwr.dataaccess.entity.User;
import org.pwr.logic.general.AbstractUc;
import org.pwr.logic.usecase.UcCreateUserAccount;

public class UcCreateUserAccountImpl extends AbstractUc implements UcCreateUserAccount {

    @Override
    public User createAccount(User user) {
        if (userRepository.findByPersonalId(user.getPersonalId()) != null) {
            throw new IllegalArgumentException("Id number is occupied");
        }
        User resultUser = userRepository.save(user);
        return resultUser;
    }
}
