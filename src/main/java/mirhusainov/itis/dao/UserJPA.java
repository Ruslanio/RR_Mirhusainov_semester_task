package mirhusainov.itis.dao;

import mirhusainov.itis.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ruslan on 26.04.2017.
 */
public interface UserJPA extends JpaRepository<UserEntity,Long> {

    UserEntity findOneByEmail(String email);
}
