package demo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
//    * for any return type
    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforelogger(JoinPoint jp) {
        System.out.println(jp.getSignature());
        String arg = jp.getArgs()[0].toString();
        System.out.println(arg);
        System.out.println("BLogging to ShoppingCart");
    }
// *.* any package. any class
    @After("execution(* *.*.checkout(..))")
    public void afterlogger(){
        System.out.println("ALogging to ShoppingCart");
    }

    @Pointcut("execution(* demo.*.quantity(..))")
    public void afterReturningPointCut(){

    }

    @AfterReturning(pointcut = "afterReturningPointCut()",returning = "retVal")
    public void afterReturning(String retVal){
        System.out.println("After Returning " + retVal);
    }

//    AfterThrowing

}
