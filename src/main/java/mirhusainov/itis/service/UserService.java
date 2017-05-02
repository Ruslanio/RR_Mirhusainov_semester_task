package mirhusainov.itis.service;

import mirhusainov.itis.dao.UserJPA;
import mirhusainov.itis.entities.UsersEntity;
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

    public void add(UsersEntity user){
        userJPA.save(user);
    }

    public UsersEntity getOneById(Long id){
        return userJPA.findOne(id);
    }

    public List<UsersEntity> getAll(){
        return userJPA.findAll();
    }
}
