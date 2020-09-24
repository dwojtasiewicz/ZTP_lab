package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends CrudRepository<User, Long>{

   User findByUsername(String userName);
   User findById(long id);

   @Override
   void deleteById(Long aLong);

   @Override
   <S extends User> S save(S s);

   @Override
   <S extends User> Iterable<S> saveAll(Iterable<S> iterable);

   @Override
   Optional<User> findById(Long aLong);

   @Override
   boolean existsById(Long aLong);

   @Override
   Iterable<User> findAll();

   @Override
   Iterable<User> findAllById(Iterable<Long> iterable);

   @Override
   long count();

   @Override
   void delete(User user);

   @Override
   void deleteAll(Iterable<? extends User> iterable);

   @Override
   void deleteAll();
}
