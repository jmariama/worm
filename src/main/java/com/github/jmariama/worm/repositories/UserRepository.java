package com.github.jmariama.worm.repositories;

import com.github.jmariama.worm.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // marks interface as a repository, its a bean that can be injected anywhere.
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
