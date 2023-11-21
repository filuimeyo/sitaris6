package lab6sitaris.parser;


import lab6sitaris.parser.productfactory.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Catalog {


    private ArrayList<Product> products;

    public Catalog(){

    }

    public Map<String, Integer> getInfoForChart(){
        return  products.stream().collect(
                Collectors.toMap(Product::getType, value -> 1, Integer::sum));

    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public List<String> getNames(){
        return products.stream().map(it-> '"'+it.getName()+'"').toList();
    }

    public Double average(){
        return products.stream().map(Product::getPrice).reduce(Double::sum).map(it->it/products.size())
                .orElse(-1.0);
    }

    public List<Double> getPrices(){
        return products.stream().map(Product::getPrice).toList();
    }

    public void setProducts(ArrayList<Product> products){
        this.products = products;
    }

    public  void push(Product p){
        if(this.products == null) products = new ArrayList<>();
        products.add(p);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Product p: products){
            sb.append(p.toString());
        }
        return sb.toString();
    }

    public void sayHello(){
        for(Product p: products){
            p.sayhello();
        }
    }
}
