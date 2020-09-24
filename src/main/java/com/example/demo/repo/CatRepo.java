package com.example.demo.repo;

import com.example.demo.entity.Cat;
import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CatRepo extends CrudRepository<Cat,Long> {

    Cat findCatByChipNumber(String numberOfChip);
    Cat findById(long id);
    List<Cat> findBySexAndOldAndBreed(String sex, String old, String breed);
}
