package demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {
    @Pointcut("within(demo..*)")
    public void authenticationPointcut() {
        System.out.println("AuthenticationPointcut");
    }

    @Pointcut("within(demo..*)")
    public void authorizationPointcut() {
        System.out.println("AuthorizationPointcut");
    }

    @Before("authenticationPointcut() && authorizationPointcut()")
    public void authenticate(){
        System.out.println("authenticating the Request");
    }
}
