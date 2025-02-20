package com.dmenca.spb.manager;

import com.dmenca.spb.dao.UserAddressDao;
import com.dmenca.spb.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAddressManager {
    @Autowired
    private UserAddressDao userAddressDao;

    public List<Address> getUserAddresses(Long userId) {
        return userAddressDao.getUserAddressById(userId);
    }
}
