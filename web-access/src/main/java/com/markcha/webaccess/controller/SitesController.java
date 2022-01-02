package com.markcha.webaccess.controller;

import com.markcha.webaccess.dto.HistoryDto;
import com.markcha.webaccess.dto.table.HistoryHourDto;
import com.markcha.webaccess.service.impl.HistoryHourServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/workplace")
public class SitesController {


    private final HistoryHourServiceImpl historyHourService;

    public SitesController(HistoryHourServiceImpl historyHourService) {
        this.historyHourService = historyHourService;
    }


    @GetMapping("/list")
    public List<HistoryHourDto> status() {
        return this.historyHourService.getHistoryHouryTable( Arrays.asList("U013_PWR_kWh", "U015_PWR_Kvarh"), LocalDateTime.parse("2021-09-09T00:00:00"), LocalDateTime.parse("2021-09-10T00:00:00"));
    }
}
