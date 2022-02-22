package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Course implements Serializable {
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
Long courseId;
String courseName;
Integer nbHours;
@Temporal(TemporalType.DATE)
Date startDate;
@Temporal(TemporalType.DATE)
Date endDate;
float Rating;
boolean isCertified;
@ManyToMany(cascade = CascadeType.ALL, mappedBy = "learnerCourses") // LearnerCourses
Set<User> learners;
@ManyToOne // FormerCourse
User former;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
Set<Certificate> certificates;
}
