package org.springframework.samples.petclinic.feeding;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "feedings")
public class Feeding extends BaseEntity{
    Integer id;
    @Column(name = "start_date")        
	@DateTimeFormat(pattern = "yyyy/MM/dd")
    LocalDate startDate;
    @Column(name = "weeks_duration")
    @Min(1)
    double weeksDuration;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pet_id")
    Pet pet;   
    @NotNull
    @ManyToOne
    @JoinColumn(name = "feeding_type_id")
    FeedingType feedingType;   
}
