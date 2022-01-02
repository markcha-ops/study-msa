package com.markcha.devicemanager.repository;

import com.markcha.devicemanager.domain.EquipmentMgmt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentMgmtRepository extends JpaRepository<EquipmentMgmt, Integer> {
    EquipmentMgmt getById(Integer id);
}
