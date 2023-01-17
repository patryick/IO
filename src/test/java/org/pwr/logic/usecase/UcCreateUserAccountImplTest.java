package org.pwr.logic.usecase;

import org.junit.Test;
import org.pwr.dataaccess.entity.User;
import org.pwr.dataaccess.repo.impl.UserRepositoryImpl;
import org.pwr.logic.usecase.impl.UcCreateUserAccountImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UcCreateUserAccountImplTest {
    static UcCreateUserAccountImpl ucCreateUserAccount = new UcCreateUserAccountImpl();

    @Test
    public void testCreateAccount() {
        User user = new User("", "", 1);
        UserRepositoryImpl userRepository = mock(UserRepositoryImpl.class);
        when(userRepository.save(user)).thenReturn(new User(user.getFirstName(), user.getLastName(), user.getPersonalId()));
        ucCreateUserAccount.setUserRepository(userRepository);

        User resultUser = ucCreateUserAccount.createAccount(user);

        assertEquals(resultUser, user);
    }
}
