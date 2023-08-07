package com.example.WorkSchedule.controllers;

import com.example.WorkSchedule.models.Purchase;
import com.example.WorkSchedule.repositoryes.PurchaseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }
    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase){
        purchaseRepository.storePurchase(purchase);
    }
    @GetMapping
    public String findPurchases(Model model){
        Iterable<Purchase> purchases = purchaseRepository.findAllPurchases();
        model.addAttribute("purchases",purchases);
        return "purchase";
    }
}
