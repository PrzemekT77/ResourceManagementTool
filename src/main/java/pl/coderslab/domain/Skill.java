package pl.coderslab.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SKILLS")
public class Skill {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String skillName;
	
	@ManyToMany (fetch=FetchType.EAGER)
	private Set<Resource> resource = new HashSet<Resource>();
	
	@ManyToMany (mappedBy = "skills")
	private Set<Project>projects = new HashSet<Project>();

}
