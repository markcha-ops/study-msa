package com.markcha.devicemanager.service.impl;

import com.markcha.devicemanager.domain.EquipmentMgmt;
import com.markcha.devicemanager.dto.EquipmentMgmtDto;
import com.markcha.devicemanager.dto.WebAccessTagsDto;
import com.markcha.devicemanager.repository.EquipmentMgmtRepository;
import com.markcha.devicemanager.service.EquipmentMgmtService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EquipmentMgmtServiceImpl implements EquipmentMgmtService {
    private final EquipmentMgmtRepository equipmentMgmtRepository;

    public EquipmentMgmtServiceImpl(EquipmentMgmtRepository equipmentMgmtRepository) {
        this.equipmentMgmtRepository = equipmentMgmtRepository;
    }


    @Override
    public EquipmentMgmtDto getEquipmentMgmtById(Integer id) {
        EquipmentMgmt equipmentMgmt = this.equipmentMgmtRepository.getById(id);

        return new EquipmentMgmtDto(equipmentMgmt);
    }
}
