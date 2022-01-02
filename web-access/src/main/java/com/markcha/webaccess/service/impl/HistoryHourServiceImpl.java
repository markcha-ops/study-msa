package com.markcha.webaccess.service.impl;


import com.markcha.webaccess.domain.HistoryHour;
import com.markcha.webaccess.dto.HistoryDto;
import com.markcha.webaccess.dto.table.HistoryHourDto;
import com.markcha.webaccess.repository.HistoryHourRepository;
import com.markcha.webaccess.service.HistoryHourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryHourServiceImpl implements HistoryHourService {

    @PersistenceContext
    private EntityManager em;

    private final HistoryHourRepository historyHourRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(HistoryHourServiceImpl.class);
    public HistoryHourServiceImpl(HistoryHourRepository historyHourRepository) {
        this.historyHourRepository = historyHourRepository;
    }



    @Override
    public List<HistoryHourDto> getHistoryHouryTable(List<String> tagName, LocalDateTime startTime, LocalDateTime endTime) {
        List<HistoryDto> crunUsage = this.historyHourRepository.findByTagnameStartWithHour(tagName, startTime, endTime, "HOUR");
        List<HistoryDto> beforeOneDayUsage = this.historyHourRepository.findByTagnameStartWithHour(tagName, startTime.minusDays(1), endTime.minusDays(1), "HOUR");
        List<HistoryDto> beforeOneMonthUsage = this.historyHourRepository.findByTagnameStartWithHour(tagName, startTime.minusMonths(1), endTime.minusMonths(1), "HOUR");
        List<HistoryDto> beforeOneYearUsage = this.historyHourRepository.findByTagnameStartWithHour(tagName, startTime.minusYears(1), endTime.minusYears(1), "HOUR");

        List<HistoryHourDto> historyHourDtoList = new ArrayList<HistoryHourDto>();

        System.out.println(crunUsage.isEmpty());
        HistoryDto crunUsagePrev = null;
        if (crunUsage.isEmpty() == false) {
            crunUsagePrev = crunUsage.remove(0);
        }

        HistoryDto beforeOneDayUsagePrev = null;
        if (beforeOneDayUsage.isEmpty() == false) {
            beforeOneDayUsagePrev = beforeOneDayUsage.remove(0);
        }
        HistoryDto beforeOneMonthUsagePrev = null;
        if (beforeOneMonthUsage.isEmpty() == false)  {
            beforeOneMonthUsagePrev = beforeOneMonthUsage.remove(0);
        }
        HistoryDto beforeOneYearUsagePrev = null;
        if (beforeOneYearUsage.isEmpty() == false)  {
            beforeOneYearUsagePrev = beforeOneYearUsage.remove(0);
        }
        for (int i = 0; i < 24; i++) {
            HistoryHourDto historyHourDto = new HistoryHourDto();
            historyHourDto.setH(i);
            if (crunUsage.isEmpty() == false) {
                if (crunUsagePrev.getTimestamp() == i) {
                    historyHourDto.setUsage(crunUsagePrev.getUsage());

                    crunUsagePrev = crunUsage.remove(0);

                } else {
                    historyHourDto.setUsage(0.0);
                }
            } else {
                historyHourDto.setUsage(0.0);
            }
            if (beforeOneDayUsage.isEmpty() == false) {
                if (beforeOneDayUsagePrev.getTimestamp() == i) {
                    historyHourDto.setBeforeOneDayUseage(beforeOneDayUsagePrev.getUsage());

                    beforeOneDayUsagePrev = beforeOneDayUsage.remove(0);

                } else {
                    historyHourDto.setBeforeOneDayUseage(0.0);
                }
            } else {
                historyHourDto.setBeforeOneDayUseage(0.0);
            }
            if (beforeOneMonthUsage.isEmpty() == false) {
                if (beforeOneMonthUsagePrev.getTimestamp() == i) {
                    historyHourDto.setBeforeOneMonthUseage(beforeOneMonthUsagePrev.getUsage());

                    beforeOneMonthUsagePrev = beforeOneMonthUsage.remove(0);

                } else {
                    historyHourDto.setBeforeOneMonthUseage(0.0);
                }
            } else {
                historyHourDto.setBeforeOneMonthUseage(0.0);
            }
            if (beforeOneYearUsage.isEmpty() == false) {
                if (beforeOneYearUsagePrev.getTimestamp() == i) {
                    historyHourDto.setBeforeOneYearUseage(beforeOneYearUsagePrev.getUsage());

                    beforeOneYearUsagePrev = beforeOneYearUsage.remove(0);

                } else {
                    historyHourDto.setBeforeOneYearUseage(0.0);
                }
            } else {
                historyHourDto.setBeforeOneYearUseage(0.0);
            }
            historyHourDtoList.add(historyHourDto);
        }



        return historyHourDtoList;
    }
}
