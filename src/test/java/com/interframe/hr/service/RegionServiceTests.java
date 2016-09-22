/**
* TODO
* @Project: interframe-web-admin
* @Title: RegionServiceTests.java
* @Package com.interframe.hr.service
* @author jason
* @Date 2016年9月20日 下午5:45:05
* @Copyright
* @Version 
*/
package com.interframe.hr.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.interframe.hr.repository.model.Region;

/**
* TODO
* @ClassName: RegionServiceTests
* @author jason
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:root-context-test.xml"})
@ActiveProfiles("jpa")
public class RegionServiceTests {

	@Autowired
	protected RegionService regionService;
	
	@Test
    public void FindRegionsTest() {
        
    	List<Region> regions = this.regionService.findRegions();
    	
    	for(Region region : regions){
    		if(region.getRegionId()==1) {
    			System.out.println(region.getRegionName());
    			assertThat(region.getRegionName()).isEqualTo("Europe");
    		}
    	}

    }
}
