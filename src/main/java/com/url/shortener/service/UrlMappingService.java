package com.url.shortener.service;

import com.url.shortener.dto.UrlMappingDto;
import com.url.shortener.model.User;

import java.util.List;

public interface UrlMappingService {
    UrlMappingDto createShortUrl(String originalUrl, User user);

    List<UrlMappingDto> getUrlsByUser(User user);
}
