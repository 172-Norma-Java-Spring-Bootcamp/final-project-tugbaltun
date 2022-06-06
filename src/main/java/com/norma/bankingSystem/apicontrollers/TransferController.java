package com.norma.bankingSystem.apicontrollers;

import com.norma.bankingSystem.business.abstracts.ITransactionService;
import com.norma.bankingSystem.business.abstracts.ITransferService;
import com.norma.bankingSystem.entity.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
public class TransferController {
    ITransferService transferService;

    @Autowired
    public void ITransferService(ITransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/transfer/{transferFrom}/{transferTo}/{amount}")
    public void betweenAccountsTransfer(@PathVariable(value = "transferFrom") String transferFrom,
                                        @PathVariable(value = "transferTo")String transferTo,
                                        @PathVariable(value = "amount")String amount) throws Exception {
        transferService.betweenAccountsTransfer(transferFrom, transferTo, amount);
    }
}
