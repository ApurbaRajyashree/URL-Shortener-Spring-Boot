package com.url.shortener.repo;

import com.url.shortener.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlMappingRepo extends JpaRepository<UrlMapping, Long> {

    Optional<UrlMapping> findByShortUrl(String shortUrl);

    @Query(value = "select * from url_mapping where user_id=?1", nativeQuery = true)
    List<UrlMapping> findAllByUserId(Long id);
}
