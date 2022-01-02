package com.markcha.devicemanager.service;

import com.markcha.devicemanager.domain.EquipmentMgmt;
import com.markcha.devicemanager.dto.EquipmentMgmtDto;

public interface EquipmentMgmtService {
    EquipmentMgmtDto getEquipmentMgmtById(Integer id);
}
