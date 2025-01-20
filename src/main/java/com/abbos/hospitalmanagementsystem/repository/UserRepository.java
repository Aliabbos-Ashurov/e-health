package com.abbos.hospitalmanagementsystem.repository;

import com.abbos.hospitalmanagementsystem.entity.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:01
 **/
public interface UserRepository extends JpaRepository<User, Long>, Repository {

    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.deleted = FALSE")
    Optional<User> findByUsername(@NotNull String username);

    @Query("SELECT u FROM User u WHERE u.id = ?1 AND u.deleted = FALSE")
    Optional<User> findByIdCustom(@NotNull Long id);

    @Query("SELECT u FROM User u WHERE u.deleted = FALSE")
    List<User> findAllCustom();

    @Modifying
    @Query("UPDATE User u SET u.deleted = TRUE WHERE u.id = ?1")
    void softDelete(@NotNull Long id);
}
