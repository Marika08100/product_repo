package hu.progmatic.product_repo.controller;

import hu.progmatic.product_repo.model.Product;
import hu.progmatic.product_repo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products")  //@Controller + @ResponseBody(JSON)
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable Long id){
        return productService.findById(id);
    }
    @PostMapping // THIS IS TH WAY
    public Product createNewProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    // THIS IS NOT THE WAY
    @GetMapping("/create/{name}/{price}") // http://localhost:8080/products/create/kandallo/5
    public Product createProductByPathVariable(@PathVariable String name, @PathVariable Integer price) {
        return productService.createProduct(new Product(name, price));
    }

    // THIS IS NOT THE WAY EITHER
    @GetMapping("/create") // http://localhost:8080/products/create?name=sajtostaller&price=10
    public Product createProductByRequestParam(@RequestParam String name, @RequestParam Integer price) {
        return productService.createProduct(new Product(name, price));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
