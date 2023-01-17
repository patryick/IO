package org.pwr.dataaccess.repo.impl;

import org.junit.Test;
import org.pwr.dataaccess.entity.Cassette;
import org.pwr.dataaccess.entity.User;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CassetteRepositoryImplTest {
    static CassetteRepositoryImpl cassetteRepository = new CassetteRepositoryImpl();

    @Test
    public void testFindByName() {
        Cassette[] cassettes = {
                new Cassette("name", false),
                new Cassette("name", false),
                new Cassette("name2", true),
                new Cassette("name3", false),
                new Cassette("name", true)

        };

        List<Cassette> resultList = cassetteRepository.findByName("name");

        assertSame(resultList.get(0), cassettes[0]);
        assertSame(resultList.get(1), cassettes[1]);
        assertSame(resultList.get(2), cassettes[4]);
    }

    @Test
    public void testSave() {
        Cassette cassette = new Cassette("name", false);

        Cassette resultCassette = cassetteRepository.save(cassette);

        assertSame(cassette, cassetteRepository.getCassetteList().get(0));
        assertEquals(resultCassette, cassette);
    }

    @Test
    public void testFindByNameAndByOwner() {
        User user1 = new User("", "", 1);
        User user2 = new User("", "", 2);
        Cassette cassette1 = new Cassette("name", true);
        cassette1.setOwner(user1);
        Cassette cassette2 = new Cassette("name", false);
        cassette2.setOwner(user2);
        Cassette cassette3 = new Cassette("name", false);
        Cassette cassette4 = new Cassette("name1", true);
        cassette4.setOwner(user1);
        cassetteRepository.getCassetteList().add(cassette1);
        cassetteRepository.getCassetteList().add(cassette2);
        cassetteRepository.getCassetteList().add(cassette3);
        cassetteRepository.getCassetteList().add(cassette4);

        Cassette cassette = cassetteRepository.findByNameAndByOwner("name", user1);

        assertSame(cassette, cassette1);
    }
}
