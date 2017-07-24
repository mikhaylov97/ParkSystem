package com.epam.park.service.api;


import com.epam.park.model.Order;

import java.util.List;

public interface ForesterService {
    List<Order> getNewTasks(String workerEmail);
    List<Order> getDeclinedTasks(String workerEmail);
    void makeTaskDone(Long id);
}
