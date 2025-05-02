package com.alasdeplata.services;

import java.util.List;

import com.alasdeplata.dto.payment.PaymentRequest;
import com.alasdeplata.dto.payment.PaymentResponse;
import com.alasdeplata.dto.payment.PaymentUpdateRequest;

public interface PaymentService {

    List<PaymentResponse> getAllPayments();

    PaymentResponse getPaymentById(Long id);

    PaymentResponse createPayment(PaymentRequest item);

    PaymentResponse updatePayment(Long id, PaymentUpdateRequest item);

    void deletePayment(Long id);

}
