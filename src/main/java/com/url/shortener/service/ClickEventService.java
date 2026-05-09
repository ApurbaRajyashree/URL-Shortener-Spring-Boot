package com.url.shortener.service;

import com.url.shortener.dto.ClickEventDto;
import com.url.shortener.model.UrlMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ClickEventService {
    List<ClickEventDto> getClickEventsByDate(UrlMapping urlMapping, LocalDateTime startDate, LocalDateTime endDate);

    Map<LocalDate, Long> getTotalClicksByUserAndDate(List<UrlMapping> urlMappings, LocalDate start, LocalDate end);

    void save(UrlMapping urlMapping);
}
