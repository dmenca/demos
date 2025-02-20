package com.dmenca.spb.dao;

import com.dmenca.spb.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserAddressDao {

    private static final Map<Long, List<Address>> userAddress = new HashMap<>();

    public  List<Address> getUserAddressById(Long id) {
        return userAddress.get(id);
    }
}
