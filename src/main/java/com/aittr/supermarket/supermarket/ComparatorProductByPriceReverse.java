package com.aittr.supermarket.supermarket;

import java.util.Comparator;

public class ComparatorProductByPriceReverse implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}
