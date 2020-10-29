package com.example.demo.controller;

import com.example.demo.model.ProductDtu;
import com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String CreateMetode(ProductDtu productDtu){
        return "Create";
    }

    @PostMapping("/Create")
    public String create( ProductDtu productDtu){
        productRepository.create(productDtu);
        return "redirect:/";
    }

    // update gider mig ikke jeg går videre med delete og prøver at få det running.
    @GetMapping("/Update")
    public String getProductToUpdate(@RequestParam String pro_id, Model model){
        model.addAttribute("products", productRepository.read(pro_id));
        return "Update";
    }

    @PostMapping ("/Update")
    public String updateProduct(ProductDtu productDtu){
        productRepository.update(productDtu);
        return "redirect:/";
    }
    // prøver at få delete product til at virke
    @GetMapping ("/Delete")
    public String getDeleteProduct(@RequestParam int pro_id, Model model){
        model.addAttribute("deleteProduct", productRepository.delete(pro_id));
        return "redirect:/";
    }

//    @GetMapping("/bookings/deleteBooking")
//    public String getDeleteBooking(@RequestParam int id, Model model) {
//        model.addAttribute("deleteBooking", BookingIDRep.BookingIdByInt(id));
//        return "/bookings/deleteBooking";
//
//    }
//


    /*
    @GetMapping ("Delete")
    public String DeleteProduct(){
        productRepository.delete()
    }

     */
//
//    @PostMapping("/")
//    public String UpdateMetode(){
//
//        return "Update";
//    }


}
