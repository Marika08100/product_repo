package hu.progmatic.product_repo.repository;

import hu.progmatic.product_repo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    void delete(Long product);
}
