package com.william.healthytalk.repository.user;

import com.william.healthytalk.entity.user.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserRepository extends CrudRepository<UserEntity,Integer> {

    int deleteUserEntityById(int id);
}
