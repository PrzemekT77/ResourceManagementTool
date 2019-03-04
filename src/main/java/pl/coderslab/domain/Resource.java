package pl.coderslab.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RESOURCE_DATA")
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany(mappedBy="resource", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Skill>skills = new HashSet<Skill>();
	
	@ManyToOne 
	@JoinColumn(name="rate_id")
	private Rate rate;
	
	@NotBlank (message = "Please provide value")
	private String firstName;
	@NotBlank (message = "Please provide value")
	private String lastName;
	@NotBlank (message = "Please provide value")
	private String address;
	@NotNull (message = "Incorrect phone number")
	@Max(value = 999999999)
	private Integer phone;
	@Email	(message = "Incorrect email form")
	private String email;
	
	@ManyToMany(mappedBy="resources")
	private Set<Project>projects= new HashSet<Project>();
}
