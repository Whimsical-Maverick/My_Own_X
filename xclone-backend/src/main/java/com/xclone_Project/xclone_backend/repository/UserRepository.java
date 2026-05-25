package com.xclone_Project.xclone_backend.repository;
import com.xclone_Project.xclone_backend.model.User;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
   boolean existsByUsername(String username);
   boolean existsByEmailId(String emailId);
   User findByUsername(String username);
   User findByEmailId(String emailId);
   
}
