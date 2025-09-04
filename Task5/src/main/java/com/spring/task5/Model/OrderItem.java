package com.spring.task5.Model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;


    @ManyToOne
    @JoinColumn(name="product_id")
    private Products product;


    private Integer quantity;


    @Column(precision = 10, scale = 2)
    private BigDecimal unitPrice;
}
