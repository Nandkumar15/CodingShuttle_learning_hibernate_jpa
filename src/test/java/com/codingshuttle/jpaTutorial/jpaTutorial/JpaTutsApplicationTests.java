package com.codingshuttle.jpaTutorial.jpaTutorial;

import com.codingshuttle.jpaTutorial.jpaTutorial.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.stylesheets.LinkStyle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutsApplicationTests {

    @Autowired
    ProductRepository productRepository;
	@Test
	void contextLoads() {
	}

    //to test the insertion of data through jpa repository without query
    @Test
    void testRepository(){
        ProductEntity productEntity=ProductEntity.builder().
                sku("neslte123")
                .title("neslte chocolate")
                .quantity(4)
                .price(BigDecimal.valueOf(123.45))
                .build();

        ProductEntity savedProductEntity=productRepository.save(productEntity);
        System.out.println(savedProductEntity);
    }

    //to get the all the data from product_table without writing query.
    @Test
    void getRepository(){
        List<ProductEntity> entities=productRepository.findAll();
        System.out.println(entities);
    }

    @Test
    void getRepositoryByTitle(){
        ProductEntity entity=productRepository.findByTitle("neslte chocolate");
        System.out.println(entity);
    }

    @Test
    void getRepositoryByCreatedAtAfter(){
        List<ProductEntity> entities=productRepository.findByCreatedAtAfter(LocalDateTime.of(2027,10,27,0,0,0));
        System.out.println(entities);
    }

    @Test
    void getRepositoryByQuantityAndPrice(){
        List<ProductEntity> entities=productRepository.findByQuantityAndPrice(4,BigDecimal.valueOf(123.45));
        System.out.println(entities);
    }

    @Test
    void getRepositoryByQuantityOrPrice(){
        List<ProductEntity> entities=productRepository.findByQuantityOrPrice(4,BigDecimal.valueOf(123.40));
        System.out.println(entities);
    }

    @Test
    void getRepositoryByQuantityGreatorThanOrPriceLessThan(){
        List<ProductEntity> entities=productRepository.findByQuantityGreaterThanOrPriceLessThan(3,BigDecimal.valueOf(123.40));
        System.out.println(entities);
    }

    @Test
    void getRepositoryByTitleLike(){
        List<ProductEntity> entities=productRepository.findByTitleLike("%nes%");
        System.out.println(entities);
    }

    @Test
    void getRepositoryByTitleContaining(){
        List<ProductEntity> entities=productRepository.findByTitleContaining("nes");
        System.out.println(entities);
    }

    @Test
    void getRepositoryByTitleContainingIgnoringcase(){
        List<ProductEntity> entities=productRepository.findByTitleContainingIgnoreCase("nEs");
        System.out.println(entities);
    }

    @Test
    void getSingleRepository(){
        Optional<ProductEntity> entities=productRepository.findByTitleAndPrice("neslte chocolate",BigDecimal.valueOf(123.45));
        entities.ifPresent(System.out::println);
    }

}
