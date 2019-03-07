package pl.coderslab.dao.impl;

import java.util.Collection;

import pl.coderslab.dao.SkillDao;
import pl.coderslab.domain.Skill;

public class SkillDaoImpl extends AbstractBaseDao<Skill, Long> implements SkillDao {


	public Skill find(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Skill.class, id);
	}

	public Collection<Skill> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT b FROM Skill b").getResultList();
	}

}
