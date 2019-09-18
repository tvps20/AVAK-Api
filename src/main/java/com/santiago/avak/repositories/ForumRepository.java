package com.santiago.avak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santiago.avak.domain.Forum;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long>{

}
