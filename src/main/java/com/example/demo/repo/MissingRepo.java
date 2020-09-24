package com.example.demo.repo;

import com.example.demo.entity.Missing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MissingRepo extends CrudRepository<Missing, Long> {

   Missing findById(long id);
}
