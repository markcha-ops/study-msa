package com.markcha.devicemanager.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.markcha.devicemanager.domain.EnergyPurpose;
import com.markcha.devicemanager.domain.EquipmentMgmt;
import com.markcha.devicemanager.dto.EnergyPurposeDto;
import com.markcha.devicemanager.dto.EquipmentMgmtDto;
import com.markcha.devicemanager.dto.EquipmentMgmtInputDto;
import com.markcha.devicemanager.exception.TestException;
import com.markcha.devicemanager.service.impl.EnergyPurposeServiceImpl;
import com.markcha.devicemanager.service.impl.EquipmentMgmtServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class EnergyPurposeController {


    private final EnergyPurposeServiceImpl energyPurposeServiceImpl;
    private final EquipmentMgmtServiceImpl equipmentMgmtService;

    public EnergyPurposeController(EnergyPurposeServiceImpl energyPurposeServiceImpl, EquipmentMgmtServiceImpl equipmentMgmtService) {
        this.energyPurposeServiceImpl = energyPurposeServiceImpl;
        this.equipmentMgmtService = equipmentMgmtService;
    }


    @GetMapping("/list")
    public List<EnergyPurposeDto> status() {
        throw new TestException("ef");
//        return this.energyPurposeServiceImpl.getEnergyPurposeListById(2);
    }

    @GetMapping("/one")
    public EnergyPurpose status2() {
        return this.energyPurposeServiceImpl.getEnergyPurposeById(2);
    }

    @GetMapping("/equip/one")
    public MappingJacksonValue status3() {
        EquipmentMgmtDto equipmentMgmtDto = this.equipmentMgmtService.getEquipmentMgmtById(2);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("equipmentName", "importance");

        FilterProvider filters = new SimpleFilterProvider().addFilter("EquipmentMgmtDto", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(equipmentMgmtDto);
        mapping.setFilters(filters);
        return mapping;
    }

    @PostMapping("/equip")
    public ResponseEntity<String> status5(
       @RequestBody @Valid EquipmentMgmtInputDto equipmentMgmtInputDto,
       BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            System.out.println("equipmentMgmtInputDto");
        }
        System.out.println(equipmentMgmtInputDto);


        return ResponseEntity.ok("User is vld");
    }

}