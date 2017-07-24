package com.epam.park.service.impl;

import com.epam.park.model.Order;
import com.epam.park.model.User;
import com.epam.park.model.roles.OrderStatusEnum;
import com.epam.park.model.roles.UserRoleEnum;
import com.epam.park.repository.OrderRepository;
import com.epam.park.repository.UserRepository;
import com.epam.park.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CommonServiceImpl commonService;

    @Override
    public void addAdmin(User user) {
        if(commonService.getUserByEmail(user.getEmail()) == null) {
            userRepository.saveAndFlush(user);
        } else throw new IllegalArgumentException();
    }

    @Override
    public void removeAdmin(Long id) {
        commonService.removeUser(id);
    }

    @Override
    public List<User> getAllAdmins() {
        List<User> result = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.getRole().equals(UserRoleEnum.ROLE_ADMIN.name())) {
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public void acceptTask(Long id) {
        Order order = orderRepository.findOne(id);
        order.setStatus(OrderStatusEnum.ACCEPTED.name());
        orderRepository.saveAndFlush(order);
    }

    @Override
    public List<Order> getDoneTasks(String ownerEmail) {
        List<Order> result = new ArrayList<>();
        for (Order order : orderRepository.findAll()){
            if (order.getStatus().equals(OrderStatusEnum.DONE.name())) {
//                    && order.getOwner().getEmail().equalsIgnoreCase(ownerEmail)) {
                result.add(order);
            }
        }
        return result;
    }

    @Override
    public void declineTask(Long id) {
        Order order = orderRepository.findOne(id);
        order.setStatus(OrderStatusEnum.DECLINED.name());
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void addNewTask(Order order) {
        orderRepository.saveAndFlush(order);
    }
}
