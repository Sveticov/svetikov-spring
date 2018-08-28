package com.svetikov.svetikovspring.repository;

import com.svetikov.svetikovspring.model.ImagesModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImagesModelRepository extends CrudRepository<ImagesModel,Integer> {

    @Query(value = "select i.id_images from images_storage i",nativeQuery = true)
    List<Integer> findAllImages();


}
