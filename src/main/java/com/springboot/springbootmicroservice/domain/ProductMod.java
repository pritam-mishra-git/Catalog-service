package com.springboot.springbootmicroservice.domain;

import java.math.BigDecimal;

public record ProductMod(
        String code,
        String name,
        String description,
        String imageUrl,
        BigDecimal price
)

{
}
