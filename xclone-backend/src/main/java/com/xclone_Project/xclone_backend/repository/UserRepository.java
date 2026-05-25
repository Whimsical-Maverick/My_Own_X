package com.xclone_Project.xclone_backend.repository;
import com.xclone_Project.xclone_backend.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
    @Query("SELECT u from User u where u.username = :username")
       List<User> findbyUsername(@Param("username") String username);
    @Query("SELECT u from User u WHERE u.emailId = :emailId")
       List<User> findbyEmailId(@Param("emailId") String emailId);
    @Query("SELECT u from User u WHERE  u.password = :password")
       List<User> findbyPassword(@Param("password") String password); 
}
