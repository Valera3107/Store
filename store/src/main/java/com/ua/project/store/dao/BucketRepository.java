package com.ua.project.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ua.project.store.domain.Bucket;

public interface BucketRepository extends JpaRepository<Bucket, Integer>{

}
