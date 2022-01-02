package com.markcha.webaccess.service;

import com.markcha.webaccess.dto.HistoryDto;
import com.markcha.webaccess.dto.table.HistoryHourDto;

import java.time.LocalDateTime;
import java.util.List;

public interface HistoryHourService {

    List<HistoryHourDto> getHistoryHouryTable(List<String> tagName, LocalDateTime startTime, LocalDateTime endTime);
}
