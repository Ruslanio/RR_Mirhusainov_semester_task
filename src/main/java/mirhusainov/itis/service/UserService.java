package mirhusainov.itis.service;

import mirhusainov.itis.dao.UserJPA;
import mirhusainov.itis.entities.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ruslan on 27.04.2017.
 */
@Service
@Transactional
public class UserService {

    private final UserJPA userJPA;

    public UserService(UserJPA userJPA) {
        this.userJPA = userJPA;
    }

    public void add(UserEntity user){
        userJPA.save(user);
    }

    public UserEntity getOneById(Long id){
        return userJPA.findOne(id);
    }

    public List<UserEntity> getAll(){
        return userJPA.findAll();
    }
}