package hu.progmatic.product_repo.service;

import hu.progmatic.product_repo.model.Product;
import hu.progmatic.product_repo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public Product createProduct(Product product){
        if(product == null){
            return null;
        }
        return productRepository.save(product);
    }
}
