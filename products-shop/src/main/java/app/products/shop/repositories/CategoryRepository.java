package app.products.shop.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.products.shop.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}