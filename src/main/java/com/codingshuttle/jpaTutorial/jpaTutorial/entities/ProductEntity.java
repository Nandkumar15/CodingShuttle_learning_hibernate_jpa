package com.codingshuttle.jpaTutorial.jpaTutorial.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "product_table",
        schema = "test",
        uniqueConstraints = {
                @UniqueConstraint(name = "title_price_unique",columnNames = {"title_x","price"})
        },
        indexes = {
                @Index(name = "sku_index",columnList = "sku")
        })
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 20)
    private String sku;
    @Column(name = "title_x")
    private String title;

    private BigDecimal price;
    private Integer quantity;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
