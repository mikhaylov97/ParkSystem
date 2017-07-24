package com.epam.park.service.impl;

import com.epam.park.model.Order;
import com.epam.park.model.roles.OrderStatusEnum;
import com.epam.park.repository.OrderRepository;
import com.epam.park.service.api.ForesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForesterServiceImpl implements ForesterService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getNewTasks(String workerEmail) {
        List<Order> result = new ArrayList<>();
        for (Order order : orderRepository.findAll()) {
            if (order.getStatus().equals(OrderStatusEnum.IN_PROGRESS.name())
                    && order.getForester().getEmail().equalsIgnoreCase(workerEmail)) {
                result.add(order);
            }
        }
        return result;
    }

    @Override
    public List<Order> getDeclinedTasks(String workerEmail) {
        List<Order> result = new ArrayList<>();
        for (Order order : orderRepository.findAll()) {
            if (order.getStatus().equals(OrderStatusEnum.DECLINED.name())
                    && order.getForester().getEmail().equalsIgnoreCase(workerEmail)) {
                result.add(order);
            }
        }
        return result;
    }

    @Override
    public void makeTaskDone(Long id) {
        Order order = orderRepository.findOne(id);
        order.setStatus(OrderStatusEnum.DONE.name());
        orderRepository.saveAndFlush(order);
    }
}
