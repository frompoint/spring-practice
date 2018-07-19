package com.snaildev.repository;

import com.snaildev.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Modifying
    @Transactional
    @Query("update UserEntity us set us.nickname=:qNickName, us.firstName=:qFirstName, us.lastName=:qLastName, us.password=:qPassword where us.id =:qId")
    public void updateUser(@Param("qNickName") String nickname, @Param("qFirstName") String firstName,
                           @Param("qLastName") String lastName, @Param("qPassword") String password, @Param("qId") Integer id);
}
