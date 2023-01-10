package org.pwr.dataaccess.repo;

import org.pwr.dataaccess.entity.User;

public interface UserRepository {

    User findByPersonalId(int personalId);
    User save(User user);
}
