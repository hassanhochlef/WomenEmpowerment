package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class User implements Serializable {
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
long userId;
String Name;
@Temporal(TemporalType.DATE)
Date birthDate;
String profilePicture;
String userName;
String password;
@ManyToMany(cascade = CascadeType.ALL)
Set<Role> roles;
/*Former*/
String Speciality;
float Rating;
/*Expert*/
long nbCasesSolved;
@Enumerated(EnumType.STRING)
Job job;
/*company*/
String activityDomain;
String address;
@Temporal(TemporalType.DATE)
Date establishmentDate;
/*Association*/
Integer nbEventsCreated;

@OneToOne
Subscription subscription;
@ManyToMany(cascade = CascadeType.ALL) //Learner
Set<Course> learnerCourses;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "former") // Former
Set<Course> formerCourses;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "expert") // Expert
Set<Service> expertServices;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
Set<Appointment> appointments;

@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
Set<Condidacy> condidacy;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
Set<Offer> offers;

@ManyToMany(cascade = CascadeType.ALL)
Set<Event> userEvents;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "association")
Set<Event> associationEvents;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
Set<Donation> donations;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
Set<Post> posts;

}
