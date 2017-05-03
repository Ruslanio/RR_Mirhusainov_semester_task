package mirhusainov.itis.security;

import mirhusainov.itis.dao.UserJPA;
import mirhusainov.itis.entities.UsersEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Ruslan on 02.05.2017.
 */
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();
    private final UserJPA userJPA;

    public AuthenticationProviderImpl(UserJPA userJPA) {
        this.userJPA = userJPA;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        UsersEntity user = userJPA.findOneByEmail(email);

        if (user == null){
            throw new UsernameNotFoundException("user not found!");
        }

        String password = authentication.getCredentials().toString();
        if (!encoder.matches(password,user.getPassword())){
            throw new BadCredentialsException("invalid password!");
        }

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        if (user.getEmail().equals("powerfull@admin.me")){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_REGULAR"));
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user,null,authorities);
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
