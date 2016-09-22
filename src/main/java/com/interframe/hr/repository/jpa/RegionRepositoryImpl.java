/**
* TODO
* @Project: interframe-web-admin
* @Title: RegionRepositoryImpl.java
* @Package com.interframe.hr.repository.jpa
* @author jason
* @Date 2016年9月20日 下午5:13:27
* @Copyright
* @Version 
*/
package com.interframe.hr.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.interframe.hr.repository.RegionRepository;
import com.interframe.hr.repository.model.Region;

/**
 * TODO
 * 
 * @ClassName: RegionRepositoryImpl
 * @author jason
 */
@Repository
public class RegionRepositoryImpl implements RegionRepository {

	@PersistenceContext
	protected EntityManager em;
	
	/*
	 * TODO
	 * 
	 * @Title: findRegions
	 * 
	 * @return
	 * 
	 * @see com.interframe.hr.repository.RegionRepository#findRegions()
	 */
	@SuppressWarnings("unchecked")
	public List<Region> findRegions() {
		// TODO Auto-generated method stub
		return this.em.createQuery("SELECT region FROM Region region ORDER BY region.regionId").getResultList();
	}

}
