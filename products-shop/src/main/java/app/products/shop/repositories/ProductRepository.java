package app.products.shop.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.products.shop.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


}