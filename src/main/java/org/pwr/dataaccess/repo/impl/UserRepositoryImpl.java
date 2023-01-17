package org.pwr.dataaccess.repo.impl;

import org.pwr.dataaccess.repo.UserRepository;
import org.pwr.dataaccess.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final List<User> userEntityList = new ArrayList<>();

    @Override
    public User findByPersonalId(int personalId) {
        return userEntityList.stream()
                .filter(user -> user.getPersonalId() == personalId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User save(User user) {
        userEntityList.add(user);
        return user;
    }

    @Override
    public String toString() {
        return "UserRepositoryImpl{" + "userEntityList=" + userEntityList + '}';
    }

    public List<User> getUserEntityList() {
        return userEntityList;
    }
}
