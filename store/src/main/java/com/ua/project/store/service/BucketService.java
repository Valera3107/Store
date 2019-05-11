package com.ua.project.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.project.store.dao.BucketRepository;
import com.ua.project.store.domain.Bucket;

@Service
public class BucketService {

	@Autowired
	private BucketRepository bucketRepository;
	
	public List<Bucket> getAll(){
		return bucketRepository.findAll();
	}
	
	public void delete(Bucket bucket) {
		bucketRepository.delete(bucket);
	}
	
	public void bucketAdd(Bucket bucket) {
		bucketRepository.save(bucket);
	}
}
