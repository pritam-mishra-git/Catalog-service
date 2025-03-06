package com.springboot.springbootmicroservice.domain;

 class ProductMapper{

      static ProductMod toProductMod(Product product){
        return new ProductMod(

                product.getCode(),
                product.getName(),
                product.getDescription(),
                product.getImageUrl(),
                product.getPrice()
        );

    }
}
