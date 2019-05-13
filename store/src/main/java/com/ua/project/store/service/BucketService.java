package com.ua.project.store.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.project.store.dao.BucketRepository;
import com.ua.project.store.domain.Bucket;

@Service
public class BucketService {

	private Logger logger = LoggerFactory.getLogger(BucketService.class);

	@Autowired
	private BucketRepository bucketRepository;
	
	public List<Bucket> getAll(){
		logger.info("Get all bucket items");
		return bucketRepository.findAll();
	}
	
	public void delete(Bucket bucket) {
		logger.info("Delete bucket " + bucket);
		bucketRepository.delete(bucket);
	}
	
	public void bucketAdd(Bucket bucket) {
		logger.info("Save bucket to DB " + bucket);
		bucketRepository.save(bucket);
	}
}
