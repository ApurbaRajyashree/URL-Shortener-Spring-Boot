package com.url.shortener.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "url_mapping")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UrlMapping extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private Integer clickCount = 0;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "id"))
    private User user;

    @OneToMany(mappedBy = "urlMapping")
    private List<ClickEvent> clickEvents;
}
