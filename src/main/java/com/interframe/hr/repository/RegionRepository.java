/**
* TODO
* @Project: interframe-web-admin
* @Title: RegionRepository.java
* @Package com.interframe.hr.repository
* @author jason
* @Date 2016年9月20日 下午5:08:35
* @Copyright
* @Version 
*/
package com.interframe.hr.repository;

import java.util.List;

import com.interframe.hr.repository.model.Region;

/**
* TODO
* @ClassName: RegionRepository
* @author jason
*/
public interface RegionRepository {

	/**
	* TODO Retrieve all </code>Region</code>s from the data store.
	* @Title: findRegions
	* @return a <code>Collection</code> of <code>Region</code>s
	 */
	List<Region> findRegions();
}
