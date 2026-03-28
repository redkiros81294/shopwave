package com.shopwave.dto;

// Name: Yared Kiros
// ID: ATE/7702/14

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private String desc;
    private BigDecimal price;
    private Integer stock;
    private String categoryName;
    private LocalDateTime createdAt;
}