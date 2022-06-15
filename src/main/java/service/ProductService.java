package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    List<Product> productList = new ArrayList<>();

    public ProductService() {
       productList.add(new Product(0,"IP6",2000));
       productList.add(new Product(1,"IP7",3000));
       productList.add(new Product(2,"IP8",4000));
       productList.add(new Product(3,"IP8",5000));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        productList.set(id,product);

    }

    @Override
    public void remove(int id) {
        productList.remove(id);

    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = findAll();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(name)){
                productList.add(products.get(i));
            }
        }
        return productList;
    }
}
