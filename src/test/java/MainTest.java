import mirhusainov.itis.config.CoreConfig;
import mirhusainov.itis.config.DataBaseConfig;
import mirhusainov.itis.config.WebConfig;
import mirhusainov.itis.entities.UsersEntity;
import mirhusainov.itis.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ruslan on 04.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class,DataBaseConfig.class, CoreConfig.class})
public class MainTest {
    private static String ADMIN_EMAIL;
    private static Long ADMIN_ID;
    @Autowired
    private UserService userService;

    @Before
    public void setUpADMIN(){
        ADMIN_EMAIL = "powerfull@admin.me";
        ADMIN_ID = 0L;
    }

    @Test
    public void thereMustBeAdmin(){
        UsersEntity expectedAdmin = userService.getOneById(ADMIN_ID);
        assertEquals(expectedAdmin.getEmail(),ADMIN_EMAIL);
    }

}
