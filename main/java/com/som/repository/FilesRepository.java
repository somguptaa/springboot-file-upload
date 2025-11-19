package com.som.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.som.entity.FilesEntity;

public interface FilesRepository extends JpaRepository<FilesEntity, Long>{

}
