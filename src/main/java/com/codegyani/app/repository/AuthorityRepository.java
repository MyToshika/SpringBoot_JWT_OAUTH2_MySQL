package com.codegyani.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegyani.app.model.AuthorityName;
import com.codegyani.app.model.entity.Authority;

public interface AuthorityRepository  extends JpaRepository<Authority, Long> {
	Authority findByName(AuthorityName name);
}
