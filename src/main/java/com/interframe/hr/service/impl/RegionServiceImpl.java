/**
* TODO
* @Project: interframe-web-admin
* @Title: RegionServiceImpl.java
* @Package com.interframe.hr.service.impl
* @author jason
* @Date 2016年9月20日 下午5:31:34
* @Copyright
* @Version 
*/
package com.interframe.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interframe.hr.repository.RegionRepository;
import com.interframe.hr.repository.model.Region;
import com.interframe.hr.service.RegionService;

/**
* TODO
* @ClassName: RegionServiceImpl
* @author jason
*/
@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionRepository regionRepository;
	/* 
	* TODO
	* @Title: findRegions
	* @return
	* @see com.interframe.hr.service.RegionService#findRegions()
	*/
	public List<Region> findRegions() {
		// TODO Auto-generated method stub
		return regionRepository.findRegions();
	}

}
