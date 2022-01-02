package com.markcha.devicemanager.service;

import com.markcha.devicemanager.domain.EnergyPurpose;
import com.markcha.devicemanager.dto.EnergyPurposeDto;

import java.util.List;

public interface EnergyPurposeService {

    List<EnergyPurposeDto> getEnergyPurposeListById(Integer id);
    EnergyPurpose getEnergyPurposeById(Integer id);
}
