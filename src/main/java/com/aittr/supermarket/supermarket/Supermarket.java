package com.aittr.supermarket.supermarket;

import java.util.ArrayList;

public class Supermarket {
    private String name;
    private String address;
    private ArrayList<Product> stock =
            new ArrayList<>();

    public Supermarket(String name, String address) {
        super();
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addProduct(Product p, double quantity) {
        if (stock.contains(p) == false) {
            p.setQuantity(quantity);
            stock.add(p);
            stock.sort(null);// возможно сделать сортировку по умолчанию и выставить вперед например акционные товары...
        } else {
            for (Product pr : stock) {
                if (pr.getCode() == p.getCode()) {
                    double q = pr.getQuantity();
                    q += quantity;
                    pr.setQuantity(q);
                    break;
                }
            }
        }
    }

    public void printProducts() {
        System.out.println("*".repeat(80));
        System.out.println("Sutermarket: " + name);
        System.out.println("Adress: " + address);
        System.out.println("\t\t\tStock: ");
        for (Product pr : stock) {
            System.out.println(pr);
        }

        System.out.println("*".repeat(80));
    }

    public void removeProduct(int code, double quantity) {
        for (Product pr : stock) {
            if (pr.getCode() == code) {
                double q = pr.getQuantity();
                q -= quantity;
                if (q < 0)
                    q = 0;
                pr.setQuantity(q);
                return;
            }
        }
        System.out.println("________________");
        System.out.println("Wrong code!!!! " + code);
        System.out.println("________________");
    }

    public void reducePrice(int code, double percent) {
        for (Product pr : stock) {
            if (pr.getCode() == code) {
                double price = pr.getPrice();
                double discount = (price * percent) / 100;
                price -= discount;
                pr.setPrice(price);
                return;
            }
        }
        System.out.println("________________");
        System.out.println("Wrong code!!!! " + code);
        System.out.println("________________");
    }

    public void sortProductsBy(int criteria) {
        switch (criteria) {
            case ISortingCriteria.SORT_BY_PRICE:
                ComparatorProductByPrice comp1 = new ComparatorProductByPrice();
                stock.sort(comp1);
                break;
            case ISortingCriteria.SORT_BY_NAME_REVERSE:
                ComparatorProductsByNameReverse comp2 =
                        new ComparatorProductsByNameReverse();
                stock.sort(comp2);
                break;
            case ISortingCriteria.SORT_BY_CODE_REVERSE:
                ComparatorProductsByCodeReverse comp3 =
                        new ComparatorProductsByCodeReverse();
                stock.sort(comp3);
        }


    }

}
