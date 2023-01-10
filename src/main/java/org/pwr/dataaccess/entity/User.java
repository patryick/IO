package org.pwr.dataaccess.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private String firstName;
    private String lastName;
    private Integer personalId;
    private final List<Cassette> rentedCassettes = new ArrayList<>();

    public User(String firstName, String lastName, int personalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalId = personalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Integer personalId) {
        this.personalId = personalId;
    }

    public List<Cassette> getRentedCassettes() {
        return rentedCassettes;
    }

    @Override
    public String toString() {
        return "User{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", personalId=" + personalId + ", rentedCassettes=" + rentedCassettes + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return firstName.equals(user.firstName) && lastName.equals(user.lastName) && personalId.equals(user.personalId) && rentedCassettes.equals(user.rentedCassettes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, personalId, rentedCassettes);
    }
}
