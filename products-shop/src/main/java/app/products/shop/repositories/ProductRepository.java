package app.products.shop.repositories;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.products.shop.model.dto.views.product.ProductInRangeViewModel;
import app.products.shop.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

	@Query(value = "SELECT new app.products.shop.model.dto.views.product.ProductInRangeViewModel(p.name, p.price, TRIM(CONCAT(COALESCE(p.seller.firstName, ''), ' ', p.seller.lastName))) "
			+ "FROM Product AS p WHERE (p.price BETWEEN :from AND :to) "
			+ "AND p.buyer IS NULL "
			+ "ORDER BY p.price asc")
	List<ProductInRangeViewModel> getAllByRangeWithoutBuyer(@Param("from") BigDecimal from, @Param("to") BigDecimal to);

}