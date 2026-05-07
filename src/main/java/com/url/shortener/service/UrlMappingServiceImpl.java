package com.url.shortener.service;

import com.url.shortener.dto.UrlMappingDto;
import com.url.shortener.model.UrlMapping;
import com.url.shortener.model.User;
import com.url.shortener.repo.UrlMappingRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class UrlMappingServiceImpl implements UrlMappingService {

    private UrlMappingRepo urlMappingRepo;

    @Override
    @Transactional
    public UrlMappingDto createShortUrl(String originalUrl, User user) {
        String shortUrl = generateShortUrl();
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setUser(user);
        urlMapping.setShortUrl(shortUrl);
        UrlMapping savedUrlMapping = urlMappingRepo.save(urlMapping);
        return convertToDto(savedUrlMapping);
    }

    @Override
    public List<UrlMappingDto> getUrlsByUser(User user) {
        List<UrlMapping> urlMappingList = urlMappingRepo.findAllByUserId(user.getId());
        return urlMappingList.stream().map(this::convertToDto).toList();
    }

    private String generateShortUrl() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder shortUrl = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            shortUrl.append(characters.charAt(random.nextInt(characters.length())));
        }
        return shortUrl.toString();
    }

    private UrlMappingDto convertToDto(UrlMapping urlMapping) {
        UrlMappingDto urlMappingDto = new UrlMappingDto();
        urlMappingDto.setId(urlMapping.getId());
        urlMappingDto.setOriginalUrl(urlMapping.getOriginalUrl());
        urlMappingDto.setUsername(urlMapping.getUser().getUsername());
        urlMappingDto.setShortUrl(urlMapping.getShortUrl());
        urlMappingDto.setCreatedDate(urlMapping.getCreatedDate());
        urlMappingDto.setClickCount(urlMappingDto.getClickCount());
        return urlMappingDto;
    }


}
