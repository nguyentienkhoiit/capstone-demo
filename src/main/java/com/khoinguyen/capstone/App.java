package com.khoinguyen.capstone;

import com.khoinguyen.capstone.entity.Role;
import com.khoinguyen.capstone.entity.User;
import com.khoinguyen.capstone.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    CommandLineRunner run(UserService service) {
//        return args -> {
//            service.save(Role.builder().name("ROLE_USER").build());
//            service.save(Role.builder().name("ROLE_MANAGER").build());
//            service.save(Role.builder().name("ROLE_ADMIN").build());
//            service.save(Role.builder().name("ROLE_SUPER_ADMIN").build());
//
//            service.save(User.builder()
//                    .email("khoi@gmail.com")
//                    .firstname("Khoi")
//                    .lastname("Nguyen")
//                    .password("123456")
//                    .build());
//            service.save(User.builder()
//                    .email("giang@gmail.com")
//                    .firstname("Giang")
//                    .lastname("Nguyen")
//                    .password("123456")
//                    .build());
//
//            service.addRoleToUser("khoi@gmail.com", "ROLE_USER");
//            service.addRoleToUser("khoi@gmail.com", "ROLE_MANAGER");
//
//            service.addRoleToUser("giang@gmail.com", "ROLE_ADMIN");
//            service.addRoleToUser("giang@gmail.com", "ROLE_SUPER_ADMIN");
//        };
//    }
}
