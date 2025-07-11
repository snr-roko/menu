package com.coffeeshop.menu.controller;

import com.coffeeshop.menu.model.Product;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private List<Product> productsList = new ArrayList<>(List.of(
            new Product(1, "Expresso", 2.50),
            new Product(2, "Latte", 3.50),
            new Product(3, "Croissant", 2.00),
            new Product(4, "Chocolate Muffin", 2.25),
            new Product(5, "Americano", 2.75)
    ));

    @RequestMapping("/")
    public String listProducts(Model productListModel) {
        productListModel.addAttribute("products", productsList);
        return "menu";
    }

    @RequestMapping("/add")
    public String showProductForm(Model productAddFormModel) {
        productAddFormModel.addAttribute("product", new Product());

        return "add-new-product";
    }

    @RequestMapping("/addNewProduct")
    public String addProduct(@Valid Product product, BindingResult bindingResult) {
        productsList.add(product);
        if (bindingResult.hasErrors()) {
            return "add-new-product";
        }
        System.out.println(productsList);
        return "redirect:/";
    }
}
