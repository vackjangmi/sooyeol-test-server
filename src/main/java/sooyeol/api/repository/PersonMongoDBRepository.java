package sooyeol.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import sooyeol.api.model.collection.PersonCollections;

import java.util.List;

public interface PersonMongoDBRepository extends MongoRepository<PersonCollections, String> {

    @Query("{ \"name\": { \"$gt\": ?0 } }")
    List<PersonCollections> findByName(String name);
}