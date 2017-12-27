package com.ways.live.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ways.live.model.User;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer>{

    @Query(value = "select * from user where cell_phone=:cellPhone and password=:passWord", nativeQuery = true)
    public User getUser(@Param("cellPhone") String cellPhone, @Param("passWord") String passWord);

}
