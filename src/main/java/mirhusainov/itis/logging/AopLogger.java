package mirhusainov.itis.logging;

import mirhusainov.itis.entities.CountryEntity;
import mirhusainov.itis.entities.UserEntity;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


/**
 * Created by Ruslan on 03.05.2017.
 */

@Aspect
public class AopLogger {

    private Logger logger = Logger.getLogger(getClass());

    {
        BasicConfigurator.configure();
    }
    @Before("execution(* mirhusainov.itis.controllers.AdminController.add*(..))")
    public void addLog(){
        logger.info("admin added something");
    }

    @Before("execution(* mirhusainov.itis.controllers.AdminController.delete*(..))")
    public void delLog(){
        logger.info("admin deleted something");
    }

    @After("execution(* mirhusainov.itis.service.UserService.add(..))")
    public void userAddedLog(JoinPoint point){
        UserEntity user = (UserEntity) point.getArgs()[0];
        logger.info("user " + user.getUserName() + "is added to the base");
    }

    @After("execution(* mirhusainov.itis.service.CountryService.add(..))")
    public void CountryAddedLog(JoinPoint point){
        CountryEntity country = (CountryEntity) point.getArgs()[0];
        logger.info("country " + country.getName() + "is added to the base");

    }

}
