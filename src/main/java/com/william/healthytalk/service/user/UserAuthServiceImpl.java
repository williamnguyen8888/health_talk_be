package com.william.healthytalk.service.user;

import com.william.healthytalk.entity.user.UserEntity;
import com.william.healthytalk.repository.user.IUserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthServiceImpl implements IUserAuthService {

    @Autowired
    private IUserAuthRepository userAuthRepository;
    @Override
    public UserEntity save(UserEntity accountEntity) {
        return userAuthRepository.save(accountEntity);
    }

    @Override
    public Optional<UserEntity> findById(int id) {
        return userAuthRepository.findById(id);
    }

    @Override
    public Iterable<UserEntity> findAll() {
        return userAuthRepository.findAll();
    }

    @Override
    public int deleteUserEntitiesById(int id) {
        int countRow = userAuthRepository.deleteUserEntitiesById(id);
        return countRow;
    }

    @Override
    public boolean existsUserEntitiesByUserNameAndPassword(String userName, String password) {
        return userAuthRepository.existsUserEntitiesByUserNameAndPassword(userName, password);
    }

    @Override
    public UserEntity findUserEntityByUserName(String userName) {
        return userAuthRepository.findUserEntityByUserName(userName);
    }
}
