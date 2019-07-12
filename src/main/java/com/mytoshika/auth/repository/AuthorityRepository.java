package com.mytoshika.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytoshika.auth.model.AuthorityName;
import com.mytoshika.auth.model.entity.Authority;

public interface AuthorityRepository  extends JpaRepository<Authority, Long> {
	Authority findByName(AuthorityName name);
}
