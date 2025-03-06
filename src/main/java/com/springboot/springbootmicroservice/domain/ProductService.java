package com.springboot.springbootmicroservice.domain;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public PagedResult<ProductMod> getProducts(int page,int size)
    {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        page = page <=1 ? 0 : page-1;
        size = size <=0 ? 0 : size;
        Pageable pageable =  PageRequest.of(page,size,sort);
         Page<ProductMod> productsPage = productRepository.findAll(pageable)
                 .map(ProductMapper::toProductMod);

         PagedResult<ProductMod> pagedResult = new PagedResult<>(
                 productsPage.getContent(),
                 productsPage.getTotalElements(),
                 productsPage.getNumber()+1,
                 productsPage.getTotalPages(),
                 productsPage.isFirst(),
                 productsPage.isLast(),
                 productsPage.hasNext(),
                 productsPage.hasPrevious()
         );
         return pagedResult;
    }
}
