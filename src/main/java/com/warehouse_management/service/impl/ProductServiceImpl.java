package com.warehouse_management.service.impl;
 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse_management.mapper.ProductMapper;
import com.warehouse_management.pojo.Product;
import com.warehouse_management.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{  
	@Autowired
	private ProductMapper productMapper;
	
	//只查询一个，常用于修改  
	public Product selectProductById(int id){
		return productMapper.selectProductById(id);
	}
	//根据条件查询多个结果
    public List<Product> selectAllProduct(Map<String,Object> map){
    	return productMapper.selectAllProduct(map);
    }
    
    //插入，用实体作为参数  
    public boolean insertProduct(Product product){
    	return productMapper.insertProduct(product)>0;
    }
    //修改，用实体作为参数
    public boolean updateProduct(Product product){
    	return productMapper.updateProduct(product)>0;
    } 
    //按id删除，删除一条
    public boolean deleteProductById(int id){
    	return productMapper.deleteProductById(id)>0;
    }
}   
