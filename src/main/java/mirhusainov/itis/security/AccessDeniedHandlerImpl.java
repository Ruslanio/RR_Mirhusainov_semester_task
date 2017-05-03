package mirhusainov.itis.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ruslan on 02.05.2017.
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    private final static String ON_ERROR_LOCATION = "/home";
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.sendRedirect(ON_ERROR_LOCATION);
    }
}
