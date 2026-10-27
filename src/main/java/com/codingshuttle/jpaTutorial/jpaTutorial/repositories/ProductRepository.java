package com.codingshuttle.jpaTutorial.jpaTutorial.repositories;

import com.codingshuttle.jpaTutorial.jpaTutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    //Query derivation of spring data jpa - we are declaring the method
    //we have to follow some rules for that ,
    // the jpa will take care of creating the queries for this method

    
    ProductEntity findByTitle(String title);
    List<ProductEntity> findByCreatedAtAfter(LocalDateTime localDateTime);

    List<ProductEntity> findByQuantityAndPrice(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByQuantityOrPrice(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByTitleLike(String nes);

    List<ProductEntity> findByTitleContaining(String s);

    List<ProductEntity> findByTitleContainingIgnoreCase(String nEs);

    //Optional<ProductEntity> findByTitleAndPrice(String neslteChocolate, BigDecimal bigDecimal);

    //@Query("select e from ProductEntity e where e.title=?1 and price=?2")
    @Query("select e from ProductEntity e where e.title=:title1 and price=:price1")
    Optional<ProductEntity>findByTitleAndPrice(String title1,BigDecimal price1);

}
