package com.warehouse_management.mapper;

import java.util.List;
import java.util.Map;

import com.warehouse_management.pojo.Product;

public interface ProductMapper {
	
	  public Product selectProductById(int id);//只查询一个，常用于修改  
	  
	  public List<Product> selectAllProduct(Map<String,Object> map);//根据条件查询多个结果
	  
	  public int insertProduct(Product product);//插入，用实体作为参数  
	  
	  public int updateProduct(Product product);//修改，用实体作为参数  
	  
	  public int deleteProductById(int id);//按id删除，删除一条

}
