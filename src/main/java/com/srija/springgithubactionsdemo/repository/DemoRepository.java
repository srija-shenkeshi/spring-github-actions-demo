package com.srija.springgithubactionsdemo.repository;

import com.srija.springgithubactionsdemo.model.DB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DemoRepository extends JpaRepository<DB, Integer> {

    Optional<DB> findByUsername(String username);
}
