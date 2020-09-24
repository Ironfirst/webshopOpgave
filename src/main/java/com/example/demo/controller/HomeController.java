package com.example.demo.controller;

import com.example.demo.model.ProductDtu;
import com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController
{

    private ProductRepository productRepository;

    public HomeController(){productRepository = new ProductRepository();}


    @GetMapping("/")
        public String showProducts(Model model){
            model.addAttribute("products", productRepository.readAll());
            return "/Products/home";
    }

    @GetMapping("/Create")
    public String CreateMetode(){
        return "Create";
    }

    @PostMapping("/Create")
    public String create( ProductDtu productDtu){
        productRepository.create(productDtu);
        return "redirect:/";
    }

    @GetMapping("/Update")
    public String update(){
        return "Update";
    }

    @PostMapping ("/Update")
    public String updateProduct(ProductDtu productDtu){
        productRepository.update(productDtu);
        return "redirect:/";
    }
//
//    @PostMapping("/")
//    public String UpdateMetode(){
//
//        return "Update";
//    }


}
