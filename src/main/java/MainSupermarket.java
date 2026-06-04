import com.aittr.supermarket.supermarket.ISortingCriteria;
import com.aittr.supermarket.supermarket.Product;
import com.aittr.supermarket.supermarket.Supermarket;

public class MainSupermarket {
    public static void main(String[] args) {
        Product p1 = new Product("Whole Milk 3.2%", 1001, "pcs", 1.99);
        Product p2 = new Product("White Bread Loaf", 1002, "pcs", 1.20);
        Product p3 = new Product("Fresh Potatoes", 2005, "kg", 1.1);
        Product p4 = new Product("Golden Apples", 2008, "kg", 2.49);
        Product p5 = new Product("Cheddar Cheese", 3012, "kg", 9.50);
        Product p6 = new Product("Instant Coffee", 4001, "pcs", 5.99);
        Product p7 = new Product("Granulated Sugar", 5022, "kg", 1.10);
        Product p8 = new Product("Sparkling Water", 6011, "pcs", 0.85);
        Product p9 = new Product("Milk Chocolate Bar", 7003, "pcs", 1.50);
        Product p10 = new Product("Sunflower Oil", 8055, "pcs", 2.99);

        Supermarket lidl = new Supermarket("WallMart", "Herzel 20, Rehovot");

        lidl.addProduct(p10,10);
        lidl.addProduct(p9,5);
        lidl.addProduct(p8,100);
        lidl.addProduct(p7,80);
        lidl.addProduct(p6,50);
        lidl.addProduct(p5,20);
        lidl.addProduct(p4,200);
        lidl.addProduct(p3,400);
        lidl.addProduct(p2,150);
        lidl.addProduct(p1,90);

        lidl.printProducts();
        Product p11 = new Product("Fresh Potatoes", 2005, "kg", 1.1);
        lidl.addProduct(p11,33);

        Product p12 = new Product("Fresh Potatoes", 2060, "kg", 0.8);
        lidl.addProduct(p12,77);

        lidl.printProducts();

        lidl.removeProduct(2005,10);
        lidl.printProducts();
        lidl.removeProduct(2006,10);
        lidl.printProducts();

        lidl.reducePrice(2005, 50);
        lidl.printProducts();

        lidl.sortProductsBy(ISortingCriteria.SORT_BY_PRICE);
        lidl.printProducts();
        lidl.sortProductsBy(ISortingCriteria.SORT_BY_CODE_REVERSE);
        lidl.printProducts();
        lidl.sortProductsBy(ISortingCriteria.SORT_BY_NAME_REVERSE);
        lidl.printProducts();
    }
}

/*
Архитектура программы магазина
Product
----------      Example:
name(String)    Yogurt Tnuva
code(int)       1234
unit(String)    200 ml
price(double)    6.70
quantity(double) 30.0

set/get
toString()
constructor

Supermarket
------------
name (String)
address(String)
products(ArrayList<Product>)
+++++++++++++++++++++++++++++
+constructor
+set/get
+addProduct(Product, quantity)
printProductsList()
removeProduct(code,quantity)
sortProductsBy(criteria)
void findProduct(code)
reducePrice(code, percent)
double totalCost()
reducePriceForALl(percent)
 */