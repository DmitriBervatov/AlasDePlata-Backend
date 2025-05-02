package com.alasdeplata.dto.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.alasdeplata.enums.PaymentMethod;

public record PaymentRequest(
        Long reservationId,
        BigDecimal amount,
        LocalDateTime paymentDate,
        PaymentMethod paymentMethod) {

}
