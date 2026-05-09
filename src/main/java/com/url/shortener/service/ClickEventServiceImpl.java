package com.url.shortener.service;

import com.url.shortener.dto.ClickEventDto;
import com.url.shortener.model.ClickEvent;
import com.url.shortener.model.UrlMapping;
import com.url.shortener.repo.ClickEventRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClickEventServiceImpl implements ClickEventService {

    private ClickEventRepo clickEventRepo;

    @Override
    public List<ClickEventDto> getClickEventsByDate(UrlMapping urlMapping, LocalDateTime startDate, LocalDateTime endDate) {
        return clickEventRepo.findAllByUrlMappingAndClickDateBetween(urlMapping, startDate, endDate).stream().map(
                clickEvent -> new ClickEventDto(clickEvent.getClickDate().toLocalDate(), urlMapping.getClickCount())
        ).toList();
    }

    @Override
    public Map<LocalDate, Long> getTotalClicksByUserAndDate(List<UrlMapping> urlMappings, LocalDate start, LocalDate end) {
        List<ClickEvent> clickEventList = clickEventRepo.findAllByUrlMappingInAndClickDateBetween(urlMappings, start.atStartOfDay(), end.plusDays(1).atStartOfDay());
        return clickEventList.stream().collect(Collectors.groupingBy(click -> click.getClickDate().toLocalDate(), Collectors.counting()));
    }
}
