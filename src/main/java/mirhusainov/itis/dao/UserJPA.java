package mirhusainov.itis.dao;

import mirhusainov.itis.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ruslan on 26.04.2017.
 */
public interface UserJPA extends JpaRepository<UsersEntity,Long> {

    UsersEntity findOneByEmail(String email);
}
