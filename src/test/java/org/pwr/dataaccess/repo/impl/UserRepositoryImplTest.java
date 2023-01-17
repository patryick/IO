package org.pwr.dataaccess.repo.impl;

import org.junit.Test;
import org.pwr.dataaccess.entity.User;

import static org.junit.Assert.*;

public class UserRepositoryImplTest {
    static UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Test
    public void testFindByPersonalId() {
        User user = new User("", "", 1);
        User user2 = new User("", "", 2);
        userRepository.getUserEntityList().add(user);
        userRepository.getUserEntityList().add(user2);

        User resultUser = userRepository.findByPersonalId(1);
        User resultUser2 = userRepository.findByPersonalId(3);

        assertSame(user, resultUser);
        assertNull(resultUser2);
    }

    @Test
    public void testSave() {
        User user = new User("", "", 1);

        User resultUser = userRepository.save(user);

        assertSame(user, userRepository.getUserEntityList().get(0));
        assertEquals(resultUser, user);
    }

}
