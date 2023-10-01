package com.learnwithvjk.orderservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnwithvjk.orderservice.dto.OrderLineItemsDto;

import java.util.List;

import com.learnwithvjk.orderservice.dto.OrderRequest;
// import com.learnwithvjk.orderservice.dto.OrderResponse;
import com.learnwithvjk.orderservice.model.Order;
import com.learnwithvjk.orderservice.model.OrderLineItems;
import com.learnwithvjk.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItemsDto> orderLineItemsDto = orderRequest.getOrderLineItemsDtoList();
        List<OrderLineItems> orderLineItems = orderLineItemsDto.stream().map(this::mapOrderLineRequestoOrderLineItems)
                .toList();
        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }

    private OrderLineItems mapOrderLineRequestoOrderLineItems(OrderLineItemsDto orderLineItemsdDto) {
        return OrderLineItems.builder()
                .skuCode(orderLineItemsdDto.getSkuCode())
                .price(orderLineItemsdDto.getPrice())
                .quantity(orderLineItemsdDto.getQuantity())
                .build();
    }

    // ic List<OrderResponse> getOrder() {
    // return null;
    // }

}
