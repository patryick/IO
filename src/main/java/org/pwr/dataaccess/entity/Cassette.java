package org.pwr.dataaccess.entity;

import java.util.Objects;

public class Cassette {

    private String name;
    private boolean isRented;
    private int delay = 0;
    private User owner;

    public Cassette() {
    }

    public Cassette(String name, boolean isRented) {
        this.name = name;
        this.isRented = isRented;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return "Cassette{" + "name='" + name + '\'' + ", isRented=" + isRented + ", delay=" + delay + ", owner=" + (isRented ? owner.getFirstName() : "no") + '}';
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cassette cassette = (Cassette) o;
        return isRented == cassette.isRented && delay == cassette.delay && Objects.equals(name, cassette.name) && Objects.equals(owner, cassette.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isRented, delay, owner);
    }
}
