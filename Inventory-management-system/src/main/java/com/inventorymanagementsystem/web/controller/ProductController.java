package com.inventorymanagementsystem.web.controller;


import com.github.fge.jsonpatch.JsonPatch;
import com.inventorymanagementsystem.data.dto.requestDto.ProductDto;
import com.inventorymanagementsystem.data.model.Product;
import com.inventorymanagementsystem.service.productService.ProductService;
import com.inventorymanagementsystem.web.exceptions.BusinessLogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private Product product;

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<?> findAllProducts(){
        List<Product> productList = productService.getAllProducts();
        return ResponseEntity.ok().body(productList);
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createProduct(@ModelAttribute ProductDto productDto) {
        try {
            Product savedProduct = productService.createProduct(productDto);
            return ResponseEntity.ok().body(savedProduct);
        }catch( BusinessLogicException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping(path ="/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<?> updateProductDetails(@PathVariable Long id, JsonPatch productPatch){
        try {
            Product updateProduct = productService.updateProductDetails(id, productPatch);
            return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
        }catch(Exception | BusinessLogicException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
