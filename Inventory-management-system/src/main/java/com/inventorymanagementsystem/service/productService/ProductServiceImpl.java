package com.inventorymanagementsystem.service.productService;

import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.inventorymanagementsystem.data.dto.requestDto.ProductDto;
import com.inventorymanagementsystem.data.model.Product;
import com.inventorymanagementsystem.data.repository.ProductRepository;
import com.inventorymanagementsystem.service.cloud.CloudService;
import com.inventorymanagementsystem.web.exceptions.BusinessLogicException;
import com.inventorymanagementsystem.web.exceptions.ProductDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CloudService cloudService;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();  }

    @Override
    public Product findProductById(Long productId) throws ProductDoesNotExistException {
        if(productId == null) throw new IllegalArgumentException("Id can not be null");
        Optional<Product> queryResult = productRepository.findById(productId);
        if(queryResult.isPresent()){ return queryResult.get(); }
        throw new ProductDoesNotExistException("Product with ID: " + productId + "does not not exist");
    }
    //    DTO===>Is The same has  CreatingRequest

    @Override
    public Product createProduct(ProductDto productDto) throws BusinessLogicException {
        if(productDto == null) throw new BusinessLogicException ("Argument cannot be null");
        if(productRepository.findByName(productDto.getProductName()).isPresent()){
            throw new IllegalArgumentException("Product with name" + productDto.getProductName() + "already exits");
        }
        Product product = new Product();
        try{
            if(productDto.getImage() != null) {
                Map<?, ?> uploadResult = cloudService.upload(productDto.getImage().getBytes(),
                        ObjectUtils.asMap(
                        "public_id",
                        "inventory/" + productDto.getImage().getOriginalFilename(),
                        "overwrite", true));
                product.setImageUrl(uploadResult.get("url").toString());
            }
        }catch(IOException e){ e.printStackTrace();  }

        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductQuantity(productDto.getProductQuantity());
        product.setProductDescription(productDto.getProductDescription());
        product.setBatchId(productDto.getBatchId());

        return productRepository.save(product);
    }

    private Product saveOrUpdateProduct(Product product) throws BusinessLogicException {
        if(product == null){ throw new BusinessLogicException("Product can not be null "); }
        return productRepository.save(product);
    }


    @Override
    public Product updateProductDetails(Long productId, JsonPatch productPatch) throws BusinessLogicException {
        Optional<Product> productQuery =productRepository.findById(productId);
        if(productQuery.isEmpty()){
            throw new BusinessLogicException("Product with ID:" + productId + "Does not exist");
        }
        Product targetProduct = productQuery.get();
        try {
            targetProduct = applyPatchToProduct(productPatch, targetProduct);
            return saveOrUpdateProduct(targetProduct);
        } catch (JsonPatchException | JsonProcessingException |BusinessLogicException jsonException){
            throw new BusinessLogicException("Product update failed");
        }
    }
    //note: In creating RESTAPI, resources can also be called Class fields
    // JsonPatch: Is for updating partial resources of an Object or a class
    // ObjectMapper helps update the resources by converting model feilds using JSon patch format...
//    ....JsonPatch...When we "apply" JsonPatch on The Target Product(Class)..It uses ModelMapper...
//    ...to convert the resources to Json And convert back to JacksonB

    private Product applyPatchToProduct(JsonPatch productPatch, Product targetProduct) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched= productPatch.apply(objectMapper.convertValue(targetProduct, JsonNode.class));
        return objectMapper.treeToValue(patched, Product.class);
    }

}
