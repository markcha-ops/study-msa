package com.markcha.devicemanager;

import com.markcha.devicemanager.domain.EnergyPurpose;
import com.markcha.devicemanager.repository.EnergyPurposeRepository;
import com.markcha.devicemanager.service.impl.EnergyPurposeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
class DeviceManagerApplicationTests {


	@Test
	void contextLoads() {
	}

}
