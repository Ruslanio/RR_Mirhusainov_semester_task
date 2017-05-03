package mirhusainov.itis.config;

import mirhusainov.itis.security.AccessDeniedHandlerImpl;
import mirhusainov.itis.security.AuthenticationProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Ruslan on 26.04.2017.
 */
@Configuration
@EnableWebSecurity
@ComponentScan("mirhusainov.itis.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AccessDeniedHandlerImpl accessDeniedHandler;
    private final AuthenticationProviderImpl authenticationProvider;

    @Autowired
    public SecurityConfig(AccessDeniedHandlerImpl accessDeniedHandler, AuthenticationProviderImpl authenticationProvider) {
        this.accessDeniedHandler = accessDeniedHandler;
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/sign-in", "/sign-up").anonymous()
                .antMatchers("/home", "/country**/**").hasRole("USER")
                .antMatchers("/**").hasRole("ADMIN");

        http.csrf()
                .disable()
                .formLogin()
                .loginPage("/sign-in")
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .failureForwardUrl("/sign-in?error = true");
        http.csrf()
                .disable()
                .logout().logoutSuccessUrl("/sign-up");
        http.csrf()
                .disable()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}
