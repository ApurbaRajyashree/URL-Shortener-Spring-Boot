package com.url.shortener.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "click_event")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClickEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "url_mapping_id", foreignKey = @ForeignKey(name = "fk_clickEvent_urlMapping"))
    private UrlMapping urlMapping;

    private LocalDateTime clickDate;
}
