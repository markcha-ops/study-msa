package com.markcha.webaccess.repository;

import com.markcha.webaccess.domain.HistoryHour;
import com.markcha.webaccess.dto.HistoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface HistoryHourRepository extends JpaRepository<HistoryHour, LocalDateTime> {

    @Query("SELECT new com.markcha.webaccess.dto.HistoryDto(" +
                "HOUR(hr.timestamp), " +
                "hr.tagname, " +
                "SUM(hr.usage)) " +
            "FROM HistoryHour hr " +
            "WHERE hr.tagname in ?1 " +
            "AND hr.timestamp >= ?2 " +
            "AND hr.timestamp < ?3 " +
            "GROUP BY HOUR(hr.timestamp)")
    List<HistoryDto> findByTagnameStartWithHour(List<String> tagName,
                                                   LocalDateTime startTime,
                                                   LocalDateTime endTime,
                                                   String timeType);

}
