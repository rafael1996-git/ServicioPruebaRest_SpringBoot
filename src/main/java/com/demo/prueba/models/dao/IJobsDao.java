package com.demo.prueba.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.prueba.models.entity.Jobs;

public interface IJobsDao  extends CrudRepository<Jobs, Long>{

}
