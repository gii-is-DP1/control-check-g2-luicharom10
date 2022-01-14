package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedingService {
	
	@Autowired
	private FeedingRepository feedingRepository;
	
    public List<Feeding> getAll(){
        return feedingRepository.findAll();
    }
    

    public List<FeedingType> getAllFeedingTypes(){
        return null;
    }

    public FeedingType getFeedingType(String typeName) {
        return feedingRepository.findFeedingTypeByName(typeName);
    }

    @Transactional
    public Feeding save(Feeding p) throws UnfeasibleFeedingException {
    	Pet pet = p.getPet();
    	FeedingType ft = p.getFeedingType();
    	PetType petType = ft.getPetType();
    	if(pet.getType() != petType) {
    		throw new UnfeasibleFeedingException();
    	}else  {
    		feedingRepository.save(p);
    	}
        return p;       
    }

    
}
