package com.alasdeplata.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alasdeplata.dto.payment.PaymentRequest;
import com.alasdeplata.dto.payment.PaymentResponse;
import com.alasdeplata.dto.payment.PaymentUpdateRequest;
import com.alasdeplata.mapper.PaymentMapper;
import com.alasdeplata.models.Payment;
import com.alasdeplata.repository.PaymentRepository;
import com.alasdeplata.services.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public List<PaymentResponse> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::toResponse)
                .toList();
    }

    @Override
    public PaymentResponse getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .map(paymentMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public PaymentResponse createPayment(PaymentRequest item) {
        Payment payment = paymentMapper.toEntity(item);
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toResponse(savedPayment);
    }

    @Override
    public PaymentResponse updatePayment(Long id, PaymentUpdateRequest item) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        paymentMapper.updatePaymentFromDto(item, payment);

        Payment updatedPayment = paymentRepository.save(payment);
        return paymentMapper.toResponse(updatedPayment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

}
