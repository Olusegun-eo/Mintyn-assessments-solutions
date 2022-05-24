package com.inventorymanagementsystem.service.productService;

import com.github.fge.jsonpatch.JsonPatch;
import com.inventorymanagementsystem.data.dto.requestDto.ProductDto;
import com.inventorymanagementsystem.data.model.Product;
import com.inventorymanagementsystem.web.exceptions.BusinessLogicException;
import com.inventorymanagementsystem.web.exceptions.ProductDoesNotExistException;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product findProductById(Long productId) throws ProductDoesNotExistException;
    Product createProduct(ProductDto productDto) throws BusinessLogicException;
    Product updateProductDetails(Long productId, JsonPatch patchPath) throws BusinessLogicException;
}
