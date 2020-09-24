package com.example.demo.start;

import com.example.demo.entity.Cat;
import com.example.demo.entity.Missing;
import com.example.demo.entity.User;
import com.example.demo.repo.CatRepo;
import com.example.demo.repo.MissingRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class Start {

    public Start(UserRepo userRepo, CatRepo catRepo, MissingRepo missingRepo, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUsername("dominika");
        user.setPassword(passwordEncoder.encode("123"));
        user.setFirstName("Dominika");
        user.setLastName("Wojtasiewicz");
        user.setRole("ROLE_USER");
        userRepo.save(user);


        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword(passwordEncoder.encode("admin"));
        user1.setFirstName("Admin");
        user1.setLastName("Adminowicz");
        user1.setRole("ROLE_ADMIN");
        userRepo.save(user1);

        Cat cat =new Cat();
        cat.setName("Luan");
        cat.setChipNumber("15462589255");
        cat.setUser(user);
        catRepo.save(cat);
        userRepo.save(user1);

        Missing miss=new Missing();
        miss.setLat("50,2556");
        miss.setLng("12,2665");
        miss.setCat(cat);
        missingRepo.save(miss);

        Cat cat2 =new Cat();
        cat2.setName("kajtek");
        cat2.setChipNumber("1155546485");
        cat2.setUser(user);
        catRepo.save(cat2);

        Cat cat1 =new Cat();
        cat1.setName("Damianek");
        cat1.setChipNumber("15462585954");
        cat1.setUser(user1);
        catRepo.save(cat1);

    }
}
