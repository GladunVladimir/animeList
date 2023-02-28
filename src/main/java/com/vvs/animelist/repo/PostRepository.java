package com.vvs.animelist.repo;

import com.vvs.animelist.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
