package pl.coderslab.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROJECTS")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	@NotNull
//	@Size(min=2, max=30, message="Podaj nazwę nie dłuższą niż 30 znaków")
	private String name;
//	@Size(min=2, max=150)
	private String description;
	//@URL(message="Niepoprawny format strony URL")
	private String website;
	
//	@NotNull(message="wartość wymagana")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	//@NotNull(message="wartość wymagana")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date finishDate;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Resource>resources = new HashSet<Resource>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Skill>skills = new HashSet<Skill>();

}
