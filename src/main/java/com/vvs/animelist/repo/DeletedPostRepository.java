package com.vvs.animelist.repo;

import com.vvs.animelist.models.DeletedPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeletedPostRepository extends JpaRepository<DeletedPost, Long> {
}
