package com.epam.park.service.api;

import com.epam.park.model.Order;
import com.epam.park.model.User;

import java.util.List;

public interface CommonService {
    List<User> getAllUsers();
    User getUserById(long id);
    User saveUser(User user);
    void removeUser(long id);
    boolean isEmailFree(String email);
    boolean isPasswordCorrect(String email, String password);
    User getUserByEmail(String email);
    String getUserRole(String email);
    List<Order> getDoneOrders();
    //void createOrder(Long id, String amount, String purpose);
    List<User> getAllWorkers();
}
