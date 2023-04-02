package com.vvs.animelist.repo;

import com.vvs.animelist.models.DeletedPost;
import org.springframework.data.repository.CrudRepository;

public interface DeletedPostRepository extends CrudRepository<DeletedPost, Long> {
}
