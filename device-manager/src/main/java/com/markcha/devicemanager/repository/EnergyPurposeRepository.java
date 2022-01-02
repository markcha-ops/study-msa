package com.markcha.devicemanager.repository;

import com.markcha.devicemanager.domain.EnergyPurpose;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EnergyPurposeRepository extends JpaRepository<EnergyPurpose, Integer> {
    List<EnergyPurpose>  getAllById(Integer id);
    EnergyPurpose getById(Integer id);
}
