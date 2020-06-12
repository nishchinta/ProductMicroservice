package com.management.ProductMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.ProductMS.dto.ProductDTO;
import com.management.ProductMS.entity.Product;
import com.management.ProductMS.repository.ProductRepository;
import com.management.ProductMS.validator.ProductValidator;

@Service
public class ProductService {
    @Autowired
	ProductRepository productRepository;
	
	public List<ProductDTO> getproducts(){
		List<Product> product= productRepository.findAll();
		List<ProductDTO> productDTO= new ArrayList<ProductDTO>();
		for(Product p1: product) {
			ProductDTO product1= ProductDTO.valueof(p1);
			productDTO.add(product1);
		}
		return productDTO;	
	}
	
	public List<ProductDTO> getproductsonCategory(String category){
		List<Product> product= productRepository.findAll();
		List<ProductDTO> productDTO= new ArrayList<ProductDTO>();
		for(Product p1: product) {
			if(p1.getCategory().equals(category)) {
			ProductDTO product1= ProductDTO.valueof(p1);
			productDTO.add(product1);}
			
		}
		return productDTO;	
	}
		
	
	
	public List<ProductDTO> getproductsonName(String productName){
		List<Product> product= productRepository.findAll();
		List<ProductDTO> productDTO= new ArrayList<ProductDTO>();
		for(Product p1: product) {
			if(p1.getProductName().equals(productName)) {
			ProductDTO product1= ProductDTO.valueof(p1);
			productDTO.add(product1);}
			
		}
		return productDTO;
		
	}
	public ProductDTO getProductsOnId(Integer prodid) {
		ProductDTO product1 = null;
		Optional<Product> product= productRepository.findById(prodid);
		if(product.isPresent()) {
//		ProductDTO productDTO= new ProductDTO();
		if(prodid.equals(product.get().getProdid())) {
			product1= ProductDTO.valueon(product);
			
	}}return product1;}

	public void addproducts(ProductDTO productdto) throws Exception{
		ProductValidator.ProdValidate(productdto);
		Product pe=productdto.createEntity();
		productRepository.save(pe);
		
	}
	
	public void deleteproducts(Integer prodid) {
		
			productRepository.deleteById(prodid);
		
		
	}}


