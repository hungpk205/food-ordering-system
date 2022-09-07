package com.food.ordering.system.order.serice.domain.entity;

import com.food.ordering.system.domain.entity.BaseEntity;
import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.domain.valueobject.ProductId;

import java.util.Objects;
import java.util.UUID;

public class Product extends BaseEntity<ProductId> {
    private String name;
    private Money price;

    public Product(ProductId productId, final String name, final Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }

    public Product(ProductId productId) {
        super.setId(productId);
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return name.equals(product.name) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public void updateWithConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }
}
