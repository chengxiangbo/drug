package com.valueplus.drug;

import com.valueplus.drug.entity.User;
import com.valueplus.drug.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DrugApplicationTests {
    @Autowired
    private IUserService userService;
    @Test
    void contextLoads() {
        User user= new User();
        user.setUsername("admin");
        User u = userService.queryUserByUsername(user);
        if(u!=null){
            System.out.println(u.getPassword());
        }
    }

}
