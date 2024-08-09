package com.cbfacademy.restapiexercise.ious;

import java.util.UUID;
import org.springframework.data.repository.ListCrudRepository;

// Interface for CRUD operations on IOU entites
public interface IOURepository extends ListCrudRepository<IOU, UUID> {   
}
