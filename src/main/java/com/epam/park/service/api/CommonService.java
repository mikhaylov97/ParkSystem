package com.epam.park.service.api;

import com.epam.park.model.Forester;
import com.epam.park.model.Owner;

import java.util.List;

public interface CommonService {
    List<Owner> getAllOwners();
    Owner getOwnerById(long id);
    Owner saveOwner(Owner user);
    void removeOwner(long id);
    List<Forester> getAllForesters();
    Forester getForesterById(long id);
    Forester saveForester(Forester user);
    void removeForester(long id);
    boolean isEmailFree(String email);
    boolean isPasswordCorrect(String email, String password);
}
