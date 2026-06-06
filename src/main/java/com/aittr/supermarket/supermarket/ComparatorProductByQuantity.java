package com.aittr.supermarket.supermarket;

import java.util.Comparator;

public class ComparatorProductByQuantity implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p2.getQuantity(), p1.getQuantity());
    }
}
