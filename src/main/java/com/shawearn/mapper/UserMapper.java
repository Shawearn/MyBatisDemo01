package com.shawearn.mapper;

import com.shawearn.model.User;

/**
 * Created by Shawearn on 7/24/2017.
 */
public interface UserMapper {
    User selectById(int id);
    void insertUser(User role);
}
