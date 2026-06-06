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
        System.out.println();
        System.out.println("~".repeat(80));
        //System.out.println(String.format("\n|   Supermarket: %-65.1f |") + name); // "|| Supermarket: " + name);
        System.out.printf("||                %-15s %-44s ||\n", "Supermarket:", name);
        System.out.printf("||                %-15s %-44s ||\n", "Adress:", address);
        System.out.printf("||   %-73s ||\n", "Stock:");
        System.out.println("~".repeat(80));
        for (Product pr : stock) {
            System.out.println(pr);
        }

        System.out.println("~".repeat(80));
        System.out.println();
    }
//метод уменьшает количество товара на значение указанное в quantity,
// если получится отрицательное значение то установит значение = 0.
    // если товара с таким кодом нет - выдаст сообщение
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
// метод снижает стоимость товара по коду на значение указанное в percent
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
                ComparatorProductsByNameReverse comp2 = new ComparatorProductsByNameReverse();
                stock.sort(comp2);
                break;
            case ISortingCriteria.SORT_BY_CODE_REVERSE:
                ComparatorProductsByCodeReverse comp3 = new ComparatorProductsByCodeReverse();
                stock.sort(comp3);
                break;
            case ISortingCriteria.SORT_BY_PRICE_REVERSE:
                ComparatorProductByPriceReverse comp4 = new ComparatorProductByPriceReverse();
                stock.sort(comp4);
                break;
            case ISortingCriteria.SORT_BY_CODE:
                ComparatorProductsByCode comp5 = new ComparatorProductsByCode();
                stock.sort(comp5);
                break;
            case ISortingCriteria.SORT_BY_NAME:
                ComparatorProductsByName comp6 = new ComparatorProductsByName();
                stock.sort(comp6);
                break;
            case ISortingCriteria.SORT_BY_QUANTITY_REVERSE:
                ComparatorProductByQuantityReverse comp7 = new ComparatorProductByQuantityReverse();
                stock.sort(comp7);
                break;
                case ISortingCriteria.SORT_BY_QUANTITY:
                ComparatorProductByQuantity comp8 = new ComparatorProductByQuantity();
                stock.sort(comp8);
                break;
        }


    }
//поиск продукта по коду
    public void findProduct(int code) {
        for (Product pr : stock) {
            if (pr.getCode() == code) {
                System.out.printf("Found item, code #: " + code + "\n" + "-".repeat(25) + "\n");
                System.out.println(pr);
                System.out.println("_".repeat(80));
                return;
            }

        }
        System.out.println("No product with code: " + code);
    }

    public void removeProductFromStock(int code) {
//        Product fakeProduct = new Product("", code, "", 0.0);
//        stock.remove(fakeProduct);
        //второй вариант
        for(Product pr: stock){
            if (pr.getCode() == code){
                stock.remove(pr);
                return;
            }
        }
    }

    public void reducePriceForALl(double percent){
        for (Product pr : stock) {
                double price = pr.getPrice();
                double discount = (price * percent) / 100;
                price -= discount;
                pr.setPrice(price);
        }
    }

    public double totalCost(){
        double tcost = 0.0;
        for (Product pr: stock){
//            double q = pr.getQuantity();
//            double p = pr.getPrice();
//            double cost = (q * p);
//            tcost += cost;
            tcost += (pr.getQuantity() * pr.getPrice());
        }
        return tcost;
    }
}


/*
public void removeProductFromStock(int code){
    for (Product pr : stock) {
        if(pr.getCode() == code) {
            stock.remove(pr);
            return;
        }
    }
    }
 */