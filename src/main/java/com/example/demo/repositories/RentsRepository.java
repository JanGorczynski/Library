package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Rents;

@Repository
public interface RentsRepository extends CrudRepository<Rents, Integer> {

    @Query(value = "select * from RENTS inner join USERS on RENTS.users_id= USERS.id where USERS.username = :username", nativeQuery = true)
    public List<Rents> findByUserName(@Param(value = "username") String userName);

}
