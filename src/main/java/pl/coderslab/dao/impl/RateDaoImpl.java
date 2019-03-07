package pl.coderslab.dao.impl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.dao.RateDao;
import pl.coderslab.domain.Rate;

@Component
@Transactional
public class RateDaoImpl extends AbstractBaseDao<Rate, Long> implements RateDao {

	public Rate find(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Rate.class, id);
	}

	public Collection<Rate> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT b FROM Rate b").getResultList();
	}

}
