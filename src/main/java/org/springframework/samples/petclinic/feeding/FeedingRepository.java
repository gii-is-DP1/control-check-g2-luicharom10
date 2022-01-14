package org.springframework.samples.petclinic.feeding;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FeedingRepository extends CrudRepository<Feeding, Integer> {
	@Query("SELECT f FROM Feeding f")
    List<Feeding> findAll();
    @Query("SELECT f FROM FeedingType f")
    List<FeedingType> findAllFeedingTypes();
    Optional<Feeding> findById(int id);
    Feeding save(Feeding p);
    @Query("SELECT f FROM FeedingType f WHERE f.name=?1")
    FeedingType findFeedingTypeByName(String name);
}
