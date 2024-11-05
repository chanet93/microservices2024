package com.amigoscode.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amigoscode.clients.fraud.FraudCheckResponse;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudCheckHistoryController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable(required = true, value = "customerId") Integer id) {
        Boolean isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(id);
        log.info("fraud check request for customer {}", id);
        return new FraudCheckResponse(isFraudulentCustomer);

    }

}
