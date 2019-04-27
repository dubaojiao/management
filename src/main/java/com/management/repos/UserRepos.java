package com.management.repos;

import com.management.entry.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<User,Integer> {
    User findFirstByState(Integer state);
}
