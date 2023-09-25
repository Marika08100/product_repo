package hu.progmatic.product_repo.controller;

import hu.progmatic.product_repo.model.Product;
import hu.progmatic.product_repo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/products")  //@Controller + @ResponseBody(JSON)
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProduct(@PathVariable Long id){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable Long id){
        return productService.findById(id);
    }
    @PostMapping("/product")
    public Product createNewProduct(@RequestParam Product product){
        return productService.createProduct(product);
    }
}
