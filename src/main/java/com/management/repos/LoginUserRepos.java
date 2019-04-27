package com.management.repos;

import com.management.entry.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title
 * @ClassName LoginUserRepos
 * @Author jsb_pbk
 * @Date 2019/4/27
 */
public interface LoginUserRepos extends JpaRepository<LoginUser,Integer>{
    LoginUser findFirstByToken(String token);
}
