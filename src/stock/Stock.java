package stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Stock {
    private List<Product> products;

    public Stock() {
        this.products = new ArrayList<Product>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void handleProduct(Product product){
        if(productExists(product)){
            addInStock(product.getName(), product.getQuantity());
        }else {
            addProduct(product);
        }
    }

    synchronized public void addProduct(Product products) {
        this.products.add(products);
    }

    public void addInStock(String productName, int quantity){
        for (var product : products){
            if(Objects.equals(product.getName(), productName)){
                product.incrementQuantity(quantity);
                break;
            }
        }
    }

    private boolean productExists(Product product){
        for (var item : products){
            if(Objects.equals(item.getName(), product.getName())){
                return true;
            }
        }
        return false;
    }
}
