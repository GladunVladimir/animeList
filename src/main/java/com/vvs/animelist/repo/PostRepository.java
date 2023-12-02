package com.vvs.animelist.repo;

import com.vvs.animelist.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
