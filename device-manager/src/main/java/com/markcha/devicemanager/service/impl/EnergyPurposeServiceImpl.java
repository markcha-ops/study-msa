package com.markcha.devicemanager.service.impl;

import com.markcha.devicemanager.domain.EnergyPurpose;
import com.markcha.devicemanager.dto.EnergyPurposeDto;
import com.markcha.devicemanager.repository.EnergyPurposeRepository;
import com.markcha.devicemanager.service.EnergyPurposeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnergyPurposeServiceImpl implements EnergyPurposeService {
    private final EnergyPurposeRepository energyPurposeRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(EnergyPurposeServiceImpl.class);
    public EnergyPurposeServiceImpl(EnergyPurposeRepository energyPurposeRepository) {
        this.energyPurposeRepository = energyPurposeRepository;
    }


    @Override
    public List<EnergyPurposeDto> getEnergyPurposeListById(Integer id) {
        List<EnergyPurpose> a = this.energyPurposeRepository.getAllById(id);
        System.out.println(a);
        return null;

    }

    @Override
    public EnergyPurpose getEnergyPurposeById(Integer id) {
        EnergyPurpose energyPurpose = this.energyPurposeRepository.getById(id);
        return energyPurpose;
    }
}
