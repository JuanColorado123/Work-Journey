package com.security.security.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Modifying()
    @Query("update User u set u.name=:name, u.lastname=:lastname where u.id = :id")
    void updateUser(@Param(value = "id") Integer id, @Param(value = "name") String name,
            @Param(value = "lastname") String lastname);

}
