package com.url.shortener.service;

import com.url.shortener.dto.ClickEventDto;
import com.url.shortener.dto.UrlMappingDto;
import com.url.shortener.model.UrlMapping;
import com.url.shortener.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UrlMappingService {
    UrlMappingDto createShortUrl(String originalUrl, User user);

    List<UrlMappingDto> getUrlsByUser(User user);

    List<ClickEventDto> getClickEventsByDate(String shortUrl, String startDate, String endDate);

    Map<LocalDate, Long> getTotalClicksByUserAndDate(User user, String startDate, String endDate);

    Optional<UrlMapping> getOriginalUrl(String shortUrl);
}
