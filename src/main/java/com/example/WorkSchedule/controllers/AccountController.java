package com.example.WorkSchedule.controllers;

import com.example.WorkSchedule.models.Account;
import com.example.WorkSchedule.models.TransferRequest;
import com.example.WorkSchedule.services.TransferService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

@Controller
public class AccountController {
    private final TransferService transferService;
    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) throws AccountNotFoundException {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }
    @GetMapping("/accounts")
    public String getAllAccounts(@RequestParam(required = false) String name, Model model){
        Iterable<Account> accounts;
        if(name == null){
             accounts = transferService.getAllAccounts();
        }else {
            accounts = transferService.findAccountsByName(name);
        }
        model.addAttribute("accounts",accounts);
        return "account.html";
    }
    @PostMapping("/accounts")
    public String addAccount(@RequestParam String name,
                             @RequestParam BigDecimal amount,
                             Model model){
        Account account = new Account();
        account.setName(name);
        account.setAmount(amount);
        transferService.addAccount(account);

        Iterable<Account> accounts = transferService.getAllAccounts();
        model.addAttribute("accounts",accounts);
        return "account.html";
    }
    @PostMapping("/delete")
    public String deleteAccount(@RequestParam String id, Model model){
        transferService.deleteAccount(Long.parseLong(id));

        Iterable<Account> accounts = transferService.getAllAccounts();
        model.addAttribute("accounts", accounts);
        return "account.html";
    }
}
