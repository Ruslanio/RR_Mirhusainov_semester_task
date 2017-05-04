package mirhusainov.itis.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by Ruslan on 04.05.2017.
 */
@Order(2)
public class SecurityInit extends AbstractSecurityWebApplicationInitializer {
}


