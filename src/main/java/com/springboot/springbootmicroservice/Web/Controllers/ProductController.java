package com.springboot.springbootmicroservice.Web.Controllers;

import com.springboot.springbootmicroservice.domain.PagedResult;
import com.springboot.springbootmicroservice.domain.Product;
import com.springboot.springbootmicroservice.domain.ProductMod;
import com.springboot.springbootmicroservice.domain.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
 class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public PagedResult<ProductMod> getProducts(@RequestParam(name = "page",defaultValue = "1") int page,@RequestParam(name = "size",defaultValue = "5") int size){
         return productService.getProducts( page,size);
    }
}
