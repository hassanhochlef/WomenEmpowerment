package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Service implements Serializable{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long serviceId;
	@Temporal(TemporalType.DATE)
	Date startDate;
	@Temporal(TemporalType.DATE)
	Date endDate;
	@ManyToOne
	User expert; //Expert
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
	Set<Appointment> appointments;
	

}
