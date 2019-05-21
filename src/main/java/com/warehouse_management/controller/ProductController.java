package com.warehouse_management.controller;
 
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.amqp.AmqpException;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.alibaba.fastjson.JSON;
//import com.warehouse_management.pojo.Product;
//import com.warehouse_management.service.ProductService;
// 
//@Controller
//public class ProductController { 
//	
//	@Autowired
//	private ProductService productService;
//	
//	//注入RabbitMQ的模板类，用于与RabbitMQ交互
//	@Autowired  
//	private RabbitTemplate rabbitTemplate;  
//
//	//创建该类的日志对象
//	Log log = LogFactory.getLog(this.getClass());  
//	
//	
//	//跳转至列表页面
//	@RequestMapping("/product/home.action")  
//    public String list(Model model){ 
//		List<Product> productList = productService.selectAllProduct(null);
//		model.addAttribute("productList",productList);//货物列表
//		return "/product/home.jsp";//转向首页
//	}
//	
//	@RequestMapping("/product/toAdd.action")  
//    public String toAdd(Model model){   
//		return "/product/add.jsp";//转向添加页
//    } 
//		
//	@RequestMapping("/product/toEdit.action")  
//    public String toEdit(Model model,Integer id){   
//		if(id!=null){
//			model.addAttribute("product", productService.selectProductById(id));
//		}
//		return "/product/edit.jsp";//转向编辑页
//    } 
//	
////	@RequestMapping("/product/add.action")  
////    public String add(Model model,Product product){   
////		productService.insertProduct(product);
////		//重新刷新至分页列表页首页
////		return list(model);
////    }  
////	
////	@RequestMapping("/product/edit.action")  
////    public String edit(Model model,Product product){   
////		productService.updateProduct(product);
////		//重新刷新至分页列表页首页
////		return list(model);
////    } 
//// 
////    @RequestMapping("/product/delete.action")  
////    public String delete(Model model,Integer id){   
////		productService.deleteProductById(id);
////		//重新刷新至分页列表页首页
////		return list(model);
////    } 
//	
//		
//	@RequestMapping("/product/add.action")    
//	public String add(Model model,Product product){     
//	    productService.insertProduct(product);  
//	    try {
//			//将信息信息发送至rabbitMQ的交换机，通知其它系统新增了商品
//			Map<String,Object> msg = new HashMap<String,Object>();
//			msg.put("itemObject",product);
//			msg.put("type", "insert");
//			msg.put("date", System.currentTimeMillis());//时间戳
//			//使用fastJson将新增的商品信息转换为json字符串，方便接收方解析
//			this.rabbitTemplate.convertAndSend("item.insert", JSON.toJSON(msg).toString());//消息的key，与内容
//		} catch (AmqpException e) {
//			e.printStackTrace();
//		}
//	    //重新刷新至分页列表页首页  
//	    return list(model);  
//	}   
//
//	  
//	@RequestMapping("/product/edit.action")    
//	public String edit(Model model,Product product){     
//	    productService.updateProduct(product); 
//	    //将信息信息发送至rabbitMQ，通知其它系统编辑了商品
//	    sengMsgToMQ(product,"update");
//	    //重新刷新至分页列表页首页  
//	    return list(model);  
//	}   
//	  
//	  
//	@RequestMapping("/product/delete.action")    
//	public String delete(Model model,Integer id){     
//	    productService.deleteProductById(id);  
//		//将信息信息发送至rabbitMQ，通知其它系统删除了商品
//	    Product product = new Product();
//	    product.setId(id);//封装删除的ID信息
//	    sengMsgToMQ(product,"delete");
//	    //重新刷新至分页列表页首页  
//	    return list(model);  
//	}  
//	    
//	private void sengMsgToMQ(Product product,String Type) {
//		try {
//			Map<String,Object> msg = new HashMap<String,Object>();
//			msg.put("itemObject",JSON.toJSON(product).toString());
//			msg.put("type", Type);
//			msg.put("date", System.currentTimeMillis());//时间戳
//			//使用fastJson将新增的商品信息转换为json字符串，方便接收方解析
//			this.rabbitTemplate.convertAndSend("item."+Type, JSON.toJSON(msg).toString());//消息的key，与内容
//		} catch (AmqpException e) {
//			e.printStackTrace();
//		}
//	}    
//
//	
//	
//}

