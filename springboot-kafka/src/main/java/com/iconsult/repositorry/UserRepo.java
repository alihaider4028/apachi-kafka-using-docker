package com.iconsult.repositorry;

import com.iconsult.payload.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
