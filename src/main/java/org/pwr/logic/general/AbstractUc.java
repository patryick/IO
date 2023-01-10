package org.pwr.logic.general;

import org.pwr.dataaccess.repo.CassetteRepository;
import org.pwr.dataaccess.repo.UserRepository;

public abstract class AbstractUc {

    protected UserRepository userRepository;
    protected CassetteRepository cassetteRepository;


    public UserRepository getUserRepository() {
        return userRepository;
    }

    public CassetteRepository getCassetteRepository() {
        return cassetteRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setCassetteRepository(CassetteRepository cassetteRepository) {
        this.cassetteRepository = cassetteRepository;
    }
}
