package main.app.controller;

import main.app.entity.Product;
import main.app.model.ProductInformation;
import main.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/getAllProducts")
    public List<ProductInformation> getAllProductsWithNameAndPrice(){
        List<Product> productInDB = productRepository.findAll();
        List<ProductInformation> productWithNameAndPrice = new ArrayList<>();
        for(Product product: productInDB){
            ProductInformation productInformation = new ProductInformation();
            productInformation.setProductName(product.getProductName());
            productInformation.setPrice(product.getPrice());
            productWithNameAndPrice.add(productInformation);
        }
        return productWithNameAndPrice;
    }

    @GetMapping("/getAllProductsDetailedInfo")
    public List<Product> getAllProductsWithDetailedInformation(){
        List<Product> productInDB = productRepository.findAll();
        return productInDB;
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        try {
            Product product = productRepository.findById(id).get();

        } catch (Exception ex) {
            return null;
        }
        return new Product();
    }

    @GetMapping("/getProductByName/{productName}")
    public  List<Product> getProductByName(@PathVariable("productName") String productName){
        List<Product> productList = productRepository.getProductDetailsByName(productName);
        return productList;
    }

    @GetMapping("/getProductsContains/{productName}")
    public  List<Product> getProductsContains(@PathVariable("productName") String productName){
        List<Product> productList = productRepository.getProductsContainsName(productName);
        return productList;
    }

    //For Promotions
    @PostMapping("/createDetailedProduct")
    public Product createDetailedProduct(@RequestBody Product product){
      Product newProduct = productRepository.save(product);
      return newProduct;
    }

    //For Vendor
    @PostMapping("/createProduct")
    public ProductInformation createProduct(@RequestBody ProductInformation product){
        Product newProduct = new Product();
        newProduct.setProductName(product.getProductName());
        newProduct.setPrice(product.getPrice());
        productRepository.save(newProduct);
        return product;
    }

    @PutMapping("/updateDetailedProduct")
    public Product updateDetailedProduct(@RequestBody Product product){
      return  productRepository.save(product);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public String deleteProductById(@PathVariable("id") Long productId){
        try {
            productRepository.deleteById(productId);
            return "ProductID:"+"\t"+productId+"\nDeleted Successfully from DB.";
        }catch(Exception ex){
            return "Product with ID"+productId+"already Deleted.";
        }
    }

    @DeleteMapping("/disableProductById/{id}")
    public String disableProductById(@PathVariable("id") Long productId){
        try {
            Product existingProduct = productRepository.findById(productId).get();
            existingProduct.setActiveProduct(false);
            productRepository.save(existingProduct);
        }catch (Exception ex){
            return "Unable to find the product.\nErr: Invalid Product ID";
        }
      return "Product has been disabled Successfully.";
    }

    @GetMapping("/getAllActiveProducts")
    public List<Product> getAllActiveProducts(){
        List<Product> productInDB = productRepository.getAllActiveProducts();
        return productInDB;
    }

    @GetMapping("/getAllInActiveProducts")
    public List<Product> getAllInActiveProducts(){
        List<Product> productInDB = productRepository.getAllInActiveProducts();
        return productInDB;
    }
}
