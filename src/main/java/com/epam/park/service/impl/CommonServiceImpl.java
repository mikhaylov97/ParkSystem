package com.epam.park.service.impl;

import com.epam.park.model.Forester;
import com.epam.park.model.Owner;
import com.epam.park.repository.ForesterRepository;
import com.epam.park.repository.OwnerRepository;
import com.epam.park.service.api.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImpl implements CommonService{

    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    ForesterRepository foresterRepository;

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner getOwnerById(long id) {
        return ownerRepository.findOne(id);
    }

    @Override
    public Owner saveOwner(Owner user) {
        return ownerRepository.saveAndFlush(user);
    }

    @Override
    public void removeOwner(long id) {
        ownerRepository.delete(id);
    }

    @Override
    public List<Forester> getAllForesters() {
        return foresterRepository.findAll();
    }

    @Override
    public Forester getForesterById(long id) {
        return foresterRepository.findOne(id);
    }

    @Override
    public Forester saveForester(Forester user) {
        return foresterRepository.saveAndFlush(user);
    }

    @Override
    public void removeForester(long id) {
        foresterRepository.delete(id);
    }

    @Override
    public boolean isEmailFree(String email) {
        List<Owner> owners = ownerRepository.findAll();
        List<Forester> foresters = foresterRepository.findAll();
        for (Owner owner : owners) {
            if (owner.getEmail().equalsIgnoreCase(email)) return false;
        }
        for (Forester forester : foresters) {
            if (forester.getEmail().equalsIgnoreCase(email)) return false;
        }
        return true;
    }

    @Override
    public boolean isPasswordCorrect(String email, String password) {
        List<Owner> owners = ownerRepository.findAll();
        for (Owner owner : owners) {
            if (owner.getEmail().equalsIgnoreCase(email) && owner.getPassword().equals(password)) return true;
        }
        List<Forester> foresters = foresterRepository.findAll();
        for (Forester forester : foresters) {
            if (forester.getEmail().equalsIgnoreCase(email) && forester.getPassword().equals(password)) return true;
        }
        return false;
    }
}
