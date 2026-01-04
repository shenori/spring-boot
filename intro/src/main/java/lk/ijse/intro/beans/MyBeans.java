package lk.ijse.intro.beans;

import org.springframework.stereotype.Component;

@Component
public class MyBeans {
    public MyBeans() {
        System.out.println("Hello beans");
    }
}
