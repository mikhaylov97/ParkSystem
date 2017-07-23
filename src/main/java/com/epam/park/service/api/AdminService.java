package com.epam.park.service.api;


import com.epam.park.model.Order;
import com.epam.park.model.User;

import java.util.List;

public interface AdminService {
    void addAdmin(User user);
    void removeAdmin(Long id);
    List<User> getAllAdmins();
    void acceptTask(Long id);
    List<Order> getDoneTasks();
    void declineTask(Long id);
}
