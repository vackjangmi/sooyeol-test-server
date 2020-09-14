package sooyeol.api.interceptor;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class TokenInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    @Value("${spring.profiles.active}")
    private String profileMode;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String loginToken = request.getHeader("LOGIN_TOKEN");
        logger.info(loginToken);

        return true;
    }
}
