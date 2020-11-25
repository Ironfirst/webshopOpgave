package com.example.demo.controller;

import com.example.demo.model.ProductDtu;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/*
@CrossOrigin(origins = "*")
@org.springframework.web.bind.annotation.RestController
public class RestController
{

   @GetMapping("/products")
   public ProductDtu productDtu(RequestBody requestBody){
      return ProductDtu(productDtu().getId(), productDtu().getName(), productDtu().getPrice(), productDtu().getBeskrivelse());
   }

   @GetMapping("/product/{id}")
   public ProductDtu productDtu(@RequestParam(value = "id") long id,@RequestBody ProductDtu productDtu) {
      return (productDtu.getId(), productDtu.getName(), productDtu.getPrice(), productDtu.getBeskrivelse());
   }

}
*/