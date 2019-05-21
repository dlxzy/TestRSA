package com.warehouse_management.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse_management.util.RSAUtils;

@Controller
public class TestRSAController {

	Map<String, String> keyMap = RSAUtils.createKeys(1024);
	
	@ResponseBody
	@RequestMapping(value="abc")
	public String jiami(String text) throws NoSuchAlgorithmException, InvalidKeySpecException{
		
		String  publicKey = keyMap.get("publicKey");
		System.out.println("公钥: \n\r" + publicKey);
		String  privateKey = keyMap.get("privateKey");
		System.out.println("私钥： \n\r" + privateKey);
		
		String rastext = RSAUtils.publicEncrypt(text, RSAUtils.getPublicKey(publicKey));
	    System.out.println("密文：\r\n" + rastext);
		
		return rastext;

	}
	
	@ResponseBody
//	@RequestMapping(value="cba",produces = "text/html;charset=UTF-8")
	@RequestMapping(value="cba")
	public String jiemi(String rastext) throws NoSuchAlgorithmException, InvalidKeySpecException{
		
		String  publicKey = keyMap.get("publicKey");
		System.out.println("公钥: \n\r" + publicKey);
		String  privateKey = keyMap.get("privateKey");
		System.out.println("私钥： \n\r" + privateKey);
		
		String text = RSAUtils.privateDecrypt(rastext, RSAUtils.getPrivateKey(privateKey));
	    System.out.println("解密后文字: \r\n" + text);
		
		return text;
	}
	
}
