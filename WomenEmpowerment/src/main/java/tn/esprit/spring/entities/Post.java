package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
public class Post implements Serializable {
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
Long postId;
String postTitle;
@Temporal(TemporalType.DATE)
Date createdAt;
String content;
@OneToMany(mappedBy = "post")
Set<PostLike> postLike;
@OneToMany(mappedBy = "post")
Set<PostComment> postComment;

@ManyToOne
User user;
}
