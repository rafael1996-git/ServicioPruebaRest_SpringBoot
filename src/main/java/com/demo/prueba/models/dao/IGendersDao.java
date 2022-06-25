package com.demo.prueba.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.prueba.models.entity.Genders;

public interface IGendersDao  extends CrudRepository<Genders, Long>{

}
