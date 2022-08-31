package com.food.ordering.system.order.serice.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public class StreetAddress {
    private UUID id;
    private String street;
    private String postalCode;
    private String city;

    public StreetAddress(final UUID id, final String street, final String postalCode, final String city) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof StreetAddress)) return false;
        StreetAddress that = (StreetAddress) o;
        return street.equals(that.street) && postalCode.equals(that.postalCode) && city.equals(that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, postalCode, city);
    }

    public void setCity(final String city) {
        this.city = city;
    }
}
