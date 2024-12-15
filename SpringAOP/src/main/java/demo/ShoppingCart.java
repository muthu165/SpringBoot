package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout(String status) {
//        Logging
//        Authentication & Authorization
//        Sanitize the data
        System.out.println("checkout from shopping cart");
    }

    public int quantity(){
            return 20;
        }

}
