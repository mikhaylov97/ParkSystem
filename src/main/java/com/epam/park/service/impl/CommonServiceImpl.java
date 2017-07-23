package com.epam.park.service.impl;

import com.epam.park.model.Order;
import com.epam.park.model.Plant;
import com.epam.park.model.User;
import com.epam.park.repository.OrderRepository;
import com.epam.park.repository.PlantRepository;
import com.epam.park.repository.UserRepository;
import com.epam.park.service.api.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PlantRepository plantRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void removeUser(long id) {
        userRepository.delete(id);
    }

    @Override
    public boolean isEmailFree(String email) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) return false;
        }
        return true;
    }

    @Override
    public boolean isPasswordCorrect(String email, String password) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) return true;
        }
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) return user;
        }
        return null;
    }

    @Override
    public String getUserRole(String email) {
        User user = getUserByEmail(email);
        return user.getRole();
    }

    @Override
    public List<Order> getDoneOrders() {
        List<Order> orders = orderRepository.findAll();
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equals("done")) {
                result.add(order);
            }
        }
        return result;
    }

    @Override
    public void createOrder(Long id, String amount, String purpose) {
        Plant plant = plantRepository.findOne(id);
        orderRepository.saveAndFlush(new Order(plant, amount, purpose));
    }
}
